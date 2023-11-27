package com.example.tramthuphikhongdung.controller;

import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userInfo, HttpSession session){
        User user = userService.findUserByEmailAndPassword(userInfo.getEmail(),userInfo.getPassword());
        if(user!=null){
            session.setAttribute("user",user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Tài khoản hoặc mật khẩu không đúng", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userInfo){
        if(userService.exitsByEmail(userInfo.getEmail())){
            return new ResponseEntity<>("Email đã tồn tại", HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByBienso(userInfo.getBienso())){
            return new ResponseEntity<>( "Biển số đã tồn tại", HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByRfid(userInfo.getRfid())){
            return new ResponseEntity<>( "Rfid số đã tồn tại", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(userService.saveUser(userInfo),HttpStatus.OK);
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
    	session.removeAttribute("user");
    	return new ResponseEntity<>("Logout thành công", HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> informationUser(@PathVariable("id") int id){
    	User user = userService.getUserById(id);
    	return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @PostMapping("/user/profile")
    public ResponseEntity<?> changeProfile(@RequestBody User user){
    	return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
    }
}
