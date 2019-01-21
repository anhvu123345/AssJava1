package com.anhvu.ass;

import java.util.Scanner;

public class NhanVien {
	public String manv;
	public String hoten;
	public double luong;

	
	
	public NhanVien() {
		super();
	}

	public NhanVien(String manv, String hoten, double luong) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.luong = luong;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	public double getThuNhap() {
	 return luong-getThueThuNhap();
	}
	public double getThueThuNhap() {
		if(luong<9000000) {
			return 0;
		}else if(luong>=9000000 && luong <= 15000000) {
			return luong*10/100;
		}else {
			return luong*12/100;
		}
		
	}
	
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên: ");
		manv = sc.nextLine();
		System.out.println("Nhập họ tên nhân viên: ");
		hoten = sc.nextLine();
		System.out.println("Nhập lương: ");
		luong = sc.nextDouble();
	}
}
