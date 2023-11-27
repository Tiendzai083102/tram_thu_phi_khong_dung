package com.example.tramthuphikhongdung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tramthuphikhongdung.entity.Goi;
import com.example.tramthuphikhongdung.entity.User;
import com.example.tramthuphikhongdung.repository.GoiRepository;
import com.example.tramthuphikhongdung.repository.UserRepository;
import com.example.tramthuphikhongdung.service.GoiService;

@Service
public class GoiServiceImpl implements GoiService{
	
	@Autowired
	private GoiRepository goiRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<Goi> getAllGoi() {
		return goiRepository.findAll();
	}

	@Override
	public List<Goi> getGoiByUser(User user) {
		return goiRepository.findByUser(user);
	}

	@Override
	public Goi addGoi(Goi goi) {
		User user = userRepository.findById(goi.getUser().getId()).get();
		user.setSodu(goi.getUser().getSodu()-goi.getLoaiGoi().getGia());
		goi.setUser(user);
		return goiRepository.save(goi);
	}
	
	
}
