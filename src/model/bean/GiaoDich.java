package model.bean;

public class GiaoDich {
	private int idGiaoDich;
	private int idDauGia;
	private int phiDichVu;
	private int thanhTien;
	private int hinhThucThanhToan;
	private int tinhTrangGD;
	private String tenNguoiNhan;
	private String diaChiNguoiNhan;
	private String sdtNguoiNhan;
	private String nguoiDang;
	private String nguoiMua;
	private String tenSanPham;
	private String thoiGianKetThuc;
	public int getIdGiaoDich() {
		return idGiaoDich;
	}
	public void setIdGiaoDich(int idGiaoDich) {
		this.idGiaoDich = idGiaoDich;
	}
	public int getIdDauGia() {
		return idDauGia;
	}
	public void setIdDauGia(int idDauGia) {
		this.idDauGia = idDauGia;
	}
	public int getPhiDichVu() {
		return phiDichVu;
	}
	public void setPhiDichVu(int phiDichVu) {
		this.phiDichVu = phiDichVu;
	}
	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	public int getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(int hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public int getTinhTrangGD() {
		return tinhTrangGD;
	}
	public void setTinhTrangGD(int tinhTrangGD) {
		this.tinhTrangGD = tinhTrangGD;
	}
	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}
	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}
	public String getDiaChiNguoiNhan() {
		return diaChiNguoiNhan;
	}
	public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
		this.diaChiNguoiNhan = diaChiNguoiNhan;
	}
	public String getSdtNguoiNhan() {
		return sdtNguoiNhan;
	}
	public void setSdtNguoiNhan(String sdtNguoiNhan) {
		this.sdtNguoiNhan = sdtNguoiNhan;
	}
	public String getNguoiDang() {
		return nguoiDang;
	}
	public void setNguoiDang(String nguoiDang) {
		this.nguoiDang = nguoiDang;
	}
	public String getNguoiMua() {
		return nguoiMua;
	}
	public void setNguoiMua(String nguoiMua) {
		this.nguoiMua = nguoiMua;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiaoDich(int idGiaoDich, int idDauGia, int phiDichVu, int thanhTien, int hinhThucThanhToan, int tinhTrangGD,
			String tenNguoiNhan, String diaChiNguoiNhan, String sdtNguoiNhan, String nguoiDang, String nguoiMua,
			String tenSanPham, String thoiGianKetThuc) {
		super();
		this.idGiaoDich = idGiaoDich;
		this.idDauGia = idDauGia;
		this.phiDichVu = phiDichVu;
		this.thanhTien = thanhTien;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.tinhTrangGD = tinhTrangGD;
		this.tenNguoiNhan = tenNguoiNhan;
		this.diaChiNguoiNhan = diaChiNguoiNhan;
		this.sdtNguoiNhan = sdtNguoiNhan;
		this.nguoiDang = nguoiDang;
		this.nguoiMua = nguoiMua;
		this.tenSanPham = tenSanPham;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	
}
