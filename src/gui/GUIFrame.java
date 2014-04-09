package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class GUIFrame extends JFrame {
	
	   JTabbedPane tabbed = new JTabbedPane(JTabbedPane.LEFT);
	  
	   JComponent panel1 = new JPanel();
	   JComponent panel2 = new JPanel();
	   
	public GUIFrame() {
		super("Anti-Sloth");
		super.setSize(400, 400);
		

		
		
		tab();
		menubar();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	

	public void tab() {
		
		//adding a tab frame to the content pane
		tabbed.setBounds(20,20, 360, 360);
		getContentPane().add(tabbed);
		
		//adding tabs to the tabbed frame, and connecting each tab with each panel
		tabbed.addTab("Test", null, panel1, "Does nothing");
		tabbed.addTab("Test2", null, panel2, "Does nothing");
		
		
		//intiating a new button
		JComponent but = new JButton();		
		
		but.setLocation(40, 40);
		panel1.add(but);
		
		
		
	}
	
	
	public void menubar() {
		//initializing menu, menubar and the menu items
		JMenuBar menuBar = new JMenuBar();
		JMenu menu, submenu;
		JMenuItem TOItem;
		JRadioButtonMenuItem rbMenuItem;
		
		
		//adding the menu to the menu bar
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		
		//initiating menuItem
		TOItem = new JMenuItem("Text only item");
		TOItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		
		
		//adding ites to the menu
		
		menu.add(TOItem);
		menu.addSeparator();
//		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(false);
//		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("Another one");
		menu.add(rbMenuItem);
		
		//adding menubar to frame
		super.setJMenuBar(menuBar);
		
		
	}
	
	
	public void add (JComponent Panel, JComponent Comp) {
		
	}
	
	public static void main(String [] args) {
		GUIFrame test = new GUIFrame();
		
	}
}
