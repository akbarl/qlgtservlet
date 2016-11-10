package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.GiaoTrinh;
import Classes.HoiDong;
import Model.GiangVien_Model;
import Model.GiaoTrinh_Model;
import Model.HoiDong_Model;

/**
 * Servlet implementation class insertHoiDong
 */
@WebServlet("/insertHoiDong")
public class insertHoiDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertHoiDong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.print("Test");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String[] s_dsgv=request.getParameterValues("dsgv");
		int[] dsgv = new int[s_dsgv.length];
		for(int i = 0; i < s_dsgv.length ; i++)
    	{
			dsgv[i] = Integer.parseInt(s_dsgv[i]);
    	}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HoiDong hd = new HoiDong();
		int magt = Integer.parseInt(request.getParameter("txtMaGiaoTrinh"));
		hd.setMaGiaoTrinh(magt);
		hd.setTenHoiDong(request.getParameter("txtTenHoiDong"));
		//hd.setNgayNghiemThu(ngayNghiemThu);
		hd.setNgayThanhLap(java.sql.Date.valueOf(java.time.LocalDate.now()));
		String NgayNghiemThu = request.getParameter("nam") + "-"+request.getParameter("thang") +"-"+ request.getParameter("ngay");
		hd.setNgayNghiemThu(java.sql.Date.valueOf(NgayNghiemThu));
		
		HoiDong_Model hdm;
		try {
			hdm = new HoiDong_Model();
			int mahd = hdm.insertHoiDong(hd);
			if(mahd > 0)
			{
				for(int i = 0 ; i< dsgv.length;i++)
				{
					GiangVien_Model gv = new GiangVien_Model();
					if(gv.updateHoiDong(dsgv[i], mahd));
				}
				GiaoTrinh_Model gtm = new GiaoTrinh_Model();
				if(gtm.updateHoiDong(magt, mahd) && gtm.updateTinhTrang(magt, 1));
				response.sendRedirect("HoiDong/DanhSachGiaoTrinh.jsp");
				
			}
			else
				response.sendRedirect("HoiDong/index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
