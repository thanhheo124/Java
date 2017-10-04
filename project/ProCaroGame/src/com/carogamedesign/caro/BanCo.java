package com.carogamedesign.caro;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ThanhNv on 6/17/2017.
 */
public class BanCo {

	public static final String MAU_SAC_XANH = "XANH";
	public static final String MAU_SAC_DO = "DO";
	public static final String MAU_SAC_TIM = "TIM";
	public static final String MAU_SAC_VANG = "VANG";

	public static final String TY_SO_MAC_DINH = "0-0";
	public static final int SO_COT = 20;
	public static final int SO_HANG = 20;
	public static final int DO_RONG_O_VUONG = 30;
	public static final int SO_QUAN_THANG = 5;
	private static final int MIN_QUAN_CO_FOR_WIN = 9;
	private static final int NGANG_TRAI = 0;
	private static final int NGANG_PHAI = 1;
	private static final int DOC_TREN = 2;
	private static final int DOC_DUOI = 3;
	private static final int CHEO_TREN_TRAI = 4;
	private static final int CHEO_TREN_PHAI = 5;
	private static final int CHEO_DUOI_TRAI = 6;
	private static final int CHEO_DUOI_PHAI = 7;
	private static final int SO_TRUONG_HOP = 8;

	private String mauSac;
	private String tySo;
	private NguoiChoi MAY, nguoiChoi2;
	private int[] demQuanCoThangHang;

	public BanCo(String mauSac, String tySo, NguoiChoi nguoiChoi1, NguoiChoi nguoiChoi2) {
		this.mauSac = mauSac;
		this.tySo = tySo;
		this.MAY = nguoiChoi1;
		this.nguoiChoi2 = nguoiChoi2;
	}

	public void veBanCo() {
		System.out.println("Ban co duoc ve voi mau: " + mauSac);
	}

	public void xoaBanCo() {
		MAY.xoaCo();
		nguoiChoi2.xoaCo();
	}

	public void choiLai() {
		tySo = TY_SO_MAC_DINH;
		xoaBanCo();
	}

	public void kiemTraThangCuoc() {
		if (MAY.getListQuanCo().size() + nguoiChoi2.getListQuanCo().size() < MIN_QUAN_CO_FOR_WIN) {
			return;
		}
		if (kiemTraThangCuoc(MAY.getLoaiQuanCo())) {
			thongBaoThangCuoc(MAY.getLoaiQuanCo());
		}

		if (kiemTraThangCuoc(nguoiChoi2.getLoaiQuanCo())) {
			thongBaoThangCuoc(nguoiChoi2.getLoaiQuanCo());
		}
	}

	private boolean kiemTraThangCuoc(char loaiQuanCo) {
		List<QuanCo> tmpList = MAY.getListQuanCo();
		if (loaiQuanCo == nguoiChoi2.getLoaiQuanCo()) {
			tmpList = nguoiChoi2.getListQuanCo();
		}

		int size = tmpList.size();
		int maxY = (BanCo.SO_HANG - 1) * BanCo.DO_RONG_O_VUONG;
		int maxX = (BanCo.SO_COT - 1) * BanCo.DO_RONG_O_VUONG;

		for (int i = 0; i < size; i++) {
			QuanCo quanCo = tmpList.get(i);
			if (demQuanCoThangHang(tmpList, quanCo, maxX, maxY)) {
				return true;
			}
		}

		return false;
	}

	private boolean demQuanCoThangHang(List<QuanCo> tmpList, QuanCo quanCo, int maxX, int maxY) {
		demQuanCoThangHang = new int[SO_TRUONG_HOP];
		Arrays.fill(demQuanCoThangHang, 1);

		int xTrai, xPhai, yTren, yDuoi;
		int x = quanCo.getX();
		int y = quanCo.getY();
		char loaiQuanCo = quanCo.getLoaiQuanCo();

		for (int index = 1; index < SO_QUAN_THANG; index++) {
			xTrai = x - index * BanCo.DO_RONG_O_VUONG;
			xPhai = x + index * BanCo.DO_RONG_O_VUONG;
			yTren = y - index * BanCo.DO_RONG_O_VUONG;
			yDuoi = y + index * BanCo.DO_RONG_O_VUONG;

			boolean ketQua = kiemTraTonTaiNgangTrai(tmpList, xTrai, y, loaiQuanCo, maxX, maxY);
			if (ketQua)
				return true;

			ketQua = kiemTraTonTaiNgangPhai(tmpList, xPhai, y, loaiQuanCo, maxX, maxY);
			if (ketQua)
				return true;

			ketQua = kiemTraTonTaiDocTren(tmpList, x, yTren, loaiQuanCo, maxX, maxY);
			if (ketQua)
				return true;

			ketQua = kiemTraTonTaiDocDuoi(tmpList, x, yDuoi, loaiQuanCo, maxX, maxY);
			if (ketQua)
				return true;

			ketQua = kiemTraTonTaiCheoTrenTrai(tmpList, xTrai, yTren, loaiQuanCo, maxX, maxY);
			if (ketQua)
				return true;

			ketQua = kiemTraTonTaiCheoTrenPhai(tmpList, xPhai, yTren, loaiQuanCo, maxX, maxY);
			if (ketQua)
				return true;

			ketQua = kiemTraTonTaiCheoDuoiTrai(tmpList, xTrai, yDuoi, loaiQuanCo, maxX, maxY);
			if (ketQua)
				return true;

			ketQua = kiemTraTonTaiCheoDuoiPhai(tmpList, xPhai, yDuoi, loaiQuanCo, maxX, maxY);
			if (ketQua)
				return true;
		}
		return false;
	}

	private boolean kiemTraTonTai(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int type, int maxX, int maxY) {
		if (x < 0 || x > maxX || y < 0 || y > maxY)
			return false;
		QuanCo tmp = new QuanCo(x, y, loaiQuanCo);
		if (tmpList.contains(tmp)) {
			demQuanCoThangHang[type]++;
			if (demQuanCoThangHang[type] == SO_QUAN_THANG)
				return true;
		}
		return false;
	}

	private boolean kiemTraTonTaiNgangTrai(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int maxX, int maxY) {
		return kiemTraTonTai(tmpList, x, y, loaiQuanCo, NGANG_TRAI, maxX, maxY);
	}

	private boolean kiemTraTonTaiNgangPhai(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int maxX, int maxY) {
		return kiemTraTonTai(tmpList, x, y, loaiQuanCo, NGANG_PHAI, maxX, maxY);
	}

	private boolean kiemTraTonTaiDocTren(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int maxX, int maxY) {
		return kiemTraTonTai(tmpList, x, y, loaiQuanCo, DOC_TREN, maxX, maxY);
	}

	private boolean kiemTraTonTaiDocDuoi(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int maxX, int maxY) {
		return kiemTraTonTai(tmpList, x, y, loaiQuanCo, DOC_DUOI, maxX, maxY);
	}

	private boolean kiemTraTonTaiCheoTrenTrai(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int maxX, int maxY) {
		return kiemTraTonTai(tmpList, x, y, loaiQuanCo, CHEO_TREN_TRAI, maxX, maxY);
	}

	private boolean kiemTraTonTaiCheoTrenPhai(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int maxX, int maxY) {
		return kiemTraTonTai(tmpList, x, y, loaiQuanCo, CHEO_TREN_PHAI, maxX, maxY);
	}

	private boolean kiemTraTonTaiCheoDuoiTrai(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int maxX, int maxY) {
		return kiemTraTonTai(tmpList, x, y, loaiQuanCo, CHEO_DUOI_TRAI, maxX, maxY);
	}

	private boolean kiemTraTonTaiCheoDuoiPhai(List<QuanCo> tmpList, int x, int y, char loaiQuanCo, int maxX, int maxY) {
		return kiemTraTonTai(tmpList, x, y, loaiQuanCo, CHEO_DUOI_PHAI, maxX, maxY);
	}

	private void thongBaoThangCuoc(char loaiQuanCo) {
		String ten;
		int soTranThangCuaNguoiChoi1 = Integer.parseInt(tySo.split("-")[0]);
		int soTranThangCuaNguoiChoi2 = Integer.parseInt(tySo.split("-")[1]);
		int thang, thua;

		if (loaiQuanCo == MAY.getLoaiQuanCo()) {
			soTranThangCuaNguoiChoi1++;
			thang = soTranThangCuaNguoiChoi1;
			thua = soTranThangCuaNguoiChoi2;
			ten = MAY.getTen();
		} else {
			soTranThangCuaNguoiChoi2++;
			thang = soTranThangCuaNguoiChoi2;
			thua = soTranThangCuaNguoiChoi1;
			ten = nguoiChoi2.getTen();
		}
		tySo = soTranThangCuaNguoiChoi1 + "-" + soTranThangCuaNguoiChoi2;

		int ketQua = JOptionPane.showConfirmDialog(null, "Nguoi choi " + ten + " thang cuoc!" + "\nTy so la: Thang: "
				+ thang + ". Thua: " + thua + "\nBan co muon choi tiep khong?", "Thong bao", JOptionPane.YES_NO_OPTION);
		if (ketQua == JOptionPane.YES_OPTION) {
			xoaBanCo();
		}
	}

	public NguoiChoi getNguoiChoi1() {
		return MAY;
	}

	public NguoiChoi getNguoiChoi2() {
		return nguoiChoi2;
	}

	public String getTySo() {
		return tySo;
	}

	
}
