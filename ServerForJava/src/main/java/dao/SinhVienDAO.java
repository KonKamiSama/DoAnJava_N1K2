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

public class SinhVienDAO implements SinhVienInterface<SinhVien> {
	@Override
	public void Delete(String jsonData) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			JSONObject jsonSv = new JSONObject(jsonData);
			String idSV = jsonSv.getString("idSV");
			transaction = session.beginTransaction();
			SinhVien sv = session.get(SinhVien.class, idSV);
				session.delete(sv);
				transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	    Transaction transaction = null;
//	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	        transaction = session.beginTransaction();
//	        SinhVien sv = session.get(SinhVien.class, t.getIdSV());
//	            session.delete(sv);
//	            transaction.commit();
//	            System.out.println("SinhVien deleted successfully!");
//	    } catch (Exception e) {
//	        if (transaction != null) {
//	            transaction.rollback();
//	        }
//	        e.printStackTrace();
//	    }
//	}

	public void Save(String jsonData) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			JSONObject jsonSv = new JSONObject(jsonData);
			// tạo 1 sv để hứng dữ liệu
			SinhVien sv = new SinhVien();
			sv.setIdSV(jsonSv.getString("idSV"));
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
			transaction = session.beginTransaction();
			session.save(sv);
			transaction.commit();
			System.out.println("SinhVien added successfully!");
		} catch (Exception e) {
			System.out.println("Error saving SinhVien: " + e.getMessage());
			e.printStackTrace();
		}
	}

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

	public JSONArray selectAllAccounts() {
	    JSONArray jsonArray = new JSONArray();
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        List<Account> accountList = session.createQuery("from Account", Account.class).list();
	        for (Account account : accountList) {
	            JSONObject jsonAccount = new JSONObject();
	            jsonAccount.put("id", account.getId());
	            jsonAccount.put("username", account.getUsername());
	            jsonAccount.put("password", account.getPassword());
	            jsonAccount.put("email", account.getEmail());
	            jsonArray.put(jsonAccount);
	        }
	        return jsonArray;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
