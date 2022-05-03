package bubble.booking.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainPage {

	public static JFrame mainpage;     //must be public for access from LoginPage

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
		mainpage.setBounds(100, 100, 450, 300);
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
		btnNewReservation.setBounds(10, 227, 187, 23);
		mainpage.getContentPane().add(btnNewReservation);
		
		JButton btnNewButton_1 = new JButton("delete reservation");
		btnNewButton_1.setBounds(237, 227, 187, 23);
		mainpage.getContentPane().add(btnNewButton_1);
		
	
	}
}
