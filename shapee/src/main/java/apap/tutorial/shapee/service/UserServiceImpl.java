package apap.tutorial.shapee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import apap.tutorial.shapee.model.UserModel;
import apap.tutorial.shapee.repository.UserDb;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

	@Override
	public UserModel getUserByUsername(String username) {
		return userDb.findByUsername(username);
	}

    @Override
    public boolean checkPassword(String password) {
        if(password.matches("^.*[A-Za-z].*")){
            if(password.matches(".*[0-9].*")){
             if(password.length() >= 8){
               return true;
             }
           }
        }
       return false;
    } 

}