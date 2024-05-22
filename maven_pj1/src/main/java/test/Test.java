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
                    sv1.setIdSV("SVn");
                    sv1.setName("Tom");
                    sv1.setClas("23NS1");
                    sv1.setCodeLan("CL123");
                    sv1.setDoB(java.sql.Date.valueOf("2000-01-01"));  // Ngày sinh
                    sv1.setNamepj("Project A");
                    sv1.setPhone("123456789");
                    sv1.setEmail("tom@example.com");
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
}
