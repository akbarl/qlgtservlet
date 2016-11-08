<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />
<% 
	String user = (String)request.getSession().getAttribute("USER"); 
	Integer role = (Integer)request.getSession().getAttribute("ROLES"); 
	Integer iduser = (Integer)request.getSession().getAttribute("IDUSER");
	
	// Kiem tra xem user co khong, neu user!=null nghia la da dang nhap roi
   	if(user == null) {	
   		// Neu dang nhap roi thi hien link cho phep dang xuat
   		response.sendRedirect(request.getContextPath());
   	}
%>

<form action="../Logout" method="post">
   		<input type="submit" value="Chào, ${sessionScope.USER} - ${sessionScope.ID}"/>									 
	</form>
<jsp:include page="/WEB-INF/footer.jsp" />