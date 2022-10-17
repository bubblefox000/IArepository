package ui;


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

import connections.SqliteLoginConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage {
	

	private JFrame frame;
	private JPasswordField tbPassword;
	private JTextField tbUsername;

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
		connection = SqliteLoginConnection.dbConnector();
	
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
			
				
			   try {
				 
				   //Query fetches the data from the Database
				   String query="select * from LoginData where username=? and password=? ";
				   PreparedStatement pst=connection.prepareStatement(query);
				   pst.setString(1, tbUsername.getText());
				   pst.setString(2, tbPassword.getText());
				   
				   ResultSet rs = pst.executeQuery();
				   int count = 0;
				   while (rs.next()) {
					   count = count+1;
					   
					//if the result is 1 that means the username and password is correct, if greater than one that means there is a duplicate 
					
				}
				   if (count == 1 ) {
					   JOptionPane.showMessageDialog(null, "Username and password is correct");
					   
					   frame.dispose();   //removes old frame
					   
					   MainPage mainpage = new MainPage();    //makes mainpage frame visible
					   mainpage.mainpage.setVisible(true);
					   					   
					   }
				   else if(count > 1){
					   
					   JOptionPane.showMessageDialog(null, "Duplicate Username and password");					   					 				
				}
				   else {
					      JOptionPane.showMessageDialog(btnLogin, "Username or password is not correct");
					   }
				   //closes the connection with the database for future use
				   rs.close();
				   pst.close();
				
				   
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			 
			
				
			}
		});
		btnLogin.setBounds(155, 196, 88, 23);
		frame.getContentPane().add(btnLogin);
		
		
		
		
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
		
		tbUsername = new JTextField();
		tbUsername.setBounds(140, 85, 123, 20);
		frame.getContentPane().add(tbUsername);
		tbUsername.setColumns(10);
	}
		}

