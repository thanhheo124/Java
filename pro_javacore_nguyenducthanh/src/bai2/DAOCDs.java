/**
 * Copyright(C) 2017 Luvina
 * DAO.java Sep 26, 2017 ducthanh
 */
package bai2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ducthanh
 *
 */
public class DAOCDs {
	Properties prt;

	/**
	 * ket noi voi CSDL
	 * 
	 * @return connection
	 */
	public Connection connect() {
		Connection con = null;
		try {
			prt = new Properties();
			prt.load(new FileReader(new File("load.properties")));
			String url = prt.getProperty("url");
			String userName = prt.getProperty("userName");
			String passWord = prt.getProperty("passWord");

			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, passWord);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("Không kết nối được");
		} // nap driver
		return con;
	}

}
