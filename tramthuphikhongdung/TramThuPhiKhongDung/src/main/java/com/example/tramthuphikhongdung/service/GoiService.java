package com.example.tramthuphikhongdung.service;

import java.util.List;

import com.example.tramthuphikhongdung.entity.Goi;
import com.example.tramthuphikhongdung.entity.User;

public interface GoiService {
	List<Goi> getAllGoi();
	List<Goi> getGoiByUser(User user);
	Goi addGoi(Goi goi);
}
