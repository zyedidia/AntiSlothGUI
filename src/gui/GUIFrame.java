package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;




@SuppressWarnings("serial")
public class GUIFrame extends JFrame {
	
	 JTabbedPane tabbed = new JTabbedPane(JTabbedPane.LEFT);
	 JComponent panel1 = new JPanel();


	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Menu");

	public GUIFrame() {

		super("Anti-Sloth");
		super.setSize(400, 400);

		
		//test
//		DefaultPieDataset data = new DefaultPieDataset();
//		data.setValue("Itunes", new Integer(30));
//		data.setValue("Chrome", new Integer(60));
//		data.setValue("Word", new Integer(10));
//		
//		JFreeChart chart = ChartFactory.createPieChart("name", data);
//		
//		BufferedImage image = chart.createBufferedImage(500,300);
//		JLabel lblChart = new JLabel();
//		lblChart.setIcon(new ImageIcon(image));
//		
//		panel1.add(lblChart);
		
		
		DefaultPieDataset d1 = (DefaultPieDataset) data("Chrome", "Itunes", "Word", 10, 20);
		JFreeChart c1 = pie("Program Usage Demo", d1);
		
		displaychart(panel1, c1, 300, 200);
		
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
	
//	public void add (JComponent Panel, JComponent Comp) {
//		
//		
//		
//	}
	
	public PieDataset data(String name, String name2, String n3, int v1, int v2) {
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue(name, new Integer(v1));
		data.setValue(name2, new Integer(v2));
		data.setValue(n3, new Integer(100 - v1 + v2));
		
		return data;
	}
	
	public JFreeChart pie(String name, PieDataset data) {
		JFreeChart chart = ChartFactory.createPieChart(name, data);
		
		return chart;
	}
	
	public void displaychart(JComponent panel, JFreeChart chart, int width, int height ) {
	    BufferedImage image = chart.createBufferedImage(width, height);
	    JLabel l = new JLabel();
		l.setIcon( new ImageIcon(image));
		panel.add(l);
		

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
//		for (int i = 0; i < 10; i++) {
//			JPanel panel = gui.addTab(i + "");
//			panel.add(new JButton("" + i));
//		}
	}
}
