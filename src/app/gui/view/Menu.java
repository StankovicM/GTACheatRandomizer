package app.gui.view;

import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.gui.controller.Start;
import app.gui.controller.Stop;
import app.gui.model.Cheat;
import app.gui.settings.SettingsWindow;
import app.util.FileUtils;

@SuppressWarnings("serial")
class Menu extends JMenuBar {

	private JMenu fileMenu = new JMenu("File    ");
	private JMenuItem settingsBtn = new JMenuItem("Settings");
	private JMenuItem saveBtn = new JMenuItem("Save    ");
	private JMenu actionsMenu = new JMenu("Actions ");
	private JMenuItem startBtn = new JMenuItem("Start   ");
	private JMenuItem stopBtn = new JMenuItem("Stop    ");
	
	Menu() {
		
		this.add(fileMenu);
		fileMenu.add(settingsBtn);
		fileMenu.add(saveBtn);
		saveBtn.setToolTipText("Saves the settings and the list of chosen cheats.");
		
		this.add(actionsMenu);
		actionsMenu.add(startBtn);
		actionsMenu.add(stopBtn);
		stopBtn.setEnabled(false);
		
		startBtn.addActionListener(new Start(stopBtn, settingsBtn, saveBtn));
		stopBtn.addActionListener(new Stop(startBtn, settingsBtn, saveBtn));
		
		settingsBtn.addActionListener(e -> { SettingsWindow.getInstance(); });
		
		saveBtn.addActionListener(e -> { FileUtils.saveConfig("config.json", 
				(DefaultListModel<Cheat>)Window.getIntance().getChosenCheatList().getModel()); });
		
	}
	
}
