package com.example.tramthuphikhongdung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tramthuphikhongdung.entity.Goi;
import com.example.tramthuphikhongdung.entity.User;

public interface GoiRepository extends JpaRepository<Goi, String>{
	List<Goi> findByUser(User user);
}
