package com.example.tramthuphikhongdung.controller;

import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userInfo){
        User user = userService.findUserByEmailAndPassword(userInfo.getEmail(),userInfo.getPassword());
        if(user!=null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Tài khoản hoặc mật khẩu không đúng", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User userInfo){            
            return new ResponseEntity<>( userService.saveUser(userInfo), HttpStatus.OK);

    }
}
