package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dialog_signup {

	private JFrame frame;
	private JButton pat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialog_signup window = new dialog_signup();
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
	public dialog_signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 162);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Doctor");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(53, 47, 114, 47);
		frame.getContentPane().add(btnNewButton);
		
		pat = new JButton("Patient");
		pat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patActionPerformed(e);
			}
		});
		pat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pat.setBounds(271, 47, 114, 47);
		frame.getContentPane().add(pat);
		
		JLabel lblNewLabel = new JLabel("Are you?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(192, 11, 76, 27);
		frame.getContentPane().add(lblNewLabel);
	}
	private void patActionPerformed(ActionEvent e)
	{
		pat_signup ps = new pat_signup();
		//home h = new home();
		//h.dispose();
		frame.dispose();		
		ps.setVisible(true);
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
		
	}
}
