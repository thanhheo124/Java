/**
 * Copyright(C) 2017 Luvina
 * DAO.java Sep 26, 2017 ducthanh
 */
package bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ducthanh
 *
 */
public class DAOCDs {
	/**
	 * ket noi voi CSDL
	 * @return connection
	 */
	public Connection connect() {
		Connection con = null;
		String url = "jdbc:mysql://localhost/cds";
		String userName = "root";
		String passWord = "root";

		String driver = "com.mysql.jdbc.Driver";
//		System.out.println("kết nối thành công");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, passWord);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} // nap driver
		return con;
	}
	
	
}
