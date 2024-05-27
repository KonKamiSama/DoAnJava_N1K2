package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
import dao.SinhVienDAO;
import model.SinhVien;
import view.Login4_1AddWindow;
import view.Login3_0ManagementWindow;

public class Login4_1ControllerAdd implements ActionListener {
    private Login4_1AddWindow login4;
    private SinhVienDAO buttonDao;
    private Login3_0ManagementWindow login3;

    public Login4_1ControllerAdd(Login4_1AddWindow login4) {
        this.login4 = login4;
        this.buttonDao = new SinhVienDAO();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Save".equals(e.getActionCommand())) {
			try {
				SinhVien sv = login4.I4();
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