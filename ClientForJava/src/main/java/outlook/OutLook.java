package outlook;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.*;

public class OutLook {
	public static void main(String[] args) {
		try {
			String src = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
			UIManager.setLookAndFeel(src);
			new Login1_RevealWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}