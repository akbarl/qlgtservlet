package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GiaoTrinh {
	private int MaGiaoTrinh;
	private String TenGiaoTrinh;
	private Date NgayDangKy;
	private Date NgayHoanThanh;
	private int TinhTrang;
	private int MaGiangVien;
	private int MaHoiDong;
	private Connection conn;
	public GiaoTrinh(GiaoTrinh gt) throws Exception
	{
		MaGiaoTrinh = gt.MaGiaoTrinh;
		TenGiaoTrinh = gt.TenGiaoTrinh;
		NgayDangKy = gt.NgayDangKy;
		NgayHoanThanh = gt.NgayHoanThanh;
		TinhTrang = gt.TinhTrang;
		MaGiangVien = gt.MaGiangVien;
		MaHoiDong = gt.MaHoiDong;
	}
	
	public boolean insert() throws SQLException
	{
		String sql = "insert into giaotrinh(MaGiaoTrinh, TenGiaoTrinh, NgayDangKy, NgayHoanThanh, TinhTrang, MaGiangVien, MaHoiDong) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, MaGiaoTrinh);
		pst.setString(2, TenGiaoTrinh);
		pst.setDate(3, NgayDangKy);
		pst.setDate(4, NgayHoanThanh);
		pst.setInt(5, TinhTrang);
		pst.setInt(6, MaGiangVien);
		pst.setInt(7, MaHoiDong);
		
		return pst.executeUpdate() > 0;
	}

}
