<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

<%
	ArrayList<GiaoTrinh> listgt = new GiaoTrinh_Model().getAll();
	String type = request.getParameter("type");
	String content = request.getParameter("content");
	if(type != null && content != null)
	{
		if(type.equalsIgnoreCase("name"))
		{
			listgt = new GiaoTrinh_Model().searchGiaoTrinhbyName(content);
		}else if(type.equalsIgnoreCase("id"))
		{
			listgt = new GiaoTrinh_Model().searchGiaoTrinhbyID(Integer.parseInt(content));
		}else if(type.equalsIgnoreCase("gv"))
		{
			listgt = new GiaoTrinh_Model().searchGiaoTrinhbyGV(Integer.parseInt(content));
		}
		
	}else
	{
		listgt = new GiaoTrinh_Model().getAll();
	}
%>
<form action="DanhSachGiaoTrinh.jsp">
	<select name="type">
		<option value="name">Ten giao trinh</option>
		<option value="id">Ma giao trinh</option>
		<option value="gv">Ma giang vien</option>
	</select>
	
	<input name="content" class="form-group">
	
	<input type="submit" value="tim kiem">
</form>

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
			<th>In thong tin</th>
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
				<td>
					<a href="editGiaoTrinh.jsp?magiaotrinh=<%= gt.getMaGiaoTrinh() %>">Sua</a>
					|
					<a href="../viewGiaoTrinh.jsp?magiaotrinh=<%= gt.getMaGiaoTrinh() %>">Xem</a>
				</td>
				<td>
					<button type="button" class="btn btn-primary" onClick="openWin('../viewGiaoTrinh.jsp?magiaotrinh=<%= gt.getMaGiaoTrinh() %>')">In</button>
				</td>
	       		
		      </tr>
	      <%} %>
	    </tbody>
	</table>
</div>
</fieldset>
</div>
<script type="text/javascript">
  function openWin(url)
  {
    var myWindow=window.open(url,'','width=800,height=800');
    
    myWindow.document.close();
	myWindow.focus();
	myWindow.print();
	myWindow.close();
    
  }
</script>

<jsp:include page="/WEB-INF/footer.jsp" />