package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GiangVien {
	private int MaGiangVien;
	private String TenGiangVien;
	private String Email;
	private String MatKhau;
	private String DiaChi;
	private String SoDienThoai;
	private Date NgaySinh;
	private int MaKhoa;
	private int MaHoiDong;
	private Connection conn;
	public GiangVien(GiangVien gv) throws Exception
	{
		Database db = new Database();
		conn = db.getConn();
		MaGiangVien = gv.MaGiangVien;
		TenGiangVien = gv.TenGiangVien;
		Email = gv.Email;
		MatKhau = gv.MatKhau;
		DiaChi = gv.DiaChi;
		SoDienThoai = gv.SoDienThoai;
		NgaySinh = gv.NgaySinh;
		MaKhoa = gv.MaKhoa;
		MaHoiDong = gv.MaHoiDong;
	}
	
	public boolean close() throws SQLException
	{
		conn.close();
		return true;
	}
	public boolean insertGiangVien() throws SQLException
	{
		String sql = "insert into GiangVien(MaGiangVien, TenGiangVien, Email, MatKhau, DiaChi, SoDienThoai, NgaySinh, MaKhoa, MaHoiDong) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, MaGiangVien);
		pst.setString(2, TenGiangVien);
		pst.setString(3, Email);
		pst.setString(4, MatKhau);
		pst.setString(5, DiaChi);
		pst.setString(6, SoDienThoai);
		pst.setDate(7, NgaySinh);
		pst.setInt(8, MaKhoa);
		pst.setInt(9, MaHoiDong);
		
		return pst.executeUpdate() > 0 ;
	}
	
	

}
