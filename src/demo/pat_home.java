package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pat_home {

	private JFrame frame;
	private JButton profile;
	private JButton new_appointment;
	private JButton logout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pat_home window = new pat_home();
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
	public pat_home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 862, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setBounds(310, 50, 156, 109);
		frame.getContentPane().add(lblNewLabel);
		
		logout = new JButton("LogOut");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutActionPerformed(e);
			}
		});
		logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logout.setBounds(659, 50, 128, 33);
		frame.getContentPane().add(logout);
		
		profile = new JButton("Profile");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profileActionPerformed(e);
			}
		});
		profile.setBounds(69, 310, 89, 41);
		frame.getContentPane().add(profile);
		
		new_appointment = new JButton("New Appointment");
		new_appointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_appointmentActionPerformed(e);
			}
		});
		new_appointment.setBounds(192, 310, 135, 41);
		frame.getContentPane().add(new_appointment);
	}

	private void profileActionPerformed(ActionEvent e)
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
	private void new_appointmentActionPerformed(ActionEvent e)
	{
		
	}
	public void setVisible(boolean b) {
		frame.setVisible(true);
		
	}

}
