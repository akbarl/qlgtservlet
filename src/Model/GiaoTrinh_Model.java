package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Classes.GiaoTrinh;

public class GiaoTrinh_Model {
	private Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
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
	
	protected Statement getStatement() throws SQLException, Exception{
		 if(stmt == null){
			 stmt = conn.createStatement();
		 }
		 return stmt;
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
	
	public ArrayList<GiaoTrinh> getAll() throws Exception{
		 ArrayList<GiaoTrinh> lst = new ArrayList<GiaoTrinh>();
		 String strSQL = "select * from giaotrinh";
		 try {
			 rs = getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 GiaoTrinh gt = new GiaoTrinh();
				 gt.setMaGiaoTrinh(rs.getInt("MaGiaoTrinh"));
				 gt.setTenGiaoTrinh(rs.getString("TenGiaoTrinh"));
				 gt.setNgayDangKy(rs.getDate("NgayDangKy"));
				 gt.setNgayHoanThanh(rs.getDate("NgayHoanThanh"));
				 gt.setTinhTrang(rs.getInt("TinhTrang"));
				 gt.setMaGiangVien(rs.getInt("MaGiangVien"));
				 gt.setMaHoiDong(rs.getInt("MaHoiDong"));
				 lst.add(gt);
			 }
		 } catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.close();
		 return lst;
		}

}