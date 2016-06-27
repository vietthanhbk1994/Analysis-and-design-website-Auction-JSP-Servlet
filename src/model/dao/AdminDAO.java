package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;
import model.bo.ConnectDatabaseBO;

public class AdminDAO {
	private PreparedStatement pstm;
	private ResultSet rs;
	ConnectDatabaseBO db = new ConnectDatabaseBO();
	public Admin checkAccount(String taiKhoan, String matKhau){
		Admin admin = null;
		String sql = "SELECT * FROM admin WHERE tendangnhap = ? AND matkhau = ? LIMIT 1";
		try {
			Connection conn = db.getConnectMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, taiKhoan);
			pstm.setString(2, matKhau);
			rs = pstm.executeQuery();
			if(rs.next()){
				//quyen mat dinh cua admin la 0, cua user la 1
				admin = new Admin(rs.getInt(1),rs.getInt(1),rs.getString(2), rs.getString(3), 0);
			}
			db.closeDB(conn, pstm, rs);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return admin;
	}
}