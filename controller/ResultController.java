package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

import model.Student;
import view.MainFrame;

public class ResultController{
	
	private MainFrame mainFrame;
	private int numOfGroups;
	private HashMap<String, ArrayList<Student>> resultMap;

	public ResultController(MainFrame mainFrame, int numOfGroups) {
		this.mainFrame = mainFrame;
		this.numOfGroups = numOfGroups;
		this.resultMap = new HashMap<String, ArrayList<Student>>();
	}

	public void performAlgorithm() {
		// PANG TEST LANG TO
		ArrayList<Student> fuck = new ArrayList<>();
		fuck.add(new Student("fuck", 1, 1, 1, 1, 1, 1));
		resultMap.put("Group1", fuck);
		// PANG TEST LANG TO
		
		//TODO ALGO HERE, save to resultMap
	}

	public ListModel getListOfGroups() {
		DefaultListModel<String> groupList = new DefaultListModel<>();
		for ( String key : resultMap.keySet() ) {
			groupList.addElement(key);
		}
		return groupList;
	}

	public void goBack() {
		mainFrame.renderView("InputStudents");
	}

	public DefaultTableModel getGroupMembers(String groupName) {
		ArrayList<Student> groupMembers = resultMap.get(groupName);
		
		Object rowData[][] = new Object[groupMembers.size()][7]; 
		Object columnNames[] = {"Name", "Mathematics", "Science", "Filipino", "Social Studies", "Algocom"};
		
		int row=0;
		int col=0;
		for(Student student : groupMembers){
			rowData[row][col] = student.getName();
			rowData[row][col+1] = student.getMathGrade();
			rowData[row][col+2] = student.getScienceGrade();
			rowData[row][col+3] = student.getEnglishGrade();
			rowData[row][col+4] = student.getFilipinoGrade();
			rowData[row][col+5] = student.getSocialStudiesGrade();
			rowData[row][col+6] = student.getAlgocomGrade();
			
			row++;
		}
		
		return new DefaultTableModel(rowData, columnNames);
	}

}
