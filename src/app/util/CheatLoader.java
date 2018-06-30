package app.util;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.gui.model.Cheat;

public class CheatLoader {
	
	public static void loadCheats(String fileName, JList<Cheat> cheatList) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			DefaultListModel<Cheat> dlm = (DefaultListModel<Cheat>)cheatList.getModel();
			if (!dlm.isEmpty())
				dlm.clear();
			
			String line;
			int cheats = 0;
			while ((line = br.readLine()) != null) {
				String code = line.substring(0, line.indexOf(';'));
				String effect = line.substring(code.length() + 1);
				
				dlm.addElement(new Cheat(code, effect));
				++cheats;
			}
			
			cheatList.setPreferredSize(new Dimension((int)cheatList.getPreferredSize().getWidth(), cheats * 18));
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
