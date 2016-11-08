package Classes;

import java.sql.Date;

import Model.Database;

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
	
	public GiangVien(GiangVien gv) throws Exception
	{
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

	public int getMaGiangVien() {
		return MaGiangVien;
	}

	public void setMaGiangVien(int maGiangVien) {
		MaGiangVien = maGiangVien;
	}

	public String getTenGiangVien() {
		return TenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		TenGiangVien = tenGiangVien;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public int getMaKhoa() {
		return MaKhoa;
	}

	public void setMaKhoa(int maKhoa) {
		MaKhoa = maKhoa;
	}

	public int getMaHoiDong() {
		return MaHoiDong;
	}

	public void setMaHoiDong(int maHoiDong) {
		MaHoiDong = maHoiDong;
	}
}
