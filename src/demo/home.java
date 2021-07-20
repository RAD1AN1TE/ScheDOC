package demo;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class home {

	private JFrame frmSchedoc;
	private JButton login;
	private JButton signup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UIManager.put("ToggleButton.select", new ColorUIResource( Color.GREEN ));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frmSchedoc.setVisible(true);
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
		frmSchedoc = new JFrame();
		frmSchedoc.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chand\\eclipse-workspace\\demo\\Images\\stethoscope.png"));
		frmSchedoc.setTitle("ScheDOC\r\n");
		frmSchedoc.setBounds(100, 100, 650, 600);
		frmSchedoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSchedoc.getContentPane().setLayout(null);
		frmSchedoc.getContentPane().setBackground( Color.decode("#f5f3e6") );
		
		login = new JButton("Login");
		login.setBackground(Color.decode("#f3e6f5"));
		login.setFocusable(false);
		
		login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		login.setBounds(73, 393, 203, 50);
		frmSchedoc.getContentPane().add(login);
		
		JLabel lblNewLabel_1 = new JLabel("Sche");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(150, 92, 162, 105);
		frmSchedoc.getContentPane().add(lblNewLabel_1);
		
		signup = new JButton("SignUp");
		signup.setBackground(Color.decode("#e6f5f3"));
		signup.setFocusable(false);
		
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signupActionPerformed(e);
			}
		});
		signup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signup.setBounds(357, 393, 203, 50);
		frmSchedoc.getContentPane().add(signup);
		
		JLabel lblNewLabel_2 = new JLabel("DOC\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel_2.setBounds(344, 92, 154, 105);
		frmSchedoc.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\chand\\eclipse-workspace\\demo\\Images\\stethoscope1.png"));
		lblNewLabel.setBounds(275, 137, 115, 105);
		frmSchedoc.getContentPane().add(lblNewLabel);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
	}

	public void dispose() {
		frmSchedoc.dispose();
	}

	public void setVisible(boolean b)
	{
		frmSchedoc.setVisible(b);
	}
	private void signupActionPerformed(ActionEvent e)
	{
		dialog_signup ds = new dialog_signup();
		frmSchedoc.dispose();
		ds.setVisible(true);
	}
	private void loginActionPerformed(ActionEvent e)
	{
		dialog_login dl = new dialog_login();
		frmSchedoc.dispose();
		dl.setVisible(true);
	}
}