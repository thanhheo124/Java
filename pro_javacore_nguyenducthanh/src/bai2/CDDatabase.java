/**
 * Copyright(C) 2017 Luvina
 * CDDatabase.java Sep 26, 2017 ducthanh
 */
package bai2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ducthanh
 *
 */
public class CDDatabase {
	private Connection connect;
	private DAOCDs dao;

	/**
	 * phuong thuc khoi tao
	 */
	public CDDatabase() {
		dao = new DAOCDs();
	}

	/**
	 * insert theo doi tuong
	 * 
	 * @param cdTemp
	 * @return thong bao
	 */

	public String insertCD(CDs cdTemp) {
		String thongBao = "";

		try {
			connect = dao.connect();
			String artist = cdTemp.getArtist();
			String title = cdTemp.getTitle();
			String sql = "INSERT INTO cds values(?,?)";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, artist);
			stm.setString(2, title);
			int kt = stm.executeUpdate();
			if (kt > 0) {
				thongBao = "Dữ liệu trống Thêm thành công";
			} else {
				thongBao = "Dữ liệu đã tồn tại! Thêm không thành công";
			}

		} catch (SQLException e) {
			System.out.println("Bị đứt kết nối");
		} finally {
			closeConnect();
		}
		return thongBao;
	}

	private void closeConnect() {
		try {
			connect.close();
		} catch (SQLException e) {
		}
		
	}

	/**
	 * xoa theo doi tuong
	 * 
	 * @param cdTemp
	 * @return thong bao
	 */
	public String removeCD(CDs cdTemp) {
		String thongBao = "";
		try {
			connect = dao.connect();
			String artist = cdTemp.getArtist();
			String title = cdTemp.getTitle();

			String sql = "DELETE FROM cds where artist = ? and title = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, artist);
			stm.setString(2, title);
			stm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Bị đứt kết nối");
		} finally {
			closeConnect();
		}
		return thongBao;
	}

	/**
	 * tim boi ten Bai hat
	 * 
	 * @param stringTitle
	 * @return ListCDs
	 */
	public ArrayList<CDs> findByTitle(String stringTitle) {
		ArrayList<CDs> arrayCD = new ArrayList<>();
		try {
			stringTitle.replace("%", "\\%");
			connect = dao.connect();
			String sql = "SELECT *FROM cds where title like ?";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1, "%" + stringTitle + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				CDs cd = new CDs(rs.getString("artist"), rs.getString("title"));
				arrayCD.add(cd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return arrayCD;

	}
	/**
	 * kiểm tra xem cdTemp có trong Database hay chưa
	 * @param cdTemp
	 * @return Khóa đánh dấu
 	 */
	public String kiemTraCDDatabase(CDs cdTemp) {
		String title = cdTemp.getTitle();
		String artist = cdTemp.getArtist();
		ArrayList<CDs> arrayCD = new ArrayList<>();
		try {
			title.replace("%", "\\%");
			connect = dao.connect();
			String sql = "SELECT *FROM cds where title like (?) and artist like (?) ";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1, "%" + title + "%");
			pstm.setString(2, "%" + artist + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				CDs cd = new CDs(rs.getString("artist"), rs.getString("title"));
				arrayCD.add(cd);
			}
			closeConnect();
			if (arrayCD.isEmpty()) {
				return "EMPTY";
			} else {
				return "EXIST";
			}
		} catch (Exception e) {
			return "DISCONECT";
		} finally {
			closeConnect();
		}
		
	}

	/**
	 * tim` boi ten Casi 
	 * @param string
	 * @return ListCDs
	 */
	public ArrayList<CDs> findByArtist(String stringTitle) {
		ArrayList<CDs> arrayCD = new ArrayList<>();
		try {
			stringTitle = stringTitle.replace("%", "\\%");
			connect = dao.connect();
			String sql = "SELECT *FROM cds where artist like (?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1, "%" + stringTitle + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				CDs cd = new CDs(rs.getString("artist"), rs.getString("title"));
				arrayCD.add(cd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}
		return arrayCD;
	}
	/**
	 * Nhập vào dữ liệu CDs gồm 2 trường artist và title
	 * @return CDs
	 */
	public CDs nhap() {
		String nghesi = nhapTenNgheSi();
		String baihat = nhapTenBaiHat();
		CDs cd1 = new CDs(nghesi, baihat);
		return cd1;
	}
	/**
	 * nhap vào tên Title
	 * @return title
	 */
	public String nhapTenBaiHat() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập tên bài hát");
		String baihat = sc.nextLine();
		while (!kiemTra(baihat, "Bài hát")) {
			System.out.println("Hãy nhập tên bài hát");
			baihat = sc.nextLine();
		}
		return baihat;
	}
	/**
	 * Nhập vào artist
	 * @return artist
	 */
	public String nhapTenNgheSi() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập tên  nghệ sĩ");
		String nghesi = sc.nextLine();
		while (!kiemTra(nghesi, "Nghệ sĩ")) {
			System.out.println("Hãy nhập tên nghệ sĩ");
			nghesi = sc.nextLine();
		}
		return nghesi;
	}
	/**
	 * kiểm tra xem dữ liệu có hợp lý không
	 * @param value
	 * @param name
	 * @return true or false
	 */
	private boolean kiemTra(String value, String name) {
		while (value.contains("  ")) {
			value = value.replace("  ", " ");
		}
		switch (value) {
		case " ":
			System.out.println("Tên " + name + " không hợp lệ");
			return false;
		case "":
			System.out.println("Tên " + name + " không được để trống");
			return false;
		default:
			return true;
		}
	}
}
