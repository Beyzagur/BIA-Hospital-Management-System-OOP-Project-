package Swing;

import Entities.Appointment;
import Entities.Doctor;
import Entities.Patient;
import Management.HospitalManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DisplayAppointment extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private HospitalManagementSystem manager;


	public DisplayAppointment(HospitalManagementSystem manager, ArrayList<Appointment> appointments, boolean isPatient) {
		this.manager = manager;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel BIAHOSPITAL_Label = new JLabel("BIA HOSPITAL");
		BIAHOSPITAL_Label.setHorizontalAlignment(SwingConstants.CENTER);
		BIAHOSPITAL_Label.setForeground(new Color(169, 169, 169));
		BIAHOSPITAL_Label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 32));
		BIAHOSPITAL_Label.setBackground(Color.WHITE);
		BIAHOSPITAL_Label.setBounds(643, 0, 243, 40);
		contentPane.add(BIAHOSPITAL_Label);
		
		JLabel lblNewLabel = new JLabel("Appointments");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(291, 81, 265, 46);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 125, 775, 327);
		contentPane.add(scrollPane);

		Object[][] arr = new Object[appointments.size()][5];

		for (int i = 0; i < appointments.size(); i++) {
			arr[i][0] = i+1;
			arr[i][1] = appointments.get(i).getNameSurname();
			Doctor d = appointments.get(i).getDoctor();
			arr[i][2] = d.getTitle() + " " + d.getName() + " " + d.getSurname();
			arr[i][3] = d.getDepartment().name();
			arr[i][4] = appointments.get(i).getAppointmentDate() + " | " + appointments.get(i).getAppointmentTime();
		}

		table = new JTable();
		if (!isPatient) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					setVisible(false);

					int i = table.getSelectedRow();

					String name = appointments.get(i).getNameSurname().split(" ")[0];
					String surName = appointments.get(i).getNameSurname().split(" ")[1];

					Patient patient = null;

					for (Patient p : manager.getPatients().values()) {
						if (p.getName().equals(name) && p.getSurname().equals(surName)){
							patient = p;
							break;
						}
					}

					WritePrescription writePrescription = new WritePrescription(manager, appointments.get(i).getDoctor(), patient);
				}
			});
		}
		table.setFont(new Font("Verdana", Font.PLAIN, 10));
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			arr ,
			new String[] {
				"SERIAL NO", "PATIENT NAME & SURNAME", "DOCTOR TITLE & NAME & SURNAME", "DEPARTMENT", "DATE & HOUR"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(145);
		table.getColumnModel().getColumn(2).setPreferredWidth(185);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		scrollPane.setViewportView(table);

		
		JButton turnBack = new JButton("Turn Back");
		turnBack.setBounds(783, 532, 93, 21);
		turnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if (isPatient)
					manager.patientScreen.setVisible(true);
				else
					manager.doctorScreen.setVisible(true);
			}
		});
		contentPane.add(turnBack);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(DisplayAppointment.class.getResource("/Swing/images/blurred-calendar-pencil-blue-tone-260nw-641052127_1024x682.jpg")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);
		
		
		
	}
}
