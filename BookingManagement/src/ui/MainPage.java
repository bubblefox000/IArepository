package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import connections.SqliteMainPageConnection;
import exceptions.TimeFormatException;
import net.proteanit.sql.DbUtils;

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
	private void tableData(DefaultTableModel LocalModel, Object[] LocalRow) {
		
		
		
		 
			
		try {
			
			String query =  "select * from mainpage";
			PreparedStatement pst = connection.prepareStatement(query); 
			ResultSet rs = pst.executeQuery();	
			getTable_1().setModel(DbUtils.resultSetToTableModel(rs));
			
			for (int i = 0; i <= getTable_1().getRowCount(); i++) {
				
				
			}
			
			
			 
			
			//connection.close();
			//pst.close();
			//rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		}
		
	//}
	
	
	
	
	public void tablePropertyChange(java.beans.PropertyChangeEvent evt) {
		
		try {
			int row = getTable_1().getSelectedRow();
			int column = getTable_1().getSelectedColumn();
			int c = getTable_1().getColumnCount();
			
			
		} catch (Exception e) {
			
		}
	}
	
private void tableDeleteAll() {
		
		
		try {
			String query =  "delete from mainpage";
		    PreparedStatement pst = connection.prepareStatement(query); //TODO: remove pull data from BookingAdd class
		    
		    pst.execute();
		    
			
			JOptionPane.showMessageDialog(null, "Data Updated");
			
		//	pst.close();
		//	connection.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
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
		mainpage.setBounds(100, 100, 1920, 1080);
		//mainpage.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		
		JButton btnNewReservation = new JButton("Add new reservation");
		btnNewReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//mainpage.dispose();
				
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
							String query =  "Update mainpage set Check_In='"+ tbCheckInE.getText()+"' ,Check_Out='" + tbCheckOutE.getText() +"' ,Price='" +tbPriceE.getText() + "'where Room_number = '"+tbRowE.getText()+"' ";
						    PreparedStatement pst = connection.prepareStatement(query); 
						    
						    pst.execute();
						    
							
							JOptionPane.showMessageDialog(null, "Data Updated");
							
						} catch (Exception e2) {
							e2.printStackTrace();
						 }
				        }
						else if(tbRowE.getText().isEmpty() == true) {
							
							JOptionPane.showMessageDialog(null, "Please insert a room number");
							
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
		
		JLabel lblNewLabel = new JLabel("Room number:");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		
		JLabel lblNewLabel_2_1 = new JLabel("*");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("Check in time:");
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Check out time:");
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
				
				try {
					String query =  "delete from mainpage where Room_number='"+tbRowE.getText()+"'";
				    PreparedStatement pst = connection.prepareStatement(query); 
				    
				    pst.execute();
				    
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
				//	pst.close();
				//	connection.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
				
				
			
		});
		
		JButton btnPastBookings = new JButton("Booking history");
		btnPastBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainpage.dispose();
				
				PastBookings pastbookings = new PastBookings();
			
				
				pastbookings.pastbookings.setVisible(true);
			}
			
		});
		
		JButton btnDeleteAll = new JButton("Delete all bookings");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(mainpage,"Are you sure you want to delete booking history", "Confirm delete",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION) {
					try {
						tableDeleteAll();
						
					//	pst.close();
					//	connection.close();
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					
				}
				
			}
				
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("CURRENT BOOKINGS");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 39));
		GroupLayout groupLayout = new GroupLayout(mainpage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(btnRefresh, GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnDeleteAll, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
					.addGap(1687))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEditData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(2366))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 2241, Short.MAX_VALUE)
					.addGap(914))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPastBookings, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
							.addGap(2311))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewReservation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(262)
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tbRowE, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addGap(45)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tbCheckInE, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tbCheckOutE, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tbPriceE, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
							.addGap(73)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
								.addComponent(btnSave, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
							.addGap(989))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(610)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
					.addGap(1211))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblNewLabel_1)
					.addGap(30)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteAll))
					.addGap(34)
					.addComponent(lblEditData)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tbPriceE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tbRowE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tbCheckOutE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3)
								.addComponent(tbCheckInE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))))
					.addGap(38)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnPastBookings)
					.addPreferredGap(ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
					.addComponent(btnNewReservation, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
