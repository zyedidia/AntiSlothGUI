package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class GUIFrame extends JFrame {

	JTabbedPane tabbed = new JTabbedPane(JTabbedPane.TOP);
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Menu");

	public GUIFrame() {

		super("Anti-Sloth");
		super.setSize(400, 400);

		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		//menubar();

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addTextItemToMenu(String name) {
		JMenuItem TOItem;
		TOItem = new JMenuItem(name);
		TOItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));

		menu.add(TOItem);
		menu.addSeparator();

		super.setJMenuBar(menuBar);
	}

	public void addRadioButtonToMenu(String name) {
		JRadioButtonMenuItem rbMenuItem;

		rbMenuItem = new JRadioButtonMenuItem(name);
		rbMenuItem.setSelected(false);

		menu.add(rbMenuItem);

		super.setJMenuBar(menuBar);
	}


	public void add (JComponent Panel, JComponent Comp) {

	}

	public JPanel addTab(String name) {
		JPanel panel = new JPanel();

		//adding a tab frame to the content pane
		tabbed.setBounds(20,20, 360, 360);
		getContentPane().add(tabbed);

		tabbed.addTab(name, null, panel, "Does nothing");

		return panel;
	}

	public void addTab(String name, JPanel panel) {
		//adding a tab frame to the content pane
		tabbed.setBounds(20,20, 360, 360);
		getContentPane().add(tabbed);

		tabbed.addTab(name, null, panel, "Does nothing");
	}

	public static void main(String [] args) {
		//@SuppressWarnings("unused")
		GUIFrame gui = new GUIFrame();
		for (int i = 0; i < 10; i++) {
			JPanel panel = gui.addTab(i + "");
			panel.add(new JButton("" + i));
		}
	}
}
