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
                PreparedStatement pst;
                String sql = "INSERT INTO students (name, math_grade, science_grade, english_grade, filipino_grade, socialstudies_grade, algocom_grade) VALUES ("
                             + student.getName() + "," + student.getMathGrade() + "," + student.getScienceGrade() + "," + student.getEnglishGrade() + "," + student.getFilipinoGrade() + "," + student.getSocialStudiesGrade() + "," +student.getAlgocomGrade() + ")";
                try{
                    pst = conn.prepareStatement(sql);
                    pst.executeQuery();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
        }
        

	public ResultSet getStudentsInfo() {
		ResultSet rs = null;
		String query = "SELECT name AS 'Name', math_grade AS 'Math', science_grade AS 'Science', english_grade AS 'English', filipino_grade AS 'Filipino', socialstudies_grade AS 'Social Studies', algocom_grade AS 'ALGOCOM' FROM students";
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
