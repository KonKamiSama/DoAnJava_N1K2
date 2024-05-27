package view;

import java.awt.Component;
import database.Connect;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.Login1Controller;
import controller.Login3_1Controller;
import controller.Login4_1ControllerAdd;
import dao.SinhVienDAO;
import model.SinhVien;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import view.Login4_1AddWindow;

public class Login3_0ManagementWindow extends JFrame {
	private JLabel welcome;							public static DefaultTableModel model;
	private JButton add; private JButton edit;		private JButton delete;
	private JButton sort;							private JButton find;
	private JButton refresh;						private JButton exit;
	private ArrayList<SinhVien> svList2;			private static SinhVienDAO svd;
	private static JTable table;					private ActionListener al;
	private static int editableRowIndex = -1;		

	public Login3_0ManagementWindow() {
		init();
		this.setVisible(true);
		Show();	
	}
	public void init() {
		//default
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1400, 800);
		this.setLocationRelativeTo(null);
		this.setTitle("Project Management");
		al = new Login3_1Controller(this);

		//??
		model = new CustomTableModel();
		 table = new JTable(model);
	        // Tiêu đề của các cột
	        String [] columnNames = {"Studen ID", "Name", "Gender", "Date of Birth", "Class", "Phone Number", "Email", "Name Project", "Code Language", "Process"};
	        model.setColumnIdentifiers(columnNames);
	        //cangiua
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	        for (int i = 0; i < table.getColumnCount(); i++) {
	            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	        }
	        //                   id, ten, gen, dob,lop,sdt,email,tenpj,lan,tien trinh
	        int[] columnWidths = {80, 120, 40, 120, 60, 100, 140, 250, 70, 80}; // Độ rộng mong muốn của từng cột
	        for (int i = 0; i < table.getColumnCount(); i++) {
	            table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
	        }
	        table.setPreferredScrollableViewportSize(new Dimension(
	        	    table.getPreferredSize().width, 
	        	    table.getRowCount() * table.getRowHeight()
	        	));
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(0, 100, 1390, 580);
	        this.add(scrollPane);
		
		//generate
		welcome = new JLabel("Management Table");	exit = new JButton("Exit");
		add = new JButton("Add"); edit = new JButton ("Edit"); delete = new JButton("Delete"); find = new JButton("Find");
		svd = new SinhVienDAO(); find =  new JButton ("Find"); sort = new JButton("Sort"); refresh = new JButton("Refresh");

        //layout
        this.setLayout(null);
        welcome.setBounds(570, 10, 400, 100);
        welcome.setFont(new Font ("Consolas", Font.BOLD, 28));
        add.setBounds(1050, 695, 100, 50);
        edit.setBounds(1160, 695, 100, 50);
        delete.setBounds(1270, 695, 100, 50);
        find.setBounds(940, 695, 100, 50);
        sort.setBounds(830, 695, 100, 50);
        refresh.setBounds(720, 695, 100, 50);
        
        //add
        this.add(add); 			add.addActionListener(al);
        this.add(edit); 		edit.addActionListener(al);
        this.add(find);			find.addActionListener(al);
        this.add(sort);			sort.addActionListener(al);
        this.add(refresh);		refresh.addActionListener(al);
        this.add(welcome);		exit.addActionListener(al);			
        						delete.addActionListener(al);
        
        if (Login1Controller.getCount() == 1 ) {
        	this.add(delete);
        	exit.setBounds(610, 695, 100, 50);
        	this.add(exit);
        } else if (Login1Controller.getCount() == 0) {
        	exit.setBounds(1270, 695, 100, 50);
        	this.add(exit);
        }
	}
	
	public static int getEditableRowIndex() {
		return editableRowIndex;
		}
	public JTable getTable() {
	        return table;
	    }
	public DefaultTableModel getModel() {
	        return model;
	    }
	
//	public static void Show() {
//		// TODO Auto-generated method stub
//		model.setRowCount(0);
//		for (SinhVien sv : svd.SelectAll()) {
//			Object [] RowData = new Object [] {
//			sv.getIdSV(), sv.getName(), sv.getGender(), sv.getDoB(),
//			sv.getClas(), sv.getPhone(), sv.getEmail(), sv.getNamepj(), sv.getCodeLan(), sv.getProcess()
//		};
//		model.addRow(RowData);
//		System.out.println(sv.toString());
//			}
//	}
	
	public static void Show() {
	    model.setRowCount(0);
	    JSONArray jsonArray = svd.SelectAll();
	    for (int i = 0; i < jsonArray.length(); i++) {
	        JSONObject svJson = jsonArray.getJSONObject(i);
	        Object[] rowData = new Object[]{
	            svJson.getString("idSV"),
	            svJson.getString("name"),
	            svJson.getString("gender"),
	            svJson.getString("doB"),
	            svJson.getString("clas"),
	            svJson.getString("phone"),
	            svJson.getString("email"),
	            svJson.getString("namepj"),
	            svJson.getString("codeLan"),
	            svJson.getString("process")
	        };
	        model.addRow(rowData);
	        System.out.println(svJson.toString());
	    }
	}
	
//	public static void refresh() {
//	    model.setRowCount(0);
//	    Timer timer = new Timer(150, e -> {
//	        ArrayList<SinhVien> svList = svd.SelectAll();
//	        for (SinhVien sv : svList) {
//	            model.addRow(new Object[]{
//	                sv.getIdSV(),
//	                sv.getName(),
//	                sv.getGender(),
//	                sv.getDoB(),
//	                sv.getClas(),
//	                sv.getPhone(),
//	                sv.getEmail(),
//	                sv.getNamepj(),
//	                sv.getCodeLan(),
//	                sv.getProcess()
//	            });
//	        }
//	        table.repaint();
//	        table.revalidate();
//	    });
//	    timer.setRepeats(false);
//	    timer.start();
//	}

	public static void refresh() {
		model.setRowCount(0);
		Timer timer = new Timer(150, e -> {
			JSONArray jsonArray = svd.SelectAll();  // Giả sử SelectAll trả về JSONArray
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject svJson = jsonArray.getJSONObject(i);
				model.addRow(new Object[]{
						svJson.getString("idSV"),
						svJson.getString("name"),
						svJson.getString("gender"),
						svJson.getString("doB"),
						svJson.getString("clas"),
						svJson.getString("phone"),
						svJson.getString("email"),
						svJson.getString("namepj"),
						svJson.getString("codeLan"),
						svJson.getString("process")
				});
			}
			table.repaint();
			table.revalidate();
		});
		timer.setRepeats(false);
		timer.start();
	}


	public void delete() {
        int n = table.getSelectedRow();
        if (n >= 0) {
            String studentID = (String) model.getValueAt(n, 0);
            SinhVien sv = new SinhVien();
            sv.setIdSV(studentID);
            svd.Delete(sv);
            model.removeRow(n);
            JOptionPane.showMessageDialog(this, "Delete Successfully !");
        } else {
            JOptionPane.showMessageDialog(this, "Pick One To Delete !");
        }
    }
	
	public void addDataFromUserInput(Object[] userInputData) {
	        model.addRow(userInputData);
	        editableRowIndex = model.getRowCount() - 1;
	    }
	
	public void processUserInput(Object[] userInputData) {
	        addDataFromUserInput(userInputData);
	        ((CustomTableModel) table.getModel()).setEditableRow(editableRowIndex);
	    }

	public void sortByProcess() {
		System.out.println("123 ");
	    TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
	    table.setRowSorter(sorter);
	    ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
	    sortKeys.add(new RowSorter.SortKey(9, SortOrder.ASCENDING));  // Cột Process
	    sorter.setSortKeys(sortKeys);
	    sorter.sort();
	}

	public void sortByStudenID() {
	    TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
	    table.setRowSorter(sorter);
	    ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
	    sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));  // Cột STT
	    sorter.setSortKeys(sortKeys);
	    sorter.sort();
	}
	
	public Set<String> getAllLanguages() {
	    Set<String> languages = new HashSet<>();
	    for (int i = 0; i < model.getRowCount(); i++) {
	        languages.add((String) model.getValueAt(i, 8));  // Giả sử cột "Code Language" là cột thứ 8
	    }
	    return languages;
	}
	
	public void filterByLanguage(String language) {
	    TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
	    table.setRowSorter(sorter);
	    sorter.setRowFilter(RowFilter.regexFilter(language, 8));  // Lọc cột ngôn ngữ
	}
	 public String[] findStudentById(String studentId) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        for (int i = 0; i < model.getRowCount(); i++) {
	            String currentId = (String) model.getValueAt(i, 0);
	            if (currentId != null && currentId.equals(studentId)) {
	                return new String[] {
	                    currentId,                                   // Student ID
	                    (String) model.getValueAt(i, 1),             // Name
	                    (String) model.getValueAt(i, 2),             // Gender
	                    dateFormat.format((java.sql.Date) model.getValueAt(i, 3)),
	                    (String) model.getValueAt(i, 5),             // Class
	                    (String) model.getValueAt(i, 6),             // Phone
	                    (String) model.getValueAt(i, 4),             // Email
	                    (String) model.getValueAt(i, 7),             // Name Project
	                    (String) model.getValueAt(i, 8),             // Code Language
	                    (String) model.getValueAt(i, 9)              // Process
	                };
	            }
	        }
	        return null;
	    }
	}