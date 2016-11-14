package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Classes.GiangVien;
import Classes.GiaoTrinh;
public class GiangVien_Model {
	
	private Connection conn;
	Statement stmt = null;
	ResultSet rs = null;
	
	public GiangVien_Model() throws Exception
	{
		Database db = new Database();
		conn = db.getConn();
	}
	public boolean close() throws SQLException
	{
		conn.close();
		return true;
	}
	
	protected Statement getStatement() throws SQLException, Exception{
		 if(stmt == null){
			 stmt = conn.createStatement();
		 }
		 return stmt;
	}
	public boolean insertGiangVien(GiangVien gv) throws SQLException
	{
		String sql = "insert into GiangVien(MaGiangVien, TenGiangVien, Email, MatKhau, DiaChi, SoDienThoai, NgaySinh, MaKhoa, MaHoiDong, LoaiNguoiDung) VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, gv.getMaGiangVien());
		pst.setString(2, gv.getTenGiangVien());
		pst.setString(3, gv.getEmail());
		pst.setString(4, gv.getMatKhau());
		pst.setString(5, gv.getDiaChi());
		pst.setString(6, gv.getSoDienThoai());
		pst.setDate(7, gv.getNgaySinh());
		pst.setInt(8, gv.getMaKhoa());
		pst.setInt(9, gv.getMaHoiDong());
		pst.setInt(10, gv.getMaChucVu());
		return pst.executeUpdate() > 0 ;
	}
	
	public int getIDbyEmail(String Email) throws SQLException
	{
		String sql = "SELECT * FROM giangvien WHERE Email = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, Email);
		rs = pst.executeQuery();
		if(rs.next())
			return rs.getInt("MaGiangVien");
		else
			return 0;
	}
	
	public boolean updateHoiDong(int magv, int hd) throws SQLException
	{
		String sql = "UPDATE giangvien SET MaHoiDong = ? WHERE MaGiangVien = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, hd);
		pst.setInt(2, magv);
		return pst.executeUpdate() > 0 ;
	}
	
	public boolean setHoiDongNull(int MaHoiDong) throws SQLException
	{
		String sql = "UPDATE giangvien SET MaHoiDong = null WHERE MaHoiDong = "+MaHoiDong;
		PreparedStatement pst = conn.prepareStatement(sql);
		//pst.setInt(1, MaHoiDong);
		//rs = getStatement().executeQuery(sql);
		
		return pst.executeUpdate() > 0 ;
	}
	
	public ArrayList<GiangVien> getAll() throws Exception{
		 ArrayList<GiangVien> lst = new ArrayList<GiangVien>();
		 String strSQL = "select * from giangvien";
		 try {
			 rs = getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 GiangVien gv = new GiangVien();
				 gv.setMaGiangVien(rs.getInt("MaGiangVien"));
				 gv.setTenGiangVien(rs.getString("TenGiangVien"));
				 gv.setEmail(rs.getString("Email"));
				 gv.setMaHoiDong(rs.getInt("MaHoiDong"));
				 gv.setMaChucVu(rs.getInt("LoaiNguoiDung"));
				 lst.add(gv);
			 }
		 } catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.close();
		 return lst;
	}
	
	public GiangVien getGiangVienbyID(int MaGiangVien) throws Exception
	{
		String strSQL = "SELECT * FROM giangvien WHERE MaGiangVien = "+MaGiangVien;
		GiangVien gv = new GiangVien();
		try{
			rs = getStatement().executeQuery(strSQL);
			while(rs.next()){
				gv.setMaGiangVien(rs.getInt("MaGiangVien"));
				gv.setTenGiangVien(rs.getString("TenGiangVien"));
				gv.setEmail(rs.getString("Email"));
				gv.setMatKhau(rs.getString("MatKhau"));
				gv.setDiaChi(rs.getString("DiaChi"));
				gv.setSoDienThoai(rs.getString("SoDienThoai"));
				gv.setNgaySinh(rs.getDate("NgaySinh"));
				gv.setMaKhoa(rs.getInt("MaKhoa"));
				gv.setMaHoiDong(rs.getInt("MaHoiDong"));
				gv.setMaChucVu(rs.getInt("LoaiNguoiDung"));
			 }
			
		}catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		}
		conn.close();
		return gv;
	}
	
	public ArrayList<GiangVien> getGiangVienbyHoiDong(int MaHoiDong) throws Exception{
		 ArrayList<GiangVien> lst = new ArrayList<GiangVien>();
		 String strSQL = "select * from giangvien WHERE MaHoiDong = "+MaHoiDong;
		 try {
			 rs = getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 GiangVien gv = new GiangVien();
				 gv.setMaGiangVien(rs.getInt("MaGiangVien"));
				 gv.setTenGiangVien(rs.getString("TenGiangVien"));
				 gv.setEmail(rs.getString("Email"));
				 gv.setMaHoiDong(rs.getInt("MaHoiDong"));
				 gv.setMaChucVu(rs.getInt("LoaiNguoiDung"));
				 lst.add(gv);
			 }
		 } catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.close();
		 return lst;
	}
	
	public boolean updateGiangVien(GiangVien gv) throws SQLException
	{
		String sql = "Update giangvien SET TenGiangVien = ?, Email = ?, DiaChi = ?, SoDienThoai = ?, NgaySinh = ?, MaKhoa = ?, LoaiNguoiDung = ? WHERE MaGiangVien = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		//pst.setInt(1, gv.getMaGiangVien());
		pst.setString(1, gv.getTenGiangVien());
		pst.setString(2, gv.getEmail());
		//pst.setString(4, gv.getMatKhau());
		pst.setString(3, gv.getDiaChi());
		pst.setString(4, gv.getSoDienThoai());
		pst.setDate(5, gv.getNgaySinh());
		pst.setInt(6, gv.getMaKhoa());
		//pst.setInt(7, gv.getMaHoiDong());
		pst.setInt(7, gv.getMaChucVu());
		pst.setInt(8, gv.getMaGiangVien());
		return pst.executeUpdate() > 0 ;
	}
	
	public boolean deleteGiangVien(int MaGiangVien) throws SQLException
	{
		String sql = "DELETE FROM giangvien WHERE MaGiangVien = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, MaGiangVien);
		return pst.executeUpdate() > 0 ;
	}
	
	public int countAll() throws SQLException, Exception
	{
		String sql = "select count(*) from giangvien";
		rs = getStatement().executeQuery(sql);
		while(rs.next())
			return rs.getInt(1);
		return 0;
		
	}
	public String getTenChucVu(int MaChucVu)
	{
		if(MaChucVu == 1)
			return "Giang Vien";
		if(MaChucVu == 2)
			return "Truong Khoa";
		if(MaChucVu == 3)
			return "Admin";
		return "";
	}
	
	public ArrayList<GiangVien> searchGiangVienbyID(int MaGiangVien) throws Exception{
		 ArrayList<GiangVien> lst = new ArrayList<GiangVien>();
		 String strSQL = "select * from giangvien WHERE MaGiangVien LIKE '%"+MaGiangVien+"%'";
		 try {
			 rs = getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 GiangVien gv = new GiangVien();
				 gv.setMaGiangVien(rs.getInt("MaGiangVien"));
				 gv.setTenGiangVien(rs.getString("TenGiangVien"));
				 gv.setEmail(rs.getString("Email"));
				 gv.setMaHoiDong(rs.getInt("MaHoiDong"));
				 gv.setMaChucVu(rs.getInt("LoaiNguoiDung"));
				 lst.add(gv);
			 }
		 } catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.close();
		 return lst;
	}
	
	public ArrayList<GiangVien> searchGiangVienbyName(String TenGiangVien) throws Exception{
		 ArrayList<GiangVien> lst = new ArrayList<GiangVien>();
		 String strSQL = "select * from giangvien WHERE TenGiangVien LIKE '%"+TenGiangVien+"%'";
		 try {
			 rs = getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 GiangVien gv = new GiangVien();
				 gv.setMaGiangVien(rs.getInt("MaGiangVien"));
				 gv.setTenGiangVien(rs.getString("TenGiangVien"));
				 gv.setEmail(rs.getString("Email"));
				 gv.setMaHoiDong(rs.getInt("MaHoiDong"));
				 gv.setMaChucVu(rs.getInt("LoaiNguoiDung"));
				 lst.add(gv);
			 }
		 } catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.close();
		 return lst;
	}
	
	public ArrayList<GiangVien> searchGiangVienbyEmail(String Email) throws Exception{
		 ArrayList<GiangVien> lst = new ArrayList<GiangVien>();
		 String strSQL = "select * from giangvien WHERE Email LIKE '%"+Email+"%'";
		 try {
			 rs = getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 GiangVien gv = new GiangVien();
				 gv.setMaGiangVien(rs.getInt("MaGiangVien"));
				 gv.setTenGiangVien(rs.getString("TenGiangVien"));
				 gv.setEmail(rs.getString("Email"));
				 gv.setMaHoiDong(rs.getInt("MaHoiDong"));
				 gv.setMaChucVu(rs.getInt("LoaiNguoiDung"));
				 lst.add(gv);
			 }
		 } catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.close();
		 return lst;
	}
	
	
	
	

}
