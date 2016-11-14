package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Classes.GiangVien;
import Classes.GiaoTrinh;
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
	
	protected Statement getStatement() throws SQLException, Exception{
		 if(stmt == null){
			 stmt = conn.createStatement();
		 }
		 return stmt;
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
	
	public ArrayList<HoiDong> getAll() throws Exception{
		 ArrayList<HoiDong> lst = new ArrayList<HoiDong>();
		 String strSQL = "select * from hoidong";
		 try {
			 rs = getStatement().executeQuery(strSQL);
			 while(rs.next()){
				 HoiDong hd = new HoiDong();
				 hd.setMaHoiDong(rs.getInt("MaHoiDong"));
				 hd.setTenHoiDong(rs.getString("TenHoiDong"));
				 hd.setMaGiaoTrinh(rs.getInt("MaGiaoTrinh"));
				 hd.setNgayThanhLap(rs.getDate("NgayNghiemThu"));
				 hd.setNgayNghiemThu(rs.getDate("NgayNghiemThu"));
				 lst.add(hd);
			 }
		 } catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		 }
		 conn.close();
		 return lst;
	}
	
	public HoiDong getHoiDongbyID(int MaHoiDong) throws Exception
	{
		String strSQL = "SELECT * FROM hoidong WHERE MaHoiDong = "+MaHoiDong;
		HoiDong hd = new HoiDong();
		try{
			rs = getStatement().executeQuery(strSQL);
			while(rs.next()){
				hd.setMaHoiDong(rs.getInt(1));
				hd.setTenHoiDong(rs.getString(2));
				hd.setMaGiaoTrinh(rs.getInt(3));
				hd.setNgayThanhLap(rs.getDate(4));
				hd.setNgayNghiemThu(rs.getDate(5));
			 }
			
		}catch (Exception e) {
			 throw new Exception(e.getMessage() +" Error at : " + strSQL);
		}
		conn.close();
		return hd;
	}
	
	public boolean updateHoiDong(HoiDong hd) throws SQLException
	{
		int result = 0;
		String sql = "UPDATE hoidong SET TenHoiDong = ?, MaGiaoTrinh = ?, NgayThanhLap = ?, NgayNghiemThu = ? WHERE MaHoiDong = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, hd.getTenHoiDong());
		pst.setInt(2, hd.getMaGiaoTrinh());
		pst.setDate(3, hd.getNgayThanhLap());
		pst.setDate(4, hd.getNgayNghiemThu());
		pst.setInt(5, hd.getMaHoiDong());
		return pst.executeUpdate() > 0;
		
	}
	
	public int countAll() throws SQLException, Exception
	{
		String sql = "select count(*) from hoidong";
		rs = getStatement().executeQuery(sql);
		while(rs.next())
			return rs.getInt(1);
		return 0;
		
	}
	

}
