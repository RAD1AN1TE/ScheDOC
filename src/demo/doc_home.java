package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class doc_home {

	private JFrame frame;
	private JButton available;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doc_home window = new doc_home();
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
	public doc_home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton logout = new JButton("LogOut");
		logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logout.setBounds(481, 55, 128, 33);
		frame.getContentPane().add(logout);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setBounds(254, 44, 156, 109);
		frame.getContentPane().add(lblNewLabel);
		
		JButton profile = new JButton("Profile");
		profile.setBounds(90, 277, 89, 41);
		frame.getContentPane().add(profile);
		
		available = new JButton("Availability");
		available.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				availableActionPerformed(e);
			}
		});
		available.setBounds(238, 277, 89, 41);
		frame.getContentPane().add(available);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	private void availableActionPerformed(ActionEvent e)
	{
		availability doca = new availability();
		frame.dispose();
		doca.setVisible(true);
	}

}
