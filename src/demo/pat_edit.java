package demo;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class pat_edit {
	
	public String user1;
	int u = 0;
	public static String age;
	public static String gender;
	public static String bloodg1;
	public static String contact;
	public static String city;
	int c = 0;
	int g = 0;
	int b = 0;
	
	

	private JFrame frame;
	private JTextField username;
	private JTextField Age;
	private JTextField Contact;
	private JTextField City;
	private JComboBox<String> Gender;
	private JComboBox<String> Bloodg;
	private JToggleButton submit;
	private JButton logout;
	private JButton back;
	private JButton password_change;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pat_edit window = new pat_edit();
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
	public pat_edit() {
		initialize();
		user1 = "pat1";   
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alien","root","pavanitej");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from pat where username = '"+user1+"'");
			rs.next();                                     ///Need to implement while loop for rs.next(); check availability.java
			username.setText(rs.getString(1));
			Age.setText(rs.getString(3));
			Gender.setSelectedItem(rs.getString(4));
			Bloodg.setSelectedItem(rs.getString(5));
			Contact.setText(rs.getString(6));
			City.setText(rs.getString(7));
			
			
			logout = new JButton("LogOut");
			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logoutActionPerformed(e);
				}
			});
			logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
			logout.setBounds(618, 50, 115, 33);
			frame.getContentPane().add(logout);
			
			back = new JButton("Back");
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backActionPerformed(e);
				}
			});
			back.setFont(new Font("Tahoma", Font.PLAIN, 20));
			back.setBounds(34, 50, 97, 33);
			frame.getContentPane().add(back);
			
			password_change = new JButton("Change Password");
			password_change.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					password_changeActionPerformed(e);
				}
			});
			password_change.setFont(new Font("Tahoma", Font.PLAIN, 20));
			password_change.setBounds(110, 768, 229, 33);
			frame.getContentPane().add(password_change);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 822, 911);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(197, 22, 320, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(110, 156, 139, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setEditable(false);
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(375, 149, 245, 34);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(110, 243, 139, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		Age = new JTextField();
		Age.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgeActionPerformed(e);
			}
		});
		Age.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Age.setColumns(10);
		Age.setBounds(375, 240, 245, 34);
		frame.getContentPane().add(Age);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(110, 336, 139, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		Contact = new JTextField();
		Contact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactActionPerformed(e);
			}
		});
		Contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Contact.setColumns(10);
		Contact.setBounds(375, 333, 245, 34);
		frame.getContentPane().add(Contact);
		
		City = new JTextField();
		City.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CityActionPerformed(e);
			}
		});
		City.setFont(new Font("Tahoma", Font.PLAIN, 20));
		City.setColumns(10);
		City.setBounds(375, 428, 245, 34);
		frame.getContentPane().add(City);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("City");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(110, 441, 139, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(110, 546, 139, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Blood Group");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_2.setBounds(110, 644, 139, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		Gender = new JComboBox<>();
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Gender.setModel(new DefaultComboBoxModel<>(new String[] {"", "Male", "Female"}));
		Gender.setEditable(true);
		Gender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenderActionPerformed(e);
			}
		});
		Gender.setBounds(375, 546, 245, 34);
		frame.getContentPane().add(Gender);
		
		Bloodg = new JComboBox<>();
		Bloodg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Bloodg.setModel(new DefaultComboBoxModel<>(new String[] {"", "A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"}));
		Bloodg.setEditable(true);
		Bloodg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BloodgActionPerformed(e);
			}
		});
		Bloodg.setBounds(375, 644, 245, 34);
		frame.getContentPane().add(Bloodg);
		
		submit = new JToggleButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitActionPerformed(e);
			}
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.setBounds(415, 767, 245, 34);
		frame.getContentPane().add(submit);
	}
	private void submitActionPerformed(ActionEvent e)
	{
		 AgeActionPerformed(e);
		 BloodgActionPerformed(e);
		 GenderActionPerformed(e);
		 ContactActionPerformed(e);
		 CityActionPerformed(e);
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alien","root","pavanitej");
				Statement st = con.createStatement();
				
				if(g==0)
				{
					JOptionPane.showMessageDialog(frame, "Select gender");
				}
				if(b==0)
				{
					JOptionPane.showMessageDialog(frame, "Select blood group");
				}
				if(c==0)
				{
					JOptionPane.showMessageDialog(frame, "Invalid mobile number");
				}
				
				if(c==1&&g==1&&b==1)
				{
					
					st.executeUpdate("update pat set age = '"+age+"',gender='"+gender+"',bloodg='"+bloodg1+"',contact='"+contact+"',city='"+city+"' where username = '"+user1+"'");
					JOptionPane.showMessageDialog(frame,"Changed Successfully");
				}	
				else
				{
					JOptionPane.showMessageDialog(frame, "Changed Unsuccessful");
				}
					st.close();
					con.close();
										
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
	}
	private void AgeActionPerformed(ActionEvent e)
	{
		age = Age.getText();
	}
	private void GenderActionPerformed(ActionEvent e)
	{
		 gender = (String)Gender.getSelectedItem();
			if(gender.length()!=0)
			{
				g = 1;  // Select gender
			} 
	}
	private void BloodgActionPerformed(ActionEvent e)
	{
		bloodg1 = (String)Bloodg.getSelectedItem();
		if(bloodg1.length()!=0)
		{
			b = 1;  // Select gender
		} 
	}
	private void ContactActionPerformed(ActionEvent e)
	{
		contact = Contact.getText();
		if (contact.length()==10)
		{
			c = 1;   // Contact number valid
		}
	}
	private void CityActionPerformed(ActionEvent e)
	{
		city = City.getText();
	}
	private void password_changeActionPerformed(ActionEvent e)
	{
		pat_forgot pf = new pat_forgot();
		frame.dispose();
		pf.setVisible(true);
	}
	private void logoutActionPerformed(ActionEvent e)
	{
		home h = new home();
		frame.dispose();
		h.setVisible(true);
	}
	private void backActionPerformed(ActionEvent e)
	{
		pat_home ph = new pat_home();
		frame.dispose();
		ph.setVisible(true);
	}

	public void setVisible(boolean d) {
		frame.setVisible(true);
	}
	
}
