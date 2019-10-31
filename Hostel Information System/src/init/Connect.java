package init;
import java.sql.*;

import javax.swing.JOptionPane;
public class Connect {
	private static String url="jdbc:mysql://localhost:3306/";
	private static String uname="root";
	private static String pass="8484452";
	private static Connection conn;
	public static Connection connect(String db)
	{
		try
		{
			String urlstring=url+db;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(urlstring,uname,pass);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Unable to connect to database","Alert",JOptionPane.WARNING_MESSAGE);
		}
		return conn;
	}
}
