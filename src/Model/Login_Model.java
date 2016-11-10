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
		public int getIDGiangVien(String username) throws SQLException, Exception{	// Quy uoc:
			// Quy uoc:
			// 1: Giang Vien
			// 2: Truong Khoa
			// 3: Admin
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
	
	public int getLoaiNguoiDung(String username) throws Exception{
		// Quy uoc:
		// 1: Giang Vien
		// 2: Truong Khoa
		// 3: Admin
		// 4: 
		Connection conn = null;
		Database db = new Database();
		conn=db.getConn();
		//GiangVien_Model gv = new GiangVien_Model().getIDbyEmail(username);
		String sql = "Select LoaiNguoiDung From giangvien Where Email = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			return rs.getInt("LoaiNguoiDung");
		else
			return 0;
	}
	
	public String getTenGiangVien(String username) throws Exception{
		// Quy uoc:
		// 1: Giang Vien
		// 2: Truong Khoa
		// 3: Admin
		// 4: 
		Connection conn = null;
		Database db = new Database();
		conn=db.getConn();
		//GiangVien_Model gv = new GiangVien_Model().getIDbyEmail(username);
		String sql = "Select TenGiangVien From giangvien Where Email = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			return rs.getString("TenGiangVien");
		else
			return "";
	}
}
