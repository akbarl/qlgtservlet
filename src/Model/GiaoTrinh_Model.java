package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classes.GiaoTrinh;

public class GiaoTrinh_Model {
	private Connection conn;
	
	public GiaoTrinh_Model() throws Exception
	{
		Database db = new Database();
		conn = db.getConn();
	}
	
	public boolean close() throws SQLException
	{
		conn.close();
		return true;
	}
	
	
	public boolean insert(GiaoTrinh gt) throws SQLException
	{
		String sql = "insert into giaotrinh(MaGiaoTrinh, TenGiaoTrinh, NgayDangKy, NgayHoanThanh, TinhTrang, MaGiangVien) VALUES(?,?,NOW(),?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, gt.getMaGiaoTrinh());
		pst.setString(2, gt.getTenGiaoTrinh());
		//java.sql.Date sqlDate = new java.sql.Date("1/1/2016"); 
		pst.setDate(3, gt.getNgayHoanThanh());
		pst.setInt(4, gt.getTinhTrang());
		pst.setInt(5, gt.getMaGiangVien());
		//pst.setInt(6, null);
		
		return pst.executeUpdate() > 0;
	}

}
