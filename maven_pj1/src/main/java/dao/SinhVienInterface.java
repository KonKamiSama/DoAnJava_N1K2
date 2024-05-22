package dao;

import java.util.ArrayList;

import model.SinhVien;

public interface SinhVienInterface <T>{
	public ArrayList<SinhVien> sv = new ArrayList <>();
	
	public void Add (SinhVien t);
	
	public void Delete (SinhVien t);
	
	public void Save (SinhVien t);
	
	public void Edit (SinhVien t);
	
	public ArrayList<SinhVien> SelectAll ();
	
	public void Sort (SinhVien t);
	
	public void Find (SinhVien t);
}
