package sliders;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class sliderTest extends JPanel
implements ChangeListener{
	
	JLabel label = new JLabel("TIME", JLabel.CENTER);
	JSlider slider;

	public sliderTest() {
		this.setPreferredSize(new Dimension(100,100));
		this.setMaximumSize(new Dimension(100,100));
		this.setLayout(new BorderLayout());
		slider = new JSlider(JSlider.HORIZONTAL, 60);
		this.add(label, BorderLayout.NORTH);
		this.add(slider, BorderLayout.CENTER);
		slider.addChangeListener(this);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			System.out.println(source.getValue());
		}

	}
	
	public static void main(String []args) {
		JFrame frame = new JFrame("Slider Test");
		frame.setContentPane(new sliderTest());
		frame.setVisible(true);
		frame.setLocation(500,500);
		frame.pack();
	}
}
