package com.anhvu.ass;

import java.util.Scanner;

public class TruongPhong extends NhanVien {
	public double trachnhiem;
	Scanner sc = new Scanner(System.in);
	public TruongPhong() {
		super();
	}

	public TruongPhong(String manv, String hoten, double luong, double trachnhiem) {
		super(manv, hoten, luong);
		this.trachnhiem = trachnhiem;
	}

	public double getTrachnhiem() {
		return trachnhiem;
	}

	public void setTrachnhiem(double trachnhiem) {
		this.trachnhiem = trachnhiem;
	}

	@Override
	public double getThuNhap() {
		// TODO Auto-generated method stub
		return super.getThuNhap() +trachnhiem;
	}

	@Override
	public void Nhap() {
		// TODO Auto-generated method stub
		super.Nhap();
		System.out.println("Nhập lương trách nhiệm: ");
		trachnhiem = sc.nextDouble();
	}
	

	
}
