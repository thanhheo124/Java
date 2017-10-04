package com.luvina.caromanager;

import java.awt.Color;

public class BanCo {
	public static final int SO_HANG = 20;
	public static final int SO_COT = 20;
	public static final int SIZE_O_VUONG = 30;
	private Color mauSacBanCo;
	private NguoiChoi nguoiChoi1;
	private NguoiChoi nguoiChoi2;
	private String tiSo;
	private boolean thangCuoc;
	public static int ngChoi1Thang;
	public static int ngChoi2Thang;

	public boolean isThangCuoc() {
		return thangCuoc;
	}

	public BanCo(Color mauSacBanCo, NguoiChoi nguoiChoi1, NguoiChoi nguoiChoi2) {
		super();
		this.mauSacBanCo = mauSacBanCo;
		this.nguoiChoi1 = nguoiChoi1;
		this.nguoiChoi2 = nguoiChoi2;
	}

	public void kiemTraThangCuoc() {
		int soTranThangNguoiChoi1 = 0;
		int soTranThangNguoiChoi2 = 0;

		if (nguoiChoi1.getListQuanCo().size() + nguoiChoi2.getListQuanCo().size() < 9)
			return;
		else {
			for (int i = 0; i < nguoiChoi1.getListQuanCo().size(); i++) {
				int x = nguoiChoi1.getListQuanCo().get(i).getX();
				int y = nguoiChoi1.getListQuanCo().get(i).getY();
				if (nguoiChoi1.kiemTra(x, y)) {
					soTranThangNguoiChoi1++;
					thangCuoc = true;
					ngChoi1Thang++;
					break;

				}
			}

			if (thangCuoc == false)
				for (int i = 0; i < nguoiChoi2.getListQuanCo().size(); i++) {
					int x = nguoiChoi2.getListQuanCo().get(i).getX();
					int y = nguoiChoi2.getListQuanCo().get(i).getY();
					if (nguoiChoi2.kiemTra(x, y)) {
						soTranThangNguoiChoi2++;
						thangCuoc = true;
						ngChoi2Thang++;
						break;

					}
				}

		}

		if (thangCuoc) {
			xoaBanCo();
		}

	}

	public void xoaBanCo() {
		nguoiChoi1.xoaCo();
		nguoiChoi2.xoaCo();
	}

}
