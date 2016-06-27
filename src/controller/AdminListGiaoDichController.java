package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GiaoDich;
import model.GiaoDichModel;

/**
 * Servlet implementation class AdminListGiaoDichController
 */
// @WebServlet("/AdminListGiaoDichController")
public class AdminListGiaoDichController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminListGiaoDichController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String loc = request.getParameter("loc");
		String xoa = request.getParameter("xoa");
		GiaoDichModel mGiaoDich = new GiaoDichModel();
		String loi = "";
		int current_page = 1;
		int row_count = 2;
		int sotrang = 0;
		int total = 0;
		// -----------------phan trang------------
		// lay trang hien tai, neu load trang lan dau thi trang hien tai =1
		// khi khong bam vao so trang
		if (request.getParameter("page") != null) {
			current_page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (current_page - 1) * row_count;
		// -------------------------------
		if (loc != null || xoa != null) {// neu nhan nut loc hoac xoa
			if (loc != null) {// nhan nut loc
				String nguoiDang = request.getParameter("nguoiDang");
				System.out.println(nguoiDang);
				String nguoiMua = request.getParameter("nguoiMua");
				String tenSanPham = request.getParameter("tenSanPham");
				String thanhTien = request.getParameter("thanhTien");
				String tinhTrang = request.getParameter("tinhTrang");
				if (!(nguoiDang.equals("") && nguoiMua.equals("") && tenSanPham.equals("") && thanhTien.equals("")
						&& tinhTrang.equals(""))) {
					// neu search co dl vao
					// -----------------Phan trang-------------------
					total = mGiaoDich.getTotalSearch(nguoiDang, nguoiMua, tenSanPham, thanhTien, tinhTrang);
					sotrang = (int) Math.ceil((float) total / row_count);

					// ----------------------------------------
					ArrayList<GiaoDich> listGiaoDich = mGiaoDich.searchGD(nguoiDang, nguoiMua, tenSanPham, thanhTien,
							tinhTrang, offset, row_count);
					if (listGiaoDich.size() != 0) {// tra ve danh sach giao dich
													// tim duoc
						request.setAttribute("listGiaoDich", listGiaoDich);
						request.setAttribute("current_page", 1);
						request.setAttribute("sotrang", sotrang);
					} else {// ko tim thay ket qua
						request.setAttribute("loi", "Không tồn tại dữ liệu!");
						request.setAttribute("current_page", 0);
						request.setAttribute("sotrang", 0);
					}
					RequestDispatcher rd = request.getRequestDispatcher("list-giao-dich.jsp");
					rd.forward(request, response);
					return;
				}
				// neu search ma ko co dl vao thi load lai trang
			} else if (xoa != null) {// nhan nut xoa
				String[] listIdXoa = request.getParameterValues("chon");
				System.out.println("size:"+listIdXoa.length);
				if (mGiaoDich.xoaGD(listIdXoa)) {// neu xoa thanh cong
					// thi chay xuong load lai trang
				} else {// neu xoa that bai, thong bao ko ton tai dl, load lai
						// trang
					loi = "Dữ liệu không tồn tại để xóa!\n";
					request.setAttribute("loi", loi);
				}
			}
		}
		// neu load trang
		// -----------------Phan trang-------------------
		total = mGiaoDich.getTotal();
		sotrang = (int) Math.ceil((float) total / row_count);
		
		System.out.println("Total:"+total);
		System.out.println("sotrang:"+sotrang);
		System.out.println("current_page:"+current_page);
		System.out.println("offset:"+offset);
		System.out.println("row_count:"+row_count);
		
		request.setAttribute("sotrang", sotrang);
		request.setAttribute("current_page", current_page);
		// ----------------------------------------
		ArrayList<GiaoDich> listGiaoDich = mGiaoDich.getGD(offset, row_count);
		// truong hop bang ko co du lieu + xoa dl da bi xoa truoc do
		if (listGiaoDich.size() == 0) {
			request.setAttribute("loi", loi + "Không tồn tại dữ liệu!");
		} else {
			request.setAttribute("listGiaoDich", listGiaoDich);
		}
		RequestDispatcher rd = request.getRequestDispatcher("list-giao-dich.jsp");
		rd.forward(request, response);
	}

}