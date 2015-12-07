package alpha;

//import java.awt.geom.AffineTransform;

//import javax.imageio.*;
//import java.io.File;
import java.util.*;

//import java.awt.image.*;
//import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class AngularMotionGUITest extends JPanel {
	String[] variables = new String[] { "var1", "var2", "var3" };

	JPanel animationPane = new JPanel();
	JPanel answerPane = new JPanel();
	ArrayList<InputPane> inputPane = new ArrayList<InputPane>();

	AnimationActionPane aActionPane = new AnimationActionPane();

	JLabel answer = new JLabel("Answer = ");
	JComboBox<String> answerVar;
	JButton addBtn = new JButton("Add");
	JButton calcBtn = new JButton("Calculate");

	public AngularMotionGUITest() {
		super();
		createAnimationComp();
		createAnswerComp();
		createAnimationPane();
		createAnswerPane();
		this.setLayout(new BorderLayout());
		this.add(animationPane, BorderLayout.NORTH);
		this.add(answerPane, BorderLayout.CENTER);
	}

	public void createAnimationComp() {
	}

	public void createAnswerComp() {
		answerVar = new JComboBox<String>(variables);
		answerVar.setSize(50, 10);
		for (int i = 0; i < 3; i++) {
			inputPane.add(new InputPane());
		}
	}

	public void createAnimationPane() {
		animationPane.setBorder(BorderFactory.createTitledBorder("Animation"));
		animationPane.setLayout(new BorderLayout());
		animationPane.add(aActionPane, BorderLayout.NORTH);
		animationPane.setPreferredSize(new Dimension(1000, 400));
	}

	public void createAnswerPane() {
		answerPane.setBorder(BorderFactory.createTitledBorder("Answer Machine"));
		answerPane.setLayout(new GridLayout(5, 1, 0, 0));

		JPanel outputPane = new JPanel();
		outputPane.add(answer);
		outputPane.add(answerVar);

		answerPane.add(outputPane);
		for (int i = 0; i < inputPane.size(); i++) {
			answerPane.add(inputPane.get(i));
		}
		JPanel actionPane = new JPanel();
		actionPane.add(addBtn);
		actionPane.add(calcBtn);
		answerPane.add(actionPane);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		AngularMotionGUITest test = new AngularMotionGUITest();

		frame.setContentPane(test);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 50);
		frame.setSize(1000, 750);
	}
}