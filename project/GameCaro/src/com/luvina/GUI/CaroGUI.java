package com.luvina.GUI;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.luvina.caropanel.CaroPanel;
import com.luvina.icommon.Icommon;

public class CaroGUI extends JFrame implements Icommon {
	CaroPanel caroPanel;

	public CaroGUI(String title) {
		super(title);
		init();
		addcomps();
		creatStyle();
	}

	private void creatStyle() {
		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

	}

	@Override
	public void init() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(1100, 600));
		pack();
		setLocationRelativeTo(null);
		setLayout(new CardLayout());
		setResizable(true);
		
	}

	@Override
	public void addcomps() {
		caroPanel = new CaroPanel();
		add(caroPanel);

	}

}
