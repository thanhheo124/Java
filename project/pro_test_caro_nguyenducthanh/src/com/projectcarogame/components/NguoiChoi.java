package com.projectcarogame.components;

import java.util.ArrayList;


public class NguoiChoi {
	ArrayList<QuanCo> listQuanCo;
	private String name;
	private char loaiQuanCo;

	public NguoiChoi(String name, char loaiQuanCo) {
		this.name = name;
		this.loaiQuanCo = loaiQuanCo;
		listQuanCo = new ArrayList<QuanCo>();

	}

	public void danhCo(int x, int y) {
		int H = BanCo.SO_HANG;
		int C = BanCo.SO_COT;
		int dr = BanCo.SIZE_O_VUONG;

		if (!(0 <= x && x <= H * dr && 0 <= y && y <= C * dr)) {
			System.out.println("đánh sai vị trí");

			return;
		}
		x = x / dr * dr + dr / 2;
		y = y / dr * dr + dr / 2;

		QuanCo co = new QuanCo(x, y, loaiQuanCo);
		if (listQuanCo.contains(co)) {
			System.out.println("Vi tri nay da co quan co");

			return;
		}

		else {

			listQuanCo.add(co);
		}
	}

	public void xoaCo() {
		listQuanCo.clear();
	}

	public ArrayList<QuanCo> getListQuanCo() {
		return listQuanCo;
	}

	public void setListQuanCo(ArrayList<QuanCo> listQuanCo) {
		this.listQuanCo = listQuanCo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getLoaiQuanCo() {
		return loaiQuanCo;
	}

	public void setLoaiQuanCo(char loaiQuanCo) {
		this.loaiQuanCo = loaiQuanCo;
	}

	protected boolean kiemTra(int x, int y) {

		return kiemTraDoc(x, y) || kiemTraNgang(x, y) || kiemTraCheoTrai(x, y) || kiemTraCheoPhai(x, y);
	}

	private boolean kiemTraNgang(int x, int y) {

		for (int i = 0; i < 5; i++) {
			QuanCo co = new QuanCo(x, y, loaiQuanCo);
			if (!listQuanCo.contains(co))
				return false;
			else {

				x = x + BanCo.SIZE_O_VUONG;
			}
		}

		return true;

	}

	private boolean kiemTraDoc(int x, int y) {
		for (int i = 0; i < 5; i++) {
			QuanCo co = new QuanCo(x, y, loaiQuanCo);
			if (!listQuanCo.contains(co))
				return false;
			else {

				y = y + BanCo.SIZE_O_VUONG;
			}
		}
		return true;

	}

	private boolean kiemTraCheoTrai(int x, int y) {
		for (int i = 0; i < 5; i++) {
			QuanCo co = new QuanCo(x, y, loaiQuanCo);
			if (!listQuanCo.contains(co))
				return false;
			else {

				x = x + BanCo.SIZE_O_VUONG;
				y = y + BanCo.SIZE_O_VUONG;
			}
		}

		return true;
	}

	private boolean kiemTraCheoPhai(int x, int y) {
		for (int i = 0; i < 5; i++) {
			QuanCo co = new QuanCo(x, y, loaiQuanCo);
			if (!listQuanCo.contains(co))
				return false;
			else {

				x = x - BanCo.SIZE_O_VUONG;
				y = y + BanCo.SIZE_O_VUONG;
			}
		}

		return true;

	}
}
