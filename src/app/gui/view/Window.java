package app.gui.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import app.gui.controller.AddCheat;
import app.gui.controller.RemoveCheat;
import app.gui.model.Cheat;
import app.util.FileUtils;
import app.util.CheatSender;

import static app.Config.*;

import java.awt.Dimension;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private static Window instance = null;
	private CheatSender sender = new CheatSender();
	
	private Menu menu = new Menu();
	
	private FlowLayout rootFl = new FlowLayout(FlowLayout.CENTER, 10, 10);
	private BackgroundPanel root = new BackgroundPanel(rootFl);
	
	private DefaultListModel<Cheat> clDLM = new DefaultListModel<>();
	private JList<Cheat> cheatList = new JList<>(clDLM);
	private JScrollPane cheatListJsp = new JScrollPane(cheatList);
	
	private FlowLayout chooserPanelFl = new FlowLayout(FlowLayout.CENTER, 10, 10);
	private JPanel chooserPanel = new JPanel(chooserPanelFl);
	private JButton addBtn = new JButton(">>");
	private JButton removeBtn = new JButton("<<");
	
	private DefaultListModel<Cheat> cclDLM = new DefaultListModel<>();
	private JList<Cheat> chosenCheatList = new JList<>(cclDLM);
	private JScrollPane chosenCheatListJsp = new JScrollPane(chosenCheatList);
	
	private Window() { createWindow(); }
	
	public static Window getIntance() {
		
		if (instance == null)
			instance = new Window();
		//TODO alert that an instance is already running
		
		return instance;
		
	}
	
	private void createWindow() {
		
		this.setTitle(TITLE);
		this.setIconImage(ICON);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(DEF_WIN_W, DEF_WIN_H);
		this.setLocation(SCR_W / 2 - DEF_WIN_W / 2, SCR_H / 2 - DEF_WIN_H / 2);
		this.setResizable(false);
		this.setContentPane(root);
		this.setJMenuBar(menu);
		root.setPreferredSize(new Dimension(1024, 708));
		root.setSize(new Dimension(1024, 708));
		root.setAlignmentY(CENTER_ALIGNMENT);
		
		root.add(cheatListJsp);
		cheatListJsp.setPreferredSize(DEF_SCRL_DIM);
		cheatListJsp.setSize(DEF_SCRL_DIM);
		cheatListJsp.setOpaque(false);
		cheatListJsp.getViewport().setOpaque(false);
		cheatList.setPreferredSize(DEF_LIST_DIM);
		cheatList.setSize(DEF_LIST_DIM);
		cheatList.setOpaque(false);
		cheatList.setCellRenderer(new TransparentCellRenderer());
		
		root.add(chooserPanel);
		chooserPanel.setPreferredSize(new Dimension(100, 90));
		chooserPanel.setOpaque(false);
		
		chooserPanel.add(addBtn);
		addBtn.setPreferredSize(new Dimension(80, 30));
		
		chooserPanel.add(removeBtn);
		removeBtn.setPreferredSize(new Dimension(80, 30));
		
		root.add(chosenCheatListJsp);
		chosenCheatListJsp.setPreferredSize(DEF_SCRL_DIM);
		chosenCheatListJsp.setSize(DEF_SCRL_DIM);
		chosenCheatListJsp.setOpaque(false);
		chosenCheatListJsp.getViewport().setOpaque(false);
		chosenCheatList.setPreferredSize(DEF_LIST_DIM);
		chosenCheatList.setSize(DEF_LIST_DIM);
		chosenCheatList.setOpaque(false);
		chosenCheatList.setCellRenderer(new TransparentCellRenderer());
		
		FileUtils.loadConfig("config.json", chosenCheatList);
		FileUtils.loadCheats("cheats.txt", cheatList, cclDLM);
		addBtn.addActionListener(new AddCheat());
		removeBtn.addActionListener(new RemoveCheat());
		this.setVisible(true);
		
	}
	
	public JList<Cheat> getCheatList() { return cheatList; }
	
	public JList<Cheat> getChosenCheatList() { return chosenCheatList; }
	
	public JButton getAddBtn() { return addBtn; }
	
	public JButton getRemoveBtn() { return removeBtn; }
	
	public CheatSender getSender() { return sender; }
	
}
