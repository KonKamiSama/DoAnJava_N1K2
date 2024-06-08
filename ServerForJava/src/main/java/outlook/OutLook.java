package outlook;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import client.Client;
import database.Connect;
import server.Server;
import view.*;

public class OutLook {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			String src = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
			UIManager.setLookAndFeel(src);
			new Login1_RevealWindow();
//		new Login3_0ManagementWindow();
//		new Login4_3Sort();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}