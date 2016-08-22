package driver;

import javax.swing.UIManager;

import view.MainFrame;

public class StudentGrouperMain {

	public static void main(String[] args) {
		try 
	    { 
	        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel"); 
	    } 
	    catch(Exception e){ 
	    }
		new MainFrame("Computing for Good Shit").renderView("InputStudents");
	}

}
