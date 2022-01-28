package Swing;

import Entities.Doctor;
import Entities.Patient;
import Entities.Prescription;
import Management.FileOperations;
import Management.HospitalManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class WritePrescription extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JList list;
	private DefaultListModel model=new DefaultListModel();


	public WritePrescription(HospitalManagementSystem manager, Doctor doctor, Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel medicinesLabel = new JLabel("Medicines");
		medicinesLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		medicinesLabel.setBounds(133, 87, 98, 37);
		contentPane.add(medicinesLabel);
		
		JLabel prescriptionLabel = new JLabel("Prescription");
		prescriptionLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		prescriptionLabel.setBounds(629, 90, 122, 31);
		contentPane.add(prescriptionLabel);

		JLabel removeLabel= new JLabel("Click Remove X");
		removeLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		removeLabel.setBounds(369, 272, 131, 21);
		contentPane.add(removeLabel);

		JLabel addLabel = new JLabel("Click Add >");
		addLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		addLabel.setBounds(369, 231, 117, 31);
		contentPane.add(addLabel);


		JList medicinesList= new JList(manager.getMedicines().toArray());
		medicinesList.setBackground(new Color(255, 255, 255));
		medicinesList.setFont(new Font("Verdana", Font.PLAIN, 12));
		medicinesList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String data=medicinesList.getSelectedValue().toString();
				model.addElement(data);
				list.setModel(model);
			}
		});
		medicinesList.setVisibleRowCount(4);
		JScrollPane medicinesScrollPane = new JScrollPane(medicinesList);
		medicinesScrollPane.setBounds(50, 125, 270, 296);
		contentPane.add(medicinesScrollPane);


		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int s = list.getSelectedIndex();
				if (s != -1)
					model.removeElementAt(s);
			}
		});
		list.setFont(new Font("Verdana", Font.PLAIN, 12));
		JScrollPane prescriptionScrollPane = new JScrollPane(list);
		prescriptionScrollPane.setBounds(554, 125, 270, 296);
		contentPane.add(prescriptionScrollPane);


		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Verdana", Font.BOLD, 14));
		saveButton.setBounds(739, 458, 85, 21);
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ArrayList<String> medicines = new ArrayList<>();
				Iterator iterator = model.elements().asIterator();
				while (iterator.hasNext()){
					medicines.add((String)iterator.next());
				}

				Prescription p = new Prescription(doctor.getTitle() + " " + doctor.getName() + " " + doctor.getSurname(),
						doctor.getDepartment().name(), patient, Integer.toString(manager.getCurrentDay()),
						Integer.toString(manager.getCurrentMonth()), "10.00", medicines);
				patient.addPrescription(p);

				try {
					FileOperations.writePrescriptions(manager.getPatients(), manager.prescriptionsPath);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
		contentPane.add(saveButton);
		
		JButton turnBackButton = new JButton("Turn Back");
		turnBackButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		turnBackButton.setBounds(785, 532, 91, 21);
		turnBackButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.doctorScreen.setVisible(true);
			}
		});
		contentPane.add(turnBackButton);
		
		JLabel BIAHOSPITAL_Label = new JLabel("BIA HOSPITAL");
		BIAHOSPITAL_Label.setHorizontalAlignment(SwingConstants.CENTER);
		BIAHOSPITAL_Label.setForeground(new Color(169, 169, 169));
		BIAHOSPITAL_Label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 32));
		BIAHOSPITAL_Label.setBackground(Color.WHITE);
		BIAHOSPITAL_Label.setBounds(-12, 0, 243, 40);
		contentPane.add(BIAHOSPITAL_Label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WritePrescription.class.getResource("/Swing/images/medicine-health-treatment-pharmacy-concept-260nw-1906132753_1024x735.jpg")));
		lblNewLabel.setBounds(-2, 0, 900, 735);
		contentPane.add(lblNewLabel);

	}
}
