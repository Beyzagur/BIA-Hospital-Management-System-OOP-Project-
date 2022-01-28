package Swing;

import Entities.Patient;
import Management.HospitalManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PatientScreen extends JFrame {

	private JPanel contentPane;

	private HospitalManagementSystem manager;


	public PatientScreen(HospitalManagementSystem manager, Patient patient) {
		this.manager = manager;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel patientLabel = new JLabel(patient.getName() + " " + patient.getSurname());
		patientLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		patientLabel.setBounds(663, 146, 195, 82);
		contentPane.add(patientLabel);
		
		JButton profileButton = new JButton("Profile");
		profileButton.setFont(new Font("Verdana", Font.BOLD, 14));
		profileButton.setBounds(167, 163, 211, 31);
		profileButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.editProfileScreen = new EditProfile(manager, patient);
				manager.editProfileScreen.setVisible(true);
			}
		});
		contentPane.add(profileButton);
		
		JButton appointmentButton = new JButton("Appointments");
		appointmentButton.setFont(new Font("Verdana", Font.BOLD, 14));
		appointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DisplayAppointment displayAppointment = new DisplayAppointment(manager, patient.getAppointmentList(), true);
				displayAppointment.setVisible(true);
			}
		});
		appointmentButton.setBounds(423, 328, 211, 31);
		contentPane.add(appointmentButton);
		
		JButton makeAnAppointmentButton = new JButton("Make An \r\nAppointment");
		makeAnAppointmentButton.setFont(new Font("Verdana", Font.BOLD, 14));
		makeAnAppointmentButton.setBounds(285, 247, 228, 31);
		contentPane.add(makeAnAppointmentButton);

		makeAnAppointmentButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				manager.appointmentScreen = new MakeAnAppointment(manager, patient);
				setVisible(false);
				manager.appointmentScreen.setVisible(true);
			}
		});
		
		JButton prescriptionsButton = new JButton("Prescriptions");
		prescriptionsButton.setFont(new Font("Verdana", Font.BOLD, 14));
		prescriptionsButton.setBounds(571, 403, 211, 31);
		prescriptionsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new DisplayPrescription(manager, patient.getPrescriptions());
			}
		});
		contentPane.add(prescriptionsButton);


		JButton logoutButton = new JButton("Logout\r\n");
		logoutButton.setFont(new Font("Verdana", Font.BOLD, 12));
		logoutButton.setBounds(789, 528, 87, 25);
		logoutButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.enterScreen.setVisible(true);
			}
		});
		contentPane.add(logoutButton);
		
		JLabel BIAHOSPITAL_Label = new JLabel("BIA HOSPITAL");
		BIAHOSPITAL_Label.setHorizontalAlignment(SwingConstants.CENTER);
		BIAHOSPITAL_Label.setForeground(new Color(169, 169, 169));
		BIAHOSPITAL_Label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 32));
		BIAHOSPITAL_Label.setBackground(Color.WHITE);
		BIAHOSPITAL_Label.setBounds(0, 0, 243, 40);
		contentPane.add(BIAHOSPITAL_Label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PatientScreen.class.getResource("/Swing/images/resized_abstract-blue-science-background_1182-1440.jpg")));
		lblNewLabel.setBounds(0, 0, 900, 600);
		contentPane.add(lblNewLabel);
		
		
	}
}
