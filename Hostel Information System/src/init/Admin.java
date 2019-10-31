package init;


import java.awt.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin {

	private JFrame frmHostelInformationSystem;
	String user;

	/**
	 * Create the application.
	 */
	public Admin(String user) {
		this.user=user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmHostelInformationSystem = new JFrame();
		frmHostelInformationSystem.setTitle("Hostel Information System");
		frmHostelInformationSystem.setBounds(100, 100, 360, 360);
		frmHostelInformationSystem.getContentPane().setLayout(null);
		
		JLabel userlbl = new JLabel("Logged in as : "+user);
		userlbl.setBounds(12, 241, 293, 16);
		frmHostelInformationSystem.getContentPane().add(userlbl);
		
		JButton btnStudentRecord = new JButton("Student Record");
		btnStudentRecord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				StudentRecord stdRec = new StudentRecord();
			}
		});
		btnStudentRecord.setBounds(94, 44, 150, 50);
		frmHostelInformationSystem.getContentPane().add(btnStudentRecord);
		
		JButton btnHostelRecord = new JButton("Hostel Record");
		btnHostelRecord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				HostelSearch hs = new HostelSearch();
			}
		});
		btnHostelRecord.setBounds(94, 152, 150, 50);
		frmHostelInformationSystem.getContentPane().add(btnHostelRecord);
		frmHostelInformationSystem.setVisible(true);
		//frmHostelInformationSystem.setResizable(false);
		JLabel footer = new JLabel("Copyright \u00A9 2019. All Rights Reserved. Pratik Goel");
		footer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		footer.setBounds(63, 285, 233, 16);
		frmHostelInformationSystem.getContentPane().add(footer);
		frmHostelInformationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
