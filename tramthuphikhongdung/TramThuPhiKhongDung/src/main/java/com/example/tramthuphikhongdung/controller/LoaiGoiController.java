package com.example.tramthuphikhongdung.controller;

import com.example.tramthuphikhongdung.entity.LoaiGoi;
import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.service.LoaiGoiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/loaigoi")
public class LoaiGoiController {
    @Autowired
    private LoaiGoiService loaiGoiService;
    @GetMapping
    public ResponseEntity<List<LoaiGoi>> getAllLoaiGoi(){
        List<LoaiGoi> loaiGoiList = loaiGoiService.getAllLoaiGoi();
            return new ResponseEntity<List<LoaiGoi>>(loaiGoiList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addLoaigoi(HttpSession session,@RequestBody LoaiGoi loaiGoiInfor){
        User user = (User) session.getAttribute("user");
        if((user != null&&!user.isAdmin())||user== null){
            return new ResponseEntity<>("Bạn không có quyền", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<LoaiGoi>(loaiGoiService.addLoaiGoi(loaiGoiInfor), HttpStatus.OK);
    }
}
