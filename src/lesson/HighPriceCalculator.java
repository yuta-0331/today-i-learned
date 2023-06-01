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

	public static int countSamePrice(Book[] args , int price) {
		int count = 0;
		for (Book book : args) {
			if (book.price == price) {
				count++;
			}
		}
		return count;
	}

	public static Book[] createArraySamePrice(Book[] args, int price, int count) {
		Book[] bookArray = new Book[count];
		for (int i = 0, j = 0; i < args.length && j < count; i++) {
			if (args[i].price == price) {
				bookArray[j++] = args[i];
			}
		}

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
		int count = countSamePrice(books, highPriceBook.price);
		Book[] highPriceBooks = createArraySamePrice(books, highPriceBook.price, count);
		System.out.println("最高価格の本")
		for (Book book : highPriceBooks) {
			System.out.print(book.title + " ");
		}
		System.out.println("価格は" + highPriceBook.price);
		
	}

}
