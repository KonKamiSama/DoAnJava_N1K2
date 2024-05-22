package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Login3_1Controller;
import controller.Login3_2Controller;

public class Login3_1Sort extends JFrame {
	
	private JButton so; 
	private JButton codeL; 
	private JButton progress;
	private ActionListener al;
	
	public Login3_1Sort() {
		init();
		this.setVisible(true);
	}
	public void init() {
		//generate
		this.setSize(650, 250);
		this.setLocationRelativeTo(null);
		this.setTitle("Sort By Type");
		al = new Login3_2Controller(this);
		
		codeL = new JButton("Code Language");
		codeL.addActionListener(al);
		progress = new JButton("Progress");
		progress.addActionListener(al);
		so = new JButton("STT");
		so.addActionListener(al);
		
		this.setLayout(null);
		codeL.setBounds(45, 90, 130, 50);
		so.setBounds(250, 90, 130, 50);
		progress.setBounds(450, 90, 130, 50);
		
		this.add(codeL);
		this.add(progress);
		this.add(so);
	} 
}