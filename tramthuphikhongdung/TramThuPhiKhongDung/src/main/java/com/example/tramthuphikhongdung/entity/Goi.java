package com.example.tramthuphikhongdung.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Date batdau;
    @Column(nullable = false)
    private Date ketthuc;
    @Column(nullable = false)
    private boolean trangthai;
    @ManyToOne(targetEntity = User.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;
    @ManyToOne(targetEntity = LoaiGoi.class)
    private LoaiGoi loaiGoi;
}
