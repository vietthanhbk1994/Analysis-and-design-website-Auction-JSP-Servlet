package bean;

public class DauGia {
	private int idDauGia;
	private int idSanPham;
	private int idUser;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	private int giaHienTai;
	private int giaCuoi;
	private int tinhTrang;
	private Boolean ketQua;
	
	public int getIdDauGia() {
		return idDauGia;
	}
	public void setIdDauGia(int idDauGia) {
		this.idDauGia = idDauGia;
	}
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public int getGiaHienTai() {
		return giaHienTai;
	}
	public void setGiaHienTai(int giaHienTai) {
		this.giaHienTai = giaHienTai;
	}
	public int getGiaCuoi() {
		return giaCuoi;
	}
	public void setGiaCuoi(int giaCuoi) {
		this.giaCuoi = giaCuoi;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public Boolean getKetQua() {
		return ketQua;
	}
	public void setKetQua(Boolean ketQua) {
		this.ketQua = ketQua;
	}
	public DauGia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DauGia(int idDauGia, int idSanPham, int idUser, String thoiGianBatDau, String thoiGianKetThuc,
			int giaHienTai, int giaCuoi, int tinhTrang, Boolean ketQua) {
		super();
		this.idDauGia = idDauGia;
		this.idSanPham = idSanPham;
		this.idUser = idUser;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.giaHienTai = giaHienTai;
		this.giaCuoi = giaCuoi;
		this.tinhTrang = tinhTrang;
		this.ketQua = ketQua;
	}
	
}
