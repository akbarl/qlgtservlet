package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.GiangVien;
import Model.GiangVien_Model;

/**
 * Servlet implementation class updateGiangVien
 */
@WebServlet("/updateGiangVien")
public class updateGiangVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateGiangVien() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static java.util.Date parseDate(String date, String format) throws ParseException
	{
		SimpleDateFormat formatter  = new SimpleDateFormat(format);
		return formatter.parse(date);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		int magiangvien = Integer.parseInt(request.getParameter("txtMaGiangVien"));
		String redirect = request.getParameter("redirect");
		try{
			GiangVien_Model gvm = new GiangVien_Model();
			if(action.equalsIgnoreCase("updateGiangVien"))
			{
					GiangVien gv =new GiangVien();
					gv.setMaGiangVien(magiangvien);
					gv.setTenGiangVien(request.getParameter("txtTenGiangVien"));
					gv.setEmail(request.getParameter("txtEmail"));
					gv.setDiaChi(request.getParameter("txtDiaChi"));
					gv.setSoDienThoai(request.getParameter("txtSoDienThoai"));
					gv.setNgaySinh(new Date(parseDate(request.getParameter("txtNgaySinh"), "dd/MM/yyyy").getTime()));
					gv.setMaKhoa(Integer.parseInt(request.getParameter("txtMaKhoa")));
					gv.setMaHoiDong(Integer.parseInt(request.getParameter("txtMaHoiDong")));
					gv.setMaChucVu(Integer.parseInt(request.getParameter("txtMaChucVu")));
					if(gvm.updateGiangVien(gv))
					{
						if(gv.getMaHoiDong() > 0)
							if(gvm.updateHoiDong(magiangvien, gv.getMaHoiDong()));
					}
			}else if(action.equalsIgnoreCase("deleteGiangVien"))
			{
				if(gvm.deleteGiangVien(magiangvien));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		response.sendRedirect(redirect+"/DanhSachGiangVien.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
