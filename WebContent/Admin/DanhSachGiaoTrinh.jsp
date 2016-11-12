<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

<%ArrayList<GiaoTrinh> listgt = new GiaoTrinh_Model().getAll(); %>

<fieldset>
<div class="form-group">
<div class="panel panel-default">
	<div class="panel-heading">Tên GV: ${sessionScope.NAME}</div>
    <table class="table">
	    <thead>
	      <tr>
	        <th>Mã giáo trình</th>
	        <th>Tên giáo trình</th>
			<th>Hội đồng</th>
			<th>Tình trạng</th>
	        <th>Ngày đăng ký</th>
			<th>Ngày hoàn thành</th>
			<th>Hanh dong</th>
	      </tr>
	    </thead>
	    <tbody>
	    <%for(GiaoTrinh gt : listgt){ %>
		      <tr>
		        <td><%= gt.getMaGiaoTrinh() %></td>
		        <td><%= gt.getTenGiaoTrinh() %></td>
		        <% if(gt.getMaHoiDong() == 0){ %>
		       	 	<td>Chua lap hoi dong</td>
		       	<% }else{%>
		       		<td><%= gt.getMaHoiDong() %></td>
		       	<% }%>
				<td><%= new GiaoTrinh_Model().getTenTinhTrang(gt.getTinhTrang()) %></td>
				<td><%= gt.getNgayDangKy() %></td>
				<td><%= gt.getNgayHoanThanh() %></td>
				<td><a href="editGiaoTrinh.jsp?magiaotrinh=<%= gt.getMaGiaoTrinh() %>">Sua</a></td>
	       	
		      </tr>
	      <%} %>
	    </tbody>
	</table>
</div>
</fieldset>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />