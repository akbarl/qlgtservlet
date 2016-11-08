package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.GiangVien;
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
	public boolean insertGiangVien(GiangVien gv) throws SQLException
	{
		String sql = "insert into GiangVien(MaGiangVien, TenGiangVien, Email, MatKhau, DiaChi, SoDienThoai, NgaySinh, MaKhoa, MaHoiDong) VALUES(?,?,?,?,?,?,?,?,?)";
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
	
	

}
