package app.randomizer;

import java.util.Random;

import javax.swing.DefaultListModel;

import app.gui.Constants;
import app.gui.model.Cheat;
import app.gui.view.Window;

public class Randomizer extends Thread {

	private static Randomizer instance = null;
	
	private int TPS = 10;
	
	private DefaultListModel<Cheat> dlm;
	
	private boolean running = false;
	
	private String currentCode = null;
	
	private Randomizer() {  }
	
	public static Randomizer getInstance() { return instance; }

	public static Randomizer getInstance(DefaultListModel<Cheat> dlm) {
		
		if (instance == null)
			instance = new Randomizer();
		
		instance.dlm = dlm;
		
		return instance;
		
	}
	
	@Override
	public void run() {
		
		if (running)
			return;
		
		running = true;
		
		final double tickTime = 1.0 / TPS;
		double unprocessedTime = 0;
		
		long lastTime = System.nanoTime();
		long counter = 0;
		
		int cheatCounter = 0;
		while (running) {
			long now = System.nanoTime();
			long delta = now - lastTime;
			lastTime = now;
			
			unprocessedTime += delta / (double)1000000000l;
			counter += delta;
			
			while (unprocessedTime > tickTime) {
				unprocessedTime -= tickTime;
				
				if (counter >= 1000000000l) {
					counter = 0;
					if (++cheatCounter >= Constants.changeTime) {
						cheatCounter = 0;
						String cheatCode = "";
						while ((cheatCode = dlm.get(new Random(now).nextInt(dlm.size())).getCode()).equalsIgnoreCase(currentCode));
						
						if (currentCode != null)
							Window.getIntance().getSender().sendCheat(currentCode);
						
						Window.getIntance().getSender().sendCheat(cheatCode);
						
						currentCode = cheatCode;
						System.out.println(cheatCode);
					}
				}
			}
			
			//long sleepTime = (long)tickTime * 1000000000l - (System.nanoTime() - lastTime) - 10;
			try {
				//sleep(sleepTime > 0 ? sleepTime : 0);
				sleep(90);
			}
			catch (InterruptedException e) {
				
			}
		}
		
	}
	
	public void stopThread() { 
		
		if (running) {
			instance = null;
			running = false;
		}
		
	}
	
}
