package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
import dao.SinhVienDAO;
import model.SinhVien;
import view.Login4_1AddWindow;
import view.Login4_2EditWindow;
import view.Login3_ManagementWindow;

public class Login4_2ControllerEdit implements ActionListener {
    private Login4_2EditWindow login4;
    private SinhVienDAO buttonDao;
    private Login3_ManagementWindow login3;

    public Login4_2ControllerEdit(Login4_2EditWindow login4_EditWindow) {
        this.login4 = login4_EditWindow;
        this.buttonDao = new SinhVienDAO();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Update".equals(e.getActionCommand())) {
			try {
				SinhVien sv = login4.I4();
				login3.Show();
				login4.dispose();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
}