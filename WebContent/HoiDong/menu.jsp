<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="khungtrang">
<div id="main-menu">
	<a href="LapHoiDong.jsp"><img  src="../HinhAnh/HoiDong/laphoidong.png"  /></a>
	<a href="DanhSachGiaoTrinh.jsp"><img  src="../HinhAnh/HoiDong/xemthongtin.png"  /></a>
	<a href="search"><img  src="../HinhAnh/HoiDong/timkiem.png"  /></a>
	<a href="search"><img  src="../HinhAnh/HoiDong/thongke.png"  /></a>
</div>
<form action="../Logout" method="post">
   		<input type="submit" value="Chào, ${sessionScope.USER} - ID: ${sessionScope.ID} - ROLES: ${sessionScope.ROLES}"/>									 
</form>

