package loginpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SqliteLoginConnection {
    /**
     * Connect to a sample database
     */
	Connection conn = null;
    public static Connection dbConnector() {
    	try {
    		Class.forName("org.sqlite.JDBC");
    		Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\alex\\OneDrive\\Desktop\\Sqlitedb\\Login.db");
    		//JOptionPane.showMessageDialog(null, "Connection successful");
    		return conn;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
			
			}
    	catch (Exception e2) {
    		JOptionPane.showMessageDialog(null, e2);
			return null;
		}
    }
       

}
