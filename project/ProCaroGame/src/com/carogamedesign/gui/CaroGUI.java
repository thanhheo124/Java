package com.carogamedesign.gui;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class CaroGUI extends JFrame implements ICommon{
	private CaroPanel caroPanel;
	
	public CaroGUI() {
		init();
		addComps();
	}
	
	@Override
	public void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(900, 600));
		pack();
		setLocationRelativeTo(null);
		setLayout(new CardLayout());
		setResizable(true);
	}

	@Override
	public void addComps() {
		caroPanel = new CaroPanel();
		add(caroPanel);
	}

}
