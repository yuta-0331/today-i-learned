package lesson;

public class HighPriceCalculator {
	
	public static Book searchHighPriceBook(Book[] args) {
		Book highPriceBook = args[0];
		for (Book book : args) {
			if (book.price > highPriceBook.price) {
				highPriceBook = book;
			}
		}
		return highPriceBook;
	}

	public static void main(String[] args) {

		Book[] books = new Book[5];
		for (int i = 0; i < books.length; i++) {
			books[i] = new Book();
		}
		
		String[] titles = { "初めてのWebGL", "PHP本格入門", "SQL入門", "JavaScript新版", "Java基本編" };
		int[] prices = { 4200, 3800, 2980, 3200, 1600 };
		for (int i = 0; i < books.length; i++) {
			books[i].title = titles[i];
			books[i].price = prices[i]; 
		}
		
		Book highPriceBook = searchHighPriceBook(books);
		System.out.println(highPriceBook.title + "\t" + highPriceBook.price + "円です");
		
	}

}
