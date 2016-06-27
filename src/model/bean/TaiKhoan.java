package model.bean;

public abstract class TaiKhoan {
	private int idTaiKhoan;
	private String tenDangNhap;
	private String matKhau;
	private int quyen;
	public enum quyenTK {
		ADMIN,USER;
	}
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	public int getIdTaiKhoan() {
		return idTaiKhoan;
	}
	public void setIdTaiKhoan(int idTaiKhoan) {
		this.idTaiKhoan = idTaiKhoan;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaiKhoan(int idTaiKhoan, String tenDangNhap, String matKhau, int quyen) {
		super();
		this.idTaiKhoan = idTaiKhoan;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	//hàm kiểm tra tài khoản mật khẩu có đúng không
	public Boolean checkAccount(String tenDangNhap, String matKhau){
		if(this.tenDangNhap.equals(tenDangNhap)&&this.matKhau.equals(matKhau)){
			return true;
		}
		return false;
	}
	//hàm kiểm tra tài khoản có tồn tại không
	public Boolean checkAccount(String tenDangNhap){
		if(this.tenDangNhap.equals(tenDangNhap)){
			return true;
		}
		return false;
	}
	//reset lai pass
	public abstract void resetPass();
}
