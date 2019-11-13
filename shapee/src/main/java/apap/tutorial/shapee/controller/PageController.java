package apap.tutorial.shapee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import apap.tutorial.shapee.service.RoleService;

@Controller
public class PageController{
    @Autowired
    RoleService roleService;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}