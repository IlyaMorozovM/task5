package task1.service;

import task1.repository.BookRepository;
import task1.entity.Book;
import task1.strategy.FineStrategy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LendingService {
    private final BookRepository bookRepository;
    private final ReservationService reservationService;
    private final FineStrategy fineStrategy;
    private final Map<String, LocalDate> loanDates = new HashMap<>();
    private final int loanPeriodDays = 14;

    public LendingService(BookRepository bookRepository, ReservationService reservationService, FineStrategy fineStrategy) {
        this.bookRepository = bookRepository;
        this.reservationService = reservationService;
        this.fineStrategy = fineStrategy;
    }

    public synchronized String checkOutBook(String bookId, String userId) {
        Book book = bookRepository.getBook(bookId);
        if (book == null) return "Book not found.";
        if (book.isLoaned()) {
            reservationService.reserveBook(bookId, userId);
            return "Book is currently loaned. Reservation placed.";
        }
        book.loanTo(userId);
        loanDates.put(bookId, LocalDate.now());
        return "Book checked out to " + userId;
    }

    public synchronized String returnBook(String bookId) {
        Book book = bookRepository.getBook(bookId);
        if (book == null) return "Book not found.";
        if (!book.isLoaned()) return "This book was not checked out.";
        int overdueDays = getOverdueDays(bookId);
        double fine = fineStrategy.calculateFine(overdueDays);
        book.returnBook();
        loanDates.remove(bookId);
        StringBuilder result = new StringBuilder("Book returned.");
        if (fine > 0) result.append(" Overdue fine: ").append(fine);
        if (reservationService.hasReservations(bookId)) {
            String nextUser = reservationService.getNextReservation(bookId);
            result.append(" Book reserved for: ").append(nextUser);
        }
        return result.toString();
    }

    private int getOverdueDays(String bookId) {
        LocalDate loanDate = loanDates.get(bookId);
        if (loanDate == null) return 0;
        int days = (int) (LocalDate.now().toEpochDay() - loanDate.toEpochDay());
        return Math.max(0, days - loanPeriodDays);
    }
}
