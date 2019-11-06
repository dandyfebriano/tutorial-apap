package apap.tutorial.shapee.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.shapee.model.UserModel;
import apap.tutorial.shapee.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private String addUserSubmit(@ModelAttribute UserModel user, @RequestParam HashMap<String,String> data, Model model){
        String password = data.get("password");
        String add = "GAGAL MENAMBAHKAN USER";
        if(userService.checkPassword(password)){
            userService.addUser(user);
            add = "BERHASIL MENAMBAHKAN USER";
        }
        model.addAttribute("add", add);
        return "home";
        
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private String changePassword(@RequestParam HashMap<String,String> data, @AuthenticationPrincipal UserDetails user, Model model){
        UserModel usermodel = userService.getUserByUsername(user.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String oldPassword = data.get("oldPassword");
        System.out.println(oldPassword);
        String newPassword = data.get("newPassword");
        String confirmPassword = data.get("confirmPassword");

        String update = "GAGAL MENGGANTI PASSWORD";

        if(userService.checkPassword(newPassword)){
            if(passwordEncoder.matches(oldPassword, usermodel.getPassword())){
                if(newPassword.equals(confirmPassword)){
                    usermodel.setPassword(newPassword);
                    userService.addUser(usermodel);
                    update = "PASSWORD BERHASIL DIGANTI";
                }
            }
        }

        model.addAttribute("update", update);
        return "home";
    }
}