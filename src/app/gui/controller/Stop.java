package app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import app.gui.view.Window;
import app.randomizer.Randomizer;

public class Stop implements ActionListener {
	
	private JMenuItem startBtn;
	private JMenuItem settingsBtn;
	private JMenuItem saveBtn;
	
	public Stop(JMenuItem startBtn, JMenuItem settingsBtn, JMenuItem saveBtn) { 
		
		this.startBtn = startBtn;
		this.settingsBtn = settingsBtn;
		this.saveBtn = saveBtn;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Window.getIntance().getAddBtn().setEnabled(true);
		Window.getIntance().getRemoveBtn().setEnabled(true);
		
		Randomizer.getInstance().stopThread();
		startBtn.setEnabled(true);
		settingsBtn.setEnabled(true);
		saveBtn.setEnabled(true);
		((JMenuItem)e.getSource()).setEnabled(false);
		
	}
	
}
