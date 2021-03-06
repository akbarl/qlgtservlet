package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.LoginModel;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	final private String errorPage="index.jsp";
	final private String homePage="homePage.jsp";
	
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			String url = "";
			String action = request.getParameter("action");
			if(action.equals("login")){
				String username = request.getParameter("txtUsername");
				String password = request.getParameter("txtPass");
				LoginModel login = new LoginModel();
				boolean result = login.checkLogin(username, password);
		
				int roles;
				int idcb;
				if(result){
					HttpSession session = request.getSession(true);
					session.setAttribute("USER", username);
					roles = login.getLoaiNguoiDung(username, password);
					session.setAttribute("ROLES", roles);
					idcb = login.getIDCanBo(username, password);
					session.setAttribute("IDCB", idcb);
					
					url = homePage;
				
				}
				else url=errorPage;
					
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.include(request, response);
			}
		}
		catch(Exception e){
				e.printStackTrace();
		}
	}

}
