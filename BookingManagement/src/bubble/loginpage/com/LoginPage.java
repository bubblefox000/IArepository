package bubble.loginpage.com;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.Content;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.ToIntBiFunction;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class LoginPage {
	

	private JFrame frame;
	private JPasswordField tbPassword;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
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
	public LoginPage() {
		initialize();
		connection = SqliteConnection.dbConnector();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Successful login!");
				
			   try {
				   
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e);
			}
			
				
			}
		});
		btnLogin.setBounds(75, 195, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(217, 195, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(57, 88, 73, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(57, 138, 73, 14);
		frame.getContentPane().add(lblPassword);
		
		tbPassword = new JPasswordField();
		tbPassword.setEchoChar('*');
		tbPassword.setBounds(140, 135, 123, 20);
		frame.getContentPane().add(tbPassword);
		
		textField = new JTextField();
		textField.setBounds(140, 85, 123, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
		}

