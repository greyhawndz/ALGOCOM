/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author William
 */
import java.util.ArrayList;
import java.util.List;
public class Cluster {
    public ArrayList<Student> points;
	public float centroid;
	public int id;
	
	//Creates a new Cluster
	public Cluster(int id) {
		this.id = id;
		this.points = new ArrayList<>();
		this.centroid = 0;
	}
 
	public ArrayList getStudents() {
		return points;
	}
	
	public void addStudent(Student point) {
		points.add(point);
	}
 
	public void setStudents(ArrayList points) {
		this.points = points;
	}
 
	public float getCentroid() {
		return centroid;
	}
 
	public void setCentroid(float centroid) {
		this.centroid = centroid;
	}
 
	public int getId() {
		return id;
	}
	
	public void clear() {
		points.clear();
	}
	
	public void plotCluster() {
		System.out.println("[Cluster: " + id+"]");
		System.out.println("[Centroid: " + centroid + "]");
		System.out.println("[Points: \n");
		for(Student p : points) {
			System.out.println(p);
		}
		System.out.println("]");
	}
}
