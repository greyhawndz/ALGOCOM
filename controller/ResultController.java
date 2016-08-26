package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import model.Cluster;
import model.Model;

import model.Student;
import view.MainFrame;

public class ResultController{
	
	private MainFrame mainFrame;
	private int numOfGroups;
	private LinkedHashMap<String, ArrayList<Student>> resultMap;
        private Model model;
        private ArrayList<Student> students;
        private ArrayList<Cluster> clusters;
        private boolean noChange = false;
        private float min;
        private float max;
        private int maxClusterSize;
	public ResultController(MainFrame mainFrame, int numOfGroups) {
		this.mainFrame = mainFrame;
		this.numOfGroups = numOfGroups;
		this.resultMap = new LinkedHashMap<String, ArrayList<Student>>();
                model = new Model();
                students = model.getListOfStudents();
                clusters = new ArrayList();
                maxClusterSize = Math.floorDiv(students.size(), numOfGroups);
	}

	public void performAlgorithm() {
		// PANG TEST LANG TO
		
		// PANG TEST LANG TO
		initializeClusters();
                assignToInitialCluster();
                while(noChange == false){
                    iterate();
                    assignToNewCluster();
                }
                System.out.println("Final");
                for(Cluster cluster : clusters){
                    ArrayList<Student> output = cluster.getStudents();
//                    System.out.println("Cluster " +cluster.getId());
//                    for(Student student : output){
//                        System.out.println(student.getName());
//                    }
//                    System.out.println("");
                    resultMap.put("Group " + (cluster.getId()+1), output);
                }
	}
        
        public void initializeClusters(){
            float upperBound = getUpperBounds();
            float lowerBound = getLowerBounds();
            for(int i = 0; i < numOfGroups;i++){
                float centroid = randomWithRange(lowerBound, upperBound);
                Cluster cluster = new Cluster(i);
                cluster.setCentroid(centroid);
                cluster.setMaxSize(maxClusterSize);
                cluster.setInitialCentroid(centroid);
                System.out.println("Cluster " +cluster.getId() + " centroid: " +centroid);
                clusters.add(cluster);
            }
        }
        
        public void assignToInitialCluster(){
            int assignId;
            float temp; 
            ArrayList<Cluster> bestCluster = new ArrayList();
                for(Student student : students){
                    assignId = 0;
                    
                    temp = Math.abs(student.getAverage() - clusters.get(0).getCentroid());
                    for(int i = 0; i < clusters.size(); i++){
                        int id = clusters.get(i).getId();
                        
                        float distance = Math.abs(student.getAverage() - clusters.get(i).getCentroid());
                        //System.out.println("Distance: " + distance);
                        //System.out.println("Temp: " + temp);
                        if(clusters.get(i).getMemberCount() >= clusters.get(i).getMaxSize()){
                            temp = distance;
                            continue;
                        }
                        if(distance <= temp){
                            temp = distance;
                            assignId = id;
                            bestCluster.add(clusters.get(i));
                            //System.out.println("assignid: " +assignId);
                        }
                        
                    }
                    
                    clusters.get(assignId).addStudent(student);
                    student.setAssignId(assignId);
                }
                System.out.println("Initial");
                for(Cluster cluster : clusters){
                    ArrayList<Student> output = cluster.getStudents();
                    System.out.println("Cluster " +cluster.getId());
                    for(Student student : output){
                        System.out.println(student.getName());
                    }
                    System.out.println("");
                }
        }
        
        public void assignToNewCluster(){
            int assignId;
            float temp; 
            noChange = true;
                for(Student student : students){
                    assignId = 0;
                    temp = Math.abs(student.getAverage() - clusters.get(0).getCentroid());
                    for(int i = 0; i < clusters.size(); i++){
                        int id = clusters.get(i).getId();
                        
                        float distance = Math.abs(student.getAverage() - clusters.get(i).getCentroid());
                        
                        if(clusters.get(i).getMemberCount() >= clusters.get(i).getMaxSize()){
                            temp = distance;
                            continue;
                        }
                        if(distance <= temp){
                            temp = distance;
                            assignId = id;
                           System.out.println("assignid: " +assignId);
                        }
                        
                    }
                    if(assignId != student.getAssignId()){
                        noChange = false;
                    }
                    clusters.get(assignId).addStudent(student);
                    student.setAssignId(assignId);
                }
                System.out.println("New group");
                for(Cluster cluster : clusters){
                    ArrayList<Student> output = cluster.getStudents();
                    System.out.println("Cluster " +cluster.getId());
                    for(Student student : output){
                        System.out.println(student.getName());
                    }
                    System.out.println("");
                }
        }
        
        public void iterate(){
            ArrayList<Student> students;
            float newCentroid = 0;
            for(Cluster cluster : clusters){
                students = cluster.getStudents();
                Student phantomStudent = new Student();
                phantomStudent.setAverage(cluster.getInitialCentroid());
                students.add(phantomStudent);
                for(Student student : students){
                   newCentroid += student.getAverage();
                }
                
                
                newCentroid/= students.size() + 1;
                
                
                System.out.println("New centroid: " +newCentroid);
                cluster.setCentroid(newCentroid);
                cluster.clear();
                cluster.setMemberCount(0);
            }
        }
        
        public float randomWithRange(float min, float max){
            float range = max - min;
            Random rand = new Random();
         //   System.out.println("Range: " + range);
            float random = (rand.nextFloat() * range) + min;
         //   System.out.println("Random: " +random);
            return random;
        }
        
        public float getLowerBounds(){
            float temp = 0;
            float lowest;
            lowest = students.get(0).getAverage();
            for(Student student : students){
                temp = student.getAverage();
           //     System.out.println("Low: " + temp);
                if(temp <= lowest){
                    lowest = temp;
                }
            }
            System.out.println("Lowest: "+ lowest);
            min = lowest;
            return lowest;
        }
        
        public float getUpperBounds(){
            float temp = 0;
            float highest;
            highest = students.get(0).getAverage();
            for(Student student: students){
                temp = student.getAverage();
           //     System.out.println("High: " +temp);
                if(temp > highest){
                    highest = temp;
                }
            }
            System.out.println("Highest: " +highest);
            max = highest;
            return highest;
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
