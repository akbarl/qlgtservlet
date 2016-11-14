<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

<%
	int sogiaotrinh = new GiaoTrinh_Model().countAll(); 
	int sohoidong = new HoiDong_Model().countAll(); 
	int sogiangvien = new GiangVien_Model().countAll();
%>
<fieldset>
<div class="form-group">
<div class="panel panel-default">
	<div class="panel-heading">Thong ke he thong</div>
	<div class="panel-body">
		<div class="col-md-4 text-center">
			<%= sogiaotrinh %>
			<div class="text-danger">Giáo trình</div>
		</div>
		<div class="col-md-4 text-center">
			<%= sohoidong %>
			<div class="text-success">Hoi dong</div>
		</div>
		<div class="col-md-4 text-center">
			<%= sogiangvien %>
			<div class="text-info">Giang vien</div>
		</div>
	</div>
</div>
</fieldset>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />