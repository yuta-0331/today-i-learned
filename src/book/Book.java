package book;

import java.util.ArrayList;

public class Book {
	private int price;
	private String title;

	//Getter
	public int getPrice() {
		return price;
	}
	public String getTitle() {
		return title;
	}

	// Setter
	public void setPrice(int price) {
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}


}
