package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.SinhVien;
import util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                Transaction tr = null;
                try {
                    tr = session.beginTransaction();
                    SinhVien sv1 = new SinhVien();	
                    sv1.setIdSV("SVn1322");
                    sv1.setName("Teim");
                    sv1.setClas("23NS1");
                    sv1.setCodeLan("CL1233");
                    sv1.setDoB(java.sql.Date.valueOf("2000-02-12"));  // Ngày sinh
                    sv1.setNamepj("Project AA");
                    sv1.setPhone("13469");
                    sv1.setEmail("ttoom@exampleee.com");
                    sv1.setGender("Male");
                    sv1.setProcess("In Progress");
                    session.save(sv1);
                    tr.commit();
                } catch (Exception e) {
                    if (tr != null) {
                        tr.rollback();
                    }
                    e.printStackTrace();
                } finally {
                    session.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateSinhVien(String idSV, String newName, String newPhone, String newEmail) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = null;
            try {
                tr = session.beginTransaction();
                SinhVien sv = session.get(SinhVien.class, idSV);
                if (sv != null) {
                    sv.setName(newName);
                    sv.setPhone(newPhone);
                    sv.setEmail(newEmail);
                    session.update(sv);
                    tr.commit();
                } else {
                    System.out.println("SinhVien not found with ID: " + idSV);
                }
            } catch (Exception e) {
                if (tr != null) {
                    tr.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }
    public static void deleteSinhVien(String idSV) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = null;
            try {
                tr = session.beginTransaction();
                SinhVien sv = session.get(SinhVien.class, idSV);
                if (sv != null) {
                    session.delete(sv);
                    tr.commit();
                } else {
                    System.out.println("SinhVien not found with ID: " + idSV);
                }
            } catch (Exception e) {
                if (tr != null) {
                    tr.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }

}
