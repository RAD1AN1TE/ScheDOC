package demo;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class confirm_book {
	
	
	public static String username1;
	public static java.util.Date slot;
	public static java.util.Date slot1;
	public static java.util.Date start;
	public static java.util.Date end;
	int present = 0;  //check whether username exists in doc and doc_avail
	int start_time = 0;
	int end_time = 0;
	int num = 0;
	
	
	
	private DateFormat dateFormat;
	private DateFormat dateFormat1;
	private SimpleDateFormat newFormat;
	private JFrame frame;
	private JLabel username;
	private JLabel Specialization;
	private JLabel Gender;
	private JLabel time;
	private JButton submit;
	private ButtonGroup buttonGroup;
	private JToggleButton buttonArr[];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confirm_book window = new confirm_book();
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
	public confirm_book() {
		initialize();
		username1 = "doc1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alien","root","pavanitej");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select doc.*,doc_avail.* from doc,doc_avail where doc_avail.doc_id = '"+username1+"'");
			while(rs.next())
			{
				if(rs.getString(1).equals(username1))
				{
					present = 1;
					break;
				}
			}
			if(present == 1)
			{
				//System.out.println("true1");
				username.setText(rs.getString("username"));
				Specialization.setText(rs.getString("field"));
				Gender.setText(rs.getString("gender"));
				start_time = Integer.valueOf(rs.getString("start"));
				end_time = Integer.valueOf(rs.getString("end"));				
				time.setText(rs.getString("start")+":00 to "+rs.getString("end")+":00");
			}

			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		try {
			start = dateFormat1.parse(String.valueOf(start_time));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			end = dateFormat1.parse(String.valueOf(end_time));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0; i<25; i++)
		{
			try {
				slot1 = dateFormat.parse(buttonArr[i].getText());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			boolean a = slot1.after(start);   // desired is true
			boolean b = slot1.equals(start);  // desired is true
			boolean c = slot1.equals(end);    // desired is true
			boolean d = slot1.before(end);    // desired is true
			
			if(a&&b&&c&&d)
			{
				
			}
	
		}
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 962, 668);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 926, 236);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(55, 41, 63, 31);
		panel.add(lblNewLabel);
		
		JLabel lblSpecialization = new JLabel("Specialization  :");
		lblSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecialization.setBounds(10, 93, 108, 31);
		panel.add(lblSpecialization);
		
		JLabel lblNewLabel_2 = new JLabel("Gender  :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(55, 142, 63, 31);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Timings  :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(41, 194, 77, 31);
		panel.add(lblNewLabel_3);
		
		username = new JLabel("");
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(139, 41, 212, 31);
		panel.add(username);
		
		Specialization = new JLabel("");
		Specialization.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Specialization.setBounds(139, 93, 166, 31);
		panel.add(Specialization);
		
		Gender = new JLabel("");
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Gender.setBounds(139, 142, 166, 31);
		panel.add(Gender);
		
		time = new JLabel("");
		time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		time.setBounds(139, 194, 153, 31);
		panel.add(time);
		
		submit = new JButton("Submit");
		submit.setBounds(673, 64, 165, 85);
		panel.add(submit);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitActionPerformed(e);
			}
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(244, 276, 692, 342);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		GridLayout gl =new GridLayout(5,3,5,20);
        panel_1.setLayout(gl);
        
        JLabel lblMorning = new JLabel("Morning   :");
        lblMorning.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMorning.setBounds(78, 289, 111, 31);
        frame.getContentPane().add(lblMorning);
        
        JLabel lblAfternoon = new JLabel("Afternoon   :");
        lblAfternoon.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAfternoon.setBounds(78, 392, 99, 31);
        frame.getContentPane().add(lblAfternoon);
        
        JLabel lblEvening = new JLabel("Evening   :");
        lblEvening.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEvening.setBounds(89, 496, 99, 31);
        frame.getContentPane().add(lblEvening);
        
        JLabel lblNight = new JLabel("Night   :");
        lblNight.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNight.setBounds(102, 576, 63, 31);
        frame.getContentPane().add(lblNight);
		
		
		dateFormat = new SimpleDateFormat("hh:mm");
		dateFormat1 = new SimpleDateFormat("hh");
		//newFormat = new SimpleDateFormat("hh:mm");
		//String formatedDate = newFormat.format(date);
		
		buttonArr = new JToggleButton[25];
		buttonArr[0] = new JToggleButton("9:00");
		buttonArr[1] = new JToggleButton("9:30");
		buttonArr[2] = new JToggleButton("10:00");
		buttonArr[3] = new JToggleButton("10:30");
		buttonArr[4] = new JToggleButton("11:00");
		buttonArr[5] = new JToggleButton("11:30");
		buttonArr[6] = new JToggleButton("12:00");
		buttonArr[7] = new JToggleButton("12:30");
		buttonArr[8] = new JToggleButton("13:00");
		buttonArr[9] = new JToggleButton("13:30");
		buttonArr[10] = new JToggleButton("14:00");
		buttonArr[11] = new JToggleButton("14:30");
		buttonArr[12] = new JToggleButton("15:00");
		buttonArr[13] = new JToggleButton("15:30");
		buttonArr[14] = new JToggleButton("16:00");
		buttonArr[15] = new JToggleButton("16:30");
		buttonArr[16] = new JToggleButton("17:00");
		buttonArr[17] = new JToggleButton("17:30");
		buttonArr[18] = new JToggleButton("18:00");
		buttonArr[19] = new JToggleButton("18:30");
		buttonArr[20] = new JToggleButton("19:00");
		buttonArr[21] = new JToggleButton("19:30");
		buttonArr[22] = new JToggleButton("20:00");
		buttonArr[23] = new JToggleButton("20:30");
		buttonArr[24] = new JToggleButton("21:00");
		
		for(int i = 0; i < 25; i++) {
            panel_1.add(buttonArr[i]);
		}
		
		buttonGroup = new ButtonGroup();
		for (int i=0; i<25; i++)
		{
			buttonGroup.add(buttonArr[i]);
		}
				
	
	}
	@SuppressWarnings("deprecation")
	private void submitActionPerformed(ActionEvent e)
	{
		//System.out.println(slot);
		for(int i = 0; i<25; i++)
		{
			if(buttonArr[i].isSelected())
			{
				num = i;
				try {
					slot = dateFormat.parse(buttonArr[i].getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		
		//System.out.println(num);
		System.out.println(start);
	//	end.setMinutes(end.getMinutes() - 30);  to perform arithmetic operations
		System.out.println(end);
		System.out.println(slot);
	}
}
