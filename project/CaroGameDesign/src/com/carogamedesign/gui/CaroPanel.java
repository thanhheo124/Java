package com.carogamedesign.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.carogamedesign.caro.BanCo;
import com.carogamedesign.caro.NguoiChoi;
import com.carogamedesign.caro.QuanCo;

public class CaroPanel extends JPanel {
	public static final int WIDTH_CARO = 500;
	public static final int HEIGHT_CARO = 500;
	public static final int DO_RONG_O_CO = 50;
	private JLabel lbCaroTitle, lbPlay1, lbPlay2, lbTySo, lbX, lbO;
	private JTextField tfPlay1, tfPlay2;
	private JButton btChoiLai, btStart;
	private ArrayList<JButton> listButton;

	private int dem = 0;
	private BanCo banCo;

	public CaroPanel() {
		listButton = new ArrayList<>();
		addComps();
		setLayout(null);
		veBanCo();

	}

	private void veBanCo() {

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				JButton bt = new JButton();
				listButton.add(bt);
				bt.setSize(DO_RONG_O_CO, DO_RONG_O_CO);
				bt.setLocation(x * DO_RONG_O_CO, y * DO_RONG_O_CO);
				add(bt);
				bt.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						bt.setFont(new Font("Tahoma", Font.BOLD, 20));

						if (dem % 2 == 0) {
							bt.setText("X");
							bt.setForeground(Color.GREEN);
							banCo.getNguoiChoi1().danhCo(bt.getX(), bt.getY());
							dem++;
						} else {
							bt.setText("O");
							bt.setForeground(Color.RED);
							banCo.getNguoiChoi2().danhCo(bt.getX(), bt.getY());
							dem++;
						}
						banCo.kiemTraThangCuoc();
						lbTySo.setText("Tỷ Số: "+banCo.getTySo());

					}
				});
			}

		}
		for (int i = 0; i < listButton.size(); i++) {
			listButton.get(i).setEnabled(false);
		}
	}

	private void addComps() {
		lbCaroTitle = new JLabel("CARO MASTER");
		Font font = new Font("Tahoma", Font.BOLD, 25);
		lbCaroTitle.setFont(font);
		lbCaroTitle.setForeground(Color.BLUE);
		lbCaroTitle.setBounds(600, 30, 220, 30);
		add(lbCaroTitle);

		lbPlay1 = new JLabel("Player1");
		lbPlay1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbPlay1.setForeground(Color.GREEN);
		lbPlay1.setBounds(510, 150, 70, 20);
		add(lbPlay1);

		lbPlay2 = new JLabel("Player2");
		lbPlay2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbPlay2.setForeground(Color.RED);
		lbPlay2.setBounds(510, 190, 70, 20);
		add(lbPlay2);

		lbX = new JLabel("X");
		lbX.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbX.setForeground(Color.GREEN);
		lbX.setBounds(645, 150, 70, 24);
		add(lbX);

		lbO = new JLabel("O");
		lbO.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbO.setForeground(Color.RED);
		lbO.setBounds(645, 190, 70, 24);
		add(lbO);

		lbTySo = new JLabel("Tỷ Số: 0-0");
		lbTySo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTySo.setForeground(Color.YELLOW);
		lbTySo.setBounds(740, 165, 130, 25);
		add(lbTySo);

		tfPlay1 = new JTextField();
		tfPlay1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPlay1.setForeground(Color.GREEN);
		tfPlay1.setBounds(570, 150, 70, 24);
		add(tfPlay1);

		tfPlay2 = new JTextField();
		tfPlay2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPlay2.setForeground(Color.RED);
		tfPlay2.setBounds(570, 190, 70, 24);
		add(tfPlay2);

		btStart = new JButton("START");
		btStart.setFont(new Font("Tahoma", Font.BOLD, 20));
		btStart.setForeground(Color.BLACK);
		btStart.setBounds(510, 260, 370, 50);
		add(btStart);
		btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfPlay1.getText().isEmpty() || tfPlay2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Bạn phải nhập tên người chơi");
					return;
				}
				String play1Name = tfPlay1.getText();
				String play2Name = tfPlay2.getText();
				banCo = new BanCo(null, BanCo.TY_SO_MAC_DINH, new NguoiChoi(play1Name, NguoiChoi.LOAI_QUAN_CO_X),
						new NguoiChoi(play2Name, NguoiChoi.LOAI_QUAN_CO_O));
				for (int i = 0; i < listButton.size(); i++) {
					listButton.get(i).setEnabled(true);
				}
			}
		});

		btChoiLai = new JButton("CHƠI LẠI");
		btChoiLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btChoiLai.setForeground(Color.BLACK);
		btChoiLai.setBounds(510, 320, 370, 50);
		add(btChoiLai);
		btChoiLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				veBanCo();
				for (int i = 0; i < listButton.size(); i++) {
					listButton.get(i).setText("");
				}
				addNotify();
				banCo.choiLai();
				lbTySo.setText("Tỷ Số: "+BanCo.TY_SO_MAC_DINH);
				
			}
		});
	}

}
