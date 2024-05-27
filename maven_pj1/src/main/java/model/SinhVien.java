package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JLabel;

@Entity
public class SinhVien {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idSV;
	
	private String name;
	private Date doB;
	private String gender;
	private String clas;
	private String phone;
	private String email;
	private String namepj;
	private String codeLan;
	private String process;
	
	
	public SinhVien() {
	}
	
	public SinhVien(String idSV, String name, Date doB, String gender, String clas, String phone, String email,
			String namepj, String codeLan, String process) {
		super();
		this.idSV = idSV;
		this.name = name;
		this.doB = doB;
		this.gender = gender;
		this.clas = clas;
		this.phone = phone;
		this.email = email;
		this.namepj = namepj;
		this.codeLan = codeLan;
		this.process = process;
	}
	@Override
	public String toString() {
		return "SinhVien [idSV=" + idSV + ", name=" + name + ", doB=" + doB + ", gender=" + gender + ", clas=" + clas
				+ ", phone=" + phone + ", email=" + email + ", namepj=" + namepj + ", codeLan=" + codeLan + ", process="
				+ process + "]";
	}
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getIdSV() {
		return idSV;
	}
	public void setIdSV(String idSV) {
		this.idSV = idSV;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDoB() {
		return doB;
	}
	public void setDoB(Date doB) {
		this.doB = doB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNamepj() {
		return namepj;
	}
	public void setNamepj(String namepj) {
		this.namepj = namepj;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getCodeLan() {
		return codeLan;
	}
	public void setCodeLan(String codeLan) {
		this.codeLan = codeLan;
	}
}
