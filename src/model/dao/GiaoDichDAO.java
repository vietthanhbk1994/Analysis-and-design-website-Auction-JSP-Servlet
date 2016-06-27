package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import bean.GiaoDich;
import model.bo.ConnectDatabaseBO;

public class GiaoDichDAO {
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	ConnectDatabaseBO db = new ConnectDatabaseBO();
	//lay so luong giao dich de phan trang
	public int getTotal() {
		int total=0;
		String sql="SELECT count(idgiaodich) AS total FROM giaodich";
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
	public int getTotalSearch(String nguoiDang, String nguoiMua, String tenSanPham, String thanhTien, String tinhTrang) {
		int total=0;
		String sq="";
		if(!nguoiDang.equals("")){
			sq+=" AND u.hovaten LIKE '%"+nguoiDang+"%'";
		}
		if(!nguoiMua.equals("")){
			sq+=" AND us.hovaten LIKE '%"+nguoiMua+"%'";
		}
		if(!tenSanPham.equals("")){
			sq+=" AND s.tensanpham LIKE '%"+tenSanPham+"%'";
		}
		if(!thanhTien.equals("")){
			sq+=" AND g.thanhtien >="+thanhTien;
		}
		if(!tinhTrang.equals("")){
			sq+=" AND g.tinhtrang ="+tinhTrang;
		}
		String sql="SELECT COUNT(idgiaodich) AS total FROM giaodich AS g, daugia AS d,"
				+"user AS u, user AS  us, sanpham AS s WHERE g.iddaugia=d.iddaugia"
				+ " AND d.iduser = u.iduser AND d.idsanpham = s.idsanpham"
				+ " AND s.iduser = us.iduser"+sq;
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
	//loc giao dich
	public ArrayList<GiaoDich> searchGD(String nguoiDang, String nguoiMua, String tenSanPham, String thanhTien, String tinhTrang,int offset,int row_count) {
		
		ArrayList<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>();
		String sql = "SELECT g.idgiaodich,s.thoigianketthuc,u.hovaten,us.hovaten,"
				+ " s.tensanpham, g.thanhtien,g.phidichvu,g.tinhtrang FROM"
				+ " giaodich AS g, daugia AS d, user AS u, user AS  us, sanpham AS s "
				+ "WHERE g.iddaugia=d.iddaugia AND d.iduser = u.iduser AND"
				+ " d.idsanpham = s.idsanpham AND s.iduser = us.iduser";
		String sqlLimit=" ORDER BY g.idgiaodich ASC LIMIT "+offset+","+row_count;
		String sq="";
		if(!nguoiDang.equals("")){
			sq+=" AND u.hovaten LIKE '%"+nguoiDang+"%'";
		}
		if(!nguoiMua.equals("")){
			sq+=" AND us.hovaten LIKE '%"+nguoiMua+"%'";
		}
		if(!tenSanPham.equals("")){
			sq+=" AND s.tensanpham LIKE '%"+tenSanPham+"%'";
		}
		if(!thanhTien.equals("")){
			sq+=" AND g.thanhtien >="+thanhTien;
		}
		if(!tinhTrang.equals("")){
			sq+=" AND g.tinhtrang ="+tinhTrang;
		}
		sql=sql+sq+sqlLimit;
		try {
			Connection conn = db.getConnectMySQL();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				GiaoDich objGiaoDich = new GiaoDich();
				objGiaoDich.setIdGiaoDich(rs.getInt(1));
				objGiaoDich.setThoiGianKetThuc(rs.getString(2));
				objGiaoDich.setNguoiDang(rs.getString(3));
				objGiaoDich.setNguoiMua(rs.getString(4));
				objGiaoDich.setTenSanPham(rs.getString(5));
				objGiaoDich.setThanhTien(rs.getInt(6));
				objGiaoDich.setPhiDichVu(rs.getInt(7));
				objGiaoDich.setTinhTrangGD(rs.getInt(8));
				
				listGiaoDich.add(objGiaoDich);
			}
			db.closeDB(conn, stm, rs);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return listGiaoDich;
	}
	//xóa giao dịch
	public Boolean xoaGD(String[] listIdXoa){
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
		String sql="DELETE FROM giaodich WHERE idgiaodich IN ("+sq+")";
		int xoa = 0;
		try {
			Connection conn = db.getConnectMySQL();
			stm = conn.createStatement();
			xoa = stm.executeUpdate(sql);
			db.closeDB(conn, stm, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Xoa:"+xoa);;
		return xoa!=0;
	}
	
	
	//Lấy danh sách giao dịch
	public ArrayList<GiaoDich> getGD(int offset,int row_count) {
		ArrayList<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>();
		String sql = "SELECT g.idgiaodich,s.thoigianketthuc,u.hovaten,us.hovaten,"
				+ " s.tensanpham, g.thanhtien,g.phidichvu,g.tinhtrang FROM"
				+ " giaodich AS g, daugia AS d, user AS u, user AS  us, sanpham AS s "
				+ "WHERE g.iddaugia=d.iddaugia AND d.iduser = u.iduser AND"
				+ " d.idsanpham = s.idsanpham AND s.iduser = us.iduser"
				+ " ORDER BY g.idgiaodich ASC LIMIT "+offset+","+row_count;
		System.out.println("SQL:"+sql);
		try {
			Connection conn = db.getConnectMySQL();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				GiaoDich objGiaoDich = new GiaoDich();
				objGiaoDich.setIdGiaoDich(rs.getInt(1));
				
				System.out.println("::"+rs.getString(2));
				
				objGiaoDich.setThoiGianKetThuc(rs.getString(2));
				objGiaoDich.setNguoiDang(rs.getString(3));
				objGiaoDich.setNguoiMua(rs.getString(4));
				objGiaoDich.setTenSanPham(rs.getString(5));
				objGiaoDich.setThanhTien(rs.getInt(6));
				objGiaoDich.setPhiDichVu(rs.getInt(7));
				objGiaoDich.setTinhTrangGD(rs.getInt(8));
				
				
				
				listGiaoDich.add(objGiaoDich);
			}
			db.closeDB(conn, stm, rs);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return listGiaoDich;
	}
}
