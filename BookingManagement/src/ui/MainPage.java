package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
	public MainPage() {
		initialize();
		
		
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
		
		//table_1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnDelete = new JButton("delete reservation");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(1775, 1103, 187, 23);
		mainpage.getContentPane().add(btnDelete);
		
		
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
		
		JButton btnTest = new JButton("Refresh");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tableData(model, row);
			}
		});
		btnTest.setBounds(29, 425, 89, 23);
		mainpage.getContentPane().add(btnTest);
		
		
		
		
		
	

		
		
		
		
	
	}
}
