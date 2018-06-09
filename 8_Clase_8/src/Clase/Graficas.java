package Clase;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Graficas extends Canvas {
	
		public static void main(String[] args) {
			JFrame frame = new JFrame("My Drawing");
			Canvas canvas = new Graficas();
			canvas.setSize(400, 400);
			frame.add(canvas);
			frame.pack();
			frame.setVisible(true);
		}
		
		public void paint(Graphics g) {
			g.fillOval(100, 100, 200, 200);
		}
}


