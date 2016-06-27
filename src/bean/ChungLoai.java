package bean;

public class ChungLoai {
	private int idChungLoai;
	private String tenChungLoai;
	
	public int getIdChungLoai() {
		return idChungLoai;
	}
	public void setIdChungLoai(int idChungLoai) {
		this.idChungLoai = idChungLoai;
	}
	public String getTenChungLoai() {
		return tenChungLoai;
	}
	public void setTenChungLoai(String tenChungLoai) {
		this.tenChungLoai = tenChungLoai;
	}
	public ChungLoai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChungLoai(int idChungLoai, String tenChungLoai) {
		super();
		this.idChungLoai = idChungLoai;
		this.tenChungLoai = tenChungLoai;
	}
	
}
