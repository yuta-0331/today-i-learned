package book;

import java.util.ArrayList;

public class BookManager {
    private ArrayList<Book> books;

    //Getter
    public ArrayList<Book> getBooks() {
        return books;
    }
    public BookManager(ArrayList<Book> books) {
        this.books = books;
    }
    public Book searchHighPriceBook() {
        Book highPriceBook = books.get(0);
        for (Book book : books) {
            if (book.getPrice() > highPriceBook.getPrice()) {
                highPriceBook = book;
            }
        }
        return highPriceBook;
    }

    public ArrayList<Book> getBooksWithSamePrice(int price) {
        ArrayList<Book> bookArray = new ArrayList<>();
        for (int i = 0, j = 0; i < books.size(); i++) {
            if (books.get(i).getPrice() == price) {
                bookArray.add(books.get(i));
            }
        }
        return bookArray;
    }

}
