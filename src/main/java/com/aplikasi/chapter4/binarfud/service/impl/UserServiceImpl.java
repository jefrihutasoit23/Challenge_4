package com.aplikasi.chapter4.binarfud.service.impl;

import com.aplikasi.chapter4.binarfud.entity.User;
import com.aplikasi.chapter4.binarfud.service.UserService;
import com.aplikasi.chapter4.binarfud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
