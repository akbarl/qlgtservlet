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
    <form action="../insertHoiDong" method="POST">
    	<div class="form-group">
	    <label for="tenhoidong">Ten hoi dong:</label>
	    <input type="text" class="form-control" name="txtTenHoiDong">
	    </div>
	    
	    <div class="form-group">
		    <label for="magiaotrinh">Ma Giao Trinh:</label>
		    <input type="text" class="form-control" name="txtMaGiaoTrinh" value="<%= request.getParameter("magiaotrinh") %>">
	    </div>
	    <div class="form-group">
		    <label for="tengiaotrinh">Ngay Nghiem Thu:</label>
		    <select id="daydropdown" name="ngay">
			</select> 
			Thang
			<select id="monthdropdown" name="thang">
			</select> 
			Nam
			<select id="yeardropdown" name="nam">
			</select> 
    	</div>
    	<script type="text/javascript">

		//populatedropdown(id_of_day_select, id_of_month_select, id_of_year_select)
		window.onload=function(){
		populatedropdown("daydropdown", "monthdropdown", "yeardropdown")
		}
		</script>
    
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
						<input type="text" name="dsgv"  placeholder='Ma Giang Vien' class="form-control"/>
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
    $('#addr'+i).html("<td>"+ (i+1) +"</td><td><input name='dsgv' type='text' placeholder='Ma Giang Vien' class='form-control input-md'  /> </td><td><input  name='mail"+i+"' type='text' placeholder='Ten Giang Vien'  class='form-control input-md'></td>");

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