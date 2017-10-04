package com.luvina.caropanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaroPanel extends BasePanel {

	private JTextField tfPlayer1;
	private JTextField tfPlayer2;
	private JPanel caroPanel;
	private JLabel lblTitle;
	private JLabel lblPlayer1;

	private JLabel lblPlayer2;
	private JLabel imageX;
	private JButton btnChoiLai;
	private JLabel imageO;
	public JLabel lblTySo;
	BanCoPanel banCoPanel;

	@Override
	public void init() {
		setLayout(null);
		setBackground(Color.PINK);

	}

	@Override
	public void addcomps() {

		lblTitle = new JLabel("Cờ Caro 2017");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(750, 61, 250, 33);
		add(lblTitle);

		lblPlayer1 = new JLabel("Player1");
		lblPlayer1.setForeground(Color.BLUE);
		lblPlayer1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayer1.setBounds(649, 149, 46, 14);
		add(lblPlayer1);

		lblPlayer2 = new JLabel("Player2");
		lblPlayer2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayer2.setForeground(Color.BLUE);
		lblPlayer2.setBounds(649, 229, 46, 14);
		add(lblPlayer2);

		tfPlayer1 = new JTextField();
		tfPlayer1.setBounds(716, 143, 86, 20);
		tfPlayer1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfPlayer1.setForeground(Color.MAGENTA);
		tfPlayer1.setText("Giang");
		add(tfPlayer1);
		

		tfPlayer2 = new JTextField();
		tfPlayer2.setBounds(716, 223, 86, 20);
		tfPlayer2.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfPlayer2.setForeground(Color.MAGENTA );
		tfPlayer2.setText("Machine");
		add(tfPlayer2);
		

		imageX = new JLabel();
		imageX.setBounds(812, 220, 28, 26);
		imageX.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("xx.png"))));
		add(imageX);

		imageO = new JLabel();
		imageO.setBounds(812, 140, 28, 26);
		imageO.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("oo.png"))));

		add(imageO);

		lblTySo = new JLabel("Tỷ số: 0-0");
		lblTySo.setForeground(Color.RED);
		lblTySo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTySo.setBounds(900, 163, 118, 55);
		add(lblTySo);

		banCoPanel = new BanCoPanel();
		add(banCoPanel);
		btnChoiLai = new JButton("Chơi lại");
		btnChoiLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChoiLai.setBounds(714, 316, 264, 33);
		add(btnChoiLai);
		btnChoiLai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choiLai();

			}
		});

	}

	public void choiLai() {
		banCoPanel.setVisible(false);
		banCoPanel = new BanCoPanel();
		add(banCoPanel);
	}

	public JTextField getTfPlayer1() {
		return tfPlayer1;
	}

	public JTextField getTfPlayer2() {
		return tfPlayer2;
	}

	public JLabel getLblTySo() {
		return lblTySo;
	}

	public void setTySo(String tiSo) {
		lblTySo.setText(tiSo);

	}

}
