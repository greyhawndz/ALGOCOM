package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import controller.MainMenuController;
import model.Model;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class MainMenuView extends JPanel implements ActionListener, KeyListener  {

	private MainFrame mainFrame;
	
	/** Controller */
	private MainMenuController controller;
	private JTextField txtfldNumOfGroups;
	private JTextField txtfldStudentQuery;
	private	JList jListOfStudents;
	private JButton btnAddGroupCount;
	private JButton btnSubGroupCount;
	private JButton btnCreateGroup;
	private JButton btnAddStudent;
	private JButton btnViewStudent;
	private JButton btnQueryStudent;
	private JButton btnClearQuery;
	
	public MainMenuView(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 683, 434);
		setLayout(null);
		
		controller = new MainMenuController(this);
		
		/** INITIALIZE LIST OF STUDENTS */
		jListOfStudents = new JList((ListModel) Model.getListOfStudents());
		jListOfStudents.setBounds(24, 22, 477, 313);
		add(jListOfStudents);
		
		JLabel lblNumberOfGroups = new JLabel("Number of Groups");
		lblNumberOfGroups.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumberOfGroups.setBounds(511, 102, 102, 14);
		add(lblNumberOfGroups);
		
		btnAddGroupCount = new JButton("+");
		btnAddGroupCount.setBounds(597, 127, 76, 54);
		add(btnAddGroupCount);
		
		btnSubGroupCount = new JButton("-");
		btnSubGroupCount.setBounds(511, 127, 76, 54);
		add(btnSubGroupCount);
		
		txtfldNumOfGroups = new JTextField();
		txtfldNumOfGroups.setBounds(623, 99, 32, 17);
		add(txtfldNumOfGroups);
		txtfldNumOfGroups.setColumns(10);
		
		btnCreateGroup = new JButton("Create Group");
		btnCreateGroup.setBounds(511, 192, 162, 66);
		add(btnCreateGroup);
		
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(24, 346, 193, 66);
		add(btnAddStudent);
		
		btnViewStudent = new JButton("View Student");
		btnViewStudent.setBounds(227, 346, 193, 66);
		add(btnViewStudent);
		
		txtfldStudentQuery = new JTextField();
		txtfldStudentQuery.setBounds(430, 346, 243, 20);
		add(txtfldStudentQuery);
		txtfldStudentQuery.setColumns(10);
		
		btnQueryStudent = new JButton("Query Student");
		btnQueryStudent.setBounds(430, 373, 126, 39);
		add(btnQueryStudent);
		
		btnClearQuery = new JButton("Clear Query");
		btnClearQuery.setBounds(555, 373, 118, 39);
		add(btnClearQuery);
	}

	public int getNumberOfGroups(){
		int input = 0;
		try{
			input = Integer.valueOf(txtfldNumOfGroups.getText());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(mainFrame,
				    "Number of groups is not valid",
				    "Suh",
				    JOptionPane.ERROR_MESSAGE);
		}
		return input;
	}
	
	public String getSelectedStudent(){
		String student="";
		student = (String)jListOfStudents.getSelectedValue();
		return student;
	}
	
	/** START OF ACTION LISTENERS */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnAddGroupCount) {
			int numOfGroups = getNumberOfGroups();
			numOfGroups++;
			txtfldNumOfGroups.setText(String.valueOf(numOfGroups));
		}
		else if(ae.getSource() == btnSubGroupCount){
			int numOfGroups = getNumberOfGroups();
			numOfGroups--;
			if(numOfGroups<0){
				numOfGroups=0;
			}
			txtfldNumOfGroups.setText(String.valueOf(numOfGroups));
		} else if(ae.getSource() == btnClearQuery){
			txtfldStudentQuery.setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
//		if(ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getSource() == chatInputTxtField)	{
//		
//		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}
}
