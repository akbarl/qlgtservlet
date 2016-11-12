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

import Classes.HoiDong;
import Model.GiangVien_Model;
import Model.HoiDong_Model;

/**
 * Servlet implementation class updateHoiDong
 */
@WebServlet("/updateHoiDong")
public class updateHoiDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateHoiDong() {
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
		int mahoidong = Integer.parseInt(request.getParameter("txtMaHoiDong"));
		String redirect = request.getParameter("redirect");
		if(action.equalsIgnoreCase("updateHoiDong"))
		{
			String[] s_dsgv = request.getParameterValues("dsgv");
			int[] dsgv = new int[s_dsgv.length];
			for(int i = 0; i < s_dsgv.length ; i++)
	    	{
				dsgv[i] = Integer.parseInt(s_dsgv[i]);
	    	}
			
			HoiDong hd = new HoiDong();
			hd.setMaHoiDong(Integer.parseInt(request.getParameter("txtMaHoiDong")));
			hd.setTenHoiDong(request.getParameter("txtTenHoiDong"));
			hd.setMaHoiDong(Integer.parseInt(request.getParameter("txtMaGiaoTrinh")));
			try {
				hd.setNgayThanhLap(new Date(parseDate(request.getParameter("txtNgayThanhLap"), "yyyy-MM-dd").getTime()));
				hd.setNgayNghiemThu(new Date(parseDate(request.getParameter("txtNgayNghiemThu"), "yyyy-MM-dd").getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				HoiDong_Model hdm = new HoiDong_Model();
				GiangVien_Model gvm = new GiangVien_Model();
				if(hdm.updateHoiDong(hd) && gvm.setHoiDongNull(mahoidong));
				for(int i = 0 ; i< dsgv.length;i++)
				{
					GiangVien_Model gv = new GiangVien_Model();
					if(gv.updateHoiDong(dsgv[i], mahoidong));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(redirect+"/DanhSachHoiDong.jsp");
				
				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
