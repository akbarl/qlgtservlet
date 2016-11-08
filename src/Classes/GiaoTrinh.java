package Classes;


import java.sql.Date;

import Model.GiaoTrinh_Model;

public class GiaoTrinh {
	private int MaGiaoTrinh;
	private String TenGiaoTrinh;
	private Date NgayDangKy;
	private Date NgayHoanThanh;
	private int TinhTrang;
	private int MaGiangVien;
	private int MaHoiDong;
	
	public GiaoTrinh(){};
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

	public int getMaGiaoTrinh() {
		return MaGiaoTrinh;
	}

	public void setMaGiaoTrinh(int maGiaoTrinh) {
		MaGiaoTrinh = maGiaoTrinh;
	}

	public String getTenGiaoTrinh() {
		return TenGiaoTrinh;
	}

	public void setTenGiaoTrinh(String tenGiaoTrinh) {
		TenGiaoTrinh = tenGiaoTrinh;
	}

	public Date getNgayDangKy() {
		return NgayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		NgayDangKy = ngayDangKy;
	}

	public Date getNgayHoanThanh() {
		return NgayHoanThanh;
	}

	public void setNgayHoanThanh(Date ngayHoanThanh) {
		NgayHoanThanh = ngayHoanThanh;
	}

	public int getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}

	public int getMaGiangVien() {
		return MaGiangVien;
	}

	public void setMaGiangVien(int maGiangVien) {
		MaGiangVien = maGiangVien;
	}

	public int getMaHoiDong() {
		return MaHoiDong;
	}

	public void setMaHoiDong(int maHoiDong) {
		MaHoiDong = maHoiDong;
	}
	

}
