package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import view.Login3_2CodeLanSort;
import view.Login3_0ManagementWindow;
import view.Login3_1Sort;

public class Login3_2Controller implements ActionListener{
	private Login3_1Sort login4;
	private Login3_0ManagementWindow login3;
	
	public Login3_2Controller(Login3_1Sort login4Sort, Login3_0ManagementWindow login3_arg) {
		this.login4 = login4Sort;
		this.login3 = login3_arg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		login3 = new Login3_0ManagementWindow();
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
			if ("Progress".equals(command)) {
				login4.dispose();
				login3.sortByProcess();
			} else if ("Code Language".equals(command)) {
				login4.dispose();
				Set<String> languages = login3.getAllLanguages();
		        new Login3_2CodeLanSort(languages, login3);
			} else if ("STT".equals(command)) {
				login4.dispose();
				login3.sortByStudenID();
			} 
		}
	}
	
