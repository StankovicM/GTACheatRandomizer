package app;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;


public class Config {

	public static final Toolkit tk = Toolkit.getDefaultToolkit();
	
	public static final int DEF_WIN_W = 1024;
	public static final int DEF_WIN_H = 768;
	
	public static final int SCR_W = (int)tk.getScreenSize().getWidth();
	public static final int SCR_H = (int)tk.getScreenSize().getHeight();
	
	public static final Dimension DEF_WIN_DIM = new Dimension(DEF_WIN_W, DEF_WIN_H);
	public static final Dimension DEF_SCRL_DIM = new Dimension(400, 688);
	public static final Dimension DEF_LIST_DIM = new Dimension(375, 668);
	
	public static final String TITLE = "GTA:SA Cheat Randomizer";
	
	public static final int DEF_CHG_TIME = 30;
	public static int changeTime = DEF_CHG_TIME;
	
	public static final boolean DEF_STK_VAL = false;
	public static boolean doStack = DEF_STK_VAL;
	
	public static final Image BG_IMG = tk.createImage("assets/bg.png");
	public static final Image ICON = tk.createImage("assets/icon.png");
	
}
