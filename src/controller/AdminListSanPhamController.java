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
import bean.SanPham;
import model.ChungLoaiModel;
import model.GiaoDichModel;
import model.SanPhamModel;

/**
 * Servlet implementation class AdminListGiaoDichController
 */
// @WebServlet("/AdminListGiaoDichController")
public class AdminListSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminListSanPhamController() {
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
		SanPhamModel mSanPham = new SanPhamModel();
		ChungLoaiModel mChungLoai = new ChungLoaiModel();
		String loi = "";
		int current_page = 1;
		int row_count = 2;
		int sotrang = 0;
		int total = 0;
		//-----------------phan trang------------
		// lay trang hien tai, neu load trang lan dau thi trang hien tai =1
		// khi khong bam vao so trang
		if (request.getParameter("page") != null) {
			current_page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (current_page - 1) * row_count;
		//-------------------------------
		if (loc != null || xoa != null) {// neu nhan nut loc hoac xoa
			if (loc != null) {// nhan nut loc
				//String tenSanPham = new String(request.getParameter("tenSanPham").getBytes("ISO-8859-1"), "UTF-8");
				String tenSanPham = request.getParameter("tenSanPham");
				String chungLoai = request.getParameter("chungLoai");
				String nguoiDang = request.getParameter("nguoiDang");
				String gia = request.getParameter("gia");
				String duyet = request.getParameter("duyet");
				if (!(tenSanPham.equals("") && nguoiDang.equals("") && gia.equals("")&& duyet.equals("")&& chungLoai.equals(""))) {
					// neu search co dl vao
					// -----------------Phan trang-------------------
					total = mSanPham.getTotalSearch(tenSanPham, chungLoai, nguoiDang, gia, duyet);
					sotrang = (int) Math.ceil((float) total / row_count);
					// ----------------------------------------
					ArrayList<SanPham> listSanPham = mSanPham.searchSP(tenSanPham, chungLoai, nguoiDang, gia, duyet,
							offset, row_count);
					if (listSanPham.size() != 0) {// tra ve danh sach giao dich
													// tim duoc
						request.setAttribute("listSanPham", listSanPham);
						request.setAttribute("current_page", 1);
						request.setAttribute("sotrang", sotrang);
					} else {// ko tim thay ket qua
						request.setAttribute("loi", "Không tồn tại dữ liệu!");
						request.setAttribute("current_page", 0);
						request.setAttribute("sotrang", 0);
					}
					request.setAttribute("listChungLoai", mChungLoai.getCL());
					RequestDispatcher rd = request.getRequestDispatcher("list-san-pham.jsp");
					rd.forward(request, response);
					return;
				}
				// neu search ma ko co dl vao thi load lai trang
			} else if (xoa != null) {// nhan nut xoa
				String[] listIdXoa = request.getParameterValues("chon");
				if (mSanPham.xoaSP(listIdXoa)) {// neu xoa thanh cong
					// thi chay xuong load lai trang
				} else {// neu xoa that bai, thong bao ko ton tai dl, load lai
						// trang
					loi = "Dữ liệu không tồn tại để xóa!\n";
					request.setAttribute("loi", loi);
				}
			}
		}
		// -----------------Phan trang-------------------
		total = mSanPham.getTotal();
		sotrang = (int) Math.ceil((float) total / row_count);
		request.setAttribute("sotrang", sotrang);
		request.setAttribute("current_page", current_page);
		// ----------------------------------------
		// neu load trang
		ArrayList<SanPham> listSanPham = mSanPham.getSP(offset, row_count);
		// truong hop bang ko co du lieu + xoa dl da bi xoa truoc do
		if (listSanPham.size() == 0) {
			request.setAttribute("loi", loi + "Không tồn tại dữ liệu!");
		} else {
			request.setAttribute("listSanPham", listSanPham);
		}

		request.setAttribute("listChungLoai", mChungLoai.getCL());
		RequestDispatcher rd = request.getRequestDispatcher("list-san-pham.jsp");
		rd.forward(request, response);
	}
}
