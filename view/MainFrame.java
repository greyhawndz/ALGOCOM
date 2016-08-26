package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import com.seaglasslookandfeel.*;

import controller.ResultController;

public class MainFrame extends JFrame {

	private JPanel currentPanel;
	
	public MainFrame(String appName) {
		/** Frame setup */
		this.setTitle(appName);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 875, 450);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void renderView(String view) {
		if(view.equals("InputStudents")) {
			currentPanel = new InputStudentsView(this); 
		}
		this.setContentPane((JPanel) currentPanel);        
		frameRevalidate();   
    }

	public void renderView(String view, int numOfGroups) {
		if(view.equals("resultController")){
			currentPanel = new GroupingResultView(new ResultController(this, numOfGroups));
		}
		this.setContentPane((JPanel) currentPanel);        
		frameRevalidate();   
    }
	
	private void frameRevalidate() {
		validate();
		repaint();
		setVisible(true);
	}
}

