package init;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


public class StudentRecord {

	private JFrame frame;
	private JTable table;
	Connection conn = null;
    Statement statement = null;
    ResultSet res = null;
    DefaultTableModel model;
    /**
	 * Launch the application.
	 */
		public StudentRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void validate(String val)
	{
		System.out.println(val);
		String url="jdbc:mysql://localhost:3306/student_list";
		String uname="root";
		String pass="8484452";
		try
		{
			val=val.toLowerCase();
			String id_query = "SELECT * from students where id='"+val+"'";
			String name_query = "SELECT * from students where lower(name) like '%"+val+"%'";
			String all_query = "SELECT * from students";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,uname,pass);
			statement = conn.createStatement();
			if (val.equalsIgnoreCase("All"))
				res=statement.executeQuery(all_query);
			else if (val.matches("[0-9]+")) {
				res=statement.executeQuery(id_query);
			}
			else
			{
				res=statement.executeQuery(name_query);
			}
			int rows = 0;
			res.last();
			rows = res.getRow();
			res.beforeFirst();
			if(rows>0)
			{
				table=new JTable();
				table.setModel(DbUtils.resultSetToTableModel(res));
				table.setSize(750, rows*15);
				JScrollPane jsp = new JScrollPane(table);
				JOptionPane.showMessageDialog(null,jsp);
			}
			else
				JOptionPane.showMessageDialog(null, "No records found");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to database");
		};
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 360);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnSearch = new JButton("Existing Student");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				validate(JOptionPane.showInputDialog(null,"Student Name/ID","Enter ALL for all student details"));
			}
		});
		btnSearch.setBounds(78, 55, 171, 64);
		frame.getContentPane().add(btnSearch);
		
		JButton btnNewStudent = new JButton("New Student");
		btnNewStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				addToDB adb = new addToDB();
			}
		});
		btnNewStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewStudent.setBounds(78, 166, 171, 64);
		frame.getContentPane().add(btnNewStudent);
		
		JLabel footer = new JLabel("Copyright \u00A9 2019. All Rights Reserved. Pratik Goel");
		footer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		footer.setBounds(50, 284, 233, 16);
		frame.getContentPane().add(footer);
	}
}
