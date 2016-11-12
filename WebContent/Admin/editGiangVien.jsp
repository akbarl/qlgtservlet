<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

<%
	//int MaGiangVien = (int) request.getSession().getAttribute("ID");
	int MaGiangVien = (int) Integer.parseInt(request.getParameter("magiangvien"));
	GiangVien gv = new GiangVien_Model().getGiangVienbyID(MaGiangVien);
	
%>
<fieldset>
<div class="form-group">
<div class="panel panel-default">
	<div class="panel-heading">Tên GV: ${sessionScope.NAME}</div>
    <div class="panel-body">
    <form action="../updateGiangVien">
    	<input type="hidden" name="action" value="updateGiangVien">
    	<input type="hidden" name="redirect" value="Admin"/>
    	<div class="form-group">
		    <label for="magiangvien">Ma giang vien:</label>
			<input type="text" class="form-control" name="txtMaGiangVien" value="<%= gv.getMaGiangVien() %>" readonly>
    	</div>
    	
    	<div class="form-group">
		    <label for="tengiangvien">Ten giang vien:</label>
			<input type="text" class="form-control" name="txtTenGiangVien" value="<%= gv.getTenGiangVien() %>">
    	</div>
    	<div class="form-group">
		    <label for="email">Email:</label>
			<input type="text" class="form-control" name="txtEmail" value="<%= gv.getEmail() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="diachi">Dia chi:</label>
			<input type="text" class="form-control" name="txtDiaChi" value="<%= gv.getDiaChi() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="sodienthoai">So dien thoai:</label>
			<input type="text" class="form-control" name="txtSoDienThoai" value="<%= gv.getSoDienThoai() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="ngaysinh">Ngay sinh:</label>
			<input type="text" class="form-control" placeholder="mm/dd/yyyy" name="txtNgaySinh" value="<%= gv.getNgaySinh() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="makhoa">Ma khoa:</label>
			<input type="text" class="form-control" name="txtMaKhoa" value="<%= gv.getMaKhoa() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="mahoidong">Ma hoi dong:</label>
			<input type="text" class="form-control" name="txtMaHoiDong" value="<%= gv.getMaHoiDong() %>">
    	</div>
    	
    	<div class="form-group">
		    <label for="machucvu">Loai nguoi dung:</label>
			<input type="text" class="form-control" name="txtMaChucVu" value="<%= gv.getMaChucVu() %>">
    	</div>
    	
    	<script type="text/javascript">

		//populatedropdown(id_of_day_select, id_of_month_select, id_of_year_select)
		window.onload=function(){
		populatedropdown("daydropdown", "monthdropdown", "yeardropdown")
		}
		</script>
		
		<div class="form-group">
		<button type="submit" class="btn btn-default">Cap nhat</button>
	</div>
	</form>
    </div>
</div>
</fieldset>
<script type="text/javascript">

/***********************************************
* Drop Down Date select script- by JavaScriptKit.com
* This notice MUST stay intact for use
* Visit JavaScript Kit at http://www.javascriptkit.com/ for this script and more
***********************************************/

var monthtext=['1','2','3','4','5','6','7','8','9','10','11','12'];

function populatedropdown(dayfield, monthfield, yearfield){
var today=new Date()
var dayfield=document.getElementById(dayfield)
var monthfield=document.getElementById(monthfield)
var yearfield=document.getElementById(yearfield)
for (var i=0; i<31; i++)
dayfield.options[i]=new Option(i, i+1)
dayfield.options[today.getDate()]=new Option(today.getDate(), today.getDate(), true, true) //select today's day
for (var m=0; m<12; m++)
monthfield.options[m]=new Option(monthtext[m], monthtext[m])
monthfield.options[today.getMonth()]=new Option(monthtext[today.getMonth()], monthtext[today.getMonth()], true, true) //select today's month
var thisyear=today.getFullYear()
for (var y=0; y<20; y++){
yearfield.options[y]=new Option(thisyear, thisyear)
thisyear+=1
}
yearfield.options[0]=new Option(today.getFullYear(), today.getFullYear(), true, true) //select today's year
}

</script>
<jsp:include page="/WEB-INF/footer.jsp" />