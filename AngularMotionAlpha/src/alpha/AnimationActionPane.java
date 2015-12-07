package alpha;

//import java.util.*;

//import java.awt.image.*;
//import java.awt.*;
import javax.swing.*;

public class AnimationActionPane extends JPanel {
	String[] variables = new String[] { "var1", "var2", "var3" };

	JButton playBtn = new JButton("Play");
	JButton pauseBtn = new JButton("Pause");
	JSlider timeSlider = new JSlider(0, 10, 0);

	public AnimationActionPane() {
		super();
		createComp();
		createPane();
		registerControllers();
	}

	public void createComp() {
		timeSlider.setPaintTicks(true);
		timeSlider.setPaintLabels(true);
	}

	public void createPane() {
		this.add(timeSlider);
		this.add(playBtn);
		this.add(pauseBtn);
		// this.setPreferredSize(new Dimension(100,100));
	}

	public void registerControllers() {
	}
}