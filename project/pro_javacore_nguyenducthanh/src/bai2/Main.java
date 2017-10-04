/**
 * Copyright(C) 2017 Luvina
 * Main.java Sep 26, 2017 ducthanh
 */
package bai2;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

/**
 * @author ducthanh
 *
 */
public class Main {
	public static void main(String[] args) {
		CDDatabase cdDatabase = new CDDatabase();

//		 Insert
		CDs cd1 = new CDs("Quang", "Dap vo cay dan");

		// Delete
		CDs cd2 = new CDs("alo", "alo");


		System.out.println("Hay nhap lua chon");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		// thuc hien lua chon
		while(true) {
			switch (choice) {
			case 1:
				System.out.println(cdDatabase.insertCD(cd1));
				return;
			case 2:
				System.out.println(cdDatabase.removeCD(cd2));
				return;
			case 3:
				System.out.println(cdDatabase.findByTitle("Dap vo cay dan"));
				return;
			case 4:
				System.out.println(cdDatabase.findByArtist("Ho Ngoc Ha").toString());
				return;

			default:
				System.out.println("Hãy nhập hàm cần test là từ 1 đến 4. ");
				break;
			}
		}
	}
}
