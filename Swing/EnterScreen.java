package Swing;

import Management.HospitalManagementSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EnterScreen extends JFrame {

	private JPanel contentPane;

	private HospitalManagementSystem manager;


	public EnterScreen(HospitalManagementSystem manager) {
		this.manager = manager;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel HOSPITAL_Label = new JLabel("HOSPITAL");
		HOSPITAL_Label.setForeground(new Color(0, 0, 102));
		HOSPITAL_Label.setFont(new Font("Verdana", Font.BOLD, 40));
		HOSPITAL_Label.setBounds(470, 269, 250, 70);
		contentPane.add(HOSPITAL_Label);
		
		JLabel BIA_Label = new JLabel("BIA");
		BIA_Label.setForeground(new Color(0, 0, 102));
		BIA_Label.setFont(new Font("Verdana", Font.BOLD, 40));
		BIA_Label.setBounds(539, 216, 100, 83);
		contentPane.add(BIA_Label);
		
		JLabel adminLabel = new JLabel("");
		adminLabel.setIcon(new ImageIcon(EnterScreen.class.getResource("/Swing/images/administration (1).png")));
		adminLabel.setBounds(167, 410, 70, 70);
		contentPane.add(adminLabel);
		
		JLabel doctorLabel = new JLabel("");
		doctorLabel.setIcon(new ImageIcon(EnterScreen.class.getResource("/Swing/images/doctor (2).png")));
		doctorLabel.setBounds(97, 216, 70, 109);
		contentPane.add(doctorLabel);
		
		JLabel patientLabel = new JLabel("");
		patientLabel.setIcon(new ImageIcon(EnterScreen.class.getResource("/Swing/images/people (1).png")));
		patientLabel.setBounds(149, 51, 70, 109);
		contentPane.add(patientLabel);
		
		JButton adminButton = new JButton("ADMINISTRATION");
		adminButton.setFont(new Font("Verdana", Font.BOLD, 14));
		adminButton.setBounds(97, 484, 193, 40);
		adminButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				manager.loginScreen = new LogIn(manager, "admin");
				setVisible(false);
				manager.loginScreen.setVisible(true);
			}
		});
		contentPane.add(adminButton);
		
		JButton doctorButton = new JButton("DOCTOR");
		doctorButton.setFont(new Font("Verdana", Font.BOLD, 14));
		doctorButton.setBounds(68, 314, 127, 40);
		doctorButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				manager.loginScreen = new LogIn(manager, "doctor");
				setVisible(false);
				manager.loginScreen.setVisible(true);
			}
		});
		contentPane.add(doctorButton);
		
		JButton patientButton = new JButton("PATIENT");
		patientButton.setFont(new Font("Verdana", Font.BOLD, 14));
		patientButton.setBounds(112, 142, 142, 39);
		patientButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				manager.loginScreen = new LogIn(manager, "patient");
				setVisible(false);
				manager.loginScreen.setVisible(true);
			}
		});
		contentPane.add(patientButton);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(EnterScreen.class.getResource("/Swing/images/resized_hms2.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);
	}

}
