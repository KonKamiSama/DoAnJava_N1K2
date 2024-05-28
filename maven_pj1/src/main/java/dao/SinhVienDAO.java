package dao;

import model.*;
import util.*;
import view.Login3_0ManagementWindow;

import org.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.Date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.hibernate.Session;
import java.util.List;

import dao.SinhVienInterface;
import database.Connect;

public class SinhVienDAO implements SinhVienInterface <SinhVien> {
	@Override
	public void Save(SinhVien t) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(t);
	        transaction.commit();
	        System.out.println("SinhVien added successfully!");
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	}

	@Override
	public void Delete(SinhVien t) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        SinhVien sv = session.get(SinhVien.class, t.getIdSV());
	        if (sv != null) {
	            session.delete(sv);
	            transaction.commit();
	            System.out.println("SinhVien deleted successfully!");
	        } else {
	            System.out.println("SinhVien not found with ID: " + t.getIdSV());
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	}
	
	public void Save(String jsonData) {
			// TODO: handle exception
		}
//		// TODO Auto-generated method stub
//		try {
//			//b1
//			Connection con = Connect.getConnection();
//			//B2
//			Statement st = con.createStatement();
//			//B3
//			String sql = "SELECT * FROM sinhvien";
//			//B4
//			System.out.println("You have done somthing: " + sql);
//			//B5
//			Connect.closeConnection(con);
//			System.out.println(con);
//		} catch (SQLException e) {
//			e.getMessage();		
//			}
	
	@Override
	public void Edit(String jsonData) {
	    Transaction transaction = null;
	    Session session = null;
	    try {
	        // Parse JSON từ chuỗi nhận được
	        JSONObject jsonSv = new JSONObject(jsonData);
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();
	        // Lấy ID từ JSON và tìm kiếm SinhVien tương ứng
	        String idSV = jsonSv.getString("idSV");
	        SinhVien sv = session.get(SinhVien.class, idSV);
	            // Cập nhật thông tin từ JSON
	            sv.setName(jsonSv.getString("name"));
	            sv.setGender(jsonSv.getString("gender"));
	            try {
	                sv.setDoB(Date.valueOf(jsonSv.getString("doB")));
	            } catch (IllegalArgumentException e) {
	                System.out.println("Error: Invalid date format. Required format is yyyy-MM-dd.");
	                return;
	            }
	            sv.setClas(jsonSv.getString("clas"));
	            sv.setPhone(jsonSv.getString("phone"));
	            sv.setEmail(jsonSv.getString("email"));
	            sv.setNamepj(jsonSv.getString("namepj"));
	            sv.setCodeLan(jsonSv.getString("codeLan"));
	            sv.setProcess(jsonSv.getString("process"));
	            session.update(sv);
	            transaction.commit();
	            System.out.println("SinhVien updated successfully!");
	    	} catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        System.out.println("Error updating SinhVien: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

//	public void Edit(SinhVien t) {
//	    Transaction transaction = null;
//	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	        transaction = session.beginTransaction();
//	        SinhVien sv = session.get(SinhVien.class, t.getIdSV());
//	        if (sv != null) {
//	            sv.setName(t.getName());
//	            sv.setGender(t.getGender());
//	            sv.setDoB(t.getDoB());
//	            sv.setClas(t.getClas());
//	            sv.setPhone(t.getPhone());
//	            sv.setEmail(t.getEmail());
//	            sv.setNamepj(t.getNamepj());
//	            sv.setCodeLan(t.getCodeLan());
//	            sv.setProcess(t.getProcess());
//	            session.update(sv);
//	            transaction.commit();
//	            System.out.println("SinhVien updated successfully!");
//	        } else {
//	            System.out.println("SinhVien not found with ID: " + t.getIdSV());
//	        }
//	    } catch (Exception e) {
//	        if (transaction != null) {
//	            transaction.rollback();
//	        }
//	        e.printStackTrace();
//	    }
//	}

//	@Override
//	public ArrayList<SinhVien> SelectAll() {
//	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	        return new ArrayList<>(session.createQuery("from SinhVien", SinhVien.class).list());
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return null;
//	    }
//	}
	public JSONArray SelectAll() {
	    JSONArray jsonArray = new JSONArray();
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        // lay tt tu db
	        List<SinhVien> svList = session.createQuery("from SinhVien", SinhVien.class).list();
	        // 
	        for (SinhVien sv : svList) {
	            JSONObject jsonSv = new JSONObject();
	            jsonSv.put("idSV", sv.getIdSV());
	            jsonSv.put("name", sv.getName());
	            jsonSv.put("gender", sv.getGender());
	            jsonSv.put("doB", sv.getDoB().toString());
	            jsonSv.put("clas", sv.getClas());
	            jsonSv.put("phone", sv.getPhone());
	            jsonSv.put("email", sv.getEmail());
	            jsonSv.put("namepj", sv.getNamepj());
	            jsonSv.put("codeLan", sv.getCodeLan());
	            jsonSv.put("process", sv.getProcess());
	            jsonArray.put(jsonSv);
	        }
	        return jsonArray;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}