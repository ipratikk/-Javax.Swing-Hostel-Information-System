package init;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class addToDB {

	class InputException extends Exception
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 3774615738401464984L;

		InputException()
		{
			super("Invalid Input");
		}
	}
	private Connection con = null;
	private PreparedStatement stmt = null;
	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField ph;
	private JTextField addr;
	private JTextField hid;
	private JLabel lblGender;
	private JRadioButton rdbtnMale,rdbtnFemale;
	private ButtonGroup bg1;

	/**
	 * Launch the application.
	/**
	 * Create the application.
	 */
	public addToDB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void reset() {
		id.setText("");
		name.setText("");
		ph.setText("");
		addr.setText("");
		hid.setText("");
		rdbtnFemale.setSelected(false);
		rdbtnMale.setSelected(false);
	}
	private void addEntry()
	{
		String gender="",qid=id.getText().trim(),qname=name.getText().trim(),qph=ph.getText().trim(),qaddr=addr.getText().trim(),qhid=hid.getText().trim();
		String insert_query="insert into students values("+qid+",'"+qname+"',"+qph+",'"+qaddr+"',"+qhid+",'"+gender+"')";
		con=Connect.connect("student_list");
		if(bg1.getSelection()==null)
			JOptionPane.showMessageDialog(null, "Select a gender");
		else
		{
			gender=(rdbtnFemale.isSelected())?rdbtnFemale.getText().trim():rdbtnMale.getText().trim();
			int rows=0;
			System.out.println(qid+" "+qname+" "+qph+" "+qaddr+" "+qhid+" "+gender);
			try
			{
					if (qid.length() == 0 )
						throw new InputException();
					if (qname.length() == 0 )
						throw new InputException();
					if (qph.length() == 0 )
						throw new InputException();
					if (qaddr.length() == 0 )
						throw new InputException();
					if (qhid.length() == 0 )
						throw new InputException();
					try
					{
						stmt=con.prepareStatement(insert_query);
						rows=stmt.executeUpdate();
						if(rows>0)
						{
							JOptionPane.showMessageDialog(null, "Added Successfully");
							reset();
						}
					}catch(Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Invalid Entry(s)", "Alert", JOptionPane.WARNING_MESSAGE);
					}
					
					
			}catch(InputException e) {
				JOptionPane.showMessageDialog(null, "Invalid Input");
			}
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 368);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnrollmentId = new JLabel("Enrollment ID");
		lblEnrollmentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnrollmentId.setBounds(12, 30, 114, 32);
		frame.getContentPane().add(lblEnrollmentId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(12, 75, 114, 32);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhone.setBounds(357, 30, 59, 32);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(12, 120, 114, 32);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblHostelId = new JLabel("Hostel ID");
		lblHostelId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHostelId.setBounds(12, 165, 114, 32);
		frame.getContentPane().add(lblHostelId);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id.setBounds(138, 36, 201, 22);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setColumns(10);
		name.setBounds(138, 81, 201, 22);
		frame.getContentPane().add(name);
		
		ph = new JTextField();
		ph.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ph.setColumns(10);
		ph.setBounds(428, 35, 201, 22);
		frame.getContentPane().add(ph);
		
		addr = new JTextField();
		addr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addr.setColumns(10);
		addr.setBounds(138, 126, 365, 22);
		frame.getContentPane().add(addr);
		
		hid = new JTextField();
		hid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hid.setColumns(10);
		hid.setBounds(138, 171, 103, 22);
		frame.getContentPane().add(hid);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(357, 75, 114, 32);
		frame.getContentPane().add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBounds(428, 80, 68, 25);
		frame.getContentPane().add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnFemale.setBounds(500, 80, 83, 25);
		frame.getContentPane().add(rdbtnFemale);
		
		bg1= new ButtonGroup( );
		bg1.add(rdbtnFemale);
		bg1.add(rdbtnMale);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addEntry();
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(259, 220, 114, 32);
		frame.getContentPane().add(btnSubmit);
		JLabel footer = new JLabel("Copyright \u00A9 2019. All Rights Reserved. Pratik Goel");
		footer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		footer.setBounds(195, 292, 233, 16);
		frame.getContentPane().add(footer);
		frame.setVisible(true);
	}
}
