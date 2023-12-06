package com.example.tramthuphikhongdung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tramthuphikhongdung.entity.Goi;
import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.service.GoiService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/goi")
@CrossOrigin("*")
public class GoiController {
	
	@Autowired
	private GoiService goiService;
	
	@GetMapping
	public ResponseEntity<List<Goi>> getAllGoi(){
		return new ResponseEntity<List<Goi>>(goiService.getAllGoi(), HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getGoiByUser(HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return new ResponseEntity<>("Bạn chưa đăng nhập", HttpStatus.FORBIDDEN);
		}
		else {
			return new ResponseEntity<List<Goi>>(goiService.getGoiByUser(user),HttpStatus.OK); 
		}
	}
	
	@PostMapping
	public ResponseEntity<?> muaGoi(@RequestBody  Goi goi, HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return new ResponseEntity<>("Bạn chưa đăng nhập", HttpStatus.FORBIDDEN);
		}else {
			if(user.getSodu() < goi.getLoaiGoi().getGia()) {
				return new ResponseEntity<>("Bạn không đủ tiền", HttpStatus.BAD_REQUEST);
			}
			goi.setUser(user);
			Goi goi1 = goiService.addGoi(goi);
			session.setAttribute("user", goi1.getUser());
			return new ResponseEntity<Goi> (goi1, HttpStatus.OK); 
		}
	}
}
