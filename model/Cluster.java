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
    private ArrayList<Student> points;
	private float centroid;
        private float initialCentroid;
	private int id;
        private int maxSize;
	private int memberCount = 0;
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
                memberCount++;
	}

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }
        
        
	public void setStudents(ArrayList points) {
		this.points = points;
	}

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public ArrayList<Student> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Student> points) {
        this.points = points;
    }

    public float getInitialCentroid() {
        return initialCentroid;
    }

    public void setInitialCentroid(float initialCentroid) {
        this.initialCentroid = initialCentroid;
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
