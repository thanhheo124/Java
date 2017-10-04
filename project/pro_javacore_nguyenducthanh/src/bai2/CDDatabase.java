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




/**
 * @author ducthanh
 *
 */
public class CDDatabase {
	Connection connect;
	/**
	 * phuong thuc khoi tao
	 */
	public CDDatabase() {
		DAOCDs dao = new DAOCDs();
		 connect = dao.connect();
	}
	
	/**
	 * insert theo doi tuong
	 * @param cdTemp
	 * @return thong bao
	 */
	
	public String insertCD(CDs cdTemp) {
		String thongBao = "";
		String artist = cdTemp.getArtist();
		String title = cdTemp.getTitle();
		String sql = "INSERT INTO cds values(?,?)";
		
		try {
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, artist);
			stm.setString(2, title);
			int kt = stm.executeUpdate();
			if(kt > 0 ) {
				thongBao = "Thêm thành công";
			}else {
				thongBao = "Chưa thành công";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return thongBao;
	}

	/**
	 * xoa theo doi tuong
	 * @param cdTemp
	 * @return thong bao
	 */
	public String removeCD(CDs cdTemp) {
		String thongBao = "";
		String artist = cdTemp.getArtist();
		String title = cdTemp.getTitle();
		
		String sql = "DELETE FROM cds where artist = ? and title = ?";
		try {
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, artist);
			stm.setString(2, title);
			int kt = stm.executeUpdate();
			if(kt > 0 ) {
				thongBao = "Thêm thành công";
			}else {
				thongBao = "Chưa thành công";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thongBao;
	}

	/**
	 * tim boi ten Bai hat
	 * @param stringTitle
	 * @return ListCDs
	 */
	public ArrayList<CDs> findByTitle(String stringTitle) {
		String sql = "SELECT *FROM cds where title like ?";
		ArrayList<CDs> arrayCD = new ArrayList<>();
		try {
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1, "%"+stringTitle+"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				CDs cd = new CDs(rs.getString("artist"), rs.getString("title"));
				arrayCD.add(cd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayCD;
		
	}

	/**
	 * tim` boi ten Casi
	 * @param string
	 * @return ListCDs
	 */
	public ArrayList<CDs> findByArtist(String stringTitle) {
		String sql = "SELECT *FROM cds where artist like ?";
		ArrayList<CDs> arrayCD = new ArrayList<>();
		try {
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1, "%"+stringTitle+"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				CDs cd = new CDs(rs.getString("artist"), rs.getString("title"));
				arrayCD.add(cd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayCD;
	}
}
