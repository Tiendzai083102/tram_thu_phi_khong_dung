package com.example.tramthuphikhongdung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goi {
    @Id
    private String id;
    @Column(nullable = false)
    private Date batdau;
    @Column(nullable = false)
    private Date ketthuc;
    @Column(nullable = false)
    private boolean trangthai;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @OneToOne(targetEntity = LoaiGoi.class)
    private LoaiGoi loaiGoi;
}
