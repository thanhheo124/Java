package com.carogamedesign.caro;

/**
 * Created by ThanhNv on 6/17/2017.
 */
public class QuanCo {
	private int x, y;
	private char loaiQuanCo;

	public QuanCo(int x, int y, char loaiQuanCo) {
		this.x = x;
		this.y = y;
		this.loaiQuanCo = loaiQuanCo;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getLoaiQuanCo() {
		return loaiQuanCo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof QuanCo) {
			QuanCo tmp = (QuanCo) obj;
			return x == tmp.x && y == tmp.y && loaiQuanCo == tmp.loaiQuanCo;
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return x+"_"+y;
	}
}
