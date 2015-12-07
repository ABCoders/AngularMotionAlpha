package alpha;

import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CircleIcon extends JComponent implements Runnable, MouseListener, ActionListener {
	int diameter;
	int radius;
	int xCoord = 0;
	int lVelocity = 0;
	double aVelocity = 0;
	double angle = 0;

	int drawX = this.getWidth() + 50;
	int drawY = -100;
	double cAngle;
	int circleX;
	int circleY;
	int dBetweenX;
	int dBetweenY;
	int dBetween;

	boolean play = false;

	public CircleIcon(int radius) {
		this(radius, 1);
	}

	public CircleIcon(int radius, double angularVelocity) {
		this(radius, (int) (angularVelocity * radius));
	}

	public CircleIcon(int radius, int linearVelocity) {
		super();
		this.diameter = radius * 2;
		this.radius = radius;
		this.lVelocity = linearVelocity;
		this.aVelocity = (double) linearVelocity / radius;
		this.setPreferredSize(new Dimension(500, 500));
		this.addMouseListener(this);
		new Thread(this).start();
	}

	public void run() {
		while (true) {
			while (play) {
				this.xCoord += lVelocity;
				this.angle -= aVelocity;
				this.cAngle -= aVelocity;
				this.repaint();
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
				if (this.xCoord > this.getWidth()) {
					this.xCoord = 0;

				}
			}
			try {
				Thread.sleep(0);
			} catch (Exception e) {
			}
			this.repaint();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D d = (Graphics2D) g;

		int x = xCoord + radius;
		int y = this.getHeight() - radius;
		int endX = (int) (x + radius * Math.sin(angle));
		int endY = (int) (y + radius * Math.cos(angle));

		circleX = (int) (x + dBetween * Math.sin(cAngle));
		circleY = (int) (y + dBetween * Math.cos(cAngle));

		// Circle
		d.drawOval(xCoord, this.getHeight() - diameter, diameter, diameter);
		d.drawLine(x, y, endX, endY);

		d.setColor(Color.RED);
		d.drawLine(x, y, circleX, circleY);
		d.fillOval(circleX - 10, circleY - 10, 20, 20);
		d.setColor(Color.BLACK);

		d.drawLine(0, this.getHeight() - 1, this.getWidth(), this.getHeight() - 1);
		if (this.xCoord + diameter > this.getWidth()) {
			d.drawOval(-this.getWidth() + xCoord, this.getHeight() - diameter, diameter, diameter);
			d.drawLine(-this.getWidth() + x, y, -this.getWidth() + endX, endY);
			d.setColor(Color.RED);
			d.drawLine(-this.getWidth() + x, y, -this.getWidth() + circleX, circleY);
			d.fillOval(-this.getWidth() + circleX - 10, circleY - 10, 20, 20);
			d.setColor(Color.BLACK);
		}
	}

	public void setLinearVelocity(int speed) {
		this.lVelocity = speed;
	}

	public void setAngularVelocity(int speed) {
		this.aVelocity = speed;
	}

	public void mousePressed(MouseEvent e) {
		if (!play) {
			drawX = (int) Math.floor(e.getX());
			drawY = (int) Math.floor(e.getY());
			dBetweenX = xCoord + radius - drawX;
			dBetweenY = this.getHeight() - radius - drawY;
			dBetween = (int) Math.sqrt(Math.pow(dBetweenX, 2) + Math.pow(dBetweenY, 2));
			cAngle = Math.atan((double) dBetweenY / (double) dBetweenX);
			if (drawX < xCoord + radius) {
				cAngle = -cAngle - 0.5 * Math.PI;
			} else {
				cAngle = -cAngle + 0.5 * Math.PI;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("PLAY")) {
			this.play = true;
			System.out.println("play");
		} else if (command.equals("PAUSE")) {
			this.play = false;
			System.out.println("pause");
		} else if (command.equals("CLEAR")) {
			drawX = this.getWidth() + 50;
			drawY = -100;
			dBetween = 0;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		CircleIcon test = new CircleIcon(100, 1);
		JPanel pane = new JPanel();
		pane.add(test);
		pane.setPreferredSize(new Dimension(550, 550));
		JButton play = new JButton("PLAY");
		pane.add(play);
		play.addActionListener(test);

		JButton pause = new JButton("PAUSE");
		pane.add(pause);
		pause.addActionListener(test);

		JButton clear = new JButton("CLEAR");
		pane.add(clear);
		clear.addActionListener(test);

		frame.setContentPane(pane);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 50);
		frame.pack();
	}
}