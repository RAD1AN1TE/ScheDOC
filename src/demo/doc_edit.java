package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class doc_edit {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doc_edit window = new doc_edit();
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
	public doc_edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(241, 32, 320, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JButton logout = new JButton("LogOut");
		logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logout.setBounds(538, 108, 115, 33);
		frame.getContentPane().add(logout);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(108, 188, 139, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText((String) null);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(362, 188, 245, 34);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(108, 279, 139, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JComboBox<String> Gender = new JComboBox<String>();
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Gender.setEditable(true);
		Gender.setBounds(362, 271, 245, 34);
		frame.getContentPane().add(Gender);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Blood Group");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_2.setBounds(108, 372, 139, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		JComboBox<String> Bloodg = new JComboBox<String>();
		Bloodg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Bloodg.setEditable(true);
		Bloodg.setBounds(362, 364, 245, 34);
		frame.getContentPane().add(Bloodg);
		
		JToggleButton submit = new JToggleButton("Submit");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.setBounds(362, 487, 245, 34);
		frame.getContentPane().add(submit);
		
		JButton password_change = new JButton("Change Password");
		password_change.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password_change.setBounds(64, 487, 229, 33);
		frame.getContentPane().add(password_change);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(77, 97, 97, 33);
		frame.getContentPane().add(back);
	}

}
