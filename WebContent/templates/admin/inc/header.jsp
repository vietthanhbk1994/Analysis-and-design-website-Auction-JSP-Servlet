<%@page import="bean.Admin"%>
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
<%
	Admin admin = (Admin) session.getAttribute("admin");
	if (admin == null) {
		//chua dang nhap thi chuyen ve trang login
		response.sendRedirect("login.jsp");
		
	} else
%>

<body class="container-fluid">
	<div style="background-color: #f1f1f1;">
		<!-- Header -->
		<div id="header">
			<!-- TOP -->
			<div class="row">
				<div class="col-md-6">
					<h3>
						<a href="#">Quản trị hệ thống Website đấu giá </a> <strong>SE27</strong>
					</h3>
				</div>
				<div class="col-md-2 col-md-offset-3" style="padding-top: 15px;">
					Chào <span class="text text-lg text-danger"><b><%=admin.getTenDangNhap()%></b></span>
				</div>
				<div style="padding-top: 10px;">
					<a class="btn btn-danger" href="#"><img
						src="<%=request.getContextPath()%>/templates/admin/images/Logout-icon.png"
						alt="" width="20" height="20">Thoát</a>
				</div>
			</div>
			<!-- /TOP -->
			<!-- BOTTOM -->
			<div class="row" style="padding-top: 30px;">
				<!-- /LEFT -->
				<div class="col-md-2">
					<!-- Groups -->
					<div class="panel-group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<img
										src="<%=request.getContextPath()%>/templates/admin/images/home.png"
										alt="" width="20" height="20"> <a href="#"
										target="_main">Trang chủ</a>
								</h4>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<img
										src="<%=request.getContextPath()%>/templates/admin/images/transaction-icon.png"
										alt="" width="20" height="20"> <a data-toggle="collapse"
										href="#giaodich">Quản giao dịch</a>
								</h4>
							</div>
							<div id="giaodich" class="panel-collapse collapse">
								<ul class="list-group">
									<li class="list-group-item"><a href="list-giao-dich"
										target="_main">Danh sách và lọc</a></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<img
										src="<%=request.getContextPath()%>/templates/admin/images/box-512.png"
										alt="" width="20" height="20"> <a data-toggle="collapse"
										href="#sanpham">Quản lý sản phẩm</a>
								</h4>
							</div>
							<div id="sanpham" class="panel-collapse collapse">
								<ul class="list-group">
									<li class="list-group-item"><a href="list-san-pham"
										target="_main">Danh sách và lọc</a></li>
									<li class="list-group-item"><a href="#" target="_main">Duyệt</a></li>
									<li class="list-group-item"><a href="#" target="_main">Thêm</a></li>
									<li class="list-group-item"><a href="#" target="_main">Cập nhật</a></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<img
										src="<%=request.getContextPath()%>/templates/admin/images/user.png"
										alt="" width="20" height="20"> <a data-toggle="collapse"
										href="#thanhvien">Quản lý thành viên</a>
								</h4>
							</div>
							<div id="thanhvien" class="panel-collapse collapse">
								<ul class="list-group">
									<li class="list-group-item"><a href="#" target="_main">Danh
											sách và lọc</a></li>
									<li class="list-group-item"><a href="#" target="_main">Thêm</a></li>
									<li class="list-group-item"><a href="#" target="_main">Khóa</a></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<img
										src="<%=request.getContextPath()%>/templates/admin/images/info-group.png"
										alt="" width="20" height="20"> <a href="#" target="_main">Thông tin</a>
								</h4>
							</div>
						</div>
					</div>
				</div>
				<!-- /LEFT -->
				<!-- RIGHT -->
				<div class="col-md-10">