package model.bean;

public class Admin extends TaiKhoan{
	private int idAdmin;

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Admin() {
		super();
	}

	public Admin(int idAdmin, int idTaiKhoan, String tenDangNhap, String matKhau, int quyen) {
		super(idTaiKhoan, tenDangNhap, matKhau, quyen);
		this.idAdmin = idAdmin;
	}

	@Override
	public void resetPass() {
		setMatKhau("admin");
	}
	
}
