package Model;

import java.sql.*;
import java.io.*;

public class Login_Model {
	
	public Login_Model(){
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
	
	public int getIDCanBo(String username) throws SQLException, Exception{
		// Quy uoc:
		// 1: Admin
		// 2: 
		// 3: 
		// 4: 
		Connection conn = null;
		Database db = new Database();
		conn=db.getConn();
		//GiangVien_Model gv = new GiangVien_Model().getIDbyEmail(username);
		String sql = "Select * From giangvien Where Email = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			return rs.getInt("MaGiangVien");
		else
			return 0;
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
