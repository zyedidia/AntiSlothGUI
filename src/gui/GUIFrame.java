package gui;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class GUIFrame extends JFrame {
	public GUIFrame() {
		super("Anti-Sloth");
		super.setSize(400, 400);
		
		tab();
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void tab() {
		JTabbedPane tabbed = new JTabbedPane(JTabbedPane.TOP);
		tabbed.setBounds(20,20, 360, 360);
		getContentPane().add(tabbed);
		
		JComponent panel1 = new JTabbedPane();
		tabbed.addTab("Test", null, panel1, "Does nothing");
		
		JComponent panel2 = new JTabbedPane();
		tabbed.addTab("Test2", null, panel2, "Does nothing");
		
		JComponent label = new JLabel();
		JComponent but = new JButton();		
		panel1.add(label);
		panel1.add(but);
	}
	
	public void add (JComponent Panel, JComponent Comp) {
		
	}
	
	public static void main(String [] args) {
		GUIFrame test = new GUIFrame();
		
	}
}
