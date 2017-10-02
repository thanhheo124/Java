/**
 * Copyright(C) 2017 Luvina
 * CDs.java Sep 26, 2017 ducthanh
 */
package bai2;

/**
 * @author ducthanh
 *
 */
public class CDs {
	private String artist;
	private String title;
	
	/**
	 * 
	 */
	public CDs(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	public void display() {
		System.out.format("%-40s%-1s%n",artist,title);
	}
	
	
	
}
