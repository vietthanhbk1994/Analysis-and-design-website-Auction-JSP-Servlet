package bean;

public class Khoa {
	private int idKhoa;
	private int idUser;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	private String lyDo;
	public Khoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdKhoa() {
		return idKhoa;
	}

	public void setIdKhoa(int idKhoa) {
		this.idKhoa = idKhoa;
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

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Khoa(int idKhoa, int idUser, String thoiGianBatDau, String thoiGianKetThuc, String lyDo) {
		super();
		this.idKhoa = idKhoa;
		this.idUser = idUser;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.lyDo = lyDo;
	}
	
}
