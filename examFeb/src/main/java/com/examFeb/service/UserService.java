package com.examFeb.service;

import com.examFeb.model.entity.UserEntity;
import com.examFeb.model.service.UserServiceModel;
import org.apache.catalina.User;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);
    UserServiceModel findByUsernameAndPassword(String username, String password);
    UserEntity findByUsername(String username);

}
