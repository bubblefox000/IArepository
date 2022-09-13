package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ui.SqliteMainPageConnection;

import java.awt.Color;
import javax.swing.JScrollPane;


public class MainPage {

	public static JFrame mainpage;     //must be public for access from LoginPage
	private JTable table_1;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	
	//Function to add row in table if user input is correct
	public static void tableData(DefaultTableModel LocalModel, Object[] LocalRow) {
		
		BookingAdd a = new BookingAdd();
				
		if (a.Record == true && a.cmd == "Add" && a.count == 0 ) {
		 
		 
			
			//System.out.println(a.pullData[1]);
			LocalModel.addRow(new Object[]{a.pullData[0], a.pullData[1], a.pullData[2]});
		    
			a.count = 1;
				
		}
		
	}
	
	public void CCP(String CheckIn, String CheckOut, String Price) throws SQLException  {
		//this method is to collect and update SQL statement 
		String query = null;
		Statement St = null;					
		try {
			St = connection.createStatement();
			query = "update tbltest set CheckIn = '" + CheckIn + "',CheckOut = '" + CheckOut + "' where price = '" + Price + "'";
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(mainpage, e);
		}
		
		finally {
			connection.close();
			St.close();
		}
		
	//end of method
	}
	
	public void tablePropertyChange(java.beans.PropertyChangeEvent evt) {
		
		try {
			int row = table_1.getSelectedRow();
			int column = table_1.getSelectedColumn();
			int c = table_1.getColumnCount();
			
			
		} catch (Exception e) {
			
		}
	}
		
		
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.mainpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
		
		connection = SqliteMainPageConnection.dbConnector();	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainpage = new JFrame();
		mainpage.getContentPane().setBackground(Color.DARK_GRAY);
		mainpage.setBounds(100, 100, 2013, 1176);
		mainpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainpage.getContentPane().setLayout(null);
		
		JButton btnNewReservation = new JButton("Add new reservation");
		btnNewReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainpage.dispose();
				
				BookingAdd bookingadd = new BookingAdd();
				BookingAdd.bookingadd.setVisible(true);
			}
		});
		btnNewReservation.setBounds(29, 1103, 187, 23);
		mainpage.getContentPane().add(btnNewReservation);
				
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 90, 1933, 314);
		mainpage.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		model = new DefaultTableModel();
		//TODO: my code under
		Object[] column = {"CheckIn", "CheckOut", "Price"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		table_1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnDelete = new JButton("delete reservation");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(table_1.getSelectedRow() != -1) {
		               // remove selected row from the model
		               model.removeRow(table_1.getSelectedRow());
		               //JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		            }
		         }
			}
		);
		
		btnDelete.setBounds(1775, 1103, 187, 23);
		mainpage.getContentPane().add(btnDelete);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tableData(model, row);
			}
		});
		btnRefresh.setBounds(29, 425, 89, 23);
		mainpage.getContentPane().add(btnRefresh);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultTableModel dt = (DefaultTableModel) table_1.getModel();
				try {
				
					Statement St;					
					St = connection.createStatement();
					
					//Execute a query
					String sql = "UPDATE mainpage SET CheckIn='" + dt.getValueAt(0, 0)+ "',CheckOut='"+ dt.getValueAt(0, 1) + "' WHERE Price=" + dt.getValueAt(0, 2);
					St.executeUpdate(sql);
					
					System.out.println("Putting into database...");
					
					
			
				/*	
					for(int x=0;x<dt.getRowCount();x++) {
									
						St.executeUpdate("UPDATE mainpage SET CheckIn='" + dt.getValueAt(x, 0)+ "',CheckOut='"+ dt.getValueAt(x, 1) + "' WHERE Price=" + dt.getValueAt(x, 2));
					}
					
					
					JOptionPane.showMessageDialog(btnSave, "Record Saved");
					St.close();
					
					*/
					
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(btnSave, e2.getMessage());
	
					
				}
				
				
			
				
			}
		});
		
		btnSave.setBounds(1775, 473, 89, 23);
		mainpage.getContentPane().add(btnSave);
		
		
		
		
		
	

		
		
		
		
	
	}
}
