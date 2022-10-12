package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import connections.SqlitePastBookingsConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PastBookings {

	public static JFrame pastbookings;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	
	Connection connection = null;
	
	
	private void tableDeleteAll() {
		
		
		try {
			String query =  "delete from pastbookings";
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
					PastBookings window = new PastBookings();
					window.pastbookings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PastBookings() {
		initialize();
		
		connection = SqlitePastBookingsConnection.dbConnector();
	}
	// function to go back to mainpage
		public static void back() {
			
			MainPage MainPage = new MainPage();
			
			pastbookings.dispose();
				
			SwingUtilities.updateComponentTreeUI(MainPage.mainpage);
			
			MainPage.mainpage.setVisible(true);
			
			
			
			
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pastbookings = new JFrame();
		pastbookings.setBounds(100, 100, 2560, 1440);
		pastbookings.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pastbookings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query =  "select * from pastbookings";
					PreparedStatement pst = connection.prepareStatement(query); //TODO: remove pull data from BookingAdd class
					ResultSet rs = pst.executeQuery();	
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					for (int i = 0; i <= table.getRowCount(); i++) {
						
						
					}
					
					
					 
					
					//connection.close();
					//pst.close();
					//rs.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		JButton btnRemoveAll = new JButton("Clear History");
		btnRemoveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(pastbookings,"Are you sure you want to delete booking history", "Confirm delete",
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
		
		JLabel lblNewLabel_1 = new JLabel("BOOKING HISTORY");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		GroupLayout groupLayout = new GroupLayout(pastbookings.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(960)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 1920, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRemoveAll, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(547, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRefresh)
						.addComponent(btnRemoveAll))
					.addGap(263)
					.addComponent(btnBack))
		);
		pastbookings.getContentPane().setLayout(groupLayout);
	}
}
