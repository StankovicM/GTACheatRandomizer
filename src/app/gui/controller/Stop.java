package app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import app.randomizer.Randomizer;

public class Stop implements ActionListener {
	
private JMenuItem startBtn;
	
	public Stop(JMenuItem startBtn) { this.startBtn = startBtn; }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Randomizer.getInstance().stopThread();
		startBtn.setEnabled(true);
		((JMenuItem)e.getSource()).setEnabled(false);
	}
	
}
