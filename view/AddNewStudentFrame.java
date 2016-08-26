package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.handler.MessageContext.Scope;

import controller.StudentController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddNewStudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtfldName;
	private JButton btnAddStudent;
	
	private StudentController controller;
	private JLabel lblMathematics;
	private JLabel lblScience;
	private JLabel lblEnglish;
	private JLabel lblFilipino;
	private JLabel lblSocialStudies;
	private JLabel lblAlgocom;
	private JTextField txtfldMathematics;
	private JTextField txtfldScience;
	private JTextField txtfldEnglish;
	private JTextField txtfldFilipino;
	private JTextField txtfldSocialStudies;
	private JTextField txtfldAlgocom;
	
	public AddNewStudentFrame(StudentController controller) {
		this.controller = controller;
		/** Frame setup */
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, 398, 339);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		getContentPane().setLayout(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 71, 14);
		getContentPane().add(lblName);
		
		txtfldName = new JTextField();
		txtfldName.setBounds(91, 8, 86, 20);
		getContentPane().add(txtfldName);
		txtfldName.setColumns(10);
		
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(261, 264, 121, 35);
		btnAddStudent.addActionListener(this);
		getContentPane().add(btnAddStudent);
		
		lblMathematics = new JLabel("Mathematics");
		lblMathematics.setBounds(10, 42, 71, 14);
		getContentPane().add(lblMathematics);
		
		lblScience = new JLabel("Science");
		lblScience.setBounds(10, 67, 71, 14);
		getContentPane().add(lblScience);
		
		lblEnglish = new JLabel("English");
		lblEnglish.setBounds(10, 102, 71, 14);
		getContentPane().add(lblEnglish);
		
		lblFilipino = new JLabel("Filipino");
		lblFilipino.setBounds(10, 133, 71, 14);
		getContentPane().add(lblFilipino);
		
		lblSocialStudies = new JLabel("Social Studies");
		lblSocialStudies.setBounds(10, 161, 71, 14);
		getContentPane().add(lblSocialStudies);
		
		lblAlgocom = new JLabel("ALGOCOM");
		lblAlgocom.setBounds(10, 192, 71, 14);
		getContentPane().add(lblAlgocom);
		
		txtfldMathematics = new JTextField();
		txtfldMathematics.setBounds(91, 39, 86, 20);
		getContentPane().add(txtfldMathematics);
		txtfldMathematics.setColumns(10);
		
		txtfldScience = new JTextField();
		txtfldScience.setBounds(91, 68, 86, 20);
		getContentPane().add(txtfldScience);
		txtfldScience.setColumns(10);
		
		txtfldEnglish = new JTextField();
		txtfldEnglish.setBounds(91, 99, 86, 20);
		getContentPane().add(txtfldEnglish);
		txtfldEnglish.setColumns(10);
		
		txtfldFilipino = new JTextField();
		txtfldFilipino.setBounds(91, 130, 86, 20);
		getContentPane().add(txtfldFilipino);
		txtfldFilipino.setColumns(10);
		
		txtfldSocialStudies = new JTextField();
		txtfldSocialStudies.setBounds(91, 158, 86, 20);
		getContentPane().add(txtfldSocialStudies);
		txtfldSocialStudies.setColumns(10);
		
		txtfldAlgocom = new JTextField();
		txtfldAlgocom.setBounds(91, 189, 86, 20);
		getContentPane().add(txtfldAlgocom);
		txtfldAlgocom.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnAddStudent){
			String name = txtfldName.getText();
			String mathGrade = txtfldMathematics.getText();
			String scienceGrade = txtfldScience.getText();
			String englishGrade = txtfldEnglish.getText();
			String filipinoGrade = txtfldFilipino.getText();
			String socialStudiesGrade = txtfldSocialStudies.getText();
			String algocomGrade = txtfldAlgocom.getText();
			
			controller.addStudent(name, mathGrade, scienceGrade, englishGrade, filipinoGrade, socialStudiesGrade, algocomGrade);
			this.dispose();
		}
	}

}
