package view;

import java.awt.Font;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.json.JSONObject;

import client.Client;
import controller.Login4_1ControllerAdd;

import java.text.ParseException;

import model.SinhVien;

public class Login4_1AddWindow extends JFrame {
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
	private JButton save;	private ButtonGroup group;
	public SinhVien sv = new SinhVien();
	private ActionListener al;
	private Client client;

	public Login4_1AddWindow() {}
	public Login4_1AddWindow(Client client4) {
		this.client = client4;
		init();
		this.setVisible(true);
	}
	public void init() {
		//generate
		this.setSize(900, 580);
		this.setLocationRelativeTo(null);
		this.setTitle("Add");
		al = new Login4_1ControllerAdd(this);
		
		//generate
		save = new JButton("Save");
		welcome = new JLabel("Adding Information"); welcome2 = new JLabel("Project  ");
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
		save.setBounds(620, 450, 160, 50);		save.setFont(new Font ("Consolas", Font.BOLD, 18));;
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
		this.add(welcome); 	this.add(welcome2);	this.add(save);		save.addActionListener(al);
		this.add(idSV); 	this.add(name); 	this.add(doB); 		this.add(email);
		this.add(gender); 	this.add(clas); 	this.add(phone);	this.add(codeLan);
		this.add(namepj); 	this.add(process);
		
		this.add(idSVB); 	this.add(nameB); 	this.add(doBB);
		this.add(emailB); 	this.add(phoneB); 	this.add(processB);
		this.add(codeLanB); this.add(clasB); 	this.add(namepjB);
		this.add(female); 	this.add(male);
		
	}
		public SinhVien I4() throws ParseException {
			 try {
			        String idSV = idSVB.getText();
			        String name = nameB.getText();
			        String date1 = doBB.getText();
			        java.sql.Date doB;
			        try {
			            doB = java.sql.Date.valueOf(date1);
			        } catch (IllegalArgumentException e) {
			            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ: '" + date1 + "'. Định dạng đúng: yyyy-MM-dd");
			            return null;
			        }

			        ButtonModel genderModel = group.getSelection();
			        if (genderModel == null) {
			            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính.");
			            return null;
			        }
			        String gender = genderModel.getActionCommand();
			        String clas = clasB.getText();
			        String phone = phoneB.getText();
			        String email = emailB.getText();
			        String namepj = namepjB.getText();
			        String codeLan = codeLanB.getText();
			        String process = processB.getText();
			        // tao 1 json de hung tt
			        JSONObject jsonSv = new JSONObject();
			        jsonSv.put("action", "Save");
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
//			        svd.Save(jsonSv.toString());
			        client.sendData(jsonSv);
			    } catch (Exception e) {
			        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage());
			    }
			    return null;
		}
}
