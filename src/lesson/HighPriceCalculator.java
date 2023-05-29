package lesson;

public class HighPriceCalculator {

	public static void main(String[] args) {

		Book[] books = new Book[5];
		for (int i = 0; i < books.length; i++) {
			books[i] = new Book();
		}
		
		books[0].title = "初めてのWebGL";
		books[0].price = 4200;
		books[1].title = "PHP本格入門";
		books[1].price = 3800;
		books[2].title = "SQL入門";
		books[2].price = 2980;
		books[3].title = "JavaScript新版";
		books[3].price = 3200;
		books[4].title = "Java基本編";
		books[4].price = 1600;
		
		Book highPriceBook = books[0];
		for (Book book : books) {
			if (book.price > highPriceBook.price) {
				highPriceBook = book;
			}
		}
		System.out.println(highPriceBook.title + "\t" + highPriceBook.price + "円です");
	}

}
