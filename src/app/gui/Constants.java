package app.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {

	public static final Toolkit tk = Toolkit.getDefaultToolkit();
	
	public static final int DEF_WIN_W = 1024;
	public static final int DEF_WIN_H = 768;
	
	public static final int SCR_W = (int)tk.getScreenSize().getWidth();
	public static final int SCR_H = (int)tk.getScreenSize().getHeight();
	
	public static final Dimension DEF_WIN_DIM = new Dimension(DEF_WIN_W, DEF_WIN_H);
	public static final Dimension DEF_SCRL_DIM = new Dimension(400, 688);
	public static final Dimension DEF_LIST_DIM = new Dimension(380, 668);
	
	public static final String TITLE = "GTA:SA Cheat Randomizer";
	
	public static final int DEF_CHG_TIME = 30;
	public static int changeTime = DEF_CHG_TIME;
	
}
