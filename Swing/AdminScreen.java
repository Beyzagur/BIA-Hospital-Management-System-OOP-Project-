package Swing;

import Entities.Admin;
import Management.HospitalManagementSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AdminScreen extends JFrame {

	private JPanel contentPane;

	HospitalManagementSystem manager;


	public AdminScreen(HospitalManagementSystem manager, Admin admin) {
		this.manager = manager;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminLabel = new JLabel(admin.getName() + " " + admin.getSurname());
		adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		adminLabel.setBounds(314, 151, 241, 56);
		contentPane.add(adminLabel);
		
		JButton profileButton = new JButton("Profile");
		profileButton.setFont(new Font("Verdana", Font.BOLD, 14));
		profileButton.setBounds(156, 300, 169, 27);
		profileButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.editProfileScreen = new EditProfile(manager, admin);
				manager.editProfileScreen.setVisible(true);
			}
		});
		contentPane.add(profileButton);
		
		JButton confirmRemoveButton = new JButton("Confirm & Remove Doctor");
		confirmRemoveButton.setFont(new Font("Verdana", Font.BOLD, 14));
		confirmRemoveButton.setBounds(536, 300, 243, 27);
		confirmRemoveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DoctorControlScreen doctorControlScreen = new DoctorControlScreen(manager, manager.getJobApplicants(), manager.getDoctors());
			}
		});
		contentPane.add(confirmRemoveButton);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Verdana", Font.BOLD, 12));
		logoutButton.setBounds(791, 532, 85, 21);
		logoutButton.addActionListener(new ActionListener() {
			@Override
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
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(AdminScreen.class.getResource("/Swing/images/caduceus_1024x576.jpg")));
		backgroundLabel.setBounds(-78, 0, 974, 563);
		contentPane.add(backgroundLabel);
	}
}
