package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Model;
import model.Student;
import net.proteanit.sql.DbUtils;
import view.AddNewStudentFrame;
import view.InputStudentsView;
import view.MainFrame;

public class StudentController {
	
	InputStudentsView view;
	MainFrame mainFrame;
	Model model;

	public StudentController(MainFrame mainFrame, InputStudentsView view) {
		this.mainFrame = mainFrame;
		this.model = new Model();
		this.view = view;
	}

	public void viewAddStudent() {
		new AddNewStudentFrame(this);
	}

	public void addStudent(String name, String mathGrade, String scienceGrade, String englishGrade, String filipinoGrade, String socialStudiesGrade, String algocomGrade) {
		Student student = new Student(name, Integer.valueOf(mathGrade), Integer.valueOf(scienceGrade), Integer.valueOf(englishGrade), Integer.valueOf(filipinoGrade), Integer.valueOf(socialStudiesGrade), Integer.valueOf(algocomGrade));
		model.addNewStudent(student);
		view.refreshStudentList();
	}

	public DefaultTableModel getStudentsTableModel() {
		ResultSet rs = model.getStudentsInfo();
		DefaultTableModel tableModel = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
		return tableModel;
	}

	public void createGroups(int numOfGroups) {
		mainFrame.renderView("resultController", numOfGroups);
	}

}
