package Swing;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Entities.Doctor;
import Management.FileOperations;
import Management.HospitalManagementSystem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorControlScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DoctorControlScreen(HospitalManagementSystem manager, ArrayList<Doctor> jobApplicants, Hashtable<String, Doctor> doctors) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane doctorInfo = new JScrollPane();
		doctorInfo.setBounds(358, 259, 170, 250);
		contentPane.add(doctorInfo);

		JList Doctorinfolist = new JList();
		doctorInfo.setViewportView(Doctorinfolist);
		Doctorinfolist.setEnabled(false);
		Doctorinfolist.setBackground(new Color(255, 255, 255));
		Doctorinfolist.setFont(new Font("Verdana", Font.PLAIN, 12));

		String[] doctorList = new String[doctors.size()];

		Iterator<Doctor> iterator = doctors.values().iterator();

		for (int i = 0; i < doctors.size(); i++) {
			Doctor d = iterator.next();
			doctorList[i] = d.getTitle() + " " + d.getName() + " " + d.getSurname();
		}

		String[] confirm = new String[jobApplicants.size()];

		for (int i = 0; i < jobApplicants.size(); i++) {
			confirm[i] = jobApplicants.get(i).getTitle() + " " + jobApplicants.get(i).getName() + " " + jobApplicants.get(i).getSurname();
		}

		JComboBox confirmdoctorsComboBox = new JComboBox(confirm);
		confirmdoctorsComboBox.setForeground(new Color(0, 0, 102));
		confirmdoctorsComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		confirmdoctorsComboBox.setBackground(Color.WHITE);
		confirmdoctorsComboBox.setBounds(560, 174, 235, 33);
		confirmdoctorsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) confirmdoctorsComboBox.getSelectedItem();
				if (s != null) {
					String name = s.split(" ")[1], surname = s.split(" ")[2];

					Iterator<Doctor> iter = jobApplicants.iterator();
					Doctor d = null;
					while (iter.hasNext()) {
						d = iter.next();

						if (d.getName().equals(name) && d.getSurname().equals(surname))
							break;
					}


					DefaultListModel m = new DefaultListModel();
					m.addElement(d.getTitle());
					m.addElement(d.getName());
					m.addElement(d.getSurname());
					m.addElement(d.getDepartment().name());
					m.addElement(d.getId());
					m.addElement(d.getPhone());
					m.addElement(d.getGender() ? "F" : "M");
					m.addElement(d.getBloodType());
					m.addElement(d.getEmail());
					m.addElement(d.getAddress());
					Doctorinfolist.setModel(m);
				}
			}
		});
		contentPane.add(confirmdoctorsComboBox);



		JComboBox doctorsComboBox = new JComboBox();
		doctorsComboBox.setForeground(new Color(0, 0, 102));
		doctorsComboBox.setModel(new DefaultComboBoxModel(doctorList));
		doctorsComboBox.setBackground(Color.WHITE);
		doctorsComboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		doctorsComboBox.setBounds(83, 174, 235, 33);
		doctorsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) doctorsComboBox.getSelectedItem();
				String name = s.split(" ")[1], surname = s.split(" ")[2];

				Iterator<Doctor> iter = doctors.values().iterator();
				Doctor d = null;
				while (iter.hasNext()){
					d = iter.next();

					if (d.getName().equals(name) && d.getSurname().equals(surname))
						break;
				}


				DefaultListModel m=new DefaultListModel();
				m.addElement(d.getTitle());
				m.addElement(d.getName());
				m.addElement(d.getSurname());
				m.addElement(d.getDepartment().name());
				m.addElement(d.getId());
				m.addElement(d.getPhone());
				m.addElement(d.getGender() ? "F" : "M");
				m.addElement(d.getBloodType());
				m.addElement(d.getEmail());
				m.addElement(d.getAddress());
				Doctorinfolist.setModel(m);
			}
		});
		contentPane.add(doctorsComboBox);

		JButton removebutton = new JButton("Remove");
		removebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) doctorsComboBox.getSelectedItem();
				String name = s.split(" ")[1], surname = s.split(" ")[2];

				Iterator<Doctor> iter = doctors.values().iterator();
				Doctor d = null;
				while (iter.hasNext()){
					 d = iter.next();

					if (d.getName().equals(name) && d.getSurname().equals(surname))
						break;
				}

				if (d != null)
					doctors.remove(d.getId());

				try {
					FileOperations.writeDoctors(doctors, manager.doctorsPath);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}

				doctorsComboBox.removeItemAt(doctorsComboBox.getSelectedIndex());
			}
		});
		removebutton.setFont(new Font("Verdana", Font.BOLD, 14));
		removebutton.setBounds(146, 332, 116, 33);
		contentPane.add(removebutton);

		JButton Confirmbutton = new JButton("Confirm");
		Confirmbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = confirmdoctorsComboBox.getSelectedIndex();
				Doctor newDoctor = jobApplicants.remove(i);
				doctors.put(newDoctor.getId(), newDoctor);
				confirmdoctorsComboBox.removeItemAt(i);
				doctorsComboBox.addItem(confirm[i]);

				try {
					FileOperations.writeDoctors(doctors, manager.doctorsPath);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
		Confirmbutton.setForeground(new Color(0, 0, 102));
		Confirmbutton.setFont(new Font("Verdana", Font.BOLD, 14));
		Confirmbutton.setBounds(625, 333, 116, 31);
		contentPane.add(Confirmbutton);

		JLabel lbldoctorconfirm = new JLabel("CONFIRM");
		lbldoctorconfirm.setForeground(new Color(0, 0, 102));
		lbldoctorconfirm.setFont(new Font("Verdana", Font.BOLD, 24));
		lbldoctorconfirm.setBounds(547, 105, 266, 33);
		contentPane.add(lbldoctorconfirm);



		JLabel BIAHOSPITAL_Label = new JLabel("BIA HOSPITAL");
		BIAHOSPITAL_Label.setBackground(UIManager.getColor("Label.disabledShadow"));
		BIAHOSPITAL_Label.setForeground(new Color(169, 169, 169));
		BIAHOSPITAL_Label.setHorizontalAlignment(SwingConstants.CENTER);
		BIAHOSPITAL_Label.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 35));
		BIAHOSPITAL_Label.setBounds(323, 22, 245, 73);
		contentPane.add(BIAHOSPITAL_Label);

		JLabel lblremovedoctor = new JLabel("REMOVE");
		lblremovedoctor.setFont(new Font("Verdana", Font.BOLD, 24));
		lblremovedoctor.setForeground(new Color(0, 0, 102));
		lblremovedoctor.setBounds(78, 97, 240, 48);
		contentPane.add(lblremovedoctor);


		JButton turnbackbutton = new JButton("Turn Back");
		turnbackbutton.setForeground(new Color(0, 0, 102));
		turnbackbutton.setFont(new Font("Verdana", Font.BOLD, 10));
		turnbackbutton.setBounds(755, 500, 96, 21);
		turnbackbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				manager.adminScreen.setVisible(true);
			}
		});
		contentPane.add(turnbackbutton);


		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(DoctorControlScreen.class.getResource("/Swing/images/caduceus_1024x576.jpg")));
		background.setBounds(-65, -17, 972, 599);
		contentPane.add(background);

	}
}
