package Swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Entities.*;
import Management.FileOperations;
import Management.HospitalManagementSystem;

public class MakeAnAppointment extends JFrame {

	private JPanel contentPane;
	private JComboBox doctorComboBox;
	private JComboBox departmentComboBox;
	private JComboBox hourComboBox;
	private JComboBox dayComboBox;
	private JComboBox monthComboBox;

	private HospitalManagementSystem manager;


	/**
	 * Create the frame.
	 */
	public MakeAnAppointment(HospitalManagementSystem manager, Patient patient) {
		this.manager = manager;

		MakeAnAppointment reference = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel makeAppointmentLabel = new JLabel("Make An Appointment");
		makeAppointmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		makeAppointmentLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		makeAppointmentLabel.setBounds(308, 73, 333, 72);
		contentPane.add(makeAppointmentLabel);

		JLabel BIAHOSPITAL_Label = new JLabel("BIA HOSPITAL");
		BIAHOSPITAL_Label.setHorizontalAlignment(SwingConstants.CENTER);
		BIAHOSPITAL_Label.setForeground(new Color(169, 169, 169));
		BIAHOSPITAL_Label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 32));
		BIAHOSPITAL_Label.setBackground(Color.WHITE);
		BIAHOSPITAL_Label.setBounds(643, 0, 243, 40);
		contentPane.add(BIAHOSPITAL_Label);

		JLabel departmentLabel = new JLabel("Department :");
		departmentLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		departmentLabel.setBounds(278, 170, 107, 27);
		contentPane.add(departmentLabel);


		JLabel doctorLabel = new JLabel("Doctor :");
		doctorLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		doctorLabel.setBounds(320, 228, 64, 27);
		contentPane.add(doctorLabel);

		JLabel dateLabel = new JLabel("Day :");
		dateLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		dateLabel.setBounds(336, 290, 48, 18);
		contentPane.add(dateLabel);

		JLabel hourLabel = new JLabel("Hour :");
		hourLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		hourLabel.setBounds(333, 343, 51, 27);
		contentPane.add(hourLabel);

		JLabel monthLabel = new JLabel("Month :");
		monthLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		monthLabel.setBounds(507, 290, 64, 18);
		contentPane.add(monthLabel);

		doctorComboBox = new JComboBox();
		doctorComboBox.setModel(new DefaultComboBoxModel(new String[] {"Please choose one"}));
		doctorComboBox.setBackground(Color.WHITE);
		doctorComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		doctorComboBox.setBounds(389, 225, 265, 33);

		contentPane.add(doctorComboBox);

		monthComboBox = new JComboBox();
		monthComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		monthComboBox.setBackground(Color.WHITE);
		monthComboBox.setBounds(575, 285, 79, 28);
		monthComboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				for (Doctor d : manager.getDoctors().values()) {
					if (doctorComboBox.getSelectedItem().equals(d.getName() + " " + d.getSurname())){
						setHours(d, (int)dayComboBox.getSelectedItem(), (int)monthComboBox.getSelectedItem());
					}
				}
			}
		});
		contentPane.add(monthComboBox);
		for (int i=manager.getCurrentMonth(); i<13; i++) {
			monthComboBox.addItem(i);
		}


		departmentComboBox = new JComboBox();
		departmentComboBox.setModel(new DefaultComboBoxModel(new String[] {"Please choose one "}));
		departmentComboBox.setBackground(Color.WHITE);
		departmentComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		departmentComboBox.setBounds(389, 167, 265, 33);
		departmentComboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				doctorComboBox.removeAllItems();
				for (Doctor d : manager.getDoctors().values()) {
					if (d.getDepartment().name().equals(departmentComboBox.getSelectedItem()))
						doctorComboBox.addItem(d.getName() + " " + d.getSurname());
				}
			}
		});
		contentPane.add(departmentComboBox);
		for (Departments department: Departments.values()) {
			departmentComboBox.addItem(department.name());
		}


		dayComboBox = new JComboBox();
		dayComboBox.setBackground(Color.WHITE);
		dayComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		dayComboBox.setBounds(389, 285, 73, 28);
		dayComboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (Doctor d : manager.getDoctors().values()) {
					if (doctorComboBox.getSelectedItem().equals(d.getName() + " " + d.getSurname())){
						setHours(d, (int)dayComboBox.getSelectedItem(), (int)monthComboBox.getSelectedItem());
					}
				}
			}
		});
		contentPane.add(dayComboBox);
		for (int i=manager.getCurrentDay()+1; i<=31;i++) {
			dayComboBox.addItem(i);
		}

		hourComboBox = new JComboBox();
		hourComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		hourComboBox.setBackground(Color.WHITE);
		hourComboBox.setBounds(389, 340, 73, 33);
		contentPane.add(hourComboBox);
		for (int i = 9; i < 18; i++) {
			hourComboBox.addItem(i);
		}

		JLabel minuteLabel = new JLabel("Minute :");
		minuteLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		minuteLabel.setBounds(507, 340, 74, 27);
		contentPane.add(minuteLabel);

		JComboBox minuteComboBox = new JComboBox();
		minuteComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		minuteComboBox.setBackground(Color.WHITE);
		minuteComboBox.setBounds(581, 337, 73, 33);
		contentPane.add(minuteComboBox);
		minuteComboBox.addItem("00");

		JButton turnBackButton = new JButton("Turn Back");
		turnBackButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		turnBackButton.setBounds(781, 532, 95, 21);
		turnBackButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.patientScreen.setVisible(true);
			}
		});
		contentPane.add(turnBackButton);

		JCheckBox vaccineCheckBox = new JCheckBox("Vaccine");
		vaccineCheckBox.setBackground(new Color(255, 255, 255));
		vaccineCheckBox.setFont(new Font("Verdana", Font.BOLD, 10));
		vaccineCheckBox.setBounds(390, 391, 93, 21);
		contentPane.add(vaccineCheckBox);

		JButton confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font("Verdana", Font.BOLD, 12));
		confirmButton.setBounds(596, 440, 159, 33);
		confirmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!departmentComboBox.getSelectedItem().equals("Please choose one ")) {
					Doctor doctor = null;
					for (Doctor d : manager.getDoctors().values()) {
						if (doctorComboBox.getSelectedItem().equals(d.getName() + " " + d.getSurname())) {
							doctor = d;
							break;
						}
					}

					Appointment appointment = new Appointment(patient.getName() + " " + patient.getSurname(),
							!vaccineCheckBox.isSelected(), patient.getId(), doctor,
							dayComboBox.getSelectedItem() + "." + monthComboBox.getSelectedItem() + ".2021",
							hourComboBox.getSelectedItem() + ".00", doctor.getDepartment().name());

					doctor.addAppointment(appointment);
					patient.addAppointment(appointment);

					ArrayList<Appointment> arr = new ArrayList<>();

					Iterator<Patient> iterator = manager.getPatients().values().iterator();

					while (iterator.hasNext())
						arr.addAll(iterator.next().getAppointmentList());

					try {
						FileOperations.writeAppointments(arr, manager.appointmentPath);
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}

					JOptionPane.showMessageDialog(reference, "Appointment created successfully.");
					setVisible(false);
					manager.patientScreen.setVisible(true);
				}
			}
		});
		contentPane.add(confirmButton);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(MakeAnAppointment.class.getResource("/Swing/images/c516ff9163fefeaa5974fc7c8855cd02.jpg")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);

	}

	private void setHours(Doctor d, int day, int month){
		hourComboBox.removeAllItems();
		for (int i = 9; i < 18; i++) {

			boolean flag = true;
			for (Appointment a : d.getAppointments()) {
				int apDay = Integer.parseInt(a.getAppointmentDate().substring(0,2));
				int apMonth = Integer.parseInt(a.getAppointmentDate().substring(3,5));
				int time = Integer.parseInt(a.getAppointmentTime().substring(0,2));
				if (time == i && day == apDay && apMonth == month){
					flag = false;
					break;
				}
			}
			if (flag)
				hourComboBox.addItem(i);
		}

	}
}