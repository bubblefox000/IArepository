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

import exceptions.TimeFormatException;
import net.proteanit.sql.DbUtils;
import ui.SqliteMainPageConnection;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class MainPage {

	public static JFrame mainpage;     //must be public for access from LoginPage
	public JTable table_1;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();

	Connection connection = null;
	private JTextField tbRowE;
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
			
			
			 
			
			//connection.close();
			//pst.close();
			//rs.close();
			
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
		mainpage.setBounds(100, 100, 2560, 1440);
		mainpage.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		
		JButton btnNewReservation = new JButton("Add new reservation");
		btnNewReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainpage.dispose();
				
				BookingAdd bookingadd = new BookingAdd();
				BookingAdd.bookingadd.setVisible(true);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
				
		
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
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tableData(model, row);
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean CheckInCheck = TimeFormatException.isValid(tbCheckInE.getText());
				boolean CheckOutCheck = TimeFormatException.isValid(tbCheckOutE.getText());
				
	         
				
				
       	
				if(tbRowE.getText().isEmpty() == false && CheckInCheck == true && CheckOutCheck == true) {
					
					
						try {
							String query =  "Update mainpage set CheckIn='"+ tbCheckInE.getText()+"' ,CheckOut='" + tbCheckOutE.getText() +"' ,Price='" +tbPriceE.getText() + "'where Row = '"+tbRowE.getText()+"' ";
						    PreparedStatement pst = connection.prepareStatement(query); //TODO: remove pull data from BookingAdd class
						    
						    pst.execute();
						    
							
							JOptionPane.showMessageDialog(null, "Data Updated");
							
						//	pst.close();
						//	connection.close();
							
						} catch (Exception e2) {
							e2.printStackTrace();
						}
				}
						else if(tbRowE.getText().isEmpty() == true) {
							
							JOptionPane.showMessageDialog(null, "Please insert a row number");
							
						}
						
						
						else if(CheckInCheck == false && CheckOutCheck == false ) {
							
							JOptionPane.showMessageDialog(null, "Please use correct date format");
						
							
							
						}
				}
								
				
			}
		);
		
		tbRowE = new JTextField();
		tbRowE.setColumns(10);
		
		JLabel lblEditData = new JLabel("Put data to edit table in text boxes");
		lblEditData.setForeground(new Color(255, 255, 0));
		
		tbCheckInE = new JTextField();
		tbCheckInE.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Row number:");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		
		JLabel lblNewLabel_2_1 = new JLabel("*");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("CheckIn time:");
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		
		JLabel lblNewLabel_4 = new JLabel("CheckOut time:");
		lblNewLabel_4.setForeground(new Color(255, 255, 0));
		
		tbCheckOutE = new JTextField();
		tbCheckOutE.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Price:");
		lblNewLabel_5.setForeground(new Color(255, 255, 0));
		
		tbPriceE = new JTextField();
		tbPriceE.setColumns(10);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookingAdd a = new BookingAdd();
				try {
					String query =  "delete from mainpage where Row='"+tbRowE.getText()+"'";
				    PreparedStatement pst = connection.prepareStatement(query); //TODO: remove pull data from BookingAdd class
				    
				    pst.execute();
				    
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
				//	pst.close();
				//	connection.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
				
				
			
		});
		
		JButton btnPastBookings = new JButton("Past Bookings");
		btnPastBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainpage.dispose();
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(mainpage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNewReservation, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
					.addGap(1781))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEditData)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(240)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tbRowE, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tbCheckInE, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(19)))
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tbCheckOutE, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tbPriceE, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(235)
					.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
					.addGap(254)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
					.addGap(264))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(btnRefresh, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
					.addGap(1890))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 2493, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(btnPastBookings, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(2390, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblEditData)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDelete)
							.addComponent(btnSave))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tbCheckInE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_4)
								.addComponent(tbCheckOutE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tbRowE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5)
								.addComponent(tbPriceE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(70)
					.addComponent(btnPastBookings)
					.addPreferredGap(ComponentPlacement.RELATED, 712, Short.MAX_VALUE)
					.addComponent(btnNewReservation, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		mainpage.getContentPane().setLayout(groupLayout);
		
		
		
		
		
	

		
		
		
		
	
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}
}
