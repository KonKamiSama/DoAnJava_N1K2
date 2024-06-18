package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.Client;
import view.Login3_3FindStudent;
import view.Login3_0ManagementWindow;
import view.Login4_1AddWindow;
import view.Login4_2EditWindow;
import view.Login3_1Sort;

public class Login3_1Controller implements ActionListener {
    private Login3_0ManagementWindow login3;
    private Login4_1AddWindow login4;
    private Login3_1Sort login43;
    private Client client;

    public Login3_1Controller(Login3_0ManagementWindow login3, Client client3) {
        this.login3 = login3;
        this.client = client3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("Add".equals(command)) {
            new Login4_1AddWindow(client);
        } else if ("Edit".equals(command)) {
            openEditWindow();
        } else if ("Delete".equals(command)) {
            login3.delete();
        } else if ("Refresh".equals(command)) {
        	login3.refresh();
        } else if ("Sort".equals(command)) {
        	new Login3_1Sort(login3);
        } else if ("Find".equals(command)) {
        	new Login3_3FindStudent(login3);
        } else if ("Exit".equals(command)) {
        	login3.dispose();
        }
    }

    public void openEditWindow() {
        int rowIndex = login3.getTable().getSelectedRow();
        if (rowIndex != -1) {
            Object[] rowData = new Object[login3.getModel().getColumnCount()];
            for (int i = 0; i < login3.getModel().getColumnCount(); i++) {
                rowData[i] = login3.getModel().getValueAt(rowIndex, i);
            }
            Login4_2EditWindow editWindow = new Login4_2EditWindow(client);
            editWindow.setEditData(rowData);
            editWindow.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(login3, "Choose A Row To Edit !");
        }
    }
}