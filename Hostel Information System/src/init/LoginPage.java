package init;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

class LoginException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 229546486115621009L;

	LoginException()
	{
		super("Invalid Login");
	}
}
class LoginSuccess extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9080428399882384063L;

	LoginSuccess()
	{
		super("Login Successful");
	}
}
public class LoginPage {
	private JFrame title;
	private JTextField id_field;
	private JPasswordField pw_field;
	Connection conn = null;
    PreparedStatement statement = null;
    ResultSet res = null;

	/**
	 * Launch the application.
	 */
    public void verify(String user,char[] pw)
    {
    	String url="jdbc:mysql://localhost:3306/userlist";
    	String uname="root";
    	String pass="8484452";
    	try
    	{
    		String pw2 = new String(pw);
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = DriverManager.getConnection(url,uname,pass);
    		String query="select * from users where username='"+user+"' and password ='"+pw2+"'";
    		statement = conn.prepareStatement(query);
    		res=statement.executeQuery();
    		try
    		{
    			if(res.absolute(1))
    			{
    				@SuppressWarnings("unused")
					Admin admin = new Admin(user);
    				title.dispose();
    				throw new LoginSuccess();
    			}
    			else
    			{
    				throw new LoginException();
    			}
    		}catch(LoginSuccess e) {
    			JOptionPane.showMessageDialog(null, "Login Successful");
    			System.out.println(e);
    		}catch(LoginException e) {
    			JOptionPane.showMessageDialog(null, "Login Invalid");
    			System.out.println(e);
    		}
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Unable to connect to database");
    		System.out.println(e);
    		System.exit(0);
    	}
    }
    	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.title.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		title = new JFrame();
		title.setTitle("Hostel Information System");
		title.setBounds(100, 100, 485, 367);
		title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				verify(id_field.getText(),pw_field.getPassword());
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		btnLogin.setBounds(177, 203, 97, 25);
		title.getContentPane().add(btnLogin);
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserId.setBounds(92, 97, 56, 16);
		title.getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(82, 137, 68, 16);
		title.getContentPane().add(lblPassword);
		
		id_field = new JTextField();
		id_field.setBounds(177, 94, 186, 22);
		title.getContentPane().add(id_field);
		id_field.setColumns(10);
		
		pw_field = new JPasswordField();
		pw_field.setToolTipText("");
		pw_field.setBounds(177, 134, 186, 22);
		title.getContentPane().add(pw_field);
		
		JLabel footer = new JLabel("Copyright \u00A9 2019. All Rights Reserved. Pratik Goel");
		footer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		footer.setBounds(110, 291, 233, 16);
		title.getContentPane().add(footer);
		title.setResizable(false);
	}
}
