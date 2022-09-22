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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;
import ui.SqliteMainPageConnection;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;


public class MainPage {

	public static JFrame mainpage;     //must be public for access from LoginPage
	public JTable table_1;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();

	Connection connection = null;
	private JTextField tbRow;
	private JTextField tbCheckInE;
	private JTextField tbCheckOutE;
	private JTextField tbPriceE;
	
	public MainPage() {
		initialize();
		
		connection = SqliteMainPageConnection.dbConnector();	//opens connection
		
	}
	
	//Function to add row in table if user input is correct
	public void tableData(DefaultTableModel LocalModel, Object[] LocalRow) {
		
		
			
	//	if (BookingAdd.Record == true && BookingAdd.cmd == "Add" && BookingAdd.count == 0 ) {
		
		
		 
			
		try {
			
			String query =  "select * from mainpage";
			PreparedStatement pst = connection.prepareStatement(query); //TODO: remove pull data from BookingAdd class
			ResultSet rs = pst.executeQuery();	
			getTable_1().setModel(DbUtils.resultSetToTableModel(rs));
			
			for (int i = 0; i <= getTable_1().getRowCount(); i++) {
				
				/*
			    table_1.setValueAt(i+1, i, 0);
				String query2 = "Update mainpage set Row ='"+ table_1.getValueAt(i-1, 0) +"'";
				PreparedStatement pst2 = connection.prepareStatement(query2);
				pst2.execute();
	
				*/
			}
			
			
			 
			
			connection.close();
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		}
		
	//}
	
	
	public static void CCP(String CheckIn, String CheckOut, String Price) throws SQLException  {
		//this method is to collect and update SQL statement 
	
		/*
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
		*/
		
	//end of method
	}
	
	public void tablePropertyChange(java.beans.PropertyChangeEvent evt) {
		
		try {
			int row = getTable_1().getSelectedRow();
			int column = getTable_1().getSelectedColumn();
			int c = getTable_1().getColumnCount();
			
			
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
	

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainpage = new JFrame();
		mainpage.getContentPane().setForeground(new Color(255, 255, 0));
		mainpage.getContentPane().setBackground(new Color(0, 0, 102));
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 90, 1933, 314);
		mainpage.getContentPane().add(scrollPane_1);
				
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		setTable_1(new JTable());
		getTable_1().setModel(model);
		scrollPane.setViewportView(getTable_1());
		getTable_1().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		//TODO: my code under
		Object[] column = {"CheckIn", "CheckOut", "Price"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		
		JButton btnDelete = new JButton("delete reservation");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(getTable_1().getSelectedRow() > 0) {
		               // remove selected row from the model
		               model.removeRow(getTable_1().getSelectedRow());
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
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingAdd a = new BookingAdd();
				try {
					//String query =  "Update mainpage set CheckIn='"+ +"'   ";
				   // PreparedStatement pst = connection.prepareStatement(query); //TODO: remove pull data from BookingAdd class
				    
				  //  pst.execute();
				    
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
				//	pst.close();
					connection.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(1118, 538, 89, 23);
		mainpage.getContentPane().add(btnNewButton);
		
		tbRow = new JTextField();
		tbRow.setBounds(336, 539, 86, 20);
		mainpage.getContentPane().add(tbRow);
		tbRow.setColumns(10);
		
		JLabel lblEditData = new JLabel("Put data to edit table in text boxes");
		lblEditData.setBounds(29, 542, 168, 14);
		mainpage.getContentPane().add(lblEditData);
		lblEditData.setForeground(new Color(255, 255, 0));
		
		tbCheckInE = new JTextField();
		tbCheckInE.setBounds(536, 539, 86, 20);
		mainpage.getContentPane().add(tbCheckInE);
		tbCheckInE.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Row number:");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(236, 542, 64, 14);
		mainpage.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Required:");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(40, 865, 53, 14);
		mainpage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(91, 865, 46, 14);
		mainpage.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("*");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(310, 538, 16, 14);
		mainpage.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("CheckIn time:");
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setBounds(452, 542, 74, 14);
		mainpage.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CheckOut time:");
		lblNewLabel_4.setForeground(new Color(255, 255, 0));
		lblNewLabel_4.setBounds(668, 542, 89, 14);
		mainpage.getContentPane().add(lblNewLabel_4);
		
		tbCheckOutE = new JTextField();
		tbCheckOutE.setBounds(750, 539, 86, 20);
		mainpage.getContentPane().add(tbCheckOutE);
		tbCheckOutE.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Price:");
		lblNewLabel_5.setForeground(new Color(255, 255, 0));
		lblNewLabel_5.setBounds(870, 542, 46, 14);
		mainpage.getContentPane().add(lblNewLabel_5);
		
		tbPriceE = new JTextField();
		tbPriceE.setBounds(926, 539, 86, 20);
		mainpage.getContentPane().add(tbPriceE);
		tbPriceE.setColumns(10);
		
		
		
		
		
	

		
		
		
		
	
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}
}
