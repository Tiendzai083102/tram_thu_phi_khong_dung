package com.example.tramthuphikhongdung.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String ten;
	private Date ngaysinh;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	private String quequan;
	private Integer sodu = 0;
	@Column(nullable = false, unique = true)
	private String bienso;
	@Column(nullable = false)
	private String maubien;
	@Column(nullable = false, unique = true)
	private String rfid;
	@Column(nullable =  false)
	private boolean isAdmin;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	public Integer getSodu() {
		return sodu;
	}
	public void setSodu(Integer sodu) {
		this.sodu = sodu;
	}
	public String getBienso() {
		return bienso;
	}
	public void setBienso(String bienso) {
		this.bienso = bienso;
	}
	public String getMaubien() {
		return maubien;
	}
	public void setMaubien(String maubien) {
		this.maubien = maubien;
	}
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
