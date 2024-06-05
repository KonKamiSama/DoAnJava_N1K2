package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login3_4FindAnotherStudent extends JFrame implements ActionListener {
    private String[] studentData;
    private JButton findAnotherButton;
    private Login3_0ManagementWindow login3;

    public Login3_4FindAnotherStudent(String[] studentData, Login3_0ManagementWindow login3) {
        this.studentData = studentData;
        this.login3 = login3;
        setTitle("Student Information");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String infoText = String.format("ID: %s\nName: %s\nClass: %s\nPhone: %s\nEmail: %s",
                studentData[0], studentData[1], studentData[2], studentData[3], studentData[4]);
        JTextArea infoArea = new JTextArea(infoText);
        infoArea.setEditable(false);

        findAnotherButton = new JButton("Find Another");
        findAnotherButton.addActionListener(this);

        add(infoArea, BorderLayout.CENTER);
        add(findAnotherButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login3_3FindStudent(login3); // Re-open the search window to find another student
        dispose();  // Close the current info window
    }
}
