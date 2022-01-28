package Swing;

import Entities.Doctor;
import Management.HospitalManagementSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorScreen extends JFrame {

	private JPanel contentPane;

	private HospitalManagementSystem manager;


	public DoctorScreen(HospitalManagementSystem manager, Doctor doctor) {
		this.manager = manager;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton EditProfileButton = new JButton("Edit Profile ");
		EditProfileButton.setForeground(new Color(0, 0, 102));
		EditProfileButton.setFont(new Font("Verdana", Font.BOLD, 18));
		EditProfileButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.editProfileScreen = new EditProfile(manager, doctor);
				manager.editProfileScreen.setVisible(true);
			}
		});
		EditProfileButton.setBounds(412, 380, 263, 37);
		contentPane.add(EditProfileButton);
		
		JLabel textdoktor = new JLabel("Doctor");
		textdoktor.setFont(new Font("Verdana", Font.BOLD, 20));
		textdoktor.setForeground(new Color(0, 0, 102));
		textdoktor.setBounds(260, 143, 131, 87);
		contentPane.add(textdoktor);
		
		JButton displayappointmentButton = new JButton("Display Appointments");
		displayappointmentButton.setFont(new Font("Verdana", Font.BOLD, 18));
		displayappointmentButton.setForeground(new Color(0, 0, 102));
		displayappointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DisplayAppointment displayAppointment = new DisplayAppointment(manager, doctor.getAppointments(), false);
				displayAppointment.setVisible(true);
			}
		});
		displayappointmentButton.setBounds(102, 380, 263, 37);
		contentPane.add(displayappointmentButton);
		
		JButton logOutButton = new JButton("LogOut");
		logOutButton.setForeground(new Color(0, 0, 102));
		logOutButton.setFont(new Font("Verdana", Font.BOLD, 14));
		logOutButton.setBounds(767, 483, 97, 37);
		logOutButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.enterScreen.setVisible(true);
			}
		});
		contentPane.add(logOutButton);

		JLabel titlenamesurnamefield = new JLabel(doctor.getTitle()+" "+doctor.getName()+" "+doctor.getSurname());
		titlenamesurnamefield.setForeground(new Color(0, 0, 102));
		titlenamesurnamefield.setFont(new Font("Verdana", Font.BOLD, 20));
		titlenamesurnamefield.setBounds(260, 220, 415, 37);
		contentPane.add(titlenamesurnamefield);

		JLabel branchfield = new JLabel(doctor.getDepartment().name());
		branchfield.setForeground(new Color(0, 0, 102));
		branchfield.setFont(new Font("Verdana", Font.BOLD, 20));
		branchfield.setBounds(400, 171, 275, 30);
		contentPane.add(branchfield);

		JLabel BIAHOSPITAL_Label = new JLabel("BIA HOSPITAL");
		BIAHOSPITAL_Label.setBackground(UIManager.getColor("Label.disabledShadow"));
		BIAHOSPITAL_Label.setForeground(new Color(169, 169, 169));
		BIAHOSPITAL_Label.setHorizontalAlignment(SwingConstants.LEFT);
		BIAHOSPITAL_Label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 35));
		BIAHOSPITAL_Label.setBounds(332, 10, 245, 73);
		contentPane.add(BIAHOSPITAL_Label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DoctorScreen.class.getResource("/Swing/images/background-doctor.jpg")));
		lblNewLabel_2.setBounds(-12, 0, 910, 563);
		contentPane.add(lblNewLabel_2);
	}
}
