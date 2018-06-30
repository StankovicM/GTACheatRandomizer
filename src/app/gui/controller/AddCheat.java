package app.gui.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.gui.model.Cheat;
import app.gui.view.Window;

public class AddCheat implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JList<Cheat> cheatList = Window.getIntance().getCheatList();
		if (cheatList.isSelectionEmpty())
			return;
		
		Window.getIntance().getAddBtn().setEnabled(false);
		Window.getIntance().getRemoveBtn().setEnabled(false);
		
		DefaultListModel<Cheat> clDLM = (DefaultListModel<Cheat>)cheatList.getModel();
		JList<Cheat> chosenCheatList = Window.getIntance().getChosenCheatList();
		DefaultListModel<Cheat> cclDLM = (DefaultListModel<Cheat>)chosenCheatList.getModel();
		
		int[] selected = cheatList.getSelectedIndices();
		for (int i : selected)
			cclDLM.addElement(clDLM.get(i));
		
		Arrays.sort(selected);
		int n = selected.length;
		for (int i = 0; i < n / 2; ++i) {
			int tmp = selected[i];
			selected[i] = selected[n - 1 - i];
			selected[n - 1 - i] = tmp;
		}
		
		for (int i : selected)
			clDLM.remove(i);
		
		cheatList.setPreferredSize(new Dimension((int)cheatList.getPreferredSize().getWidth(), clDLM.size() * 18));
		chosenCheatList.setPreferredSize(new Dimension((int)chosenCheatList.getPreferredSize().getWidth(), cclDLM.size() * 18));
		
		Window.getIntance().getAddBtn().setEnabled(true);
		Window.getIntance().getRemoveBtn().setEnabled(true);
		
	}
	
}
