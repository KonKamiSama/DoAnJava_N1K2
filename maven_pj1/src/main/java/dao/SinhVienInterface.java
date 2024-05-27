package dao;

import java.util.ArrayList;

import org.json.JSONArray;

import model.SinhVien;

public interface SinhVienInterface <T>{
	public ArrayList<SinhVien> sv = new ArrayList <>();
	
	public void Add (SinhVien t);
	
	public void Delete (SinhVien t);
	
	public void Save (SinhVien t);
	
//	public void Edit (SinhVien t);
	
//	public ArrayList<SinhVien> SelectAll ();
	
	public JSONArray SelectAll();

	void Edit(String jsonData);
}
