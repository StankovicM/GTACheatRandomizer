package app.gui.settings;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class SettingsWindowListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent e) {  }

	@Override
	public void windowClosed(WindowEvent e) {  }

	@Override
	public void windowClosing(WindowEvent e) { SettingsWindow.getInstance().closeWindow(); }

	@Override
	public void windowDeactivated(WindowEvent e) {  }

	@Override
	public void windowDeiconified(WindowEvent e) {  }

	@Override
	public void windowIconified(WindowEvent e) {  }

	@Override
	public void windowOpened(WindowEvent e) {  }

}
