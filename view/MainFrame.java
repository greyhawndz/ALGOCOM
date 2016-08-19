package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JPanel currentPanel;
	
	public MainFrame(String appName) {
		/** Frame setup */
		this.setTitle(appName);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 683, 434);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void renderView(String view) {
		if(view.equals("Main Menu")) {
			currentPanel = new MainMenuView(this); 
		}
		frameRevalidate();
		this.setContentPane((JPanel) currentPanel);
	
                
    }
	
	private void frameRevalidate() {
		validate();
		repaint();
		setVisible(true);
	}
}
