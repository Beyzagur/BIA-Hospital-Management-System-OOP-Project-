package Swing;

import Entities.Doctor;
import Entities.Patient;
import Entities.Person;
import Management.HospitalManagementSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfile extends JFrame {

	private HospitalManagementSystem manager;

	private JPanel contentPane;
	private JTextField editEmailField_1;
	private JTextField EditPhoneField_1;
	private JPasswordField editpasswordField1;
	private JPasswordField editpasswordField_2;
	private JLabel BIAhospýtaltext;
	private JButton editsavebutton;
	private JButton editturnback;


	public EditProfile(HospitalManagementSystem manager, Person person) {
		this.manager = manager;

		EditProfile reference = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel editprofiletext = new JLabel("EDIT PROFILE");
		editprofiletext.setForeground(new Color(0, 0, 102));
		editprofiletext.setFont(new Font("Verdana", Font.BOLD, 24));
		editprofiletext.setBounds(327, 189, 203, 48);
		contentPane.add(editprofiletext);
		
		editEmailField_1 = new JTextField();
		editEmailField_1.setText(person.getEmail());
		editEmailField_1.setBounds(521, 281, 171, 26);
		contentPane.add(editEmailField_1);
		editEmailField_1.setColumns(10);
		
		EditPhoneField_1 = new JTextField();
		EditPhoneField_1.setBounds(596, 324, 96, 26);
		contentPane.add(EditPhoneField_1);
		EditPhoneField_1.setText(person.getPhone());
		EditPhoneField_1.setColumns(10);
		
		JLabel editpassword1 = new JLabel("Password:");
		editpassword1.setForeground(new Color(0, 0, 102));
		editpassword1.setFont(new Font("Verdana", Font.BOLD, 18));
		editpassword1.setBounds(80, 281, 123, 26);
		contentPane.add(editpassword1);
		
		JLabel editpassword2 = new JLabel("Password:");
		editpassword2.setFont(new Font("Verdana", Font.BOLD, 18));
		editpassword2.setForeground(new Color(0, 0, 102));
		editpassword2.setBounds(80, 324, 123, 26);
		contentPane.add(editpassword2);
		
		JLabel editmail = new JLabel("Email:");
		editmail.setForeground(new Color(0, 0, 102));
		editmail.setFont(new Font("Verdana", Font.BOLD, 18));
		editmail.setBounds(455, 281, 69, 26);
		contentPane.add(editmail);
		
		JLabel phonenumber = new JLabel("Phone Number:");
		phonenumber.setForeground(new Color(0, 0, 102));
		phonenumber.setFont(new Font("Verdana", Font.BOLD, 16));
		phonenumber.setBounds(456, 326, 144, 24);
		contentPane.add(phonenumber);
		
		JLabel addresstext = new JLabel("Address:");
		addresstext.setForeground(new Color(0, 0, 102));
		addresstext.setFont(new Font("Verdana", Font.BOLD, 18));
		addresstext.setBounds(80, 392, 96, 26);
		contentPane.add(addresstext);
		
		editpasswordField1 = new JPasswordField();
		editpasswordField1.setBounds(189, 282, 128, 26);
		contentPane.add(editpasswordField1);
		
		editpasswordField_2 = new JPasswordField();
		editpasswordField_2.setBounds(189, 325, 128, 26);
		contentPane.add(editpasswordField_2);
		
		BIAhospýtaltext = new JLabel("BIA HOSPITAL");
		BIAhospýtaltext.setForeground(new Color(0, 0, 102));
		BIAhospýtaltext.setFont(new Font("Verdana", Font.BOLD, 36));
		BIAhospýtaltext.setBounds(274, 48, 326, 59);
		contentPane.add(BIAhospýtaltext);
		
		editturnback = new JButton("Turn Back");
		editturnback.setFont(new Font("Verdana", Font.BOLD, 12));
		editturnback.setForeground(new Color(0, 0, 102));
		editturnback.setBounds(745, 491, 110, 39);
		editturnback.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				if (person instanceof Patient)
					manager.patientScreen.setVisible(true);
				else if (person instanceof Doctor)
					manager.doctorScreen.setVisible(true);
				else
					manager.adminScreen.setVisible(true);
			}
		});
		contentPane.add(editturnback);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(177, 399, 515, 59);
		editorPane.setText(person.getAddress());
		contentPane.add(editorPane);

		editsavebutton = new JButton("Save");
		editsavebutton.setForeground(new Color(0, 0, 102));
		editsavebutton.setFont(new Font("Verdana", Font.BOLD, 18));
		editsavebutton.setBounds(609, 491, 96, 39);
		editsavebutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (editpasswordField1.getText().equals(editpasswordField_2.getText())){
					person.setAddress(editorPane.getText());
					person.setEmail(editEmailField_1.getText());
					person.setPassword(editpasswordField1.getText());
					person.setPhone(EditPhoneField_1.getText());

					JOptionPane.showMessageDialog(reference, "Your profile updated successfully.");
					setVisible(false);

					if (person instanceof Patient)
						manager.patientScreen.setVisible(true);
					else if (person instanceof Doctor)
						manager.doctorScreen.setVisible(true);
					else
						manager.adminScreen.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(reference, "Passwords don't match!");
					editpasswordField1.setText("");
					editpasswordField_2.setText("");
				}

			}
		});
		contentPane.add(editsavebutton);
		
		JLabel backgroundjpg = new JLabel("");
		backgroundjpg.setIcon(new ImageIcon(EditProfile.class.getResource("/Swing/images/resized_depositphotos_18391939-stock-photo-abstract-medical-background.jpg")));
		backgroundjpg.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundjpg);
		
	}
}
