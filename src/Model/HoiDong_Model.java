package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.GiangVien;
import Classes.HoiDong;

public class HoiDong_Model {
	private Connection conn;
	Statement stmt = null;
	ResultSet rs = null;
	
	public HoiDong_Model() throws Exception
	{
		Database db = new Database();
		conn = db.getConn();
	}
	public boolean close() throws SQLException
	{
		conn.close();
		return true;
	}
	
	public int insertHoiDong(HoiDong hd) throws SQLException
	{
		int result = 0;
		String sql = "insert into hoidong(TenHoiDong, MaGiaoTrinh, NgayThanhLap, NgayNghiemThu) VALUES(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, hd.getTenHoiDong());
		pst.setInt(2, hd.getMaGiaoTrinh());
		pst.setDate(3, hd.getNgayThanhLap());
		pst.setDate(4, hd.getNgayNghiemThu());
		pst.executeUpdate();
		rs = pst.getGeneratedKeys();
		if (rs.next()){
		    result =rs.getInt(1);
		}
		return result;
	}

}
