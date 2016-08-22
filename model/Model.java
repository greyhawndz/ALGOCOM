package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Model {
	
	private DBConnection db;
	
	public ArrayList<Student> getListOfStudents(){
		ArrayList<Student> listOfStudents = new ArrayList<>();
		//TODO SQL QUERY HERE
		//TODO ADD TO listOfStudents ARRAYLIST
		return listOfStudents;
	}

	public void addNewStudent(Student student) {
		//TODO SQL INSERT QUERY HERE
	}

	public ResultSet getStudentsInfo() {
		db = new DBConnection();
		db.getConnection();
		
		ResultSet rs = null;
		
		try{
			//TODO CHANGE QUERY TO LEGIT gumawa lang ako temp query for testing e
	        String query = "Select * from students";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        rs = pst.executeQuery();
		} catch(Exception e) {
			
		}
		return rs;
	}
	
}
