package app.gui.view;

import static app.Config.*;

import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class BackgroundPanel extends JPanel {

	BackgroundPanel(LayoutManager layout) { super(layout); }
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(BG_IMG, 0, 0, null);
		
	}
	
}
