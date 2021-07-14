package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class home {

	private JFrame frame;
	private JButton login;
	private JButton signup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
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
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1123, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		login = new JButton("Login");
		login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		login.setBounds(239, 372, 203, 50);
		frame.getContentPane().add(login);
		
		JLabel lblNewLabel_1 = new JLabel("ScheDOC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(428, 43, 170, 105);
		frame.getContentPane().add(lblNewLabel_1);
		
		signup = new JButton("SignUp");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signupActionPerformed(e);
			}
		});
		signup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signup.setBounds(738, 372, 203, 50);
		frame.getContentPane().add(signup);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
	}

	public void dispose() {
		frame.dispose();
	}

	public void setVisible(boolean b)
	{
		frame.setVisible(b);
	}
	private void signupActionPerformed(ActionEvent e)
	{
		dialog_signup ds = new dialog_signup();
		frame.dispose();
		ds.setVisible(true);
	}
	private void loginActionPerformed(ActionEvent e)
	{
		dialog_login dl = new dialog_login();
		frame.dispose();
		dl.setVisible(true);
	}

}