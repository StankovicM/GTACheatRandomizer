package app.gui.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.gui.controller.Start;
import app.gui.controller.Stop;

@SuppressWarnings("serial")
class Menu extends JMenuBar {

	private JMenu fileMenu = new JMenu("File    ");
	private JMenuItem settingsBtn = new JMenuItem("Settings");
	private JMenu actionsMenu = new JMenu("Actions ");
	private JMenuItem startBtn = new JMenuItem("Start   ");
	private JMenuItem stopBtn = new JMenuItem("Stop    ");
	
	Menu() {
		
		this.add(fileMenu);
		fileMenu.add(settingsBtn);
		
		this.add(actionsMenu);
		actionsMenu.add(startBtn);
		actionsMenu.add(stopBtn);
		stopBtn.setEnabled(false);
		
		startBtn.addActionListener(new Start(stopBtn));
		stopBtn.addActionListener(new Stop(startBtn));
		
	}
	
}
