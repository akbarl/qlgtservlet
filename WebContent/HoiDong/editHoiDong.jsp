<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

<%
	//int MaGiangVien = (int) request.getSession().getAttribute("ID");
	int MaHoiDong = (int) Integer.parseInt(request.getParameter("mahoidong"));
	HoiDong hd = new HoiDong_Model().getHoiDongbyID(MaHoiDong);
	ArrayList<GiangVien> dsgv = new GiangVien_Model().getGiangVienbyHoiDong(MaHoiDong);
	
%>
<fieldset>
<div class="form-group">
<div class="panel panel-default">
	<div class="panel-heading">Tên GV: ${sessionScope.NAME} | <input type="button" value="Print this page" onClick="window.print()"></div>
    <div class="panel-body">
    <form action="../updateHoiDong" method="POST">
    	<input type="hidden" name="action" value="updateHoiDong">
    	<input type="hidden" name="redirect" value="Admin"/>
    	<div class="form-group">
		    <label for="tenhoidong">Ma hoi dong:</label>
			<input type="text" class="form-control" name="txtMaHoiDong" value="<%= request.getParameter("mahoidong") %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="tenhoidong">Ten hoi dong:</label>
			<input type="text" class="form-control" name="txtTenHoiDong" value="<%= hd.getTenHoiDong() %>">
    	</div>
		
		<div class="form-group">
		    <label for="magiaotrinh">Ma giao trinh:</label>
			<input type="text" class="form-control" name="txtMaGiaoTrinh" value="<%= hd.getMaGiaoTrinh() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="ngaythanhlap">Ngay thanh lap:</label>
			<input type="text" class="form-control" name="txtNgayThanhLap" value="<%= hd.getNgayThanhLap() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="ngaynghiemthu">Ngay nghiem thu:</label>
			<input type="text" class="form-control" name="txtNgayNghiemThu" value="<%= hd.getNgayNghiemThu() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="magiaotrinh">Danh sach thanh vien:</label>
		    <table class="table" id="tab_logic">
		    	<thead>
		    		<tr >
						<th class="text-center">
							STT
						</th>
						<th class="text-center">
							Ma Giang Vien
						</th>
						<th class="text-center">
							Ten Giang Vien
						</th>
					</tr>
		    	</thead>
		    	<tbody>
		    	<%int i = 1; %>
		    	<%for(GiangVien gv : dsgv){ %>
		    	<tr id='addr<%= i %>'>
		    			<td>
						<%= i %>
						</td>
						<td>
						<input type="text" name="dsgv"  value="<%= gv.getMaGiangVien() %>" placeholder='Ma Giang Vien' class="form-control"/>
						</td>
						<td>
						<input type="text" name='mail0' value="<%= gv.getTenGiangVien() %>"placeholder='Ten Giang Vien' class="form-control"/>
						</td>
				</tr>
				
				<%i++; } %>
		    		<tr id='addr<%= i %>'></tr>
		    	</tbody>
		    </table>
		
		    <a id="add_row" class="btn btn-default">Them Dong</a>
		    <a id='delete_row' class="btn btn-default">Xoa Dong</a>
	
	    </div>
		<div class="form-group">
		<button type="submit" class="btn btn-default">Cap nhat</button>
	</div>
	</form>
    </div>
</div>
</fieldset>
<script>
$(document).ready(function(){
    var i=<%= i %>;
   $("#add_row").click(function(){
    $('#addr'+i).html("<td>"+ (i) +"</td><td><input name=\"dsgv\" type='text' placeholder='Ma Giang Vien' class='form-control input-md'  /> </td><td><input  name='mail"+i+"' type='text' placeholder='Ten Giang Vien'  class='form-control input-md'></td>");

    $('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');
    i++; 
});
   $("#delete_row").click(function(){
  	 if(i>1){
		 $("#addr"+(i-1)).html('');
		 i--;
		 }
	 });

});
</script>
<jsp:include page="/WEB-INF/footer.jsp" />