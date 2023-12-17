package com.aplikasi.chapter4.binarfud.service;

import com.aplikasi.chapter4.binarfud.entity.User;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);
}
