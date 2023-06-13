package lesson;

import java.util.ArrayList;

public class HighPriceCalculator {
	
	public static Book searchHighPriceBook(ArrayList<Book> args) {
		Book highPriceBook = args.get(0);
		for (Book book : args) {
			if (book.price > highPriceBook.price) {
				highPriceBook = book;
			}
		}
		return highPriceBook;
	}

	public static ArrayList<Book> createArraySamePrice(ArrayList<Book> args, int price) {
		ArrayList<Book> bookArray = new ArrayList<>();
		for (int i = 0, j = 0; i < args.size(); i++) {
			if (args.get(i).price == price) {
				bookArray.add(args.get(i));
			}
		}
		return bookArray;
	}
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<>();
		
		String[] titles = { "初めてのWebGL", "PHP本格入門", "SQL入門", "JavaScript新版", "Java基本編" };
		int[] prices = { 4200, 3800, 4200, 3200, 1600 };
		for (int i = 0; i < titles.length; i++) {
			books.add(new Book(titles[i], prices[i]));
		}
		
		Book highPriceBook = searchHighPriceBook(books);
		ArrayList<Book> highPriceBooks = createArraySamePrice(books, highPriceBook.price);
		System.out.println("最高価格の本");
		for (Book book : highPriceBooks) {
			System.out.print(book.title + " ");
		}
		System.out.println("価格は" + highPriceBook.price);
		
	}

}
