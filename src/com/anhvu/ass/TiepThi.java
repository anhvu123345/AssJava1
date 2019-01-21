package com.anhvu.ass;

import java.util.Scanner;

public class TiepThi  extends NhanVien{

	public double doanhso;
	public double huehong;

	Scanner sc = new Scanner(System.in);
	public TiepThi() {
		super();
	}

	
	public TiepThi(String manv, String hoten, double luong, double doanhso, double huehong) {
		super(manv, hoten, luong);
		this.doanhso = doanhso;
		this.huehong = huehong;
	}

	public double getDoanhso() {
		return doanhso;
	}

	public void setDoanhso(double doanhso) {
		this.doanhso = doanhso;
	}

	public double getHuehong() {
		return huehong;
	}

	public void setHuehong(double huehong) {
		this.huehong = huehong;
	}

	@Override
	public double getThuNhap() {
		// TODO Auto-generated method stub
		return super.getThuNhap() +(doanhso*huehong/100);
	}


	@Override
	public void Nhap() {
		// TODO Auto-generated method stub
		super.Nhap();
		
		System.out.println("Nhập doanh số: ");
		doanhso = sc.nextDouble();
		System.out.println("Nhập huê hồng: ");
		huehong  = sc.nextDouble();
		
	}
	

}
