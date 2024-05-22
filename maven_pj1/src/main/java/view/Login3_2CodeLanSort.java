package view;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Login3_2CodeLanSort extends JFrame implements ActionListener {
    private Login3_ManagementWindow login3;
    private JList<String> languageList;
    private JButton selectButton;

    public Login3_2CodeLanSort(Set<String> languages, Login3_ManagementWindow login3) {
        this.login3 = login3;
        setTitle("Select Language");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        languageList = new JList<>(languages.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(languageList);
        add(scrollPane, BorderLayout.CENTER);

        selectButton = new JButton("Select");
        selectButton.addActionListener(this);
        add(selectButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedLanguage = languageList.getSelectedValue();
        login3.filterByLanguage(selectedLanguage);
        dispose();
    }
}
