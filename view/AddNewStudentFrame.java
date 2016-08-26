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
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JTextField txtfldAlgocom;
	private JTextField txtfldSocialStudies;
	
	public AddNewStudentFrame(StudentController controller) {
		this.controller = controller;
		/** Frame setup */
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, 288, 339);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{54, 86, 77, 62, 0};
		gridBagLayout.rowHeights = new int[]{50, 20, 20, 21, 20, 20, 20, 20, 35, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		setBounds(100, 100, 450, 300);
		//		contentPane = new JPanel();
		//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//		setContentPane(contentPane);
		//		contentPane.setLayout(null);
				
				JLabel lblName = new JLabel("Name");
				lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
				GridBagConstraints gbc_lblName = new GridBagConstraints();
				gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblName.insets = new Insets(0, 0, 5, 5);
				gbc_lblName.gridx = 1;
				gbc_lblName.gridy = 1;
				getContentPane().add(lblName, gbc_lblName);
		
		txtfldName = new JTextField();
		txtfldName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_txtfldName = new GridBagConstraints();
		gbc_txtfldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldName.anchor = GridBagConstraints.NORTH;
		gbc_txtfldName.insets = new Insets(0, 0, 5, 5);
		gbc_txtfldName.gridx = 2;
		gbc_txtfldName.gridy = 1;
		getContentPane().add(txtfldName, gbc_txtfldName);
		txtfldName.setColumns(10);
		
		lblMathematics = new JLabel("Mathematics");
		lblMathematics.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMathematics = new GridBagConstraints();
		gbc_lblMathematics.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMathematics.insets = new Insets(0, 0, 5, 5);
		gbc_lblMathematics.gridx = 1;
		gbc_lblMathematics.gridy = 2;
		getContentPane().add(lblMathematics, gbc_lblMathematics);
		
		txtfldMathematics = new JTextField();
		txtfldMathematics.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_txtfldMathematics = new GridBagConstraints();
		gbc_txtfldMathematics.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldMathematics.anchor = GridBagConstraints.NORTH;
		gbc_txtfldMathematics.insets = new Insets(0, 0, 5, 5);
		gbc_txtfldMathematics.gridx = 2;
		gbc_txtfldMathematics.gridy = 2;
		getContentPane().add(txtfldMathematics, gbc_txtfldMathematics);
		txtfldMathematics.setColumns(10);
		
		lblScience = new JLabel("Science");
		lblScience.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblScience = new GridBagConstraints();
		gbc_lblScience.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblScience.insets = new Insets(0, 0, 5, 5);
		gbc_lblScience.gridx = 1;
		gbc_lblScience.gridy = 3;
		getContentPane().add(lblScience, gbc_lblScience);
		
		txtfldScience = new JTextField();
		txtfldScience.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_txtfldScience = new GridBagConstraints();
		gbc_txtfldScience.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldScience.anchor = GridBagConstraints.SOUTH;
		gbc_txtfldScience.insets = new Insets(0, 0, 5, 5);
		gbc_txtfldScience.gridx = 2;
		gbc_txtfldScience.gridy = 3;
		getContentPane().add(txtfldScience, gbc_txtfldScience);
		txtfldScience.setColumns(10);
		
		lblEnglish = new JLabel("English");
		lblEnglish.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEnglish = new GridBagConstraints();
		gbc_lblEnglish.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEnglish.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnglish.gridx = 1;
		gbc_lblEnglish.gridy = 4;
		getContentPane().add(lblEnglish, gbc_lblEnglish);
		
		txtfldEnglish = new JTextField();
		txtfldEnglish.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_txtfldEnglish = new GridBagConstraints();
		gbc_txtfldEnglish.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldEnglish.anchor = GridBagConstraints.NORTH;
		gbc_txtfldEnglish.insets = new Insets(0, 0, 5, 5);
		gbc_txtfldEnglish.gridx = 2;
		gbc_txtfldEnglish.gridy = 4;
		getContentPane().add(txtfldEnglish, gbc_txtfldEnglish);
		txtfldEnglish.setColumns(10);
		
		lblFilipino = new JLabel("Filipino");
		lblFilipino.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFilipino = new GridBagConstraints();
		gbc_lblFilipino.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFilipino.insets = new Insets(0, 0, 5, 5);
		gbc_lblFilipino.gridx = 1;
		gbc_lblFilipino.gridy = 5;
		getContentPane().add(lblFilipino, gbc_lblFilipino);
		
		txtfldFilipino = new JTextField();
		txtfldFilipino.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_txtfldFilipino = new GridBagConstraints();
		gbc_txtfldFilipino.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldFilipino.anchor = GridBagConstraints.NORTH;
		gbc_txtfldFilipino.insets = new Insets(0, 0, 5, 5);
		gbc_txtfldFilipino.gridx = 2;
		gbc_txtfldFilipino.gridy = 5;
		getContentPane().add(txtfldFilipino, gbc_txtfldFilipino);
		txtfldFilipino.setColumns(10);
		
		lblSocialStudies = new JLabel("Social Studies");
		lblSocialStudies.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSocialStudies = new GridBagConstraints();
		gbc_lblSocialStudies.anchor = GridBagConstraints.WEST;
		gbc_lblSocialStudies.insets = new Insets(0, 0, 5, 5);
		gbc_lblSocialStudies.gridx = 1;
		gbc_lblSocialStudies.gridy = 6;
		getContentPane().add(lblSocialStudies, gbc_lblSocialStudies);
		
		txtfldSocialStudies = new JTextField();
		GridBagConstraints gbc_txtfldSocialStudies = new GridBagConstraints();
		gbc_txtfldSocialStudies.insets = new Insets(0, 0, 5, 5);
		gbc_txtfldSocialStudies.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldSocialStudies.gridx = 2;
		gbc_txtfldSocialStudies.gridy = 6;
		getContentPane().add(txtfldSocialStudies, gbc_txtfldSocialStudies);
		txtfldSocialStudies.setColumns(10);
		
		lblAlgocom = new JLabel("ALGOCOM");
		lblAlgocom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAlgocom = new GridBagConstraints();
		gbc_lblAlgocom.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAlgocom.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlgocom.gridx = 1;
		gbc_lblAlgocom.gridy = 7;
		getContentPane().add(lblAlgocom, gbc_lblAlgocom);
		
		txtfldAlgocom = new JTextField();
		txtfldAlgocom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_txtfldAlgocom = new GridBagConstraints();
		gbc_txtfldAlgocom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfldAlgocom.anchor = GridBagConstraints.NORTH;
		gbc_txtfldAlgocom.insets = new Insets(0, 0, 5, 5);
		gbc_txtfldAlgocom.gridx = 2;
		gbc_txtfldAlgocom.gridy = 7;
		getContentPane().add(txtfldAlgocom, gbc_txtfldAlgocom);
		txtfldAlgocom.setColumns(10);
		
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(this);
		GridBagConstraints gbc_btnAddStudent = new GridBagConstraints();
		gbc_btnAddStudent.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddStudent.gridwidth = 2;
		gbc_btnAddStudent.fill = GridBagConstraints.VERTICAL;
		gbc_btnAddStudent.gridx = 1;
		gbc_btnAddStudent.gridy = 9;
		getContentPane().add(btnAddStudent, gbc_btnAddStudent);
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
