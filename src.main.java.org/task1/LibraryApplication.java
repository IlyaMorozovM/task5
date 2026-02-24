package task1;

import task1.entity.Book;
import task1.repository.BookRepository;
import task1.service.LendingService;
import task1.service.ReservationService;
import task1.strategy.DefaultFineStrategy;
import task1.strategy.FineStrategy;

public class LibraryApplication {
    public static void main(String[] args) {
        BookRepository bookRepo = new BookRepository();
        ReservationService reservationService = new ReservationService();
        FineStrategy fineStrategy = new DefaultFineStrategy();
        LendingService lendingService = new LendingService(bookRepo, reservationService, fineStrategy);

        bookRepo.addBook(new Book("BK001", "Clean Code"));
        bookRepo.addBook(new Book("BK002", "Effective Java"));

        System.out.println(lendingService.checkOutBook("BK001", "USR001"));
        System.out.println(lendingService.checkOutBook("BK001", "USR002")); // Reservation
        System.out.println(lendingService.returnBook("BK001")); // Should notify about reservation
        System.out.println(lendingService.returnBook("BK002")); // Not checked out
    }
}
