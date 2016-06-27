package model.bean;

public class XepHang {
	private int idXepHang;
	private String tenXepHang;
	private int mucDuoi;
	private int mucTren;
	public int getIdXepHang() {
		return idXepHang;
	}
	public void setIdXepHang(int idXepHang) {
		this.idXepHang = idXepHang;
	}
	public String getTenXepHang() {
		return tenXepHang;
	}
	public void setTenXepHang(String tenXepHang) {
		this.tenXepHang = tenXepHang;
	}
	public int getMucDuoi() {
		return mucDuoi;
	}
	public void setMucDuoi(int mucDuoi) {
		this.mucDuoi = mucDuoi;
	}
	public int getMucTren() {
		return mucTren;
	}
	public void setMucTren(int mucTren) {
		this.mucTren = mucTren;
	}
	public XepHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XepHang(int idXepHang, String tenXepHang, int mucDuoi, int mucTren) {
		super();
		this.idXepHang = idXepHang;
		this.tenXepHang = tenXepHang;
		this.mucDuoi = mucDuoi;
		this.mucTren = mucTren;
	}
	
}
