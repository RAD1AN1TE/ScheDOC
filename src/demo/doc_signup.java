package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class doc_signup {
	
	public static String username1;
	public static String password1;
	public static String password2;
	public static String gender;
	public static String specialization;
	int u1 = 1;
	int u2 = 0;
	int p = 0;
	int g = 0;
	int s = 0;
	
	
	

	private JFrame frame;
	private JTextField username;
	private JPasswordField pass1;
	private JTextField pass2;
	private JComboBox<String> Gender;
	private JComboBox<String> Specialization;
	private JToggleButton submit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doc_signup window = new doc_signup();
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
	public doc_signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SignUp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(313, 65, 115, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(30, 49, 97, 33);
		frame.getContentPane().add(back);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(87, 166, 162, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameActionPerformed(e);
			}
		});
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setColumns(10);
		username.setBounds(280, 166, 217, 23);
		frame.getContentPane().add(username);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(87, 220, 162, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		pass1 = new JPasswordField();
		pass1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass1ActionPerformed(e);
			}
		});
		pass1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass1.setBounds(280, 221, 217, 23);
		frame.getContentPane().add(pass1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(87, 272, 162, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		pass2 = new JTextField();
		pass2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass2ActionPerformed(e);
			}
		});
		pass2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass2.setColumns(10);
		pass2.setBounds(280, 273, 217, 23);
		frame.getContentPane().add(pass2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(87, 332, 162, 25);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		Gender = new JComboBox<String>();
		Gender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenderActionPerformed(e);
			}
		});
		Gender.setModel(new DefaultComboBoxModel<>(new String[] {"", "Male", "Female"}));
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Gender.setBounds(280, 333, 217, 22);
		frame.getContentPane().add(Gender);
		
		JLabel lblNewLabel_1_3 = new JLabel("Specialization");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(87, 388, 162, 25);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		Specialization = new JComboBox<String>();
		Specialization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpecializationActionPerformed(e);
			}
		});
		Specialization.setModel(new DefaultComboBoxModel<>(new String[] {"", "Cardiologist", "Gastroenterologist", "Neurologist", "Ophthalmologist", "Otolaryngologist", "Pulmonologist"}));
		Specialization.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Specialization.setBounds(280, 389, 217, 22);
		frame.getContentPane().add(Specialization);
		
		submit = new JToggleButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitActionPerformed(e);
			}
		});
		submit.setBounds(177, 554, 121, 23);
		frame.getContentPane().add(submit);
	}
	private void submitActionPerformed(ActionEvent e)
	 {
		 usernameActionPerformed(e);
		 pass1ActionPerformed(e);
		 pass2ActionPerformed(e);		 
		 GenderActionPerformed(e);
		 SpecializationActionPerformed(e);
		
		 
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alien","root","pavanitej");
				PreparedStatement st = con.prepareStatement("insert into doc(username,password,field,gender) values(?,?,?,?)");
				
				if(u1==0)
				{
					JOptionPane.showMessageDialog(frame, "Username already exists");
				} 
				if(u2==2)
				{
					JOptionPane.showMessageDialog(frame, "Enter Valid Username");
				}
				if(p==0)
				{
					JOptionPane.showMessageDialog(frame, "Entered password do not match");
				}
				if(g==0)
				{
					JOptionPane.showMessageDialog(frame, "Select gender");
				}
				if(s==0)
				{
					JOptionPane.showMessageDialog(frame, "Select Specialization");
				}
				
				if(u1==1&&p==1&&g==1&&s==1)
				{
					st.setString(1, username1);
					st.setString(2, password1);
					st.setString(3, specialization);
					st.setString(4, gender);
					st.executeUpdate();
					//JOptionPane.showMessageDialog(frame, username1+" Registered Successfully");
					doc_login docl = new doc_login();
					frame.dispose();
					docl.setVisible(true);
					
				}	
				else
				{
					JOptionPane.showMessageDialog(frame, username1+", Registration Unsuccessful");
				}
					st.close();
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
				ResultSet rs = st.executeQuery("select * from doc");
				while(rs.next())
				{
					if (username1.equals(rs.getString(1)))
					{
						u1 = 0;  // User_name Exists
					}
				}
				int k = username1.length();
				int l = 0;
				for(int i=0; i<k; i++)
				{
					if(username1.charAt(i)>=48&&username1.charAt(i)<=57)
					{
						l++;
					}

				}
				if (l==k)
				{
					u2 = 0;  // Enter a valid User_name	
				}
				else
				{
					u2 = 1;  // No errors
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
			if (password1.equals(password2))
			{
				p = 1;  // Passwords matches
			}
	 }
	
	 private void GenderActionPerformed(ActionEvent e)
	 {
		 gender = (String)Gender.getSelectedItem();
			if(gender.length()!=0)
			{
				g = 1;  // Select gender
			} 
	 }
	 private void SpecializationActionPerformed(ActionEvent e)
	 {
		 specialization = (String)Specialization.getSelectedItem();
			if(specialization.length()!=0)
			{
				s = 1;  // Select specialization
			} 
		 	 
	 }

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
	
}
