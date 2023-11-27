package com.example.tramthuphikhongdung.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBatdau() {
		return batdau;
	}
	public void setBatdau(Date batdau) {
		this.batdau = batdau;
	}
	public Date getKetthuc() {
		return ketthuc;
	}
	public void setKetthuc(Date ketthuc) {
		this.ketthuc = ketthuc;
	}
	public boolean isTrangthai() {
		return trangthai;
	}
	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LoaiGoi getLoaiGoi() {
		return loaiGoi;
	}
	public void setLoaiGoi(LoaiGoi loaiGoi) {
		this.loaiGoi = loaiGoi;
	}
    
}
