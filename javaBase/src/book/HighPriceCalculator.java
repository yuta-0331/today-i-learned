package book;

import book.Book;

import java.util.ArrayList;

public class HighPriceCalculator {
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<>();
		
		String[] titles = { "初めてのWebGL", "PHP本格入門", "SQL入門", "JavaScript新版", "Java基本編" };
		int[] prices = { 4200, 3800, 4200, 3200, 1600 };
		for (int i = 0; i < titles.length; i++) {
			books.add(new Book(titles[i], prices[i]));
		}

		BookManager bookManager = new BookManager(books);
		
		Book highPriceBook = bookManager.searchHighPriceBook();
		ArrayList<Book> highPriceBooks = bookManager.getBooksWithSamePrice(highPriceBook.getPrice());
		System.out.println("最高価格の本");
		for (Book book : highPriceBooks) {
			System.out.print(book.getTitle() + " ");
		}
		System.out.println("価格は" + highPriceBook.getPrice());
		
	}

}
