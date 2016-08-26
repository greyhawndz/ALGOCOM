package driver;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.MainFrame;

public class StudentGrouperMain {

	public static void main(String[] args) {
		try 
	    { 
//	        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if ("Nimbus".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} catch (Exception e) {
			    // If Nimbus is not available, you can set the GUI to another look and feel.
			}
	    } 
	    catch(Exception e){ 
	    }
		new MainFrame("Computing for Good").renderView("InputStudents");
	}

}
