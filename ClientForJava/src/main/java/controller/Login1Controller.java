package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Login1_RevealWindow;
import view.Login2_Login;

public class Login1Controller implements ActionListener {
	private Login1_RevealWindow login1;
	private Login2_Login login2;
	public static int count;

	public Login1Controller(Login1_RevealWindow login1) {
		this.login1 = login1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("Giáo Viên".equals(command)) {
			count = 1;
			login1.dispose();
			new Login2_Login();
		} else if ("Sinh Viên".equals(command)) {
			count = 0;
			login1.dispose();
			login2 = new Login2_Login();
		}
	}

	public static int getCount() {
		return count;
	}
}
