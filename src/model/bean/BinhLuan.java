package model.bean;

import java.util.ArrayList;

public class BinhLuan {
	private int idBinhLuan;
	private int idUser;
	private ArrayList noiDungbinhLuan;
	public int getIdBinhLuan() {
		return idBinhLuan;
	}
	public void setIdBinhLuan(int idBinhLuan) {
		this.idBinhLuan = idBinhLuan;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public ArrayList getNoiDungbinhLuan() {
		return noiDungbinhLuan;
	}
	public void setNoiDungbinhLuan(ArrayList noiDungbinhLuan) {
		this.noiDungbinhLuan = noiDungbinhLuan;
	}
	public BinhLuan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BinhLuan(int idBinhLuan, int idUser, ArrayList noiDungbinhLuan) {
		super();
		this.idBinhLuan = idBinhLuan;
		this.idUser = idUser;
		this.noiDungbinhLuan = noiDungbinhLuan;
	}
}
