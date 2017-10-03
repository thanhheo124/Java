package com.carogamedesign.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.carogamedesign.caro.BanCo;

public class RootPanel extends JPanel {
	private CaroPanel caroPanel;
	
	
	public RootPanel(){
		init();
		addComps();
	}

	private void init() {
		setBackground(Color.WHITE);
		setLayout(null);
	}

	private void addComps() {
		caroPanel = new CaroPanel();
		caroPanel.setBounds(0, 0, 900, 530);
		add(caroPanel);
	}

}
