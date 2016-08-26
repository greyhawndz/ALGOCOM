package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.StudentController;
import model.Model;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class InputStudentsView extends JPanel implements ActionListener, KeyListener  {

	private MainFrame mainFrame;
	
	/** Controller */
	private StudentController controller;
	
	private JTextField txtfldNumOfGroups;
	private	JList jListOfStudents;
	private JButton btnAddGroupCount;
	private JButton btnSubGroupCount;
	private JButton btnCreateGroup;
	private JButton btnAddStudent;
	
	private JTable resultTable;
	private JScrollPane jscrllpnlTable;
	
	public InputStudentsView(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 875, 434);
		setLayout(null);
		
		controller = new StudentController(mainFrame, this);
		
		/** Initial model for table */
        String [] header={};
        String [][] data={};
        DefaultTableModel tableModel = new DefaultTableModel(data,header);
        
        /** JTable setup */
        resultTable = new JTable(tableModel);
//        resultTable.setPreferredScrollableViewportSize(new Dimension(450,63));
        resultTable.setFillsViewportHeight(true);
		refreshStudentList();
        
        jscrllpnlTable=new JScrollPane(resultTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // jscrllpnlTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
         jscrllpnlTable.setBounds(24, 22, 669, 313);
         jscrllpnlTable.setVisible(true);
         add(jscrllpnlTable);
		
		JLabel lblNumberOfGroups = new JLabel("Number of Groups");
		lblNumberOfGroups.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfGroups.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumberOfGroups.setBounds(717, 88, 102, 27);
		add(lblNumberOfGroups);
		
		btnAddGroupCount = new JButton("+");
		btnAddGroupCount.setBounds(789, 126, 76, 54);
		btnAddGroupCount.addActionListener(this);
		add(btnAddGroupCount);
		
		btnSubGroupCount = new JButton("-");
		btnSubGroupCount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSubGroupCount.setBounds(703, 126, 76, 54);
		btnSubGroupCount.addActionListener(this);
		add(btnSubGroupCount);
		
		txtfldNumOfGroups = new JTextField();
		txtfldNumOfGroups.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtfldNumOfGroups.setText("1");
		txtfldNumOfGroups.setBounds(829, 88, 36, 27);;
		txtfldNumOfGroups.addActionListener(this);
		add(txtfldNumOfGroups);
		txtfldNumOfGroups.setColumns(10);
		
		btnCreateGroup = new JButton("Create Groups");
		btnCreateGroup.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreateGroup.setBounds(703, 191, 162, 66);
		btnCreateGroup.addActionListener(this);
		add(btnCreateGroup);
		
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddStudent.setBounds(24, 346, 193, 66);
		btnAddStudent.addActionListener(this);
		add(btnAddStudent);
	}

	public int getNumberOfGroups(){
		int input = 1;
		String inputString = txtfldNumOfGroups.getText();
		if(inputString.equals(""))
			inputString="1";
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
			if(numOfGroups<1){
				numOfGroups=1;
			}
			txtfldNumOfGroups.setText(String.valueOf(numOfGroups));
		} 
		else if(ae.getSource() == btnAddStudent){
			controller.viewAddStudent();
		}
		else if(ae.getSource()== btnCreateGroup){
			controller.createGroups(getNumberOfGroups());
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

	public void refreshStudentList() {
	    DefaultTableModel model = new DefaultTableModel();

	    model = controller.getStudentsTableModel();
	    
		resultTable.setModel(model);
	}
}
