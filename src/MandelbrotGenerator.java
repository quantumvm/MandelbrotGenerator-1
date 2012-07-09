
import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

public class MandelbrotGenerator extends Canvas {
BufferStrategy strategy;	
boolean running = true;
	
	MandelbrotGenerator(){
		Dimension size = new Dimension(800,600);
		
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setIgnoreRepaint(true);
		
		JFrame frame = new JFrame("MandelbrotGenerator");
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		
	}
	
	public void renderLoop(){
		while(running){
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 800, 600);
			g.dispose();
			strategy.show();
			
			
			
			try{
			Thread.sleep(1);
			}
			catch(Exception e){
				
			}
		}
	}
	
	public static void main(String[] args)
	{
		MandelbrotGenerator generator = new MandelbrotGenerator();
		generator.renderLoop();
	}

}
