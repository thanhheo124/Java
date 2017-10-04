package com.carogamedesign.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class GUI extends JFrame{
	
	private static final int WIDTH_FRAME = 900;
	private static final int HEIGHT_FRAME = 530;
	private RootPanel rootPanel;

	public GUI(){
		init();
		addComps();
		setStyleUI();
	}

	private void init() {
		setLayout(new CardLayout());
		setTitle("Caro game");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void addComps() {
		rootPanel = new RootPanel();
		add(rootPanel);
	}

	private void setStyleUI() {
		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
