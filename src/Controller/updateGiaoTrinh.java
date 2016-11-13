package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.GiaoTrinh;
import Model.GiaoTrinh_Model;

/**
 * Servlet implementation class updateGiaoTrinh
 */
@WebServlet("/updateGiaoTrinh")
public class updateGiaoTrinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateGiaoTrinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		int magiaotrinh = Integer.parseInt(request.getParameter("magiaotrinh"));
		String redirect = request.getParameter("redirect");
		if(action.equalsIgnoreCase("updateTinhTrang"))
		{
			try {
				GiaoTrinh_Model gtm = new GiaoTrinh_Model();
				int matinhtrang = Integer.parseInt(request.getParameter("matinhtrang"));
				if(gtm.updateTinhTrang(magiaotrinh, matinhtrang + 1));
				response.sendRedirect(redirect+"/DanhSachGiaoTrinh.jsp");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		if(action.equalsIgnoreCase("updateGiaoTrinh"))
		{
			try {
				String NgayHoanThanh = request.getParameter("nam") + "-"+request.getParameter("thang") +"-"+ request.getParameter("ngay");
				String TenGiaoTrinh = request.getParameter("txtTenGiaoTrinh");
				int TinhTrang = Integer.parseInt(request.getParameter("tinhtrang"));
				GiaoTrinh_Model gtm = new GiaoTrinh_Model();
				GiaoTrinh gt = new GiaoTrinh();
				gt.setNgayHoanThanh(java.sql.Date.valueOf(NgayHoanThanh));
				gt.setMaGiaoTrinh(magiaotrinh);
				gt.setTenGiaoTrinh(TenGiaoTrinh);
				gt.setTinhTrang(TinhTrang);
				if(gtm.updateGiaoTrinh(gt));
				response.sendRedirect(redirect+"/DanhSachGiaoTrinh.jsp");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
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
