package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.GiaoDich;
import bean.SanPham;
import library.LibraryConnectDatabase;

public class SanPhamModel {
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	LibraryConnectDatabase db = new LibraryConnectDatabase();
	//lay so luong san pham de phan trang
	public int getTotal() {
		int total=0;
		String sql="SELECT count(idsanpham) AS total FROM sanpham";
		try {
			Connection conn= db.getConnectMySQL();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			if(rs.next()){
				total=rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	public int getTotalSearch(String tenSanPham, String chungLoai, String nguoiDang, String gia, String duyet) {
		int total=0;
		String sq="";
		if(!tenSanPham.equals("")){
			sq+=" AND s.tensanpham LIKE '%"+tenSanPham+"%'";
		}
		if(!chungLoai.equals("")){
			sq+=" AND c.idchungloai LIKE '%"+chungLoai+"%'";
		}
		if(!nguoiDang.equals("")){
			sq+=" AND u.hovaten LIKE '%"+nguoiDang+"%'";
		}
		if(!gia.equals("")){
			sq+=" AND s.giabandau >="+gia;
		}
		if(!duyet.equals("")){
			sq+=" AND s.duyet ="+duyet;
		}
		String sql="SELECT COUNT(idsanpham) AS total FROM sanpham AS s,"
				+ " chungloai AS c, user AS u WHERE s.idchungloai = c.idchungloai AND"
				+ " s.iduser=u.iduser"+sq;
		try {
			Connection conn= db.getConnectMySQL();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			if(rs.next()){
				total=rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	//loc san pham
	public ArrayList<SanPham> searchSP(String tenSanPham, String chungLoai, String nguoiDang, String gia, String duyet,int offset,int row_count) {
		System.out.println("Duyet1:"+duyet);
		ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
		String sql = "SELECT s.idsanpham, s.tensanpham, c.tenchungloai,"
				+ " u.hovaten, s.giabandau, s.duyet, s.chitietsanpham,"
				+ " s.hinhanh FROM sanpham AS s, chungloai AS c,"
				+ " user AS u WHERE s.idchungloai = c.idchungloai AND"
				+ " s.iduser=u.iduser";
		String sqlLimit=" ORDER BY s.idsanpham ASC LIMIT "+offset+","+row_count;
		String sq="";
		if(!tenSanPham.equals("")){
			sq+=" AND s.tensanpham LIKE '%"+tenSanPham+"%'";
		}
		if(!chungLoai.equals("")){
			sq+=" AND c.idchungloai LIKE '%"+chungLoai+"%'";
		}
		if(!nguoiDang.equals("")){
			sq+=" AND u.hovaten LIKE '%"+nguoiDang+"%'";
		}
		if(!gia.equals("")){
			sq+=" AND s.giabandau >="+gia;
		}
		if(!duyet.equals("")){
			sq+=" AND s.duyet ="+duyet;
		}
		//lay so ket qua tim kiem dc
		sql=sql+sq+sqlLimit;
		System.out.println(sql);
		try {
			Connection conn = db.getConnectMySQL();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				SanPham objSanPham = new SanPham();
				objSanPham.setIdSanPham(rs.getInt(1));
				objSanPham.setTenSanPham(rs.getString(2));
				objSanPham.setChungLoai(rs.getString(3));
				objSanPham.setNguoiDang(rs.getString(4));
				objSanPham.setGiaBanDau(rs.getInt(5));
				objSanPham.setDuyet(rs.getInt(6));
				objSanPham.setChiTietSP(rs.getString(7));
				objSanPham.setHinhAnh(rs.getString(8));
				
				listSanPham.add(objSanPham);
			}
			db.closeDB(conn, stm, rs);
			pstm.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return listSanPham;
	}
	//xóa san pham
	public Boolean xoaSP(String[] listIdXoa){
		String sq="";
		//lay danh sach id can xoa
		if(listIdXoa.length==1){
			sq = listIdXoa[0];
		}else{
			for (int i = 0; i < listIdXoa.length-1; i++) {
				sq+=listIdXoa[i]+",";
			}
			sq+= listIdXoa[listIdXoa.length-1];
		}
		String sql="DELETE FROM sanpham WHERE idsanpham IN ("+sq+")";
		int xoa = 0;
		try {
			Connection conn = db.getConnectMySQL();
			stm = conn.createStatement();
			xoa = stm.executeUpdate(sql);
			db.closeDB(conn, stm, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xoa!=0;
	}
	
	
	//Lấy danh sách san pham
	public ArrayList<SanPham> getSP(int offset,int row_count) {
		ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
		String sql = "SELECT s.idsanpham, s.tensanpham, c.tenchungloai,"
				+ " u.hovaten, s.giabandau, s.duyet, s.chitietsanpham,"
				+ " s.hinhanh FROM sanpham AS s, chungloai AS c,"
				+ " user AS u WHERE s.idchungloai = c.idchungloai AND"
				+ " s.iduser=u.iduser ORDER BY s.idsanpham ASC "
				+ " LIMIT "+offset+","+row_count;
		try {
			Connection conn = db.getConnectMySQL();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				SanPham objSanPham = new SanPham();
				objSanPham.setIdSanPham(rs.getInt(1));
				objSanPham.setTenSanPham(rs.getString(2));
				objSanPham.setChungLoai(rs.getString(3));
				objSanPham.setNguoiDang(rs.getString(4));
				objSanPham.setGiaBanDau(rs.getInt(5));
				objSanPham.setDuyet(rs.getInt(6));
				objSanPham.setChiTietSP(rs.getString(7));
				objSanPham.setHinhAnh(rs.getString(8));
				
				listSanPham.add(objSanPham);
			}
			db.closeDB(conn, stm, rs);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return listSanPham;
	}
}
