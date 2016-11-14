<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="khungtrang">
<div id="main-menu">
	<a href="DanhSachGiaoTrinh.jsp"><img  src="../HinhAnh/Admin/danhsachgt.png"  /></a>
	<a href="DanhSachHoiDong.jsp"><img  src="../HinhAnh/Admin/danhsachhd.png"  /></a>
	<a href="DanhSachGiangVien.jsp"><img  src="../HinhAnh/Admin/danhsachgv.png"  /></a>
	<a href="ThongKe.jsp"><img  src="../HinhAnh/Admin/thongke.png"  /></a>
	<a href="search"><img  src="../HinhAnh/GiangVien/timkiem.png"  /></a>
</div>
<form action="../Logout" method="post">
   		<input type="submit" value="Chào, ${sessionScope.USER} - ID: ${sessionScope.ID} - ROLES: ${sessionScope.ROLES}"/>									 
</form>
	

