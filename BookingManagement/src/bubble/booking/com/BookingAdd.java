package bubble.booking.com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingAdd {

	public static JFrame bookingadd;
	private JTextField tbCheckIn;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnAdd;

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
		
		textField_1 = new JTextField();
		textField_1.setBounds(260, 90, 86, 20);
		bookingadd.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 150, 86, 20);
		bookingadd.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Price($):");
		lblNewLabel_2.setBounds(140, 125, 86, 14);
		bookingadd.getContentPane().add(lblNewLabel_2);
		
		JButton btnBackButton = new JButton("Back \u23CE");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bookingadd.dispose();
				
				MainPage mainpage = new MainPage();
				
				MainPage.mainpage.setVisible(true);

			}
		});
		btnBackButton.setBounds(260, 195, 89, 23);
		bookingadd.getContentPane().add(btnBackButton);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String checkin = tbCheckIn.getText(); // gets the time of check in
				
				
				
			}
		});
		btnAdd.setBounds(17, 195, 89, 23);
		bookingadd.getContentPane().add(btnAdd);
	}
}
