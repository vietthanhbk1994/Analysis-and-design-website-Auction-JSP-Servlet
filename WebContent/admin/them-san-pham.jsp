<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/libraries/js/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/templates/admin/css/styles.css" />
<link
	href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
	href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
	
</script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
	
</script>
<script type="text/javascript"
	src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
	
</script>
<script type="text/javascript"
	src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
	
</script>
</head>
<style>
.basic-grey {
	margin-left: auto;
	margin-right: auto;
	max-width: 900px;
	background: #F7F7F7;
	padding: 25px 15px 25px 10px;
	font: 12px Georgia, "Times New Roman", Times, serif;
	color: #888;
	text-shadow: 1px 1px 1px #FFF;
	border: 1px solid #E4E4E4;
}

.basic-grey h1 {
	font-size: 25px;
	padding: 0px 0px 10px 40px;
	display: block;
	border-bottom: 1px solid #E4E4E4;
	margin: -10px -15px 30px -10px;;
	color: #888;
}

.basic-grey h1>span {
	display: block;
	font-size: 11px;
}

.basic-grey label {
	display: block;
	margin: 0px;
}

.basic-grey label>span {
	float: left;
	width: 20%;
	text-align: right;
	padding-right: 10px;
	margin-top: 10px;
	color: #888;
}

.basic-grey input[type="text"], .basic-grey input[type="email"],
	.basic-grey textarea, .basic-grey select {
	border: 1px solid #DADADA;
	color: #888;
	height: 30px;
	margin-right: 6px;
	margin-top: 3px;
	outline: 0 none;
	padding: 3px 3px 3px 5px;
	width: 70%;
	font-size: 12px;
	line-height: 15px;
	box-shadow: inset 0px 1px 4px #ECECEC;
	-moz-box-shadow: inset 0px 1px 4px #ECECEC;
	-webkit-box-shadow: inset 0px 1px 4px #ECECEC;
}

.basic-grey textarea {
	padding: 5px 3px 3px 5px;
}

.basic-grey textarea {
	height: 100px;
}

.basic-grey .idNguoiDang input[type="text"] {
	width: 55%;
}
</style>
<body>
	<div>
		<form action="#" method="post" class="form basic-grey"
			name="themSanPham">
			<h1>
				Form thêm sản phẩm <span>Điền đầy đủ tất cả các trường.</span>
			</h1>
			<div class="">
				<label class=""> <span>Tên sản phẩm *</span> <input
					type="text" class="" name="tenSanPham">
				</label>
			</div>
			<div class="">
				<label class="idNguoiDang"> <span>ID người đăng *</span> <input
					type="text" class="idNguoiDang" name="id">
					<button type="button" class="btn btn-info">Kiểm tra</button> <a
					class="l" href="#"> <img
						src="<%=request.getContextPath()%>/templates/admin/images/reset.png"
						alt="" width="20" height="20">
				</a>
				</label>
			</div>
			<div class="">
				<label class=""><span>Thông tin người đăng</span> <textarea
						class="form-control" disabled></textarea> </label>
			</div>
			<div class="">
				<label class=""><span>Chủng loại *</span> <select class=""
					name="chungLoai">
						<option value="">Volvo</option>
				</select> </label>
			</div>
			<div class="">
				<label class=""><span>Giá ban đầu *</span> <input
					type="text" class="" name="giaBanDau" value=""> </label>
			</div>
			<div class="">
				<label class=""><span>Bước giá *</span> <input type="text"
					class="" name="buocGia"
					placeholder="Là giá thấp nhất mỗi lần tăng giá"> </label>
			</div>
			<div class="">
				<label class=""><span>Hình ảnh *</span> </label> <input type="file"
					name="hinhAnh">
			</div>
			<div class="">
				<label class=""><span>Thời gian bắt đầu *</span></label>
				<div id="datetimepicker1" class="input-append date">
					<input data-format="yyyy/MM/dd hh:mm:ss" type="text"></input> <span
						class="add-on"> <i data-time-icon="icon-time"
						data-date-icon="icon-calendar"> </i>
					</span>
				</div>
			</div>
			<div class="">
				<label class=""><span>Thời gian kết thúc *</span></label>
				<div id="datetimepicker2" class="input-append date">
					<input data-format="yyyy/MM/dd hh:mm:ss" type="text"></input> <span
						class="add-on"> <i data-time-icon="icon-time"
						data-date-icon="icon-calendar"> </i>
					</span>
				</div>
			</div>
			<div class="">
				<label class=""><span>Thông tin chi tiết</span></label> <br /> <br />
				<br />
				<textarea name="chitiet" rows="7" cols="90" class="ckeditor"></textarea>
			</div>
			<div class="" style="text-align: center; margin-top: 50px;">
				<button type="submit" class="btn btn-success">Thêm</button>
				<button type="reset" class="btn btn-warning">Nhập lại</button>
				<button type="button" class="btn btn-danger">Hủy</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker({
				language : 'en'
			});
		});
		$(function() {
			$('#datetimepicker2').datetimepicker({
				language : 'en'
			});
		});
	</script>

	<!-- Kết thúc phần gì gì đó -->
	<%@include file="/templates/admin/inc/footer.jsp"%>