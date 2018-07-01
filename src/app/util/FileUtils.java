package app.util;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import app.Config;
import app.gui.model.Cheat;

public class FileUtils {
	
	public static void loadCheats(String fileName, JList<Cheat> cheatList, DefaultListModel<Cheat> cclDLM) {
		
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
				
				Cheat c = new Cheat(code, effect);
				if (!cclDLM.isEmpty()) {
					if (!cclDLM.contains(c)) {
						dlm.addElement(c);
						++cheats;
					}
				}
				else {
					dlm.addElement(c);
					++cheats;
				}
			}
			
			cheatList.setPreferredSize(new Dimension((int)cheatList.getPreferredSize().getWidth(), cheats * 18));
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean loadConfig(String fileName, JList<Cheat> chosenCheatList) {
		
		File f = new File(fileName);
		if (!f.exists())
			return false;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			JSONTokener tokener = new JSONTokener(br);
			JSONObject object = new JSONObject(tokener);
			
			Config.changeTime = object.getInt("changeTime");
			Config.doStack = object.getBoolean("doStack");
			
			JSONArray array = object.getJSONArray("cheats");
			if (array.length() > 0) {
				DefaultListModel<Cheat> dlm = (DefaultListModel<Cheat>)chosenCheatList.getModel();
				for (int i = 0; i < array.length(); ++i) {
					JSONObject cheat = array.getJSONObject(i);
					dlm.addElement(new Cheat(cheat.getString("code"), cheat.getString("effect")));
				}
			}
			
			chosenCheatList.setPreferredSize(new Dimension((int)chosenCheatList.getPreferredSize().getWidth(), 
				array.length() * 18));
			
			br.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static void saveConfig(String fileName, DefaultListModel<Cheat> cclDLM) {
		
		File f = new File(fileName);
		try {
			if (!f.exists())
				f.createNewFile();
			
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			JSONObject object = new JSONObject();
			
			object.put("changeTime", Config.changeTime);
			object.put("doStack", Config.doStack);
			
			JSONArray array = new JSONArray();
			if (!cclDLM.isEmpty()) {
				for (int i = 0; i < cclDLM.size(); ++i) {
					JSONObject cheat = new JSONObject();
					cheat.put("code", cclDLM.get(i).getCode());
					cheat.put("effect", cclDLM.get(i).getEffect());
					array.put(cheat);
				}
			}
			
			object.put("cheats", array);
			pw.print(object.toString(4));
			
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
