package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class doc_login {
	public static String username1;
	public static String password1;
	public static String user;
	public static String pass;
	int u = 0;

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private JToggleButton submit;
	private JToggleButton forgot;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doc_login window = new doc_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public doc_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(241, 68, 87, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userLabel.setBounds(67, 206, 153, 25);
		frame.getContentPane().add(userLabel);
		
		username = new JTextField();
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameActionPerformed(e);
			}
		});
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setColumns(10);
		username.setBounds(366, 206, 165, 25);
		frame.getContentPane().add(username);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passLabel.setBounds(67, 341, 153, 25);
		frame.getContentPane().add(passLabel);
		
		password = new JPasswordField();
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordActionPerformed(e);
			}
		});
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(366, 341, 165, 25);
		frame.getContentPane().add(password);
		
		forgot = new JToggleButton("Forgot Password");
		forgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forgotActionPerformed(e);
			}
		});
		forgot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		forgot.setBounds(44, 454, 195, 38);
		frame.getContentPane().add(forgot);
		
		submit = new JToggleButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitActionPerformed(e);
			}
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.setBounds(366, 454, 121, 38);
		frame.getContentPane().add(submit);
	}
	private void submitActionPerformed(ActionEvent e)
	{
		usernameActionPerformed(e);
		passwordActionPerformed(e);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alien","root","pavanitej");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from doc");
			while (rs.next())
			{
				user = rs.getString(1);
				pass = rs.getString(2);
				if (user.equals(username1)&&pass.equals(password1))
				{
					JOptionPane.showMessageDialog(frame,username1+", Logged In successfully");
					u = 1;
					doc_home doch = new doc_home();
					frame.dispose();
					doch.setVisible(true);
				}
				
			}
			if(u==0)
			{
				JOptionPane.showMessageDialog(frame, "Username or Password is Incorrect");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
				
	}
	
	private void usernameActionPerformed(ActionEvent e)
	{
		username1 = username.getText();
	}
	@SuppressWarnings("deprecation")
	private void passwordActionPerformed(ActionEvent e)
	{
		password1 = password.getText();
	}
	private void forgotActionPerformed(ActionEvent e)
	{
		
	}
	public void setVisible(boolean b) {
		frame.setVisible(true);
	}

}
