package task1.repository;

import task1.entity.Book;

import java.util.concurrent.ConcurrentHashMap;

public class BookRepository {
    private final ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book getBook(String bookId) {
        return books.get(bookId);
    }
}
