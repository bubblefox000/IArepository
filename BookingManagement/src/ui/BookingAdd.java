package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingAdd {

	public static JFrame bookingadd;
	private JTextField tbCheckIn;
	private JTextField tbCheckOut;
	private JTextField tbPrice;
	private JButton btnAdd;
	public static String[] pullData; // pulls data from data[]
	public static boolean Record; // establishes if there is a record
	public static String cmd; // fetches action command 
	public static int count; // makes sure there is only one table of one input
	
	//function to store input data in array
	public static String[] data(String CheckIn, String CheckOut, String Price) {
		
		String[] infor = {CheckIn, CheckOut, Price};
		
		return infor;
	}
	
	// function to go back to mainpage
	public static void back() {
		
		bookingadd.dispose();
		
		MainPage mainpage = new MainPage();
		
		SwingUtilities.updateComponentTreeUI(MainPage.mainpage);
		
		MainPage.mainpage.setVisible(true);
		
		
		
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingAdd window = new BookingAdd();
					window.bookingadd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
					
				}
				
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		bookingadd = new JFrame();
		bookingadd.setBounds(100, 100, 450, 300);
		bookingadd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bookingadd.getContentPane().setLayout(null);
		
		tbCheckIn = new JTextField();
		tbCheckIn.setBounds(20, 90, 86, 20);
		bookingadd.getContentPane().add(tbCheckIn);
		tbCheckIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Time of check in:");
		lblNewLabel.setBounds(20, 65, 124, 14);
		bookingadd.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time of check out:");
		lblNewLabel_1.setBounds(260, 65, 135, 14);
		bookingadd.getContentPane().add(lblNewLabel_1);
		
		tbCheckOut = new JTextField();
		tbCheckOut.setBounds(260, 90, 86, 20);
		bookingadd.getContentPane().add(tbCheckOut);
		tbCheckOut.setColumns(10);
		
		tbPrice = new JTextField();
		tbPrice.setBounds(140, 150, 86, 20);
		bookingadd.getContentPane().add(tbPrice);
		tbPrice.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Price($):");
		lblNewLabel_2.setBounds(140, 125, 86, 14);
		bookingadd.getContentPane().add(lblNewLabel_2);
		
		JButton btnBackButton = new JButton("Back \u23CE");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				back();

			}
		});
		btnBackButton.setBounds(260, 195, 89, 23);
		bookingadd.getContentPane().add(btnBackButton);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(tbCheckIn.getText().equals("")||tbCheckOut.getText().equals("")||tbPrice.getText().equals("")) {  //Checks if any of the user inputs are empty
					
					JOptionPane.showMessageDialog(btnAdd, "Please input all required data");
					
					Record = false;
				}
				else {
					
					//stores all user input in String array
					pullData = data(tbCheckIn.getText(), tbCheckOut.getText(), tbPrice.getText());
					
					//System.out.println(pullData[1]);
					
					JOptionPane.showMessageDialog(btnAdd, "Record added");
					
					Record = true;
					
					cmd = e.getActionCommand();
					
					count = 0;
										
					back();
									
					
					
					
					
				
				}
				
						
				
				
			}
		});
		btnAdd.setBounds(17, 195, 89, 23);
		bookingadd.getContentPane().add(btnAdd);
	}
}
