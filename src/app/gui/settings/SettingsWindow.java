package app.gui.settings;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import app.Config;
import app.gui.view.Window;

import static app.Config.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class SettingsWindow extends JFrame {
	
	private static SettingsWindow instance = null;
	
	private BorderLayout rootBl = new BorderLayout(10, 0);
	private JPanel root = new JPanel(rootBl);
	
	private JPanel northPanel = new JPanel();
	private JPanel changeTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
	private JLabel changeTimeLb = new JLabel("Cheat change time: ");
	private JTextField changeTimeTf = new JTextField(Integer.toString(changeTime));
	private JLabel invalidInputErrorLb = new JLabel(" * Invalid input. Please type in a number.");
	
	private JPanel stackCheatsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
	private JCheckBox stackCheatsCb = new JCheckBox("Stack cheats");
	
	private FlowLayout separatorFl = new FlowLayout(FlowLayout.CENTER, 10, 0);
	private JPanel separatorPanel = new JPanel(separatorFl);
	private JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
	
	private FlowLayout btnFl = new FlowLayout(FlowLayout.RIGHT, 10, 10);
	private JPanel btnPanel = new JPanel(btnFl);
	private JButton okBtn = new JButton("Ok");
	private JButton saveBtn = new JButton("Save");
	
	private JPanel eastPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	
	private String numberPatter = "\\d+";
	
	private SettingsWindow() { createWindow(); }
	
	public static SettingsWindow getInstance() { 
		
		if (instance == null)
			instance = new SettingsWindow();
		
		return instance;
		
	}
	
	private void createWindow() {
		
		this.setTitle("Settings");
		this.setIconImage(ICON);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(640, 480);
		this.setLocation(SCR_W / 2 - 320, SCR_H / 2 - 240);
		this.setResizable(false);
		this.setContentPane(root);
		root.setOpaque(false);
		this.setUndecorated(true);
		this.setBackground(new Color(1.0f,1.0f,1.0f,0.8f));
		this.addWindowListener(new SettingsWindowListener());
		
		root.add(northPanel, BorderLayout.NORTH);
		northPanel.setPreferredSize(new Dimension(620, 400));
		northPanel.setOpaque(false);
		
		northPanel.add(changeTimePanel);
		changeTimePanel.setPreferredSize(new Dimension(620, 35));
		changeTimePanel.setOpaque(false);
		changeTimePanel.add(changeTimeLb);
		changeTimeLb.setToolTipText("<html>"
								  + "Time in seconds after which the cheat will change."
								  + "<br>"
								  + "If set to 0, a random cheat will be activated and will not change."
								  + "<br>"
								  + "If left empty, it will use the default value of 300 seconds."
								  + "</html>");
		
		changeTimePanel.add(changeTimeTf);
		changeTimeTf.setPreferredSize(new Dimension(75, 25));
		changeTimeTf.setToolTipText("<html>"
				  				  + "Time in seconds after which the cheat will change."
				  				  + "<br>"
				  				  + "If set to 0, a random cheat will be activated and will not change."
				  				  + "<br>"
				  				  + "If left empty, it will use the default value of 300 seconds."
				  				  + "</html>");
		
		changeTimePanel.add(invalidInputErrorLb);
		invalidInputErrorLb.setForeground(Color.RED);
		invalidInputErrorLb.setVisible(false);
		
		northPanel.add(stackCheatsPanel);
		stackCheatsPanel.setPreferredSize(new Dimension(620, 35));
		stackCheatsPanel.setOpaque(false);
		stackCheatsPanel.add(stackCheatsCb);
		stackCheatsCb.setSelected(doStack);
		stackCheatsCb.setOpaque(false);
		stackCheatsCb.setToolTipText("<html>"
								   + "If checked, the previouse cheat will not be deactivated"
								   + "<br>"
								   + "after another one gets activated."
								   + "</html>");
		
		root.add(separatorPanel, BorderLayout.CENTER);
		separatorPanel.setPreferredSize(new Dimension(620, 20));
		separatorPanel.setAlignmentX(CENTER_ALIGNMENT);
		separatorPanel.setAlignmentY(CENTER_ALIGNMENT);
		separator.setOpaque(false);
		separatorPanel.add(separator);
		separator.setPreferredSize(new Dimension(600, 2));
		
		root.add(btnPanel, BorderLayout.SOUTH);
		btnPanel.setPreferredSize(new Dimension(620, 50));
		btnPanel.setOpaque(false);
		btnPanel.add(saveBtn);
		saveBtn.setPreferredSize(new Dimension(80, 25));
		btnPanel.add(okBtn);
		okBtn.setPreferredSize(new Dimension(80, 25));
		
		root.add(eastPanel, BorderLayout.EAST);
		eastPanel.setOpaque(false);
		root.add(westPanel, BorderLayout.WEST);
		westPanel.setOpaque(false);
		
		Window.getIntance().setEnabled(false);
		this.setVisible(true);
		
		okBtn.addActionListener(e -> { closeWindow(); });
		
		saveBtn.addActionListener(e -> {
			
			if (changeTimeTf.getText() == null || changeTimeTf.getText().isEmpty()) {
				Config.changeTime = Config.DEF_CHG_TIME;
			} else if (!changeTimeTf.getText().trim().matches(numberPatter)) {
				invalidInputErrorLb.setVisible(true);
				return;
			} else {
				Config.changeTime = Integer.parseInt(changeTimeTf.getText().trim());
			}
			
			Config.doStack = stackCheatsCb.isSelected();
			
		});
		
	}
	
	public void closeWindow() { 
		
		Window.getIntance().setEnabled(true);
		instance = null;
		dispose(); 
		
	}
	
}
