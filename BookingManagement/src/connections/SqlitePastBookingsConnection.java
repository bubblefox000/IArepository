package connections;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SqlitePastBookingsConnection {

	
		// TODO Auto-generated method stub
		static String filePath = "PastBookings.db";
		static String workingDirectory = System.getProperty("user.dir");
		static File file = new File(workingDirectory+"\\Resources",filePath);
		static String fileString = file.toString();
		
		Connection conn = null;
	    public static Connection dbConnector() {
	    	try {
	    		Class.forName("org.sqlite.JDBC");
	    		Connection conn = DriverManager.getConnection("jdbc:sqlite:" +fileString);
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


