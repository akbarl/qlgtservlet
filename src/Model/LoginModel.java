package Model;

import java.sql.*;
import java.io.*;

public class LoginModel {
	
	public LoginModel(){
	}
	
	public boolean checkLogin(String username, String password){
		
		try{
			Database db = new Database();
			Connection conn=db.getConn();
			//Class.forName(JDBC_DRIVER);
			//conn = DriverManager.getConnection(DB_URL,USER,PASS);
			String sql = "Select * From giangvien Where email=? and matkhau=md5(?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			boolean result = rs.next();
			rs.close();
			stm.close();
			conn.close();
			if(result){
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public int getIDCanBo(String username, String password){
		// Quy uoc:
		// 1: Admin
		// 2: 
		// 3: 
		// 4: 
		Connection conn = null;
		int id_cb=0;
		
		return id_cb;
	}
	
	public int getLoaiNguoiDung(String username, String password){
		// Quy uoc:
		// 1: Admin
		// 2: 
		// 3: 
		// 4: 
		Connection conn = null;
		int loaicb = 10;
		
		return loaicb;
	}
}
