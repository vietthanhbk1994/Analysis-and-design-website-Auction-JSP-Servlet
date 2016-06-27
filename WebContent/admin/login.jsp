<!-- Đăng nhập admin. Ngô Viết Thành -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Đấu giá</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/templates/admin/css/styles.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/libraries/bootstrap/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/libraries/bootstrap/bootstrap.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/libraries/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/libraries/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/libraries/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/libraries/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/libraries/bootstrap/bootstrap.js"></script>

</head>
<body class="container" style="background-color: #f1f1f1;">
	<!-- Code ở giữa này-->
	<%
		String loi = (String) request.getAttribute("loi");
	%>
	<!-- Bắt form dang nhap -->
	<div style="text-align: center;">
	
		<img alt="" src="<%=request.getContextPath()%>/templates/admin/images/logo.png" width="600px" height="150px">
		<div style="font-size: 400%;">
			<label>Trang quản trị website đấu giá</label>
		</div>
		<br />
		<div class="loi">
			<span>
				<%
					if (loi != null)
						out.print(loi);
				%>
			</span>
		</div>
		<br />
		<form id="frm" action="login" method="post" class="form-horizontal"
			onsubmit="return checkLogin()">
			<div class="form-group ">
				<label class="col-sm-4 control-label">Tài khoản:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="taiKhoan"
						placeholder="Nhập tài khoản" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">Mật khẩu:</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="matKhau"
						placeholder="Nhập mật khẩu" />
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<input type="submit" name="dangnhap" value="Đăng nhập"
						class="btn btn-success" /> <input type="reset" name="reset"
						value="Nhập lại" class="btn btn-success" />
				</div>
			</div>
		</form>
	</div>
	<!-- Kiem tra dang nhap -->
	<script type="text/javascript">
		//kiem tra ký tự đặc biệt. hàm này tự thêm vào
		$.validator.addMethod("kytudacbiet",function(value,element){
			if(/\W+/.test(value)) return false;
			return true;
		},"Trường này không được chứa ký tự đặc biệt hay dấu trống");
		$(document).ready(function() {
			$("#frm").validate({
				rules: {
					taiKhoan : {
						required : true,
						minlength: 4,
						maxlength: 20,
						kytudacbiet: true
					},
					matKhau : {
						required : true,
						minlength : 6,
						maxlength: 20
					}
				},
				messages : {
					taiKhoan : {
						required : "<span style=\"color: red; font-weight: bold;\">Tài khoản không được để trống</span>",
						minlength : "<span style=\"color: red; font-weight: bold;\">Tài khoản phải lớn hơn hoặc bằng 4 ký tự</span>",
						maxlength : "<span style=\"color: red; font-weight: bold;\">Tài khoản phải nhỏ hơn hoặc bằng 20 ký tự</span>",
						kytudacbiet: "<span style=\"color: red; font-weight: bold;\">Tài khoản không được chứa ký tự đặc biệt hay dấu trống</span>"
					},
					matKhau : {
						required : "<span style=\"color: red; font-weight: bold;\">Mật khẩu không được để trống</span>",
						minlength : "<span style=\"color: red; font-weight: bold;\">Mật khẩu phải lớn hơn hoặc bằng 6 ký tự</span>",
						maxlength : "<span style=\"color: red; font-weight: bold;\">Mật khẩu phải nhỏ hơn hoặc bằng 20 ký tự</span>"
					}
				}
			});
		});
			/*var taiKhoan, matKhau,msg="";
			// Get the value of the input field with id="numb"
			taiKhoan = document.getElementsByName("taiKhoan")[0].value;
			matKhau = document.getElementsByName("matKhau")[0].value;
			// kiem tra tai khoan mat khau trong. DangNhapAdmin 6
			if (taiKhoan == "" ) {
				msg="Tài khoản không được để trống";
				return false;
			} else if (matKhau == "") {
				msg="Mật khẩu không được để trống";
				return false;
			} else {
				//kiem tra taiKhoan >= 4 ky tu DangNhapAdmin 8
				if (taiKhoan.length >= 4) {
					//kiem tra taiKhoan <= 20 ky tu
					if (taiKhoan.length <= 20) { //DangNhapAdmin 10
						//kiem tra ky tu dac biet, ko phai so, ko phai chu DangNhapAdmin 7
						if (/\W+/.test(taiKhoan)) {
							alert("Tài khoản không được chứa ký tự đặc biệt hay dấu trống");
							return false;
						}
					} else {
						alert("Tài khoản phải nhỏ hơn hoặc bằng 20 ký tự");
						return false;
					}
				} else {
					alert("Tài khoản phải lớn hơn hoặc bằng 4 ký tự");
					return false;
				}
				//kiem tra mat khau DangNhapAdmin 9
				if (matKhau.length >= 6) {
					//kiem tra matKhau <= 20 ky tu DangNhapAdmin 11
					if (matKhau.length <= 20) {
						//ok
					} else {
						alert("Mật khẩu phải nhỏ hơn hoặc bằng 20 ký tự");
						return false;
					}
				} else {
					alert("Mật khẩu phải lớn hơn hoặc bằng 6 ký tự");
					return false;
				}
			}
		} */
	</script>
	<!-- Kết thúc form dang nhap -->
</body>
</html>