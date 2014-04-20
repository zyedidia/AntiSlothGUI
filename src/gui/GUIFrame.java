package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
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

	JTabbedPane tabbed = new JTabbedPane(JTabbedPane.TOP);

	JComponent panel1 = new JPanel();


	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Menu");

	public GUIFrame() {

		super("Anti-Sloth");
		super.setSize(700, 700);
		
		//this.setLayout(null);

		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

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

	public void createPieChart(JPanel panel, String chartName, String[] dataStrings, int[] dataValues, int sizeX, int sizeY) {
		DefaultPieDataset data = new DefaultPieDataset();

		if (dataStrings.length == dataValues.length) {

			for (int i = 0; i < dataStrings.length; i++) {
				data.setValue(dataStrings[i], new Integer(dataValues[i]));
			}

			JFreeChart chart = ChartFactory.createPieChart(chartName, data);

			BufferedImage image = chart.createBufferedImage(sizeX, sizeY);
			JLabel lblChart = new JLabel();
			lblChart.setIcon(new ImageIcon(image));

			panel.add(lblChart);
		} else {
			System.err.println("Data Strings array must be the same length as data values array!");
		}
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

		GUIFrame gui = new GUIFrame();
		
		/*// Write blocked programs to BlockedPrograms.txt
		TextFileWriter.writeToFile("BlockedPrograms.txt", "Itunes\nChrome\nBlah\nSteam");
		
		// Write values to TestValues.txt
		TextFileWriter.writeToFile("TestValues.txt", "Itunes");
		TextFileWriter.writeToFile("TestValues.txt", "20");
		
		TextFileWriter.writeToFile("TestValues.txt", "Chrome");
		TextFileWriter.writeToFile("TestValues.txt", "50");

		TextFileWriter.writeToFile("TestValues.txt", "Blah");
		TextFileWriter.writeToFile("TestValues.txt", "30");*/
		
		// Read values in from TestValues.txt and turn them into a pie chart
		gui.createPieChart(gui.addTab("Pie Chart"), "Hello world", 
				new String[] {
							  TextFileReader.readLineFromFile("TestValues.txt", 1), 
							  TextFileReader.readLineFromFile("TestValues.txt", 3), 
							  TextFileReader.readLineFromFile("TestValues.txt", 5)}, 
				new int[] {
			 				  Integer.parseInt(TextFileReader.readLineFromFile("TestValues.txt", 2)), 
						      Integer.parseInt(TextFileReader.readLineFromFile("TestValues.txt", 4)), 
						      Integer.parseInt(TextFileReader.readLineFromFile("TestValues.txt", 6))},
				600, 600);
		
		gui.createPieChart(gui.addTab("Other Pie Chart"), "Goodbye", new String[] {"Itunes", "Chrome", "Blah"}, new int[] {25, 25, 50}, 600, 600);
		gui.addTab("Blocked Programs", new ProductivePanel());
	}
}
