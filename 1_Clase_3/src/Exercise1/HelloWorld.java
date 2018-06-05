package Exercise1;
import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorld extends Applet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) 
	{
		g.drawString("Hello! How are you doing?", 10, 10);
		g.drawString("Good and you?", 20, 20);
	}

}
