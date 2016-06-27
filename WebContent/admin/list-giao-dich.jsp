<!-- 7.8.1.1 Quản lý giao dịch – Danh sách, lọc. Ngô Viết Thành-->

<%@page import="bean.GiaoDich"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Code ở giữa này -->
	<%
		ArrayList<GiaoDich> listGiaoDich = 	(ArrayList<GiaoDich>) request.getAttribute("listGiaoDich");
		int stt=1;
		String loi = (String)request.getAttribute("loi");
	%>
	<!-- Bắt đầu phần gì gì đó. Khi làm 1 khối/ lệnh điều khiển gì thì phải comment -->
	<div>
		<form action="list-giao-dich" method="post" name="loc" class="form-inline" onsubmit="return checkLocGiaoDich()" id="frm">
			<div class="form-group">
		   		<label class=" control-label">Người đăng: </label>
		   		<input type="text" class="form-control" id="" placeholder="" name="nguoiDang" style="width: 120px" />
		 	 </div>
		 	 <div class="form-group">
		   		<label class="control-label">Người mua: </label>
		   		<input type="text" class="form-control" id="" placeholder="" name="nguoiMua" style="width: 120px" />
		 	 </div>
		 	 <div class="form-group">
		   		<label class="control-label">Tên sản phẩm: </label>
		   		<input type="text" class="form-control" id="" placeholder="" name="tenSanPham" style="width: 120px" />
		 	 </div>
		 	 <div class="form-group">
		   		<label class="control-label">Thành tiền: </label>
		   		<input type="text" class="form-control" id="" placeholder="" name="thanhTien" style="width: 100px" />
		 	 </div>
		 	 <div class="form-group">
		   		<label class="control-label">Tình trạng: </label>
		   		<select class="form-control" name="tinhTrang" style="width: 130px">
		   			<option value="">Tất cả</option>
					<option value="1">Thành công</option>
					<option value="2">Thất bại</option>
				</select>
		 	 </div>
		 	 <div class="loi-search">
		 	 	<span class="loi" id="loi"><%if(loi!=null) out.print(loi); %></span>
			 	 <div class="form-group right search">
			   		<input type="submit" class="form-control btn btn-success" id="" value="Lọc" name="loc" style="width: 80px" />
			 	 </div>
				<div class="clear"></div>
		 	 </div>
		</form>
	</div>
	<div>
		<form action="list-giao-dich" method="post" onsubmit="return checkXoa()" id="frm1">
			<table class="table table-bordered table-hover">
				<tr>
					<th>STT</th>
					<th>Chọn</th>
					<th>Mã giao dịch</th>
					<th>Thời gian đấu giá thành công</th>
					<th>Người đăng</th>
					<th>Người mua</th>
					<th>Tên sản phẩm</th>
					<th>Thành tiền</th>
					<th>Phí dịch vụ</th>
					<th>Tình trạng giao dịch</th>
				</tr>
				<%
					if(listGiaoDich!=null){
						for(GiaoDich objGiaoDich:listGiaoDich){
				%>
				<tr>
				<td><%=stt++ %></td>
				<td>
					<input type="checkbox" name="chon" value="<%=objGiaoDich.getIdGiaoDich() %>">
				</td>
				<td><%=objGiaoDich.getIdGiaoDich() %></td>
				<td><%=objGiaoDich.getThoiGianKetThuc() %></td>
				<td><%=objGiaoDich.getNguoiDang() %></td>
				<td><%=objGiaoDich.getNguoiMua() %></td>
				<td><%=objGiaoDich.getTenSanPham() %></td>
				<td><%=objGiaoDich.getThanhTien() %></td>
				<td><%=objGiaoDich.getPhiDichVu() %></td>
				<td><%if(objGiaoDich.getTinhTrangGD()==1) out.print("Thành công"); else out.print("Thất bại"); %></td>
				</tr>
				<%	
						}
					}
				%>
			</table>
			<div>
				<div class="left">
					<button type="submit" class="btn btn-danger" name="xoa" >
						<img src="<%=request.getContextPath() %>/templates/admin/images/del-icon.png" alt="" width="20" height="20"> Xóa
					</button>
				</div>
				<!-- Phân trang. -->
				<div class="right ">
					<nav>
					<ul class="pagination">
					<%	
						String active="";
						int sotrang=(Integer)(request.getAttribute("sotrang"));
						int current_page=(Integer)(request.getAttribute("current_page"));
						for(int i=1;i<=sotrang;i++){
							if(current_page==i){
								active=" class= 'btn disabled'";
							}else{
								active="";
							}
							if(i==1){
					%>
							<li>
								<a href="<%=request.getContextPath()%>/admin/list-giao-dich?page=<%=i%>" <%=active %>>Đầu</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/admin/list-giao-dich?page=<%=current_page-1%>" <%=active %>>Trước</a>
							</li>
							<%} %>
					<li>		
						<a href="<%=request.getContextPath()%>/admin/list-giao-dich?page=<%=i%>" <%=active %>><%=i %></a>
					</li>
							<%if(i==sotrang) {%>
							<li>
								<a href="<%=request.getContextPath()%>/admin/list-giao-dich?page=<%=current_page+1%>" <%=active %>>Sau</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/admin/list-giao-dich?page=<%=i%>" <%=active %>>Cuối</a>
							</li>
					<%	
							}
						} 
					%>
					</ul>
					</nav>
				</div>
				<div class="clear"></div>
			</div>
		</form>
	</div>
	</div>
	<!-- Kiem tra du lieu loc -->
	<script type="text/javascript">
		//Thêm vào validator hàm kiểm tra xem có phải là bội của 1000 hay ko
		$.validator.addMethod("boi1000",function(value,element){
			if(value%1000==0){
				return true;
			}
			return false;
		},"<span style=\"color: red; font-weight: bold;\">Trường này phải là bội của 1000</span>");
		$(document).ready(function() {
			$("#frm").validate({
				errorPlacement: function (error, element) {
				      error.insertAfter(document.getElementById("loi"));
				},
				rules: {
					nguoiDang: {
						maxlength: 30
					},
					nguoiMua: {
						maxlength: 30
					},
					tenSanPham: {
						maxlength: 30
					},
					thanhTien : {
						/* number: true, */
						min:1,
						max:999999999,
						boi1000: true
					}
				},
				messages : {
					nguoiDang : {
						maxlength: "<span style=\"color: red; font-weight: bold;\">Người đăng phải nhỏ hơn hoặc bằng 30 ký tự</span>"
					},
					nguoiMua : {
						maxlength: "<span style=\"color: red; font-weight: bold;\">Người mua phải nhỏ hơn hoặc bằng 30 ký tự</span>"
					},
					tenSanPham :{
						maxlength: "<span style=\"color: red; font-weight: bold;\">Tên sản phẩm phải nhỏ hơn hoặc bằng 30 ký tự</span>"
					},
					thanhTien : {
						/* number : "<span style=\"color: red; font-weight: bold;\">Tiền phải là số</span>", */
						min: "<span style=\"color: red; font-weight: bold;\">Thành tiền phải là số dương</span>",
						max: "<span style=\"color: red; font-weight: bold;\">Thành tiền phải là số nhỏ hơn 1 tỉ</span>",
						boi1000: "<span style=\"color: red; font-weight: bold;\">Thành tiền phải là bội của 1000</span>"
					}
				}
			});
		});
	//kiem tra xoa giao dich
	$(document).ready(function(){
		$("#frm1").validate({
			errorPlacement: function(error, element){
				error.insertAfter(document.getElementById("loi"));
			},
			rules:{
				chon:{
					required: true
				}
			},
			messages:{
				chon:{
					required: "<span style=\"color: red; font-weight: bold;\">Chưa chọn giao dịch để xóa</span>"
				}
			}
		});
	});
	/* function checkXoa() {
		var chonXoa = document.getElementsByName("chon");
		for (var i = 0; i < chonXoa.length; i++) {
			if(chonXoa[i].checked){
				return true;
			}
		}
		alert("Chưa chọn giao dịch để xóa");
		return false;
		
	} */
	//kiem tra loc giao dich
	/* function checkLocGiaoDich() {
	    var nguoiDang, nguoiMua, tenSanPham, thanhTien;
	    // Get the value of the input field with id="numb"
	    nguoiDang = document.getElementsByName("nguoiDang")[0].value;
	    nguoiMua = document.getElementsByName("nguoiMua")[0].value;
	    tenSanPham = document.getElementsByName("tenSanPham")[0].value;
	    thanhTien = document.getElementsByName("thanhTien")[0].value;
	    // kiem tra thanhTien DanhSachLocGiaoDich15
	    //kt so nguyen duong
	    if (/\D+/.test(thanhTien)) {
	    	alert("Thành tiền phải là số nguyên dương");
	    	return false;
	    } */
	  //thanh tien phai duoi 9 chu so DanhSachLocGiaoDich20
/* 		if(thanhTien>=1000000000){
			alert("Thành tiền phải nhỏ hơn 1.000.000.000");
    		return false;	
		} */
	    //kiem tra thanhTien la boi cua 1.000 DanhSachLocGiaoDich19
/* 	    if(thanhTien%1000!=0){
	    	alert("Thành tiền phải là bội của 1000");
    		return false;
	    }
 *//* 	    //kiem tra maxlength nguoiDang, nguoiMua, tenSanPham
	    if (nguoiDang.length >30) {
	    	alert("Người đăng phải nhỏ hơn hoặc bằng 30 ký tự");
        	return false;
	     }
	    if (nguoiMua.length >30) {
			alert("Người mua phải nhỏ hơn hoặc bằng 30 ký tự");
        	return false;
		}
	    if (tenSanPham.length >30) {
			alert("Tên sản phẩm phải nhỏ hơn hoặc bằng 30 ký tự");
        	return false;
		} */
	/* } */
	</script>
	<!-- Kết thúc phần gì gì đó -->
<%@include file="/templates/admin/inc/footer.jsp" %> 