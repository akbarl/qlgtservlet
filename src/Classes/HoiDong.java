package Classes;

import java.sql.Date;

public class HoiDong {
	private int MaHoiDong;
	private String TenHoiDong;
	private int MaGiaoTrinh;
	private Date NgayThanhLap;
	private Date NgayNghiemThu;
	private GiangVien[] dsgv;
	
	public HoiDong(){};
	public HoiDong(HoiDong hd)
	{
		MaHoiDong = hd.MaHoiDong;
		TenHoiDong = hd.TenHoiDong;
		MaGiaoTrinh = hd.MaGiaoTrinh;
		NgayThanhLap = hd.NgayThanhLap;
		NgayNghiemThu = hd.NgayNghiemThu;
		dsgv = hd.dsgv;
	}

	public int getMaHoiDong() {
		return MaHoiDong;
	}

	public void setMaHoiDong(int maHoiDong) {
		MaHoiDong = maHoiDong;
	}

	public String getTenHoiDong() {
		return TenHoiDong;
	}

	public void setTenHoiDong(String tenHoiDong) {
		TenHoiDong = tenHoiDong;
	}

	public int getMaGiaoTrinh() {
		return MaGiaoTrinh;
	}

	public void setMaGiaoTrinh(int maGiaoTrinh) {
		MaGiaoTrinh = maGiaoTrinh;
	}

	public Date getNgayThanhLap() {
		return NgayThanhLap;
	}

	public void setNgayThanhLap(Date ngayThanhLap) {
		NgayThanhLap = ngayThanhLap;
	}

	public Date getNgayNghiemThu() {
		return NgayNghiemThu;
	}

	public void setNgayNghiemThu(Date ngayNghiemThu) {
		NgayNghiemThu = ngayNghiemThu;
	}

	public GiangVien[] getDsgv() {
		return dsgv;
	}

	public void setDsgv(GiangVien[] dsgv) {
		this.dsgv = dsgv;
	}
	
	
	
	

}
