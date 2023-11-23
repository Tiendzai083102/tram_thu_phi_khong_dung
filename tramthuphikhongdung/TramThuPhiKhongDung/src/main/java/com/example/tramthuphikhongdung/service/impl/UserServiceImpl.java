package com.example.tramthuphikhongdung.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.repository.UserRepository;
import com.example.tramthuphikhongdung.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if(user.isPresent()){
           return user.get();
        }else{
            return null;
        }
    }	


    @Override
    public String saveUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            return "Email đã tồn tại";
        }
        if(userRepository.existsByBienso(user.getBienso())){
            return "Biển số đã tồn tại";
        }
        if(userRepository.existsByRfid(user.getEmail())) {
            return "RFID đã tồn tại";
        }
        user.setAdmin(false);
        userRepository.save(user);
        return "Đăng ký tài khoản thành công";
    }
}
