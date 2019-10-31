package init;

import java.sql.*;
import java.util.ArrayList;
import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HostelSearch {

	private static Connection con;
	private static PreparedStatement st;
	private static ResultSet rs;
	private JFrame frame;
	private ButtonGroup bg1;

		public HostelSearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
		
	public static void initDb(String query)
	{
		con=Connect.connect("student_list");
		try{
			st = con.prepareStatement(query);
			rs=st.executeQuery();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Unable to connect to database");
			e.printStackTrace();
		}
	}
	
	private void showData(String query)
	{
		try{
			st=con.prepareStatement(query);
			rs=st.executeQuery();
			int rows = 0;
			rs.last();
			rows = rs.getRow();
			rs.beforeFirst();
			if(rows>0)
			{
				JTable table=new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				JScrollPane jsp = new JScrollPane(table);
				JOptionPane.showMessageDialog(null,jsp);
			}
			else
				JOptionPane.showMessageDialog(null, "No records found");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to database");
		}
	}
	private void initialize() {
		initDb("select hostel_id from hostels");
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnViewStudentRecords = new JRadioButton("View Student Records");
		rdbtnViewStudentRecords.setBounds(34, 119, 171, 25);
		frame.getContentPane().add(rdbtnViewStudentRecords);
		
		JRadioButton rdbtnViewHostelDetails = new JRadioButton("View Hostel Details");
		rdbtnViewHostelDetails.setBounds(208, 119, 171, 25);
		frame.getContentPane().add(rdbtnViewHostelDetails);
		
		bg1 = new ButtonGroup();
		bg1.add(rdbtnViewStudentRecords);
		bg1.add(rdbtnViewHostelDetails);
		
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.setBounds(208, 63, 171, 22);
		frame.getContentPane().add(jcb);
		ArrayList<String> h_id=new ArrayList<String>();
		try{
			while(rs.next()) {
				String x=rs.getString(1);
				h_id.add(x);
				jcb.addItem(x);
			}
		}catch(Exception e) {}
		
		JLabel lblSelectHostelId = new JLabel("Select Hostel ID");
		lblSelectHostelId.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectHostelId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectHostelId.setBounds(34, 57, 171, 32);
		frame.getContentPane().add(lblSelectHostelId);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item=jcb.getSelectedItem().toString();
				if(bg1.getSelection()==null)
					JOptionPane.showMessageDialog(null, "Select an Option");
				else {
					if(rdbtnViewHostelDetails.isSelected())
						showData("select * from hostels where hostel_id="+item);
					else
						showData("select * from students where hostel_id="+item);
					
				}
			}
		});
		btnSubmit.setBounds(164, 187, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		frame.setVisible(true);
		
	}
}
