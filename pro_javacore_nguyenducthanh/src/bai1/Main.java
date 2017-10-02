/**
 * Copyright(C) 2017 Luvina
 * Main.java Sep 25, 2017 ducthanh
 */
package bai1;

/**
 * 
 * @author ducthanh
 *
 */
public class Main {
	/**
	 * chạy chương trình
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DivisionAB divisionAB = new DivisionAB();

		String A = divisionAB.getData("A");

		while (!divisionAB.checkData(A, "A")) {
			A = divisionAB.getData("A");
		}

		String B = divisionAB.getData("B");

		while (!divisionAB.checkData(B, "B")) {
			B = divisionAB.getData("B");
		}

		float kq = divisionAB.calculator(A, B);

		System.out.println("Thương của A/B bằng: " + kq);
	}
}
