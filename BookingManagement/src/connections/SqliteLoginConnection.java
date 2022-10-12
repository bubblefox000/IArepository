package connections;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SqliteLoginConnection {
	
    /**
     * Connect to a sample database
     */
	static String filePath = "Login.db";
	static String workingDirectory = System.getProperty("user.dir");
	static File file= new File(workingDirectory+"\\Resources",filePath); // file provides the whole directory to file
	static String fileString = file.toString();
	
			Connection conn = null;
    public static Connection dbConnector() {
    	try {
    		Class.forName("org.sqlite.JDBC");
    		Connection conn = DriverManager.getConnection("jdbc:sqlite:" +fileString); //C:\Users\alex\git\IArepository\IArepository\BookingManagement

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
