/**
 * Copyright(C) 2017 Luvina
 * Main.java Sep 26, 2017 ducthanh
 */
package bai2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ducthanh
 *
 */
public class Main {
	/**
	 * main chinh
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		CDDatabase cdDatabase = new CDDatabase();

		// thuc hien lua chon

		System.out.println("Hay nhap lua chon");
		System.out.println("0 - Để thoát");
		System.out.println("1 - Để thêm");
		System.out.println("2 - Để xóa");
		System.out.println("3 - Để tìm theo tên bài hát");
		System.out.println("4 - Để tìm theo tên nghệ sĩ");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		switch (choice) {
		case "0":
			break;
		case "1": {
			insertCD(cdDatabase);
			break;
		}
		case "2":
			removeCD(cdDatabase);
			break;
		case "3":
			findByTilte(cdDatabase);
			break;
		case "4":
			findByArtist(cdDatabase);
			break;
		default:
			System.out.println("Hãy nhập hàm cần test là từ 1 đến 4. ");
			menu();
			break;
		}
		loop();
	}

	private static void loop() {
		System.out.println();
		System.out.println("Bạn có muốn tiếp tục ko? Y/N");
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		switch (key) {
		case "Y":
		case "y":
			menu();
			break;
		case "N":
		case "n":
			System.out.println("Ban da thoat ra khoi chuong trinh");
			break;
		default:
			break;
		}
	}

	private static void findByArtist(CDDatabase cdDatabase) {
		String nghesi = cdDatabase.nhapTenNgheSi();
		ArrayList<CDs> cdx = new ArrayList<>();
		cdx = cdDatabase.findByArtist(nghesi);
		System.out.format("%20s%s", "artist", "title");
		for (CDs list : cdx) {
			list.display();
		}

	}

	private static void findByTilte(CDDatabase cdDatabase) {
		String title = cdDatabase.nhapTenBaiHat();
		ArrayList<CDs> cdx = new ArrayList<>();
		cdx = cdDatabase.findByTitle(title);
		System.out.format("%-40s%-1s%n", "artist", "title");
		for (CDs list : cdx) {
			list.display();
		}
	}

	private static void removeCD(CDDatabase cdDatabase) {
		CDs cd2 = cdDatabase.nhap();
		switch (cdDatabase.kiemTraCDDatabase(cd2)) {
		case "EMPTY":
			System.out.println("Dữ liệu trống, đã xóa dữ liệu");
			System.out.println(cdDatabase.removeCD(cd2));
			break;
		case "EXIST":
			System.out.println("Đã xóa thành công");
			System.out.println(cdDatabase.removeCD(cd2));
			break;
		case "DISCONECT":
			System.out.println("Bị đứt kết nối");
			break;
		default:
			break;
		}
		return;

	}

	private static void insertCD(CDDatabase cdDatabase) {
		CDs cd1 = cdDatabase.nhap();
		switch (cdDatabase.kiemTraCDDatabase(cd1)) {
		case "EMPTY":
			System.out.print(cdDatabase.insertCD(cd1));
			break;
		case "EXIST":
			System.out.println("Dữ liệu đã tồn tại, thêm không thành công");
			break;
		case "DISCONECT":
			System.out.println("Bị đứt kết nối");
			break;
		default:
			break;
		}

	}
}
