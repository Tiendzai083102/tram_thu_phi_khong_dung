package com.example.tramthuphikhongdung.service;

import com.example.tramthuphikhongdung.entity.User;

public interface UserService {
    User findUserByEmailAndPassword(String email,String password);
    String saveUser(User user);
}
