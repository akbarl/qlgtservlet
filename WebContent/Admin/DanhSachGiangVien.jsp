<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

<%ArrayList<GiangVien> listgt = new GiangVien_Model().getAll(); %>

<fieldset>
<div class="form-group">
<div class="panel panel-default">
	<div class="panel-heading">Tên GV: ${sessionScope.NAME}</div>
    <table class="table">
	    <thead>
	      <tr>
	        <th>Mã giang vien</th>
	        <th>Tên giang vien</th>
			<th>Email</th>
			<th>Thuoc hoi dong</th>
	        <th>Chuc vu</th>
	        <th>Hanh dong</th>
	      </tr>
	    </thead>
	    <tbody>
	    <%for(GiangVien gv : listgt){ %>
		      <tr>
		        <td><%= gv.getMaGiangVien() %></td>
		        <td><%= gv.getTenGiangVien() %></td>
		        <td><%= gv.getEmail() %></td>
		        <% if(gv.getMaHoiDong() == 0){ %>
		       	 	<td>Khong thuoc hoi dong nao</td>
		       	<% }else{%>
		       		<td><%= gv.getMaHoiDong() %></td>
		       	<% }%>
				<td><%= new GiangVien_Model().getTenChucVu(gv.getMaChucVu()) %></td>
		      	<td>
		      		<a href="editGiangVien.jsp?magiangvien=<%= gv.getMaGiangVien() %>">Sua</a>
		      		| <a href="../updateGiangVien?txtMaGiangVien=<%= gv.getMaGiangVien() %>&action=deleteGiangVien&redirect=Admin">Xoa</a>
		      	</td>
		      </tr>
	      <%} %>
	    </tbody>
	</table>
</div>
</fieldset>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />