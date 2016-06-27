package bean;

import java.util.ArrayList;

public class TuVan {
	private int idTuVan;
	private ArrayList noiDungTuVanUser;
	private ArrayList noiDungTuVanAdmin;
	public int getIdTuVan() {
		return idTuVan;
	}
	public void setIdTuVan(int idTuVan) {
		this.idTuVan = idTuVan;
	}
	public ArrayList getNoiDungTuVanUser() {
		return noiDungTuVanUser;
	}
	public void setNoiDungTuVanUser(ArrayList noiDungTuVanUser) {
		this.noiDungTuVanUser = noiDungTuVanUser;
	}
	public ArrayList getNoiDungTuVanAdmin() {
		return noiDungTuVanAdmin;
	}
	public void setNoiDungTuVanAdmin(ArrayList noiDungTuVanAdmin) {
		this.noiDungTuVanAdmin = noiDungTuVanAdmin;
	}
	public TuVan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TuVan(int idTuVan, ArrayList noiDungTuVanUser, ArrayList noiDungTuVanAdmin) {
		super();
		this.idTuVan = idTuVan;
		this.noiDungTuVanUser = noiDungTuVanUser;
		this.noiDungTuVanAdmin = noiDungTuVanAdmin;
	}
}
