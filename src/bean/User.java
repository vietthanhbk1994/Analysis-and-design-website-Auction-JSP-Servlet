package bean;

public class User extends TaiKhoan {
	private int idUser;
	private int idTuVan;
	private String hoVaTen;
	private String email;
	private String sdt;
	private String cmnd;
	private String diaChi;
	private String ngaySinh;
	private int diemCongHien;
	private Boolean khoa;
	private String lanDangNhapCuoi;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdTuVan() {
		return idTuVan;
	}

	public void setIdTuVan(int idTuVan) {
		this.idTuVan = idTuVan;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getDiemCongHien() {
		return diemCongHien;
	}

	public void setDiemCongHien(int diemCongHien) {
		this.diemCongHien = diemCongHien;
	}

	public Boolean getKhoa() {
		return khoa;
	}

	public void setKhoa(Boolean khoa) {
		this.khoa = khoa;
	}

	public String getLanDangNhapCuoi() {
		return lanDangNhapCuoi;
	}

	public void setLanDangNhapCuoi(String lanDangNhapCuoi) {
		this.lanDangNhapCuoi = lanDangNhapCuoi;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int idUser, int idTaiKhoan, String tenDangNhap, String matKhau, int quyen, int idTuVan,
			String hoVaTen, String email, String sdt, String cmnd, String diaChi, String ngaySinh, int diemCongHien,
			Boolean khoa, String lanDangNhapCuoi) {
		super(idTaiKhoan, tenDangNhap, matKhau, quyen);
		this.idUser = idUser;
		this.idTuVan = idTuVan;
		this.hoVaTen = hoVaTen;
		this.email = email;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.diemCongHien = diemCongHien;
		this.khoa = khoa;
		this.lanDangNhapCuoi = lanDangNhapCuoi;
	}

	// reset mat khau = ngay sinh
	@Override
	public void resetPass() {
		setMatKhau(ngaySinh);
	}
	//.....
}
