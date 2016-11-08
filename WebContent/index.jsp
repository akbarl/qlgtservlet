<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/header.jsp" />
	<div id="content">

	<h2>ĐĂNG NHẬP</h2>
		<form method="post" action="Login">
			<fieldset>
				<input class="form-control"  type="text" name="txtUsername" placeholder="Tên đăng nhập" required><br>
				<input class="form-control"  type="password" name="txtPass" placeholder="Mật khẩu" required><br>
				
				<input type="hidden" name="action" value="login"/>
				<input class="btn btn-primary"   type="submit" value="Đăng nhập">
				<input class="btn btn-primary"   type="reset" value="Làm lại">
			</fieldset>
		</form>
		
		</form><br>
	</div>
<jsp:include page="/WEB-INF/footer.jsp" />