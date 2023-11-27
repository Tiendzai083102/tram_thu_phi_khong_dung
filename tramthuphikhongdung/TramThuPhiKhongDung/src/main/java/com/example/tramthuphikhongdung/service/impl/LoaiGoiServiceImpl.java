package com.example.tramthuphikhongdung.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tramthuphikhongdung.entity.LoaiGoi;
import com.example.tramthuphikhongdung.repository.LoaiGoiRepository;
import com.example.tramthuphikhongdung.service.LoaiGoiService;

@Service
public class LoaiGoiServiceImpl implements LoaiGoiService {
    @Autowired
    private LoaiGoiRepository loaiGoiRepository;
    @Override
    public List<LoaiGoi> getAllLoaiGoi() {
       return loaiGoiRepository.findAll();

    }

    @Override
    public LoaiGoi addLoaiGoi(LoaiGoi loaiGoi) {
        return loaiGoiRepository.save(loaiGoi);
    }
}
