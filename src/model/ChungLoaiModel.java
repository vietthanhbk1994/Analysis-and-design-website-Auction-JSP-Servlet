package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Admin;
import bean.ChungLoai;
import bean.TaiKhoan.quyenTK;
import library.LibraryConnectDatabase;

public class ChungLoaiModel {
	private Statement stm;
	private ResultSet rs;
	LibraryConnectDatabase db = new LibraryConnectDatabase();
	public ArrayList<ChungLoai> getCL(){
		ArrayList<ChungLoai> listChungLoai = new ArrayList<ChungLoai>();
		String sql = "SELECT * FROM chungloai";
		try {
			Connection conn = db.getConnectMySQL();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				ChungLoai objChungLoai = new ChungLoai();
				objChungLoai.setIdChungLoai(rs.getInt(1));
				objChungLoai.setTenChungLoai(rs.getString(2));
				listChungLoai.add(objChungLoai);
			}
			db.closeDB(conn, stm, rs);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return listChungLoai;
	}
}