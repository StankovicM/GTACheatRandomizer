package app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;

import app.gui.model.Cheat;
import app.gui.view.Window;
import app.randomizer.Randomizer;

public class Start implements ActionListener {

	private JMenuItem stopBtn;
	private JMenuItem settingsBtn;
	private JMenuItem saveBtn;
	
	public Start(JMenuItem stopBtn, JMenuItem settingsBtn, JMenuItem saveBtn) { 
		
		this.stopBtn = stopBtn;
		this.settingsBtn = settingsBtn;
		this.saveBtn = saveBtn;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultListModel<Cheat> dlm = (DefaultListModel<Cheat>)Window.getIntance().getChosenCheatList().getModel();
		if (dlm.isEmpty())
			return;
		
		Window.getIntance().getAddBtn().setEnabled(false);
		Window.getIntance().getRemoveBtn().setEnabled(false);
		
		Randomizer.getInstance(dlm).start();
		stopBtn.setEnabled(true);
		settingsBtn.setEnabled(false);
		saveBtn.setEnabled(false);
		((JMenuItem)e.getSource()).setEnabled(false);
		
	}

}
