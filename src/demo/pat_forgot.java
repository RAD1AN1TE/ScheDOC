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
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JButton;
public class pat_forgot {
	
	public static String username1;
	public static String password1;
	public static String password2;
	int p = 0;
	int u = 0;
	
	
	

	private JFrame frame;
	private JTextField pass2;
	private JTextField username;
	private JPasswordField pass1;
	private JToggleButton submit;
	private JButton logout;
	private JButton back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pat_forgot window = new pat_forgot();
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
	public pat_forgot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change or Forgot Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(129, 78, 342, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(113, 165, 103, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(113, 246, 103, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(113, 322, 169, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		pass2 = new JTextField();
		pass2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass2ActionPerformed(e);
			}
		});
		pass2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass2.setBounds(351, 322, 169, 25);
		frame.getContentPane().add(pass2);
		pass2.setColumns(10);
		
		username = new JTextField();
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameActionPerformed(e);
			}
		});
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setColumns(10);
		username.setBounds(351, 165, 169, 25);
		frame.getContentPane().add(username);
		
		pass1 = new JPasswordField();
		pass1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass1ActionPerformed(e);
			}
		});
		pass1.setBounds(351, 241, 169, 25);
		frame.getContentPane().add(pass1);
		
		submit = new JToggleButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitActionPerformed(e);
			}
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.setBounds(382, 433, 121, 33);
		frame.getContentPane().add(submit);
		
		logout = new JButton("LogOut");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutActionPerformed(e);
			}
		});
		logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logout.setBounds(459, 34, 126, 33);
		frame.getContentPane().add(logout);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(28, 34, 115, 33);
		frame.getContentPane().add(back);
	}
	private void submitActionPerformed(ActionEvent e)
	{
		usernameActionPerformed(e);
		pass1ActionPerformed(e);
		pass2ActionPerformed(e);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alien","root","pavanitej");
			Statement st = con.createStatement();
			
			if(u==1 && p==1)
			{
				st.executeUpdate("update pat set password='"+password2+"' where username='"+username1+"'");
				JOptionPane.showMessageDialog(frame,"Password updated successfully");
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Error");
			}
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}		
	}
	private void usernameActionPerformed(ActionEvent e)
	{
		username1 = username.getText();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alien","root","pavanitej");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from pat");
			while(rs.next())
			{
				if (username1.equals(rs.getString(1)))
				{
					u = 1;  // User existed
				}
			}
			if(u==0)  // User does not exist
			{
				JOptionPane.showMessageDialog(frame, "User does not exists");
			}
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	@SuppressWarnings("deprecation")
	private void pass1ActionPerformed(ActionEvent e)
	{
		password1 = pass1.getText();
	}
	private void pass2ActionPerformed(ActionEvent e)
	{
		password2 = pass2.getText();
		if(password2.equals(password1))
		{
			p = 1; // passwords matches
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Passwords do not match");
		}
	}
	private void backActionPerformed(ActionEvent e)
	{
		pat_edit pe = new pat_edit();
		frame.dispose();
		pe.setVisible(true);
	}
	private void logoutActionPerformed(ActionEvent e)
	{
		home h = new home();
		frame.dispose();
		h.setVisible(true);
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
	}

}
