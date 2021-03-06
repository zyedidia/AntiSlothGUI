package gui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ProductivePanel extends JPanel {

	private JTextArea textArea;
	private JTextField textField;
	private JButton blockButton;
	private JButton refreshButton;
	private JButton unblockButton;
	
	public ProductivePanel() {
		textArea = new JTextArea();
		textField = new JTextField("Block a program");
		blockButton = new JButton("Block!");
		refreshButton = new JButton("Refresh");
		unblockButton = new JButton("Unblock");
		
		
		AL AL = new AL();
		
		refreshButton.addActionListener(AL);
		blockButton.addActionListener(AL);
		unblockButton.addActionListener(AL);
		
		textArea.setText(TextFileReader.readEntireFile("BlockedPrograms.txt"));
		textArea.setEditable(false);
		
		this.add(textArea);
		this.add(textField);
		this.add(blockButton);
		this.add(refreshButton);
		this.add(unblockButton);
		
		refreshButton.setLocation(new Point(0,  800));

	}
	
	private class AL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == blockButton) {
				TextFileWriter.writeToFile("BlockedPrograms.txt", textField.getText());
			}
			
			if (e.getSource() == refreshButton) {
				textArea.setText(TextFileReader.readEntireFile("BlockedPrograms.txt"));
			}
			
			if (e.getSource() == unblockButton) {
				System.out.println("Unblock " + textField.getText());
			}
		}
		
	}
}
