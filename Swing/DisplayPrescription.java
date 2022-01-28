package Swing;

import Entities.Patient;
import Entities.Prescription;
import Management.HospitalManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DisplayPrescription extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public DisplayPrescription(HospitalManagementSystem manager, ArrayList<Prescription> prescriptions) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BIAHOSPITAL_Label = new JLabel("BIA HOSPITAL");
		BIAHOSPITAL_Label.setHorizontalAlignment(SwingConstants.CENTER);
		BIAHOSPITAL_Label.setForeground(new Color(169, 169, 169));
		BIAHOSPITAL_Label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 32));
		BIAHOSPITAL_Label.setBackground(Color.WHITE);
		BIAHOSPITAL_Label.setBounds(-15, 0, 243, 40);
		contentPane.add(BIAHOSPITAL_Label);
		
		JLabel prescriptionLabel = new JLabel("PRESCRIPTIONS");
		prescriptionLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		prescriptionLabel.setBounds(328, 86, 179, 48);
		contentPane.add(prescriptionLabel);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(34, 127, 818, 341);
		contentPane.add(scrollPaneTable);

		int number = 0;
		for (Prescription p : prescriptions) {
			number += p.getMedicineList().size();
		}

		Object[][] arr = new Object[number][6];

		number = 0;
		for (int i = 0; i < prescriptions.size(); i++){
			ArrayList<String> medicines = prescriptions.get(i).getMedicineList();
			for (int j = 0; j < medicines.size(); j++) {
				arr[number][0] = number + 1;
				Patient p = prescriptions.get(i).getPatient();
				arr[number][1] = p.getName() + " " + p.getSurname();
				arr[number][2] = medicines.get(j);
				arr[number][3] = prescriptions.get(i).getDoctor();
				arr[number][4] = prescriptions.get(i).getDepartment();
				arr[number][5] = String.format("%s.%s.2021 | %s", prescriptions.get(i).getDay(),
						prescriptions.get(i).getMonth(), prescriptions.get(i).getHour());
				number++;
			}
		}


		table = new JTable();
		table.setModel(new DefaultTableModel(
			arr,
			new String[] {
				"SERIAL NO", "PATIENT NAME & SURNAME", "MEDICINE", "DOCTOR TITLE & NAME & SURNAME", "DEPARTMENT", "DATE & HOUR"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.setFont(new Font("Verdana", Font.PLAIN, 10));
		scrollPaneTable.setViewportView(table);
		
		JButton turnBackButton = new JButton("Turn Back");
		turnBackButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		turnBackButton.setBounds(784, 532, 92, 21);
		turnBackButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.patientScreen.setVisible(true);
			}
		});
		contentPane.add(turnBackButton);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(DisplayPrescription.class.getResource("/Swing/images/close-up.jpg")));
		backgroundLabel.setBounds(-5, -22, 900, 733);
		contentPane.add(backgroundLabel);
	}
}
