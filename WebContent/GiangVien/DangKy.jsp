<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/header.jsp" />
<jsp:include page="menu.jsp" />

<form action="../insertGiaoTrinh">
<fieldset>
<div class="form-group col-md-12">
	<h2>Đăng ký biên soạn</h2>
	<div class="panel panel-default">
	<div class="panel-body">
	<div class="form-group">
    <label for="tengiaotrinh">Tên giáo trình:</label>
    <input type="text" class="form-control" name="txtTenGiaoTrinh">
    </div>
    <div class="form-group">
	<label for="tengiaotrinh">Ma Giang Vien:</label>
    <input type="text" class="form-control" name="txtMaGiangVien" value="${sessionScope.ID}" disabled>
	</div>
	<div class="form-group">
    <label for="tengiaotrinh">Ngay Hoan Thanh:</label>
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
		<button type="submit" class="btn btn-default">Đăng ký</button>
	</div>
	</div>
	</div>
</div>
</fieldset>
</form>
</div>
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