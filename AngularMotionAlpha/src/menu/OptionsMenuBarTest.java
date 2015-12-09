package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class OptionsMenuBarTest extends JMenuBar implements ActionListener {
	private JMenu file;
	private JMenu other;
	private JMenuItem saveItem;
	private JMenuItem loadItem;
	private JMenuItem helpItem;
	private JMenuItem colorItem;
	
	public OptionsMenuBarTest() {
		super();
		createComponents();
		createMenuBar();
		registerControllers();
	}
	
	private void createComponents() {
		file = new JMenu("File");
		other = new JMenu("Other");
		saveItem = new JMenuItem("Save As");
		loadItem = new JMenuItem("Load");
		helpItem = new JMenuItem("Help");
		colorItem = new JMenuItem("Change Color");
	}
	
	private void createMenuBar() {
		file.add(saveItem);
		file.add(loadItem);
		other.add(helpItem);
		other.add(colorItem);
		this.add(file);
		this.add(other);
	}
	
	private void registerControllers() {
		saveItem.addActionListener(this);
		loadItem.addActionListener(this);
		helpItem.addActionListener(this);
		colorItem.addActionListener(this);
	}
	
	public static void main (String []args) {
		JFrame frame = new JFrame("Test");
		OptionsMenuBarTest test = new OptionsMenuBarTest();
		frame.setJMenuBar(test);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(100, 100);
		frame.setSize(new Dimension(500,300));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
	}
}
