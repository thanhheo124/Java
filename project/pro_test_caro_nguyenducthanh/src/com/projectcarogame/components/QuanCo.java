package com.projectcarogame.components;

import javax.swing.Icon;

public class QuanCo {
	private int x, y;
	private char loaiQuanCo;

	public QuanCo(int x, int y, char loaiQuanCo) {
		super();
		this.x = x;
		this.y = y;
		this.loaiQuanCo = loaiQuanCo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		QuanCo quanCo = (QuanCo) obj;
		return this.x == quanCo.getX() && this.y == quanCo.getY();
	}
}
