package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dialog_login {

	private JFrame frame;
	private JButton pat;
	private JButton doc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialog_login window = new dialog_login();
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
	public dialog_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		doc = new JButton("Doctor");
		doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				docActionPerformed(e);
			}
		});
		doc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		doc.setBounds(60, 43, 114, 47);
		frame.getContentPane().add(doc);
		
		pat = new JButton("Patient");
		pat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patActionPerformed(e);
			}
		});
		pat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pat.setBounds(256, 43, 114, 47);
		frame.getContentPane().add(pat);
		
		JLabel lblNewLabel = new JLabel("Are you?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(188, 11, 74, 21);
		frame.getContentPane().add(lblNewLabel);
	}
	private void patActionPerformed(ActionEvent e)
	{
		pat_login pl = new pat_login();
		//home h = new home();
		//h.setVisible(false);
		frame.dispose();		
		pl.setVisible(true);
	}
	private void docActionPerformed(ActionEvent e)
	{
		doc_login docl = new doc_login();
		//home h = new home();
		//h.setVisible(false);
		frame.dispose();		
		docl.setVisible(true);
	}
	

	public void setVisible(boolean b) {
		frame.setVisible(true);
		
	}
}
