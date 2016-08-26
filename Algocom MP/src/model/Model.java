package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Model {
	
	private DBConnection db;
        private Connection conn;
        
        public Model(){
            db = DBConnection.getInstance();
            conn = db.getConnection();
        }
	
	public ArrayList<Student> getListOfStudents(){
		ArrayList<Student> listOfStudents = new ArrayList<>();
		//TODO SQL QUERY HERE
                PreparedStatement pst;
                String sql = "SELECT * FROM students";
                ResultSet rs;
                try{
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    while(rs.next()){
                        Student student = new Student(rs.getString("name"), 
                                rs.getFloat("math_grade"), 
                                rs.getFloat("science_grade"),
                                rs.getFloat("english_grade"), 
                                rs.getFloat("filipino_grade"),
                        rs.getFloat("socialstudies_grade"),
                        rs.getFloat("algocom_grade"));
                        listOfStudents.add(student);
                    }
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
		//TODO ADD TO listOfStudents ARRAYLIST
		return listOfStudents;
	}

	public void addNewStudent(Student student) {
		//TODO SQL INSERT QUERY HERE	
}

	public ResultSet getStudentsInfo() {
		ResultSet rs = null;
		String query = "SELECT * FROM students";
                PreparedStatement pst;
		try{
	        pst = conn.prepareStatement(query);
	        rs = pst.executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}