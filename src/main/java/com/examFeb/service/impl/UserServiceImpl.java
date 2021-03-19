package com.examFeb.service.impl;

import com.examFeb.model.entity.UserEntity;
import com.examFeb.model.service.UserServiceModel;
import com.examFeb.repository.UserRepository;
import com.examFeb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user ->  modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

}
