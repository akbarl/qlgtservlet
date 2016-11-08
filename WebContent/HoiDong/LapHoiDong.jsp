<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Classes.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

Chào, ${sessionScope.USER} - ${sessionScope.ROLES}
<%ArrayList<GiaoTrinh> listgt = new GiaoTrinh_Model().getAll(); %>

<fieldset>
<div class="form-group">
<div class="panel panel-default">
	<div class="panel-heading">Tên GV: Nguyễn Văn A</div>
    <div class="panel-body">
    <form action="insertHoiDong">
    	<div class="form-group">
	    <label for="tenhoidong">Ten hoi dong:</label>
	    <input type="text" class="form-control" name="txtTenHoiDong">
	    </div>
	    
	    <div class="form-group">
		    <label for="magiaotrinh">MaGiaoTrinh:</label>
		    <input type="text" class="form-control" name="txtMaGiaoTrinh" value="<%= request.getParameter("magiaotrinh") %>" disabled>
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
		    			<td>
						1
						</td>
						<td>
						<input type="text" name='dsgv[]'  placeholder='Ma Giang Vien' class="form-control"/>
						</td>
						<td>
						<input type="text" name='mail0' placeholder='Ten Giang Vien' class="form-control"/>
						</td>
		    		<tr id='addr1'></tr>
		    	</tbody>
		    </table>
		
		    <a id="add_row" class="btn btn-default">Them Dong</a>
		    <a id='delete_row' class="btn btn-default">Xoa Dong</a>
	
	    </div>
	 
	 <div class="form-group">
			<button type="submit" class="btn btn-default">Thanh Lap</button>
	</div>
	</form>
	</div>
	
</div>
</fieldset>
</div>
<script>
$(document).ready(function(){
    var i=1;
   $("#add_row").click(function(){
    $('#addr'+i).html("<td>"+ (i+1) +"</td><td><input name='dsgv[]' type='text' placeholder='Ma Giang Vien' class='form-control input-md'  /> </td><td><input  name='mail"+i+"' type='text' placeholder='Ten Giang Vien'  class='form-control input-md'></td>");

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