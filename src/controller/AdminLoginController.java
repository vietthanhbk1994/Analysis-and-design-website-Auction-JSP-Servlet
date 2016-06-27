package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import model.AdminModel;
import model.bo.AdminBO;

/**
 * Servlet implementation class AdminLoginController
 */
//@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String submit = request.getParameter("dangnhap");
		//Kiem tra mo trang dang nhap hay click vao dang nhap
		if(submit!=null){//neu nham vao submit thi kiem tra tai khoan mat khau
			String taiKhoan = request.getParameter("taiKhoan");
			String matKhau = request.getParameter("matKhau");
			AdminBO mAdmin = new AdminBO();
			// goi ham kiem tra tai khoan, mat khau trong Model
			Admin admin = mAdmin.checkAccount(taiKhoan, matKhau);
			if(admin!=null){//dung tai khoan mat khau
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				response.sendRedirect(request.getContextPath()+"/admin/list-giao-dich");
			}else{//sai tai khoan mat khau
				request.setAttribute("loi", "Tên đăng nhập hoặc mật khẩu bị sai. Vui lòng nhập lại");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}else{//neu mo trang dang nhap
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
