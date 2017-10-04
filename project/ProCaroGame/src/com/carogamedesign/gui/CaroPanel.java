package com.carogamedesign.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class CaroPanel extends JPanel implements ICommon, MouseListener {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	public static final int SO_COT = 20;
	public static final int DO_RONG_CUA_O = 30;
	private static final String CLICK = "CLICK";
	public CaroPanel() {
		init();
		addComps();
	}

	@Override
	public void init() {
		setSize(WIDTH,HEIGHT);
		setBackground(Color.GRAY);
		setLayout(null);
	}

	@Override
	public void addComps() {
		for (int i = 0; i < SO_COT; i++)
			for (int j = 0; j < SO_COT; j++) {
				Button oVuong = new Button();
				oVuong.setBounds(j * DO_RONG_CUA_O, i * DO_RONG_CUA_O, DO_RONG_CUA_O - 1, DO_RONG_CUA_O - 1);
				add(oVuong);
				oVuong.setBackground(Color.white);
				oVuong.addMouseListener(this);
				oVuong.setActionCommand(CLICK);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
