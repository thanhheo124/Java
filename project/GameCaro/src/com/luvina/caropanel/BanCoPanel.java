package com.luvina.caropanel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.luvina.caromanager.BanCo;
import com.luvina.caromanager.NguoiChoi;
import com.luvina.theco.TheCo;

public class BanCoPanel extends BasePanel {

	private boolean thangCuoc = false;
	private BanCo banCo;
	private NguoiChoi nguoiChoi1;
	private NguoiChoi may;
	private int luotDanh;

	@Override
	public void init() {
		setLayout(null);
		setSize(BanCo.SO_HANG * BanCo.SIZE_O_VUONG, BanCo.SO_COT * BanCo.SIZE_O_VUONG);
		setBackground(Color.GREEN);

	}

	@Override
	public void addcomps() {

		JLabel listLabel[][] = new JLabel[BanCo.SO_HANG][BanCo.SO_COT];
		// cài đặt icon cho label//
		Icon imageX = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("xx.png")));
		Icon imageO = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("oo.png")));
		Icon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("chuaChoi.png")));
		nguoiChoi1 = new NguoiChoi("Long", imageO);
		may = new NguoiChoi("Giang", imageX);
		banCo = new BanCo(Color.BLACK, nguoiChoi1, may);

		for (int i = 0; i < BanCo.SO_HANG; i++)
			for (int j = 0; j < BanCo.SO_COT; j++) {

				JLabel oVuong = new JLabel();
				oVuong.setBounds(j * BanCo.SIZE_O_VUONG, i * BanCo.SIZE_O_VUONG, 28, 28);
				listLabel[i][j] = oVuong;
				add(oVuong);
				oVuong.setForeground(Color.PINK);
				oVuong.setIcon(image);
				oVuong.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						String nguoiThangCuoc = "";
						Container container = getParent();
						CaroPanel caroPanelx = (CaroPanel) container;
						int oWin = BanCo.ngChoi1Thang;
						int xWin = BanCo.ngChoi2Thang;
						if (oVuong.getIcon() == imageO || oVuong.getIcon() == imageX) {
							JOptionPane.showMessageDialog(null, "Ô đã được đánh! mời bạn đánh ô khác");
						}
						// nếu chưa đánh trùng ô thì O và X đánh lần lượt
						else {

							oVuong.setIcon(imageO);
							nguoiChoi1.danhCo(oVuong.getX() + 5, oVuong.getY() + 5);
							timViTriMayDanh();

						}
						/*
						 * đánh xong thì kiểm tra thắng cuộc! nếu thắng thông báo ra màn hình và reset
						 * bàn chơi nếu ng chơi đồng ý
						 */
						banCo.kiemTraThangCuoc();
						if (BanCo.ngChoi1Thang > oWin)
							nguoiThangCuoc = caroPanelx.getTfPlayer1().getText();
						else
							nguoiThangCuoc = caroPanelx.getTfPlayer2().getText();
						caroPanelx.setTySo("Tỷ số: " + BanCo.ngChoi1Thang + "-" + BanCo.ngChoi2Thang);
						if (banCo.isThangCuoc()) {
							System.out.println(BanCo.ngChoi1Thang + " " + BanCo.ngChoi2Thang);

							int kq = JOptionPane.showConfirmDialog(null,
									"Người chơi " + nguoiThangCuoc + " thắng cuộc!!! bạn có muốn chơi tiếp",
									"Thông báo", JOptionPane.YES_NO_OPTION);
							if (kq == JOptionPane.YES_OPTION) {
								banCo = new BanCo(Color.BLUE, nguoiChoi1, may);

								luotDanh = 0;
								for (int k = 0; k < BanCo.SO_HANG; k++) {
									for (int m = 0; m < BanCo.SO_COT; m++) {
										listLabel[k][m].setIcon(image);

									}
								}
							} else
								setVisible(false);

						}

					}

					private ArrayList<String> loadTheCo() {
						ArrayList<String> listTheCoHienTai = new ArrayList<String>();

						for (int i = 0; i < BanCo.SO_HANG - 4; i++)
							for (int j = 0; j < BanCo.SO_COT - 4; j++) {

								{
									String s = "";
									for (int m = i; m < i + 5; m++) {
										for (int n = j; n < j + 5; n++) {
											if (listLabel[m][n].getIcon() == imageX)
												s += "X";
											else if (listLabel[m][n].getIcon() == imageO)
												s += "O";
											else
												s += "T";
										}
									}

									listTheCoHienTai.add(s);

								}

							}

						return listTheCoHienTai;

					}

					private void timViTriMayDanh() {
						boolean mayDanh = false;
						ArrayList<String> theCoHienTai = this.loadTheCo();
						ArrayList<String> danhSachTheCo = new TheCo().getListTheCo();

						for (String theCo : danhSachTheCo) {
							for (int i = 0; i < theCoHienTai.size(); i++) {

								if (theCoHopLe(theCo, theCoHienTai.get(i))) {
									System.out.println("thế cờ hợp lệ: " + theCo);
									System.out.println("the co hien tai: " + " vitri" + i + " " + theCoHienTai.get(i));
									for (int k = 0; k < theCo.length(); k++) {
										if (theCo.charAt(k) == 'D') {
											int viTriX = (i % 16 + k % 5) * BanCo.SIZE_O_VUONG + 5;
											int viTriY = (i / 16 + k / 5) * BanCo.SIZE_O_VUONG + 5;
											may.danhCo(viTriX, viTriY);
											listLabel[viTriY / BanCo.SIZE_O_VUONG][viTriX / BanCo.SIZE_O_VUONG]
													.setIcon(imageX);

										}
									}

									mayDanh = true;
									break;

								}

							}
							if (mayDanh)
								break;
						}

					}

					public boolean theCoHopLe(String a, String b) {

						for (int i = 0; i < a.length(); i++) {
							if (a.charAt(i) == 'O' && b.charAt(i) != 'O' || a.charAt(i) == 'X' && b.charAt(i) != 'X'
									|| a.charAt(i) == 'T' && b.charAt(i) != 'T'
									|| a.charAt(i) == 'D' && b.charAt(i) != 'T' || b.equals("TTTTTTTTTTTTTTTTTTTTTTTTT")
									|| a.contains("0") || a.contains(" ")

							)

								return false;
						}

						return true;
					}

				});

			}

	}

}
