package view;

import java.awt.event.ActionListener;

import javax.swing.*;

import client.Client;
import controller.Login1Controller;
import server.Server;

public class Login1_RevealWindow extends JFrame {
	private JButton GV;
	private JButton HS;
	private JLabel title;
	private ActionListener al;

	public Login1_RevealWindow () {
		init();
		this.setVisible(true);
	}
	public void init() {
		
		this.setLayout(null);
		this.setTitle("Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350, 200);
		this.setLocationRelativeTo(null);

		al = new Login1Controller(this);
		GV = new JButton("Giáo Viên");
		GV.addActionListener(al);
		HS = new JButton("Sinh Viên");
		HS.addActionListener(al);
		title = new JLabel("Who Are You ?");
		
		title.setBounds(120, 10, 100, 50);
		GV.setBounds(40, 70, 100, 40);
		HS.setBounds(200, 70, 100, 40);
		this.add(GV); this.add(HS); this.add(title);
		
	}
}
