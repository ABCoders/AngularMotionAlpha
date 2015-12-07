package alpha;

//import java.util.*;

//import java.awt.image.*;
import java.awt.*;
import javax.swing.*;

public class InputPane extends JPanel {
	String[] variables = new String[] { "var1", "var2", "var3" };

	JComboBox<String> inputVar = new JComboBox<String>(variables);
	JLabel equals = new JLabel(" = ");
	JTextField inputField = new JTextField(10);
	JButton closeBtn = new JButton("X");

	public InputPane() {
		super();
		createComp();
		createPane();
		registerControllers();
	}

	public void createComp() {
		inputVar.setSize(10, 10);
		closeBtn.setSize(50, 50);
	}

	public void createPane() {
		this.add(inputVar);
		this.add(equals);
		this.add(inputField);
		this.add(closeBtn);

		this.setMinimumSize(new Dimension(100, 50));
		this.setMaximumSize(new Dimension(100, 50));
	}

	public void registerControllers() {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		InputPane pane = new InputPane();
		JPanel panel = new JPanel();
		panel.add(pane);

		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.pack();
	}
}