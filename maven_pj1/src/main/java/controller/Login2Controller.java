package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Login2_Login;
import view.Login3_0ManagementWindow;

public class Login2Controller implements ActionListener {
    private Login2_Login login2;
    private Login3_0ManagementWindow login3;

    public Login2Controller(Login2_Login login2) {
        this.login2 = login2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Login".equals(e.getActionCommand())) {
            	boolean log = login2.checkLogin();
            	if (log == true) {
            		 if (login3 == null) {
                         login3 = new Login3_0ManagementWindow();
                     }
                     login3.setVisible(true);
                     login2.setVisible(false);
            	} else {
            		login2.dispose();
            		JOptionPane.showMessageDialog(null, "Login Failed !", "Login", JOptionPane.PLAIN_MESSAGE);
            		new Login2_Login();
            	}
        	}
        }
    }
