<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

<%ArrayList<HoiDong> listgt = new HoiDong_Model().getAll(); %>

<fieldset>
<div class="form-group">
<div class="panel panel-default">
	<div class="panel-heading">Tên GV: ${sessionScope.NAME}</div>
    <table class="table">
	    <thead>
	      <tr>
	        <th>Ma Hoi Dong</th>
	        <th>Tên Hoi Dong</th>
			<th>Ma Giao Trinh</th>
			<th>Ngay Thanh Lap</th>
	        <th>Ngay Nghiem Thu</th>
	        <th>Hanh dong</th>
	        <th>In danh sach</th>
	      </tr>
	    </thead>
	    <tbody>
	    <%for(HoiDong hd : listgt){ %>
		      <tr>
		        <td><%= hd.getMaHoiDong() %></td>
		        <td><%= hd.getTenHoiDong() %></td>
		       	<td><%= hd.getMaGiaoTrinh() %></td>
		       	<td><%= hd.getNgayThanhLap() %></td>
		       	<td><%= hd.getNgayNghiemThu() %></td>
		       	<td>
		       		<a href="editHoiDong.jsp?mahoidong=<%= hd.getMaHoiDong() %>">Sua</a>
		       		|
		       		<a href="../viewHoiDong.jsp?mahoidong=<%= hd.getMaHoiDong() %>">Xem</a>
		       	</td>
		       	<td>
		       		<button type="button" class="btn btn-primary" onClick="openWin('../viewHoiDong.jsp?mahoidong=<%= hd.getMaHoiDong() %>')">In danh sach</button>
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