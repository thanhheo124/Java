/**
 * Copyright(C) 2017 Luvina
 * DivisionAB.java Sep 25, 2017 ducthanh
 */
package bai1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author ducthanh
 * chia 2 số AB
 */
public class DivisionAB {
	
	/**
	 *  phuong thuc khoi tao.
	 */
	public DivisionAB() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Lấy dữ liệu từ bàn phím
	 * @param nameTemp - tên biến truyefn vào
	 * @return 1 String.
	 */
	
	public String getData(String nameTemp) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Giá trị ["+nameTemp+"]:");
		String temp = sc.nextLine();
		return temp;
	
		
	}

	/**
	 * kiểm tra dữ liệu nhập vào
	 * @param stringData
	 * @return true or false;
	 */
	public boolean checkData(String stringData) {
		boolean checkKQ = true;
		if(stringData.length()==0) {
			System.out.println("Hãy nhập giá trị cho ["+stringData+"]");
			checkKQ = false;
		}else if(stringData.length()>5){
			System.out.println("Giá trị ["+stringData+"]không được lớn hơn 5 số. Hãy nhập lại.");
			checkKQ = false;
		} else {
			checkKQ = validateNumber(stringData);
			if(!checkKQ) {
				System.out.println("Giá trị ["+stringData+"] phải là giá trị số và > 0. Hãy nhập lại");
			}else {
				int so = Integer.parseInt(stringData);
				if(so==0) {
					System.out.println("Giá trị ["+stringData+"] phải là giá trị số và > 0. Hãy nhập lại");
					checkKQ = false;
				}
			}
		}
		return checkKQ;
	}
	
	/**
	 * kiểm tra số có phải là số âm hoặc bằng 0 hay ko?
	 * @param stringData - dữ liệu truyền vào để kiểm tra
	 * trả về true, false
	 */
	private boolean validateNumber(String stringData) {
		Pattern type = Pattern.compile("\\d+");
		Matcher mat = type.matcher(stringData);
		boolean kt = mat.matches();
		return kt;
	}
	/**
	 * tính toán dữ liệu
	 * @param tu
	 * @param mau
	 * @return kết quả phép chia
	 */
	public float calculator(String tu,String mau) {
		int A = Integer.parseInt(tu);
		int B = Integer.parseInt(mau);
		float kq = (float) A/B;
		return kq;
	}
}

