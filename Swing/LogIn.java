package Swing;

import Entities.Admin;
import Entities.Doctor;
import Entities.Patient;
import Management.HospitalManagementSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField;

	private HospitalManagementSystem manager;



	public LogIn(HospitalManagementSystem manager, String type) {
		this.manager = manager;

		LogIn reference = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel biahospital = new JLabel("BIA HOSPITAL");
		biahospital.setFont(new Font("Verdana", Font.BOLD, 36));
		biahospital.setForeground(new Color(0, 0, 102));
		biahospital.setBounds(315, 69, 328, 62);
		contentPane.add(biahospital);
		
		idField = new JTextField();
		idField.setBounds(245, 225, 220, 29);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel textID = new JLabel("ID:");
		textID.setFont(new Font("Verdana", Font.BOLD, 24));
		textID.setForeground(new Color(0, 0, 102));
		textID.setBounds(186, 218, 49, 40);
		contentPane.add(textID);
		
		JButton loginbutton = new JButton("Login");
		loginbutton.setForeground(new Color(0, 0, 102));
		loginbutton.setFont(new Font("Verdana", Font.BOLD, 18));
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getText() != null && idField.getText().length() == 11) {

					String id = idField.getText();
					String password = passwordField.getText();

					switch (type){
						case "patient":
							if (!manager.getPatients().containsKey(id)) {
								idField.setText("");
								passwordField.setText("");
								JOptionPane.showMessageDialog(reference, "Patient not Found!");
								break;
							}

							Patient patient = manager.getPatients().get(id);

							if (password.equals(patient.getPassword())){
								manager.patientScreen = new PatientScreen(manager, patient);
								setVisible(false);
								manager.patientScreen.setVisible(true);
							}
							else {
								passwordField.setText("");
								JOptionPane.showMessageDialog(reference, "Password is incorrect!");
							}

							break;

						case "doctor":
							if (!manager.getDoctors().containsKey(id)) {
								idField.setText("");
								passwordField.setText("");
								JOptionPane.showMessageDialog(reference, "Doctor not Found!");
								break;
							}

							Doctor doctor = manager.getDoctors().get(id);

							if (password.equals(doctor.getPassword())){
								manager.doctorScreen = new DoctorScreen(manager, doctor);
								setVisible(false);
								manager.doctorScreen.setVisible(true);
							}
							else {
								passwordField.setText("");
								JOptionPane.showMessageDialog(reference, "Password is incorrect!");
							}

							break;

						case "admin":
							Admin admin = manager.getAdmin();

							if (!admin.getId().equals(id)){
								idField.setText("");
								passwordField.setText("");
								break;
							}

							if (password.equals(admin.getPassword())){
								manager.adminScreen = new AdminScreen(manager, admin);
								setVisible(false);
								manager.adminScreen.setVisible(true);
							}
							else {
								passwordField.setText("");
								JOptionPane.showMessageDialog(reference, "Password is incorrect!");
							}

							break;
					}
				}
				else{
					JOptionPane.showMessageDialog(reference, "ID must be length of 11 and password not empty!");
				}
			}
		});
		loginbutton.setBounds(403, 342, 100, 29);
		contentPane.add(loginbutton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(245, 290, 220, 29);
		contentPane.add(passwordField);
		
		JLabel textPassword = new JLabel("Password:");
		textPassword.setForeground(new Color(0, 0, 102));
		textPassword.setFont(new Font("Verdana", Font.BOLD, 24));
		textPassword.setBounds(83, 290, 143, 29);
		contentPane.add(textPassword);

		if (type.equals("patient")) {
			JLabel textpatientsignup = new JLabel("Patient Sign Up:");
			textpatientsignup.setFont(new Font("Verdana", Font.BOLD, 16));
			textpatientsignup.setForeground(new Color(0, 0, 102));
			textpatientsignup.setBounds(83, 431, 156, 29);
			contentPane.add(textpatientsignup);

			JButton signupbutton = new JButton("SignUp");
			signupbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					manager.signUpScreen = new NewAccount(manager, true);
					manager.signUpScreen.setVisible(true);
				}
			});
			signupbutton.setBounds(233, 434, 113, 28);
			contentPane.add(signupbutton);
		}

		if (type.equals("doctor")) {
			JLabel lblNewLabel_5_3 = new JLabel("");
			lblNewLabel_5_3.setIcon(new ImageIcon(LogIn.class.getResource("/Swing/images/hospital-fill (1).png")));
			lblNewLabel_5_3.setBounds(673, 321, 100, 88);
			contentPane.add(lblNewLabel_5_3);

			JLabel lookingforajobtext = new JLabel("Looking for a job?");
			lookingforajobtext.setForeground(new Color(0, 0, 102));
			lookingforajobtext.setFont(new Font("Verdana", Font.BOLD, 12));
			lookingforajobtext.setBounds(596, 414, 129, 29);
			contentPane.add(lookingforajobtext);

			JButton applybutton = new JButton("Apply");
			applybutton.setBounds(721, 419, 85, 21);
			applybutton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					manager.signUpScreen = new NewAccount(manager, false);
					manager.signUpScreen.setVisible(true);
				}
			});
			contentPane.add(applybutton);
		}
		JLabel textlogin = new JLabel("LOGIN");
		textlogin.setForeground(new Color(0, 0, 102));
		textlogin.setFont(new Font("Verdana", Font.BOLD, 24));
		textlogin.setBounds(304, 180, 113, 29);
		contentPane.add(textlogin);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(LogIn.class.getResource("/Swing/images/resized_depositphotos_18391939-stock-photo-abstract-medical-background.jpg")));
		lblNewLabel_7.setBounds(0, 0, 886, 563);
		contentPane.add(lblNewLabel_7);
	}
	
}
