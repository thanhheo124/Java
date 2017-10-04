package com.projectcarogame.giaodien;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.projectcarogame.components.BanCo;

public class CaroPanel extends JPanel implements ICommon {

	public CaroPanel() {
		init();
		addComps();
	}

	@Override
	public void init() {
		setSize(BanCo.SO_HANG * BanCo.SIZE_O_VUONG, BanCo.SO_COT * BanCo.SIZE_O_VUONG);
		setBackground(Color.GRAY);
		setLayout(null);
	}

	@Override
	public void addComps() {
		for (int i = 0; i < BanCo.SO_HANG; i++)
			for (int j = 0; j < BanCo.SO_COT; j++) {
				JButton oVuong = new JButton();
				oVuong.setBounds(j * BanCo.SIZE_O_VUONG, i * BanCo.SIZE_O_VUONG, 29, 29);
				add(oVuong);
				oVuong.setBackground(Color.white);
			
		}
	}

}
