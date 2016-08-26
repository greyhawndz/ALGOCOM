package driver;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;

public class SeaglassTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeaglassTest frame = new SeaglassTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeaglassTest() {
		try 
	    { 
	        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel"); 
	    } 
	    catch(Exception e){ 
	    }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRawr = new JButton("rawr");
		btnRawr.setBounds(262, 129, 167, 127);
		btnRawr.setFocusable(false);
		contentPane.add(btnRawr);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 64, 258, 13);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(53, 181, 89, 23);
		contentPane.add(btnNewButton);
	}
}
