package com.anhvu.ass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ass {
	public static Scanner sc = new Scanner(System.in);
	public static List<NhanVien> arr = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		S: for (int i = 0;; i++) {
			showMenu();
			Chon();
			System.out.println("Bạn có tiếp tục chương trình hay không (N/Y)");
			String key = sc1.nextLine();
			if (key.equalsIgnoreCase("Y")) {
				continue S;
			} else {
				break;
			}

		}

	}

	public static void showMenu() {
		System.out.println("******************************");
		System.out.println("              MENU         ");
		System.out.println("1. Nhập danh sách nhân viên từ bàn phím.");
		System.out.println("2. Xuất danh sách nhân viên ra màn hình.");
		System.out.println("3. Tìm và hiển thị nhân viên theo mã nhập từ bàn phím.");
		System.out.println("4. Xóa nhân viên theo mã nhập từ bàn phím.");
		System.out.println("5. Cập nhật thông tin nhân viên theo mã nhập từ bàn phím");
		System.out.println("6. Tìm các nhân viên theo khoảng lương nhập từ bàn phím.");
		System.out.println("7. Sắp xếp nhân viên theo họ và tên.");
		System.out.println("8. Sắp xếp nhân viên theo thu nhập.");
		System.out.println("9. Xuất 5 nhân viên có thu nhập cao nhất.");
		System.out.println("10.Thoát");
		System.out.println("******************************");
	}

	public static void Chon() {

		System.out.println("Xin mời bạn chọn chức năng: ");
		int chon = sc.nextInt();
		switch (chon) {
		case 1:
			NhapDS();
			break;
		case 2:
			XuatDS();
			break;
		case 3:
			XuatNVTheoMa();
			break;
		case 4:
			XoaNVTheoMa();
			break;
		case 5:
			CapNhatThongTin();
			break;
		case 6:
			TimNVTheoKhoangLuong();
			break;
		case 7:
			SXTheoHoTen();
			break;
		case 8:
			SXTheoThuNhap();
			break;
		case 9:
			Top5NVLuongCaoNhat();
			break;
		case 10:
			System.out.println("Bạn đã thoát khỏi chương trình");
			System.exit(0);		
			break;

		default:
			System.out.println("Chức năng này không có trong chương trình");

		}
	}

	public static List<NhanVien> NhapDS() {					
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập danh sách nhân viên của công ty");
		String chon2;
		String chon1;
		A: for (int i = 1;; i++) {
			System.out.println("Mời bạn chọn loại nhân viên: Hành chính(HC), Tiếp thị(TT), Trưởng Phòng(TP)");
			chon2 = scan.nextLine();
			if (chon2.equalsIgnoreCase("HC")) {
				NhanVien nv = new NhanVien();
				nv.Nhap();
				arr.add(nv);
			} else if (chon2.equalsIgnoreCase("TT")) {
				TiepThi tt = new TiepThi();
				tt.Nhap();
				arr.add(tt);
			} else if (chon2.equalsIgnoreCase("TP")) {
				TruongPhong tp = new TruongPhong();
				tp.Nhap();
				arr.add(tp);
			} else {
				System.out.println("Bạn đã chọn sai");
			}
			System.out.println("Bạn có muốn tiếp tục:(N/Y) ");
			chon1 = scan.nextLine();
			if (chon1.equalsIgnoreCase("Y")) {
				continue A;
			} else {
				break;
			}

		}
		return arr;

	}

	public static void XuatDS() {
		System.out.println("Danh sách nhân viên của công ty");
		for (NhanVien list : arr) {
			System.out.println("Mã nhân viên: " + list.manv);
			System.out.println("Họ tên: " + list.hoten);
			System.out.println("Lương: " + list.luong);
			System.out.println("Thuế thu nhập: " + list.getThueThuNhap());
			System.out.println("Thu nhập sau thuế: " + list.getThuNhap());
			System.out.println("******************************");
		}
	}

	public static ArrayList<NhanVien> TimDSTheoMaNV(String ma) {
		ArrayList<NhanVien> list = new ArrayList<>();
		for (NhanVien ds : arr) {
			if (ds.manv.equals(ma)) {
				list.add(ds);
			}
		}
		return list;
	}

	public static void XuatNVTheoMa() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên cần tìm: ");
		String ma = scan.nextLine();
		ArrayList<NhanVien> list = TimDSTheoMaNV(ma);
		for (NhanVien ls : list) {
			System.out.println("Mã nhân viên: " + ls.manv);
			System.out.println("Họ tên: " + ls.hoten);
			System.out.println("Lương: " + ls.luong);
			System.out.println("Thu nhập sau thuế: " + ls.getThuNhap());
			System.out.println("******************************");
		}

	}

	public static void XoaNVTheoMa() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên cần xóa: ");
		String maa = scan.nextLine();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).manv.equalsIgnoreCase(maa)) {
				arr.remove(i);
			}
		}

	}

	public static void CapNhatThongTin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên cần cập nhật: ");
		String maa = scan.nextLine();
		boolean isSearch = false;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).manv.equalsIgnoreCase(maa)) {
				isSearch = true;
				NhanVien x = arr.get(i);
				x.Nhap();
				arr.remove(i);
				arr.add(i, x);
			}
		}
	}

	public static void TimNVTheoKhoangLuong() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập số lương từ khoảng: ");
		double from = scan.nextDouble();
		System.out.print("Đến: ");
		double to = scan.nextDouble();
		ArrayList<NhanVien> listTim = new ArrayList<NhanVien>();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).luong >= from && arr.get(i).luong <= to) {
				listTim.add(arr.get(i));
			}
		}
		for (NhanVien list : listTim) {
			System.out.println("Mã nhân viên: " + list.manv);
			System.out.println("Họ tên: " + list.hoten);
			System.out.println("Lương: " + list.luong);
			System.out.println("Thuế thu nhập: " + list.getThueThuNhap());
			System.out.println("Thu nhập sau thuế: " + list.getThuNhap());
			System.out.println("******************************");
		}

	}

	public static void SXTheoHoTen() {
		Comparator<NhanVien> com = new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				// TODO Auto-generated method stub
				return o1.getHoten().compareTo(o2.getHoten());
			}

		};
		Collections.sort(arr, com);

		System.out.println("Danh sách nhân viên của công ty sắp xếp theo họ tên: ");
		for (NhanVien list : arr) {
			System.out.println("Mã nhân viên: " + list.manv);
			System.out.println("Họ tên: " + list.hoten);
			System.out.println("Lương: " + list.luong);
			System.out.println("Thuế thu nhập: " + list.getThueThuNhap());
			System.out.println("Thu nhập sau thuế: " + list.getThuNhap());
			System.out.println("******************************");
		}
	}

	public static void SXTheoThuNhap() {
		
		Collections.sort(arr, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				// TODO Auto-generated method stub
				int s = 0;
				double tn1 = o1.getThuNhap(), tn2 = o2.getThuNhap();
				if (tn1 > tn2)
					s = -1;
				else if (tn1 < tn2)
					s = 1;
				else
					s = 0;
				return s;
			}

		});
		System.out.println("Danh sách nhân viên của công ty sắp xép theo thu nhập: ");
		for (NhanVien list : arr) {
			System.out.println("Mã nhân viên: " + list.manv);
			System.out.println("Họ tên: " + list.hoten);
			System.out.println("Lương: " + list.luong);
			System.out.println("Thuế thu nhập: " + list.getThueThuNhap());
			System.out.println("Thu nhập sau thuế: " + list.getThuNhap());
			System.out.println("******************************");
		}
	}

	public static void Top5NVLuongCaoNhat() {
		Collections.sort(arr, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				// TODO Auto-generated method stub
				int s = 0;
				double tn1 = o1.getThuNhap(), tn2 = o2.getThuNhap();
				if (tn1 > tn2)
					s = -1;
				else if (tn1 < tn2)
					s = 1;
				else
					s = 0;
				return s;
			}

		});
		
		System.out.println("Top 5 nhân viên có thu nhập cao nhất: ");
		for (int i = 0; i<5; i++) {
			System.out.println("Mã nhân viên: " + arr.get(i).manv);
			System.out.println("Họ tên: " + arr.get(i).hoten);
			System.out.println("Lương: " + arr.get(i).luong);
			System.out.println("Thuế thu nhập: " + arr.get(i).getThueThuNhap());
			System.out.println("Thu nhập sau thuế: " + arr.get(i).getThuNhap());
			System.out.println("******************************");
		}

	}
}
