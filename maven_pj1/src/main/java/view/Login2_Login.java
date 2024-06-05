package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONObject;

import client.Client;
import controller.Login2Controller;

public class Login2_Login extends JFrame{
	private JLabel user;
	private JLabel password;
	private JTextField enterUser;
	private JPasswordField enterPassword;
	private JButton login;
	private ActionListener al;
	private Client client = new Client();
	
	public Login2_Login() {
		init();
		this.setVisible(true);
	}
	public void init() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setTitle("Login");
		
		al = new Login2Controller(this);
		user = new JLabel("User");
		password = new JLabel("Password");
		enterPassword = new JPasswordField();
		enterUser = new JTextField();
		login = new JButton("Login");
		login.addActionListener(al);
		
		this.setLayout(null);
		this.add(enterPassword); this.add(enterUser); this.add(password); this.add(user); this.add(password); this.add(login);
		user.setBounds(65, 10, 100, 50);
		user.setFont(new Font("Consolas", Font.PLAIN, 16));
		password.setBounds(54, 90, 80, 50);
		password.setFont(new Font("Consolas", Font.PLAIN, 16));
		enterUser.setBounds(180, 10, 200, 50);
		enterPassword.setBounds(180, 90, 200, 50);
		login.setBounds(150, 170, 100, 50);
		
	}
//	public boolean checkLogin() {
//		  Connection con = null;
//		  PreparedStatement ps = null;
//		  ResultSet rs = null;
//		try {
//			con = Connect.getConnection();
//			String sql = "SELECT * FROM account WHERE user =? AND password =?";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, enterUser.getText());
//			ps.setString(2, new String(enterPassword.getPassword()));
//			rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				String User = rs.getString("user");
//				String Pass = rs.getString("password");
//				if (enterUser.getText().equals(User) && new String (enterPassword.getPassword()).equals(Pass)) {
//					JOptionPane.showMessageDialog(this, "Login Successfully !");
//					System.out.println("You have done somthing: " + sql);
//					return true;
//				} 
//			}
//			return false;
//		} catch (SQLException e) {
//		        e.printStackTrace();
//			return false;
//		}  finally {
//	        try {
//	            if (rs != null) rs.close();
//	            if (ps != null) ps.close();
//	            if (con != null) con.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//			}
//		}
//	}

	public boolean checkLogin() {
		JSONObject user = new JSONObject();
		user.put("action", "Check");
		client.sentData(user);
	    JSONArray users = client.getData();
	    String usernameInput = enterUser.getText();
	    String passwordInput = new String(enterPassword.getPassword());

	    for (int i = 0; i < users.length(); i++) {
	        JSONObject userCheck = users.getJSONObject(i);
	        String username = userCheck.getString("username");
	        String password = userCheck.getString("password");
	        if (usernameInput.equals(username) && passwordInput.equals(password)) {
	            JOptionPane.showMessageDialog(this, "Login Successfully!");
	            return true;
	        }
	    }
	    JOptionPane.showMessageDialog(this, "Login Failed.");
	    return false;
	}
}