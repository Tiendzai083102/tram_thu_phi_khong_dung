package com.example.tramthuphikhongdung.service;

import com.example.tramthuphikhongdung.entity.LoaiGoi;

import java.util.List;

public interface LoaiGoiService {
    List<LoaiGoi> getAllLoaiGoi();
    LoaiGoi addLoaiGoi(LoaiGoi loaiGoi);
}
