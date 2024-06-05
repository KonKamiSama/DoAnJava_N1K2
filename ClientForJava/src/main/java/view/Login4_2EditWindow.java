package view;

import java.awt.Font;
import java.text.SimpleDateFormat;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import org.json.JSONObject;

import client.Client;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import controller.Login4_1ControllerAdd;
import controller.Login4_2ControllerEdit;

import java.text.DateFormat;
import java.text.ParseException;

import model.SinhVien;

public class Login4_2EditWindow extends JFrame {
	//
	private JLabel welcome;	private JLabel welcome2;
	private JLabel idSV; 	private JTextField idSVB;
	private JLabel name;	private JTextField nameB;
	private JLabel doB;		private JTextField doBB;
	private JLabel gender;	private JRadioButton male; private JRadioButton female;
	private JLabel email;	private JTextField emailB;
	private JLabel clas;	private JTextField clasB;
	private JLabel phone;	private JTextField phoneB;
	private JLabel namepj;	private JTextField namepjB;
	private JLabel process;	private JTextField processB;
	private JLabel codeLan;	private JTextField codeLanB;
	private JButton update;	private ButtonGroup group;
	public SinhVien sv = new SinhVien();
	private Login3_0ManagementWindow login3;
	private ActionListener al;
	private Client client = new Client();
	
	public Login4_2EditWindow() {
		init();
		this.setVisible(true);
	}
	public void init() {
		//generate
		this.setSize(900, 580);
		this.setLocationRelativeTo(null);
		this.setTitle("Edit");
		al = new Login4_2ControllerEdit(this, login3);
		
		//generate
		update = new JButton("Update");
		welcome = new JLabel("Update Information"); welcome2 = new JLabel("Project  ");
		idSV = new JLabel("Studen ID");			idSVB = new JTextField();
		name = new JLabel("Full Name");			nameB = new JTextField();
		doB = new JLabel("Date Of Birth");		doBB = new JTextField();	
		email = new JLabel("Email");			emailB = new JTextField();
		clas = new JLabel("Class");				clasB = new JTextField();
		phone = new JLabel("Phone Number");		phoneB = new JTextField();
		namepj = new JLabel("Project Name");	namepjB = new JTextField();
		codeLan = new JLabel("Code Language");	codeLanB = new JTextField();
		process = new JLabel("Process");		processB = new JTextField();
		
		gender = new JLabel("Gender");			
		male = new JRadioButton("Male");
		male.setActionCommand("Male");
		female = new JRadioButton("Female");
		female.setActionCommand("Female");
		group = new ButtonGroup();
		group.add(male); group.add(female);
		
		//label                                 
		this.setLayout(null);
		update.setBounds(620, 450, 160, 50);	update.setFont(new Font ("Consolas", Font.BOLD, 18));;
		welcome.setBounds(320, 5, 300, 50); 	welcome.setFont(new Font ("Consolas", Font.BOLD, 27));
		welcome2.setBounds(390, 290, 300, 50); 	welcome2.setFont(new Font ("Consolas", Font.BOLD, 27));
		name.setBounds(50, 70, 200, 50);		idSV.setFont(new Font ("Consolas", Font.BOLD, 18));
		doB.setBounds(50, 120, 200, 50);		name.setFont(new Font ("Consolas", Font.BOLD, 18));
		gender.setBounds(450, 70, 200, 50);		gender.setFont(new Font ("Consolas", Font.BOLD, 18));
		idSV.setBounds(50, 170, 200, 50);		doB.setFont(new Font ("Consolas", Font.BOLD, 18));
		male.setBounds(600, 83, 80, 20); 		female.setBounds(700, 83, 80, 20);
		clas.setBounds(450, 170, 200, 50);		clas.setFont(new Font ("Consolas", Font.BOLD, 18));
		email.setBounds(50, 220, 200, 50);		phone.setFont(new Font ("Consolas", Font.BOLD, 18));
		phone.setBounds(450, 220, 200, 50);		email.setFont(new Font ("Consolas", Font.BOLD, 18));	
		namepj.setBounds(50, 370, 200, 50);		namepj.setFont(new Font ("Consolas", Font.BOLD, 18));
		codeLan.setBounds(450, 370, 200, 50);	codeLan.setFont(new Font ("Consolas", Font.BOLD, 18));
		process.setBounds(50, 420, 200, 50);	process.setFont(new Font ("Consolas", Font.BOLD, 18));
		
		//textfield
		nameB.setBounds(200, 73, 200, 40);		phoneB.setBounds(600, 223, 200, 40);
		doBB.setBounds(200, 123, 200, 40);		namepjB.setBounds(200, 373, 200, 40);
		idSVB.setBounds(200, 173, 200, 40);		codeLanB.setBounds(600, 373, 200, 40);
		clasB.setBounds(600, 173, 200, 40);		processB.setBounds(200, 423, 200, 40);
		emailB.setBounds(200, 223, 200, 40); 	
		
		//add
		this.add(welcome); 	this.add(welcome2);	this.add(update);	this.update.addActionListener(al);
		this.add(idSV); 	this.add(name); 	this.add(doB); 		this.add(email);
		this.add(gender); 	this.add(clas); 	this.add(phone);	this.add(codeLan);
		this.add(namepj); 	this.add(process);
		
		this.add(idSVB); 	this.add(nameB); 	this.add(doBB);
		this.add(emailB); 	this.add(phoneB); 	this.add(processB);
		this.add(codeLanB); this.add(clasB); 	this.add(namepjB);
		this.add(female); 	this.add(male);
		
	}
//	public SinhVien I4Update() throws ParseException {
//	    try {
//	        String idSV = idSVB.getText();
//	        String name = nameB.getText();
//	        String date1 = doBB.getText();
//	        java.sql.Date doB;
//	        try {
//	            doB = java.sql.Date.valueOf(date1);
//	        } catch (IllegalArgumentException e) {
//	            JOptionPane.showMessageDialog(this, "Wrong Date Format: '" + date1 + "' Correct Form: yyyy-MM-dd");
//	            return null;
//	        }
//
//	        ButtonModel genderModel = group.getSelection();
//	        if (genderModel == null) {
//	            JOptionPane.showMessageDialog(this, "Choose Your Gender !");
//	            return null;
//	        }
//	        String gender = genderModel.getActionCommand();
//	        String email = emailB.getText();
//	        String clas = clasB.getText();
//	        String phone = phoneB.getText();
//	        String namepj = namepjB.getText();
//	        String codeLan = codeLanB.getText();
//	        String process = processB.getText();
//	        sv = new SinhVien(idSV, name, doB, gender, email, clas, phone, namepj, codeLan, process);
//	        svd.Edit(sv);
//	        return sv;
//	    } catch (Exception e) {
//	        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//	    }
//	    return null;
//	}
	public SinhVien I4Update() throws ParseException {
	    try {
	        String idSV = idSVB.getText();
	        String name = nameB.getText();
	        String date1 = doBB.getText();
	        java.sql.Date doB;
	        try {
	            doB = java.sql.Date.valueOf(date1);
	        } catch (IllegalArgumentException e) {
	            JOptionPane.showMessageDialog(this, "Wrong Date Format: '" + date1 + "' Correct Form: yyyy-MM-dd");
	            return null;
	        }
	        ButtonModel genderModel = group.getSelection();
	        if (genderModel == null) {
	            JOptionPane.showMessageDialog(this, "Choose Your Gender !");
	            return null;
	        }
	        String gender = genderModel.getActionCommand();
	        String email = emailB.getText();
	        String clas = clasB.getText();
	        String phone = phoneB.getText();
	        String namepj = namepjB.getText();
	        String codeLan = codeLanB.getText();
	        String process = processB.getText();
	        // tao 1 json de hung tt
	        JSONObject jsonSv = new JSONObject();
	        jsonSv.put("action", "Edit");
	        jsonSv.put("idSV", idSV);
	        jsonSv.put("name", name);
	        jsonSv.put("doB", doB.toString());
	        jsonSv.put("gender", gender);
	        jsonSv.put("email", email);
	        jsonSv.put("clas", clas);
	        jsonSv.put("phone", phone);
	        jsonSv.put("namepj", namepj);
	        jsonSv.put("codeLan", codeLan);
	        jsonSv.put("process", process);
	        // ep json nay thanh 1 kieu string
	        client.sentData(jsonSv);
//	        svd.Edit(jsonSv.toString());
	        
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
	    }
	    return null;
	}

	 public void setEditData(Object[] rowData) {
	        if (rowData == null || rowData.length < 10) {
	            JOptionPane.showMessageDialog(this, "Invalid Data");
	            return;
	        }
	        idSVB.setText((String) rowData[0]);
	        nameB.setText((String) rowData[1]);
	        if (rowData[3] != null && rowData[3] instanceof Date) {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            doBB.setText(dateFormat.format((Date) rowData[3]));
	        } else {
	            doBB.setText("");
	        }
	        String gender = (String) rowData[2];
	        if ("Male".equalsIgnoreCase(gender)) {
	            male.setSelected(true);
	        } else if ("Female".equalsIgnoreCase(gender)) {
	            female.setSelected(true);
	        } else {
	            group.clearSelection();
	        }

	        emailB.setText((String) rowData[4]);
	        clasB.setText((String) rowData[5]);
	        phoneB.setText((String) rowData[6]);
	        namepjB.setText((String) rowData[7]);
	        codeLanB.setText((String) rowData[8]);
	        processB.setText((String) rowData[9]);
	    }
}
