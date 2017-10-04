package com.carogamedesign.caro;

import java.util.ArrayList;

/**
 * Created by ThanhNv on 6/17/2017.
 */
public class NguoiChoi {
	public static final char LOAI_QUAN_CO_X = 'X';
	public static final char LOAI_QUAN_CO_O = 'O';

	private String ten;
	private ArrayList<QuanCo> listQuanCo;
	private char loaiQuanCo;
	private int diem;
	
	

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public NguoiChoi(String ten, char loaiQuanCo) {
		this.ten = ten;
		this.loaiQuanCo = loaiQuanCo;
		listQuanCo = new ArrayList<>();
	}

	void xoaCo() {
		listQuanCo.clear();
	}

	public String getTen() {
		return ten;
	}

	public ArrayList<QuanCo> getListQuanCo() {
		return listQuanCo;
	}

	public char getLoaiQuanCo() {
		return loaiQuanCo;
	}

	public boolean danhCo(int x, int y) {
		// Kiem tra hop le:
		int maxX = (BanCo.SO_COT - 1) * BanCo.DO_RONG_O_VUONG;
		int maxY = (BanCo.SO_HANG - 1) * BanCo.DO_RONG_O_VUONG;
		if (x < 0 || y < 0 || x > maxX || y > maxY) {
			return false;
		}

		// Dieu chinh x , y
		int cotX = x / BanCo.DO_RONG_O_VUONG;
		int hangY = y / BanCo.DO_RONG_O_VUONG;
		x = cotX * BanCo.DO_RONG_O_VUONG + BanCo.DO_RONG_O_VUONG / 2;
		y = hangY * BanCo.DO_RONG_O_VUONG + BanCo.DO_RONG_O_VUONG / 2;

		// Kiem tra quan co co nam trong ds khong?
		QuanCo quanCo = new QuanCo(x, y, loaiQuanCo);
		if (listQuanCo.contains(quanCo)) {
			System.err.println("Vi tri nay da co quan co!!!");
			return false;
		}

		listQuanCo.add(quanCo);
		return true;
	}
}
