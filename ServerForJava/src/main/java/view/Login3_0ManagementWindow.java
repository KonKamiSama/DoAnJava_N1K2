package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import client.Client;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import controller.Login1Controller;
import controller.Login3_1Controller;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Login3_0ManagementWindow extends JFrame {
	private JLabel welcome;
	public static DefaultTableModel model;
	private JButton add, edit, delete, sort, find, refresh, exit;
	private static JTable table;
	private ActionListener al;
	private static int editableRowIndex = -1;
	private static Client client;
	private static JSONArray jsonArray;

	public Login3_0ManagementWindow() {
	}

	public Login3_0ManagementWindow(Client client3) {
		try {
			this.client = client3;
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("loi~" + e);
		}
		System.out.println(1);
		init();
		System.out.println(2);
		this.setVisible(true);
		System.out.println(3);
		Show();
		System.out.println(4);
	}

	public void init() {
		//default
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1400, 800);
		this.setLocationRelativeTo(null);
		this.setTitle("Project Management");
		al = new Login3_1Controller(this, client);

		//??
		model = new CustomTableModel();
		table = new JTable(model);
		// Tiêu đề của các cột
		String[] columnNames = {"Studen ID", "Name", "Gender", "Date of Birth", "Class", "Phone Number", "Email", "Name Project", "Code Language", "Process"};
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
		welcome = new JLabel("Management Table");
		exit = new JButton("Exit");
		add = new JButton("Add");
		edit = new JButton("Edit");
		delete = new JButton("Delete");
		find = new JButton("Find");
		find = new JButton("Find");
		sort = new JButton("Sort");
		refresh = new JButton("Refresh");

		//layout
		this.setLayout(null);
		welcome.setBounds(570, 10, 400, 100);
		welcome.setFont(new Font("Consolas", Font.BOLD, 28));
		add.setBounds(1050, 695, 100, 50);
		edit.setBounds(1160, 695, 100, 50);
		delete.setBounds(1270, 695, 100, 50);
		find.setBounds(940, 695, 100, 50);
		sort.setBounds(830, 695, 100, 50);
		refresh.setBounds(720, 695, 100, 50);

		//add
		this.add(add);
		add.addActionListener(al);
		this.add(edit);
		edit.addActionListener(al);
		this.add(find);
		find.addActionListener(al);
		this.add(sort);
		sort.addActionListener(al);
		this.add(refresh);
		refresh.addActionListener(al);
		this.add(welcome);
		exit.addActionListener(al);
		delete.addActionListener(al);

		if (Login1Controller.getCount() == 1) {
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

	public static void Show() throws JSONException {
		try {
			model.setRowCount(0);
			JSONObject get = new JSONObject();
			get.put("action", "Show");
			client.sendData(get);
			jsonArray = new JSONArray(client.getData());
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
		} catch (Exception e) {
			e.getStackTrace();
			System.out.print("Loi~" + e);
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
//			JSONArray jsonArray = svd.SelectAll();
			JSONObject get = new JSONObject();
			get.put("action", "Show");
			client.sendData(get);
			JSONArray jsonArray = client.getData();
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
//            SinhVien sv = new SinhVien();
//            sv.setIdSV(studentID);
			JSONObject jsonSv = new JSONObject();
			jsonSv.put("action", "Delete");
			jsonSv.put("idSV", studentID);
			model.removeRow(n);
//            svd.Delete(jsonSv.toString());
			client.sendData(jsonSv);
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
			languages.add((String) model.getValueAt(i, 8));
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
				try {
					Date dob = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(i, 3)); // Giả sử ngày sinh được lưu dưới dạng chuỗi
					return new String[]{
							currentId,                                  // Student ID
							(String) model.getValueAt(i, 1),            // Name
							(String) model.getValueAt(i, 2),            // Gender
							dateFormat.format(dob),                     // Date of Birth
							(String) model.getValueAt(i, 5),            // Class
							(String) model.getValueAt(i, 6),            // Phone
							(String) model.getValueAt(i, 4),            // Email
							(String) model.getValueAt(i, 7),            // Name Project
							(String) model.getValueAt(i, 8),            // Code Language
							(String) model.getValueAt(i, 9)             // Process
					};
				} catch (ParseException e) {
					e.printStackTrace();
					System.out.println("Error parsing the date: " + model.getValueAt(i, 3));
				}
			}
		}
		return null;
	}
}