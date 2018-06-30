package app.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.Map;

import com.sun.glass.events.KeyEvent;

public class CheatSender {

	private Robot sender;
	
	private Map<Character, Integer> keyCodes = new HashMap<>();
	
	public CheatSender() {
		
		try {
			sender = new Robot();
			 
			keyCodes.put('A', KeyEvent.VK_A);
			keyCodes.put('B', KeyEvent.VK_B);
			keyCodes.put('C', KeyEvent.VK_C);
			keyCodes.put('D', KeyEvent.VK_D);
			keyCodes.put('E', KeyEvent.VK_E);
			keyCodes.put('F', KeyEvent.VK_F);
			keyCodes.put('G', KeyEvent.VK_G);
			keyCodes.put('H', KeyEvent.VK_H);
			keyCodes.put('I', KeyEvent.VK_I);
			keyCodes.put('J', KeyEvent.VK_J);
			keyCodes.put('K', KeyEvent.VK_K);
			keyCodes.put('L', KeyEvent.VK_L);
			keyCodes.put('M', KeyEvent.VK_M);
			keyCodes.put('N', KeyEvent.VK_N);
			keyCodes.put('O', KeyEvent.VK_O);
			keyCodes.put('P', KeyEvent.VK_P);
			keyCodes.put('Q', KeyEvent.VK_Q);
			keyCodes.put('R', KeyEvent.VK_R);
			keyCodes.put('S', KeyEvent.VK_S);
			keyCodes.put('T', KeyEvent.VK_T);
			keyCodes.put('U', KeyEvent.VK_U);
			keyCodes.put('V', KeyEvent.VK_V);
			keyCodes.put('W', KeyEvent.VK_W);
			keyCodes.put('X', KeyEvent.VK_X);
			keyCodes.put('Y', KeyEvent.VK_Y);
			keyCodes.put('Z', KeyEvent.VK_Z);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendCheat(String code) {
		
		for (char c : code.toCharArray()) {
			sender.keyPress(keyCodes.get(c));
			sender.keyRelease(keyCodes.get(c));
		}
			
	}
	
}
