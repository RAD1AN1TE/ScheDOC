package demo;

import java.awt.Color;
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
import java.awt.Toolkit;

public class doc_signup {
	
	public static String username1;
	public static String password1;
	public static String password2;
	public static String gender;
	public static String specialization;
	public static String name;
	public static String email;
	public static String contact;
	public static String city;
	public static String hospital;
	
	int u1 = 1;
	int u2 = 0;
	int p = 0;
	int g = 0;
	int s = 0;
	int c = 0;
	
	
	

	private JFrame frmDoctorSignUp;
	private JTextField username;
	private JPasswordField pass1;
	private JTextField pass2;
	private JComboBox<String> Gender;
	private JComboBox<String> Specialization;
	private JButton submit;
	private JTextField Name;
	private JTextField Email;
	private JLabel lblContact;
	private JTextField Contact;
	private JTextField Hospital;
	private JTextField City;
	private JLabel labelName_2;
	private JLabel labelName_3;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doc_signup window = new doc_signup();
					window.frmDoctorSignUp.setVisible(true);
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
		frmDoctorSignUp = new JFrame();
		frmDoctorSignUp.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chand\\eclipse-workspace\\demo\\Images\\stethoscope.png"));
		frmDoctorSignUp.setTitle("Doctor Sign Up");
		frmDoctorSignUp.setBounds(100, 100, 655, 947);
		frmDoctorSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDoctorSignUp.getContentPane().setLayout(null);
		frmDoctorSignUp.getContentPane().setBackground( Color.decode("#e6f5f3") );
		
		JLabel lblNewLabel = new JLabel("Doctor SignUp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(191, 49, 207, 42);
		frmDoctorSignUp.getContentPane().add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.setBackground(Color.decode("#f5f3e6"));
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog_signup ds = new dialog_signup();
				frmDoctorSignUp.dispose();
				ds.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(30, 49, 97, 33);
		frmDoctorSignUp.getContentPane().add(back);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(87, 150, 162, 25);
		frmDoctorSignUp.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameActionPerformed(e);
			}
		});
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setColumns(10);
		username.setBounds(280, 149, 217, 30);
		frmDoctorSignUp.getContentPane().add(username);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(87, 220, 162, 25);
		frmDoctorSignUp.getContentPane().add(lblNewLabel_1_1);
		
		pass1 = new JPasswordField();
		pass1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass1ActionPerformed(e);
			}
		});
		pass1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass1.setBounds(280, 220, 217, 30);
		frmDoctorSignUp.getContentPane().add(pass1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(87, 290, 162, 25);
		frmDoctorSignUp.getContentPane().add(lblNewLabel_1_2);
		
		pass2 = new JTextField();
		pass2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass2ActionPerformed(e);
			}
		});
		pass2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass2.setColumns(10);
		pass2.setBounds(280, 290, 217, 30);
		frmDoctorSignUp.getContentPane().add(pass2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(87, 500, 162, 25);
		frmDoctorSignUp.getContentPane().add(lblNewLabel_1_4);
		
		Gender = new JComboBox<String>();
		Gender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenderActionPerformed(e);
			}
		});
		Gender.setModel(new DefaultComboBoxModel<>(new String[] {"", "Male", "Female"}));
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Gender.setBounds(280, 500, 217, 30);
		frmDoctorSignUp.getContentPane().add(Gender);
		
		JLabel lblNewLabel_1_3 = new JLabel("Specialization");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(87, 570, 162, 25);
		frmDoctorSignUp.getContentPane().add(lblNewLabel_1_3);
		
		Specialization = new JComboBox<String>();
		Specialization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpecializationActionPerformed(e);
			}
		});
		Specialization.setModel(new DefaultComboBoxModel<>(new String[] {"Cardiologist", "Gastroenterologist", "Neurologist", "Ophthalmologist", "Otolaryngologist", "Pulmonologist"}));
		Specialization.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Specialization.setBounds(280, 570, 217, 30);
		frmDoctorSignUp.getContentPane().add(Specialization);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.setBackground(Color.decode("#f5f3e6"));
		submit.setFocusable(false);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitActionPerformed(e);
			}
		});
		submit.setBounds(280, 850, 217, 47);
		frmDoctorSignUp.getContentPane().add(submit);
		
		JLabel labelName = new JLabel("Last Name");
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelName.setBounds(87, 360, 162, 25);
		frmDoctorSignUp.getContentPane().add(labelName);
		
		Name = new JTextField();
		Name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameActionPerformed(e);
			}
		});
		Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Name.setColumns(10);
		Name.setBounds(280, 360, 217, 30);
		frmDoctorSignUp.getContentPane().add(Name);
		
		Email = new JTextField();
		Email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailActionPerformed(e);
			}
		});
		Email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Email.setColumns(10);
		Email.setBounds(280, 430, 217, 30);
		frmDoctorSignUp.getContentPane().add(Email);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Email ID");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5_1.setBounds(87, 430, 162, 25);
		frmDoctorSignUp.getContentPane().add(lblNewLabel_1_5_1);
		
		lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContact.setBounds(87, 640, 162, 25);
		frmDoctorSignUp.getContentPane().add(lblContact);
		
		Contact = new JTextField();
		Contact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactActionPerformed(e);
			}
		});
		Contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Contact.setColumns(10);
		Contact.setBounds(280, 640, 217, 30);
		frmDoctorSignUp.getContentPane().add(Contact);
		
		Hospital = new JTextField();
		Hospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospitalActionPerformed(e);
			}
		});
		Hospital.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Hospital.setColumns(10);
		Hospital.setBounds(280, 710, 217, 30);
		frmDoctorSignUp.getContentPane().add(Hospital);
		
		City = new JTextField();
		City.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CityActionPerformed(e);
			}
		});
		City.setFont(new Font("Tahoma", Font.PLAIN, 20));
		City.setColumns(10);
		City.setBounds(280, 780, 217, 30);
		frmDoctorSignUp.getContentPane().add(City);
		
		labelName_2 = new JLabel("Hospital Name");
		labelName_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelName_2.setBounds(87, 710, 162, 25);
		frmDoctorSignUp.getContentPane().add(labelName_2);
		
		labelName_3 = new JLabel("City");
		labelName_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelName_3.setBounds(87, 780, 162, 25);
		frmDoctorSignUp.getContentPane().add(labelName_3);
		
		lblNewLabel_2 = new JLabel("( This will be your Username )");
		lblNewLabel_2.setBounds(64, 175, 185, 14);
		frmDoctorSignUp.getContentPane().add(lblNewLabel_2);
	}
	private void submitActionPerformed(ActionEvent e)
	 {
		 usernameActionPerformed(e);
		 pass1ActionPerformed(e);
		 pass2ActionPerformed(e);
		 NameActionPerformed(e);
		 EmailActionPerformed(e);
		 GenderActionPerformed(e);
		 SpecializationActionPerformed(e);
		 ContactActionPerformed(e);
		 CityActionPerformed(e);
		 HospitalActionPerformed(e);
		
		 
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alien","root","pavanitej");
				PreparedStatement st = con.prepareStatement("insert into doc(username,password,field,gender,name,email,contact,hospital,city) values(?,?,?,?,?,?,?,?,?)");
				
				if(u1==0)
				{
					JOptionPane.showMessageDialog(frmDoctorSignUp, "Username already exists");
				} 
				if(u2==2)
				{
					JOptionPane.showMessageDialog(frmDoctorSignUp, "Enter Valid Username");
				}
				if(p==0)
				{
					JOptionPane.showMessageDialog(frmDoctorSignUp, "Entered password do not match");
				}
				if(g==0)
				{
					JOptionPane.showMessageDialog(frmDoctorSignUp, "Select gender");
				}
				if(s==0)
				{
					JOptionPane.showMessageDialog(frmDoctorSignUp, "Select Specialization");
				}
				if(c==0)
				{
					JOptionPane.showMessageDialog(frmDoctorSignUp, "Invalid mobile number");
				}
				
				if(u1==1&&p==1&&g==1&&s==1&&c==1)
				{
					st.setString(1, username1);
					st.setString(2, password1);
					st.setString(3, specialization);
					st.setString(4, gender);
					st.setString(5, name);
					st.setString(6, email);
					st.setString(7, contact);
					st.setString(8, hospital);
					st.setString(9, city);
					
					st.executeUpdate();
					//JOptionPane.showMessageDialog(frame, username1+" Registered Successfully");
					doc_login docl = new doc_login();
					frmDoctorSignUp.dispose();
					docl.setVisible(true);
					
				}	
				else
				{
					JOptionPane.showMessageDialog(frmDoctorSignUp, username1+", Registration Unsuccessful");
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
	 private void NameActionPerformed(ActionEvent e)
	 {
		 name = Name.getText();
	 }
	 private void EmailActionPerformed(ActionEvent e)
	 {
		 email = Email.getText();
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
	 private void HospitalActionPerformed(ActionEvent e)
	 {
		 hospital = Hospital.getText();
	 }

	public void setVisible(boolean b) {
		frmDoctorSignUp.setVisible(b);
		
	}
}