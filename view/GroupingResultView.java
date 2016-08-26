package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.ResultController;
import controller.StudentController;
import java.util.ArrayList;

public class GroupingResultView extends JPanel implements ActionListener, KeyListener, ListSelectionListener {
	
	/** Controller */
	private ResultController controller;
	
	private JTable resultTable;
	private JScrollPane jscrllpnlTable;
	private JList jListGroups;
	private JButton btnBack;
	
	public GroupingResultView(ResultController resultController) {
		this.setBounds(0, 0, 875, 434);
		
		controller = resultController;
		controller.performAlgorithm();
		
		/** INITIALIZE LIST OF GROUPS */
		jListGroups = new JList(controller.getListOfGroups());
		jListGroups.setBounds(10, 11, 164, 313);
		jListGroups.addListSelectionListener(this);
		add(jListGroups);
		
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
        jscrllpnlTable.setBounds(196, 11, 669, 313);
         jscrllpnlTable.setVisible(true);
         setLayout(null);
         add(jscrllpnlTable);
         
         btnBack = new JButton("Back");
         btnBack.setBounds(10, 367, 164, 23);
         btnBack.addActionListener(this);
         add(btnBack);
	}

	
	
	/** START OF ACTION LISTENERS */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnBack) {
			controller.goBack();
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

//	    model = controller.getStudentsTableModel();
	    
		resultTable.setModel(model);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent ae) {
		if(ae.getSource() == jListGroups){
			String groupName = jListGroups.getSelectedValue().toString();
			DefaultTableModel tableModel = controller.getGroupMembers(groupName);
			resultTable.setModel(tableModel);
		}
	}
}
