<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />

<%
	int MaGiangVien = (int) request.getSession().getAttribute("ID");
	int MaHoiDong = (int) Integer.parseInt(request.getParameter("mahoidong"));
	HoiDong hd = new HoiDong_Model().getHoiDongbyID(MaHoiDong);
	ArrayList<GiangVien> dsgv = new GiangVien_Model().getGiangVienbyHoiDong(MaHoiDong);
	
%>


<fieldset id="content">
<div class="form-group">
<div class="panel panel-default">
	<div class="panel-heading">Ten GV: ${sessionScope.NAME}</div>
    <div class="panel-body">
    <form action="../updateHoiDong" method="POST">
    	<input type="hidden" name="action" value="updateHoiDong">
    	<input type="hidden" name="redirect" value="Admin"/>
    	<div class="form-group">
			<label for="mahoidong">Ma hoi dong: </label>
			<%= request.getParameter("mahoidong") %>
    	</div>
    	
    	<div class="form-group">
    		<label for="tenhoidong">Ten hoi dong: </label> 
    		<%= hd.getTenHoiDong() %>
		</div>
		
		<div class="form-group">
    		<label for="magiaotrinh">Ma giao trinh: </label> 
    		<%= hd.getMaGiaoTrinh() %>
		</div>
    	
    	<div class="form-group">
    		<label for="ngaythanhlap">Ngay thanh lap: </label> 
    		<%= hd.getNgayThanhLap() %>
		</div>
    	
    	<div class="form-group">
    		<label for="ngaynghiemthu">Ngay nghiem thu: </label> 
    		<%= hd.getNgayNghiemThu() %>
		</div>
    	
    	<div class="form-group">
		    <label for="magiaotrinh">Danh sach thanh vien:</label>
		    <table class="table table-bordered text-center">
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
		    	<tr>
	    			<td>
					<%= i %>
					</td>
					<td>
					<%= gv.getMaGiangVien() %>
					</td>
					<td>
					<%= gv.getTenGiangVien() %>
					</td>
				</tr>
				
				<%} %>
		    	</tbody>
		    </table>
	
	    </div>
	</form>
    </div>
</div>
</fieldset>
<script type="text/javascript">
  function openWin(url)
  {
    var myWindow=window.open(url,'','width=800,height=800');
    myWindow.document.write("<p>This is 'myWindow'</p>");
    
    myWindow.document.close();
	myWindow.focus();
	myWindow.print();
	myWindow.close();
    
  }
</script>

<jsp:include page="/WEB-INF/footer.jsp" />