package bubble.loginpage.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SqliteConnection {
    /**
     * Connect to a sample database
     */
	Connection conn = null;
    public static Connection dbConnector() {
    	try {
    		Class.forName("org.sqlite.JDBC");
    		Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\alex\\OneDrive\\Desktop\\Sqlitedb\\Login.db");
    		JOptionPane.showMessageDialog(null, "Connection successful");
    		return conn;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
    }
       

}
