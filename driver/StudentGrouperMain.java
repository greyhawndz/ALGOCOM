package driver;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.MakeSound;
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
		new MakeSound().playSound("src/jeopardy.wav");
	}
}
