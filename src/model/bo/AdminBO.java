package model.bo;


import bean.Admin;
import model.dao.AdminDAO;

public class AdminBO {
	AdminDAO adminDAO = new AdminDAO();
	public Admin checkAccount(String taiKhoan, String matKhau){
		return adminDAO.checkAccount(taiKhoan, matKhau);
	}
}