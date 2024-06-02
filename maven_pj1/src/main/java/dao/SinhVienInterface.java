package dao;

import java.util.ArrayList;

import org.json.JSONArray;

import model.SinhVien;

public interface SinhVienInterface <T>{
	
//	public void Save (SinhVien t);
	
	public void Save (String jsonData);
	
//	public void Delete (SinhVien t);
	
	public void Delete (String jsonData);
	
//	public ArrayList<SinhVien> SelectAll ();
	
	public JSONArray SelectAll();

	public void Edit(String jsonData);
	
//	public void Edit (SinhVien t);
}
