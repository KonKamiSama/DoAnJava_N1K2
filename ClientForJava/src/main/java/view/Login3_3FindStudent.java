package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Login3_3FindStudent extends JFrame implements ActionListener {
    private JTextField studentIdField;
    private JButton findButton;
    private Login3_0ManagementWindow login3;

    public Login3_3FindStudent(Login3_0ManagementWindow login3) {
        this.login3 = login3;
        setTitle("Find Student");
        setSize(300, 100);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        studentIdField = new JTextField(15);
        findButton = new JButton("Find");
        findButton.addActionListener(this);

        add(new JLabel("Enter Student ID:"));
        add(studentIdField);
        add(findButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String studentId = studentIdField.getText();
        if (!studentId.isEmpty()) {
            try {
                displayStudentInfo(studentId);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid Student ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayStudentInfo(String studentId) throws ParseException {
        // Dummy data, replace with actual data retrieval logic
        String[] studentData = login3.findStudentById(studentId);
        if (studentData != null) {
            new Login3_4FindAnotherStudent(studentData, login3);
            dispose();  // Close the search window
        } else {
            JOptionPane.showMessageDialog(this, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

