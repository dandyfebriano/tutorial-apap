package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    UserModel getUserByUsername(String username);
    boolean checkPassword(String password);
}