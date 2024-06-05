package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
import model.SinhVien;
import view.Login4_1AddWindow;
import view.Login4_2EditWindow;
import view.Login3_0ManagementWindow;

public class Login4_2ControllerEdit implements ActionListener {
    private Login4_2EditWindow login4;
    private Login3_0ManagementWindow login3;

    public Login4_2ControllerEdit(Login4_2EditWindow login4_EditWindow, Login3_0ManagementWindow login3argu) {
        this.login4 = login4_EditWindow;
        this.login3 = login3argu;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Update".equals(e.getActionCommand())) {
			try {
				SinhVien sv = login4.I4Update();
//				login3.Show();
				login3.refresh();
				login4.dispose();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
}