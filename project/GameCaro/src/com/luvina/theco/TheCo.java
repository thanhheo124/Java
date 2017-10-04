package com.luvina.theco;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TheCo {
	public static final String FILE_THE_CO = "theco.txt";

	ArrayList<String> listTheCo;

	public TheCo() {
		String theCo = "";

		listTheCo = new ArrayList<String>();
		{
			File file = new File(FILE_THE_CO);
			try {
				DataInputStream dataIn = new DataInputStream(new FileInputStream(file));
				while (true) {

					String s = dataIn.readLine();

					theCo += s;

					if (s == null) {
						break;
					}
					if (s.isEmpty()) {
						theCo = theCo.replace(" ", "");
						listTheCo.add(theCo);
						theCo = "";
					}

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public ArrayList<String> getListTheCo() {
		return listTheCo;
	}

	public static void main(String[] args) {
		TheCo tc = new TheCo();

	}

}
