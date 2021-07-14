package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;

public class doctor {

	private JFrame frame;
	private JTextField txtIAmDoctor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctor window = new doctor();
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
	public doctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 944, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtIAmDoctor = new JTextField();
		txtIAmDoctor.setFont(new Font("Tahoma", Font.PLAIN, 28));
		txtIAmDoctor.setText("I am Doctor");
		txtIAmDoctor.setBounds(232, 196, 178, 39);
		frame.getContentPane().add(txtIAmDoctor);
		txtIAmDoctor.setColumns(10);
	}

	public void setVisibile(boolean b) {
		frame.setVisible(true);
		
	}

	
}
