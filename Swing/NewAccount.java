package Swing;

import Entities.*;
import Management.FileOperations;
import Management.HospitalManagementSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NewAccount extends JFrame {

	private HospitalManagementSystem manager;

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField IDTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField firstPasswordField;
	private JPasswordField secondPasswordField;
	private JTextField titleTextField;


	public NewAccount(HospitalManagementSystem manager, boolean isPatient) {
		this.manager = manager;

		NewAccount reference = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel signUpLabel = new JLabel("Sign Up");
		signUpLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		signUpLabel.setBounds(392, 61, 116, 80);
		contentPane.add(signUpLabel);

		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		nameLabel.setBounds(79, 187, 70, 31);
		contentPane.add(nameLabel);

		JLabel surnameLabel = new JLabel("Surname :");
		surnameLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		surnameLabel.setBounds(51, 239, 99, 21);
		contentPane.add(surnameLabel);

		JLabel IDLabel = new JLabel("ID :");
		IDLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		IDLabel.setBounds(104, 294, 45, 13);
		contentPane.add(IDLabel);

		JLabel phoneNumberLabel = new JLabel("Phone Number :");
		phoneNumberLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		phoneNumberLabel.setBounds(452, 299, 180, 31);
		contentPane.add(phoneNumberLabel);

		JLabel emailLabel = new JLabel("E-mail :\r\n");
		emailLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		emailLabel.setBounds(526, 351, 75, 31);
		contentPane.add(emailLabel);

		JRadioButton femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setBackground(Color.WHITE);
		buttonGroup.add(femaleRadioButton);
		femaleRadioButton.setFont(new Font("Verdana", Font.BOLD, 16));
		femaleRadioButton.setBounds(176, 420, 103, 21);
		contentPane.add(femaleRadioButton);

		JRadioButton maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setBackground(Color.WHITE);
		buttonGroup.add(maleRadioButton);
		maleRadioButton.setFont(new Font("Verdana", Font.BOLD, 16));
		maleRadioButton.setBounds(301, 420, 103, 21);
		contentPane.add(maleRadioButton);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
		nameTextField.setBounds(159, 187, 245, 31);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);

		surnameTextField = new JTextField();
		surnameTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(159, 235, 245, 31);
		contentPane.add(surnameTextField);

		IDTextField = new JTextField();
		IDTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
		IDTextField.setColumns(10);
		IDTextField.setBounds(159, 286, 245, 31);
		contentPane.add(IDTextField);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
		emailTextField.setColumns(10);
		emailTextField.setBounds(614, 351, 245, 31);
		contentPane.add(emailTextField);

		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(615, 300, 244, 31);
		contentPane.add(phoneNumberTextField);

		JLabel bloodTypeLabel = new JLabel("Blood Type :");
		bloodTypeLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		bloodTypeLabel.setBounds(482, 410, 116, 31);
		contentPane.add(bloodTypeLabel);

		JComboBox bloodTypeComboBox = new JComboBox();
		bloodTypeComboBox.setBackground(Color.WHITE);
		bloodTypeComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		bloodTypeComboBox.setBounds(621, 417, 61, 23);
		contentPane.add(bloodTypeComboBox);
		bloodTypeComboBox.addItem("0+");
		bloodTypeComboBox.addItem("0-");
		bloodTypeComboBox.addItem("A+");
		bloodTypeComboBox.addItem("A-");
		bloodTypeComboBox.addItem("B+");
		bloodTypeComboBox.addItem("B-");
		bloodTypeComboBox.addItem("AB+");
		bloodTypeComboBox.addItem("AB-");

		JLabel firstPasswordLabel = new JLabel("Password :");
		firstPasswordLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		firstPasswordLabel.setBounds(46, 336, 103, 21);
		contentPane.add(firstPasswordLabel);

		firstPasswordField = new JPasswordField();
		firstPasswordField.setBounds(158, 334, 246, 23);
		contentPane.add(firstPasswordField);

		JLabel secondPasswordLabel = new JLabel("Password :");
		secondPasswordLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		secondPasswordLabel.setBounds(46, 378, 103, 21);
		contentPane.add(secondPasswordLabel);

		secondPasswordField = new JPasswordField();
		secondPasswordField.setBounds(158, 376, 246, 23);
		contentPane.add(secondPasswordField);

		JEditorPane addressPane = new JEditorPane();
		addressPane.setBounds(615, 187, 245, 96);
		contentPane.add(addressPane);

		JLabel addressLabel = new JLabel("Address :");
		addressLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		addressLabel.setBounds(512, 190, 348, 31);
		contentPane.add(addressLabel);

		JLabel BIAHOSPITAL_Label = new JLabel("BIA HOSPITAL");
		BIAHOSPITAL_Label.setBackground(UIManager.getColor("Label.disabledShadow"));
		BIAHOSPITAL_Label.setForeground(new Color(169, 169, 169));
		BIAHOSPITAL_Label.setHorizontalAlignment(SwingConstants.CENTER);
		BIAHOSPITAL_Label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 35));
		BIAHOSPITAL_Label.setBounds(332, 10, 245, 73);
		contentPane.add(BIAHOSPITAL_Label);

		if (isPatient) {
			JButton saveButton = new JButton("Save");
			saveButton.setFont(new Font("Verdana", Font.BOLD, 12));
			saveButton.setBounds(332, 492, 85, 31);
			saveButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (firstPasswordField.getText().equals(secondPasswordField.getText())) {

						if (IDTextField.getText().length() == 11) {

							boolean isExisted = false;

							for (Patient p : manager.getPatients().values()) {
								if (p.getId().equals(IDTextField.getText())) {
									JOptionPane.showMessageDialog(reference, "Patient with this ID is available in database.");
									isExisted = true;
									break;
								}
							}

							if (!isExisted) {
								Patient newPatient = new Patient(nameTextField.getText(), surnameTextField.getText(), IDTextField.getText(),
										phoneNumberTextField.getText(), addressPane.getText(), femaleRadioButton.isSelected(),
										(String) bloodTypeComboBox.getSelectedItem(), firstPasswordField.getText(), emailTextField.getText());

								manager.register(newPatient);

								try {
									FileOperations.writePatients(manager.getPatients(), manager.patientsPath);
								} catch (IOException ioException) {
									ioException.printStackTrace();
								}

								JOptionPane.showMessageDialog(reference, "Your registration has been created successfully.");

								setVisible(false);
								manager.patientScreen = new PatientScreen(manager, newPatient);
								manager.patientScreen.setVisible(true);
							}
						} else
							JOptionPane.showMessageDialog(reference, "ID must be length of 11!");
					} else {
						firstPasswordField.setText("");
						secondPasswordField.setText("");
						JOptionPane.showMessageDialog(reference, "Passwords are different!");
					}
				}
			});
			contentPane.add(saveButton);
		}
		else{
			JLabel titleLabel = new JLabel("Title :");
			titleLabel.setFont(new Font("Verdana", Font.BOLD, 16));
			titleLabel.setBounds(97, 140, 52, 21);
			contentPane.add(titleLabel);

			JLabel departmentLabel = new JLabel("Department :");
			departmentLabel.setFont(new Font("Verdana", Font.BOLD, 16));
			departmentLabel.setBounds(487, 134, 118, 21);
			contentPane.add(departmentLabel);

			titleTextField = new JTextField();
			titleTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
			titleTextField.setColumns(10);
			titleTextField.setBounds(159, 136, 245, 31);
			contentPane.add(titleTextField);

			JComboBox departmentComboBox = new JComboBox();
			departmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"Please choose one "}));
			departmentComboBox.setBackground(Color.WHITE);
			departmentComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
			departmentComboBox.setBounds(614, 130, 245, 31);

			for (Departments department: Departments.values()) {
				departmentComboBox.addItem(department.name());
			}
			contentPane.add(departmentComboBox);

			JButton saveApplyButton = new JButton("Save & Apply");
			saveApplyButton.setFont(new Font("Verdana", Font.BOLD, 12));
			saveApplyButton.setBounds(452, 492, 149, 31);
			saveApplyButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (!departmentComboBox.getSelectedItem().equals("Please choose one ") || IDTextField.getText().length() != 11){

						if (firstPasswordField.getText().equals(secondPasswordField.getText())) {

							Doctor applicant = new Doctor(nameTextField.getText(), surnameTextField.getText(), IDTextField.getText(),
									phoneNumberTextField.getText(), addressPane.getText(), femaleRadioButton.isSelected(),
									(String) bloodTypeComboBox.getSelectedItem(), firstPasswordField.getText(), emailTextField.getText(),
									titleTextField.getText(), (String)departmentComboBox.getSelectedItem());

							manager.addJobApplicant(applicant);
							JOptionPane.showMessageDialog(reference, "Successfull.");
						}
						else{
							firstPasswordField.setText("");
							secondPasswordField.setText("");
							JOptionPane.showMessageDialog(reference, "Passwords are different!");
						}
					}
					else
						JOptionPane.showMessageDialog(reference, "Please check your information!");
				}
			});
			contentPane.add(saveApplyButton);
		}

		JButton turnBackButton = new JButton("Turn Back");
		turnBackButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		turnBackButton.setBounds(750, 532, 100, 21);
		turnBackButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.enterScreen.setVisible(true);
			}
		});
		contentPane.add(turnBackButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewAccount.class.getResource("/Swing/images/resized_depositphotos_18391939-stock-photo-abstract-medical-background_1024x1024.jpg")));
		lblNewLabel.setBounds(0, 0, 900, 600);
		contentPane.add(lblNewLabel);

	}

}
