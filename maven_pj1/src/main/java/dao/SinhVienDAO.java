package dao;

import model.*;
import view.Login3_ManagementWindow;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.SinhVienInterface;
import database.Connect;

public class SinhVienDAO implements SinhVienInterface <SinhVien> {

	@Override
	public void Add (SinhVien t) {
		try {
			//b1
			Connection con = Connect.getConnection();
			//B2
			String sql = "INSERT INTO sinhvien VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, t.getIdSV());
	        st.setString(2, t.getName());
	        st.setString(3, t.getGender());
	        st.setDate(4, t.getDoB());
	        st.setString(5, t.getClas());
	        st.setString(6, t.getPhone());
	        st.setString(7, t.getEmail());
	        st.setString(8, t.getNamepj());
	        st.setString(9, t.getCodeLan());
	        st.setString(10, t.getProcess());
	        System.out.println(sql);
	        st.executeUpdate();
			//B4
			System.out.println("You have done somthing: " + st);
			//B5
			Connect.closeConnection(con);
			System.out.println(con);
		} catch (SQLException e) {
			System.out.println(e.toString());
			e.getMessage();		
		}
	}

	@Override
	public void Delete(SinhVien t) {
		// TODO Auto-generated method stub
		try {
			//b1
			Connection con = Connect.getConnection();
			//B2
			String sql = "DELETE FROM sinhvien WHERE StudentID = ?";
			//B3
			PreparedStatement ps = con. prepareStatement(sql);
			ps.setString(1, t.getIdSV());
			ps.executeUpdate();
			//B4
			System.out.println("You have done somthing: " + sql);
			//B5
			Connect.closeConnection(con);
			System.out.println(con);
		} catch (SQLException e) {
			e.getMessage();		
			}
	}

	@Override
	public void Save(SinhVien t) {
		// TODO Auto-generated method stub
		try {
			//b1
			Connection con = Connect.getConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM sinhvien";
			//B4
			System.out.println("You have done somthing: " + sql);
			//B5
			Connect.closeConnection(con);
			System.out.println(con);
		} catch (SQLException e) {
			e.getMessage();		
			}
	}

	@Override
	public void Edit(SinhVien t) {
		try {
		    Connection con = Connect.getConnection();
		    String sql = "UPDATE sinhvien SET FullName = ?, Gender = ?, DateofBirth = ?, Class = ?, PhoneNumber = ?, Email = ?, ProjectName = ?, CodeLanguage = ?, Process = ? WHERE StudentID = ?";
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setString(1, t.getName());
		    st.setString(2, t.getGender());
		    st.setDate(3, t.getDoB());
		    st.setString(4, t.getClas());
		    st.setString(5, t.getPhone());
		    st.setString(6, t.getEmail());
		    st.setString(7, t.getNamepj());
		    st.setString(8, t.getCodeLan());
		    st.setString(9, t.getProcess());
		    st.setString(10, t.getIdSV());
		    st.executeUpdate();

		    System.out.println("Update successful: " + st);
		} catch (SQLException e) {
		    System.out.println("Error in updating record: " + e.getMessage());
		    e.printStackTrace();
		}
	}
	@Override
	public ArrayList<SinhVien> SelectAll() {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> svList = new ArrayList<SinhVien>();
			try {
				Connection con = Connect.getConnection();
				PreparedStatement st = con.prepareStatement("SELECT * FROM sinhvien");
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
//					Object oList [] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)};
					String idSV = rs.getString(1);
					String name = rs.getString(2);
					String gender = rs.getString(3);
					Date doB = rs.getDate(4);
					String email = rs.getString(5);
					String clas = rs.getString(6);
					String phone = rs.getString(7);
					String namepj = rs.getString(8);
					String codeLan = rs.getString(9);
					String process = rs.getString(10);
					SinhVien sv = new SinhVien(idSV, name, doB,  gender, email, clas, phone, namepj, codeLan, process);
					svList.add(sv);
				}
				return svList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return svList;
	}

	@Override
	public void Sort(SinhVien t) {
		// TODO Auto-generated method stub
		try {
			Connection con = Connect.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT FROM sinhvien WHERE");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void Find(SinhVien t) {
		// TODO Auto-generated method stub
		
	}
}
