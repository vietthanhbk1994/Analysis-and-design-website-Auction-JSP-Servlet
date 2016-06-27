package bean;

public class SanPham {
	private int idSanPham;
	private int idChungLoai;
	private int idUser;
	private int duyet;
	private String chiTietSP;
	private int idBinhLuan;
	private String tenSanPham;
	private String hinhAnh;
	private String thoiGianDKSP;
	private String chungLoai;
	private String nguoiDang;
	private int trangThaiDauGia;
	private int buocGia;
	private int giaBanDau;
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}
	public int getIdChungLoai() {
		return idChungLoai;
	}
	public void setIdChungLoai(int idChungLoai) {
		this.idChungLoai = idChungLoai;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getDuyet() {
		return duyet;
	}
	public void setDuyet(int duyet) {
		this.duyet = duyet;
	}
	public String getChiTietSP() {
		return chiTietSP;
	}
	public void setChiTietSP(String chiTietSP) {
		this.chiTietSP = chiTietSP;
	}
	public int getIdBinhLuan() {
		return idBinhLuan;
	}
	public void setIdBinhLuan(int idBinhLuan) {
		this.idBinhLuan = idBinhLuan;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getThoiGianDKSP() {
		return thoiGianDKSP;
	}
	public void setThoiGianDKSP(String thoiGianDKSP) {
		this.thoiGianDKSP = thoiGianDKSP;
	}
	public String getChungLoai() {
		return chungLoai;
	}
	public void setChungLoai(String chungLoai) {
		this.chungLoai = chungLoai;
	}
	public String getNguoiDang() {
		return nguoiDang;
	}
	public void setNguoiDang(String nguoiDang) {
		this.nguoiDang = nguoiDang;
	}
	public int getTrangThaiDauGia() {
		return trangThaiDauGia;
	}
	public void setTrangThaiDauGia(int trangThaiDauGia) {
		this.trangThaiDauGia = trangThaiDauGia;
	}
	public int getBuocGia() {
		return buocGia;
	}
	public void setBuocGia(int buocGia) {
		this.buocGia = buocGia;
	}
	public int getGiaBanDau() {
		return giaBanDau;
	}
	public void setGiaBanDau(int giaBanDau) {
		this.giaBanDau = giaBanDau;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(int idSanPham, int idChungLoai, int idUser, int duyet, String chiTietSP, int idBinhLuan,
			String tenSanPham, String hinhAnh, String thoiGianDKSP, String chungLoai, String nguoiDang,
			int trangThaiDauGia, int buocGia, int giaBanDau) {
		super();
		this.idSanPham = idSanPham;
		this.idChungLoai = idChungLoai;
		this.idUser = idUser;
		this.duyet = duyet;
		this.chiTietSP = chiTietSP;
		this.idBinhLuan = idBinhLuan;
		this.tenSanPham = tenSanPham;
		this.hinhAnh = hinhAnh;
		this.thoiGianDKSP = thoiGianDKSP;
		this.chungLoai = chungLoai;
		this.nguoiDang = nguoiDang;
		this.trangThaiDauGia = trangThaiDauGia;
		this.buocGia = buocGia;
		this.giaBanDau = giaBanDau;
	}
	
}
