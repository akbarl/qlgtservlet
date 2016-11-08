package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.GiaoTrinh;
import Model.GiaoTrinh_Model;
/**
 * Servlet implementation class insertGiaoTrinh
 */
@WebServlet("/insertGiaoTrinh")
public class insertGiaoTrinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertGiaoTrinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		GiaoTrinh gt = new GiaoTrinh();
		gt.setTenGiaoTrinh(request.getParameter("txtTenGiaoTrinh"));
		gt.setMaGiangVien(1);
		String NgayHoanThanh = request.getParameter("nam") + "-"+request.getParameter("thang") +"-"+ request.getParameter("ngay");
		gt.setNgayHoanThanh(java.sql.Date.valueOf(NgayHoanThanh));
		gt.setTinhTrang(0);
		
		
		try {
			GiaoTrinh_Model gtm = new GiaoTrinh_Model();
			if(gtm.insert(gt))
				response.sendRedirect("GiangVien/DangKy.jsp");
			response.sendRedirect("GiangVien/index.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
