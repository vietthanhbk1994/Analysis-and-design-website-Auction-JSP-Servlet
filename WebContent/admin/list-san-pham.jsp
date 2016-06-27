<!-- 7.6.1.1 Quản lý sản phẩm - Nguyễn Duy Tiến -->
<%@page import="bean.ChungLoai"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.SanPham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %> 
<!-- Code ở giữa này. Đây là -->
	<!-- Bắt đầu phần gì gì đó. Khi làm 1 khối/ lệnh điều khiển gì thì phải comment -->
	<%
		ArrayList<SanPham> listSanPham = (ArrayList<SanPham>) request.getAttribute("listSanPham");
		ArrayList<ChungLoai> listChungLoai = (ArrayList<ChungLoai>) request.getAttribute("listChungLoai");
		int stt=1;
		String loi = (String)request.getAttribute("loi");
	%>
	<div>
		<form action="list-san-pham" method="post" name="loc" class="form-inline" onsubmit="return checkLocSanPham()" accept-charset="UTF-8" >
			<div class="form-group">
		   		<label class=" control-label">Tên sản phẩm: </label>
		   		<input type="text" class="form-control" id="" placeholder="" name="tenSanPham" style="width: 120px" />
		 	 </div>
		 	 <div class="form-group">
		   		<label class="control-label">Chủng loại: </label>
		   		<select class="form-control" name="chungLoai" style="width: 130px">
		   			<option value="">Tất cả</option>
		   			<%
		   				for(ChungLoai objChungLoai: listChungLoai){
		   			%>
					<option value="<%=objChungLoai.getIdChungLoai() %>"><%=objChungLoai.getTenChungLoai() %></option>
					<%} %>
				</select>
		 	 </div>
		 	 <div class="form-group">
		   		<label class="control-label">Người đăng: </label>
		   		<input type="text" class="form-control" id="" placeholder="" name="nguoiDang" style="width: 120px" />
		 	 </div>
		 	 <div class="form-group">
		   		<label class="control-label">Giá: </label>
		   		<input type="text" class="form-control" id="" placeholder="" name="gia" style="width: 120px" />
		 	 </div>
		 	 <div class="form-group">
		   		<label class="control-label">Duyệt: </label>
		   		<select class="form-control" name="duyet" style="width: 130px">
		   			<option value="">Tất cả</option>
					<option value="1">Chưa duyệt</option>
					<option value="2">Được đăng</option>
					<option value="3">Không được đăng</option>
				</select>
		 	 </div>
		 	 <div class="form-group">
		   		<input type="submit" class="form-control btn btn-success" id="" value="Lọc" name="loc" style="width: 80px" />
		 	 </div>
		</form>
		<br />
		<div class="loi">
			<span><%if(loi!=null) out.print(loi); %></span>
		</div>
	</div>
	<div>
		<form action="list-san-pham" method="post" onsubmit="return checkXoa()">
			<table class="table table-bordered table-hover">
				<tr>
					<th>STT</th>
					<th>Chọn</th>
					<th>Mã sản phẩm</th>
					<th>Tên sản phẩm</th>
					<th>Chủng loại</th>
					<th>Người đăng</th>
					<th>Giá ban đầu</th>
					<th>Trạng thái duyệt</th>
					<th>Chi tiết sản phẩm</th>
					<th>Hình ảnh</th>
					<th>Sửa</th>
				</tr>
				<%
					if(listSanPham!=null){
						for(SanPham objSanPham:listSanPham){
				%>
				<tr>
				<td><%=stt++ %></td>
				<td>
					<input type="checkbox" name="chon" value="<%=objSanPham.getIdSanPham() %>">
				</td>
				<td><%=objSanPham.getIdSanPham() %></td>
				<td><%=objSanPham.getTenSanPham() %></td>
				<td><%=objSanPham.getChungLoai() %></td>
				<td><%=objSanPham.getNguoiDang() %></td>
				<td><%=objSanPham.getGiaBanDau() %></td>
				<td>
					<% 
						if(objSanPham.getDuyet()==1){
							out.print("Chưa duyệt");
						}else if(objSanPham.getDuyet()==2){
							out.print("Được đăng");
						}else if(objSanPham.getDuyet()==3){
							out.print("Không được đăng");
						}
					%>
				</td>
				<td><%=objSanPham.getChiTietSP() %></td>
				<td><%=objSanPham.getHinhAnh() %></td>
				<td>
					<a href="#">Sửa</a>
				</td>
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
								<a href="<%=request.getContextPath()%>/admin/list-san-pham?page=<%=i%>" <%=active %>>Đầu</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/admin/list-san-pham?page=<%=current_page-1%>" <%=active %>>Trước</a>
							</li>
							<%} %>
					<li>		
						<a href="<%=request.getContextPath()%>/admin/list-san-pham?page=<%=i%>" <%=active %>><%=i %></a>
					</li>
							<%if(i==sotrang) {%>
							<li>
								<a href="<%=request.getContextPath()%>/admin/list-san-pham?page=<%=current_page+1%>" <%=active %>>Sau</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/admin/list-san-pham?page=<%=i%>" <%=active %>>Cuối</a>
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
	<!-- Kiem tra du lieu loc -->
	<script type="text/javascript">
	//kiem tra xoa giao dich
	function checkXoa() {
		var chonXoa = document.getElementsByName("chon");
		for (var i = 0; i < chonXoa.length; i++) {
			if(chonXoa[i].checked){
				return true;
			}
		}
		alert("Chưa chọn giao dịch để xóa");
		return false;
		
	}
	//kiem tra loc giao dich
	function checkLocSanPham() {
	    var tenSanPham, chungLoai, nguoiDang, gia, duyet;
	    // Get the value of the input field with id="numb"
	    tenSanPham = document.getElementsByName("tenSanPham")[0].value;
	    chungLoai = document.getElementsByName("chungLoai")[0].value;
	    nguoiDang = document.getElementsByName("nguoiDang")[0].value;
	    gia = document.getElementsByName("gia")[0].value;
	    duyet = document.getElementsByName("duyet")[0].value;
	    // kiem tra thanhTien DanhSachLocGiaoDich15
	    //kt so nguyen duong
	    if (/\D+/.test(gia)) {
	    	alert("Giá phải là số nguyên dương");
	    	return false;
	    }
	    //kiem tra thanhTien la boi cua 1.000 DanhSachLocGiaoDich19
	    if(gia%1000!=0){
	    	alert("Giá phải là bội của 1000");
    		return false;
	    }
	    	//thanh tien phai duoi 9 chu so DanhSachLocGiaoDich20
	    if(gia>=1000000000){
	    	alert("Giá phải nhỏ hơn 1.000.000.000");
			return false;	
	    }
	    
	    //kiem tra maxlength nguoiDang, nguoiMua, tenSanPham
	    if (nguoiDang.length >30) {
	    	alert("Người đăng phải nhỏ hơn hoặc bằng 30 ký tự");
        	return false;
		}
	    if (tenSanPham.length <=30) {
    		alert("Tên sản phẩm phải nhỏ hơn hoặc bằng 30 ký tự");
	      	return false;
	   	}
	}
	</script>
	<!-- Kết thúc phần gì gì đó -->
<%@include file="/templates/admin/inc/footer.jsp" %> 