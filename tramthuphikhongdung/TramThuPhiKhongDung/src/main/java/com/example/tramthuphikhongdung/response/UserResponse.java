package com.example.tramthuphikhongdung.response;

import java.sql.Date;

import lombok.Data;

@Data
public class UserResponse {
	private Integer id;
	private String ten;
	private Date ngaysinh;
	private String email;
	private String quequan;
	private Integer sodu = 0;
	private String bienso;
	private String maubien;
	private String rfid;
	private boolean isAdmin;
}
