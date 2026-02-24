package task1.service;

import java.util.*;

public class ReservationService {
    private final Map<String, Queue<String>> reservations = new HashMap<>();

    public void reserveBook(String bookId, String userId) {
        reservations.computeIfAbsent(bookId, k -> new LinkedList<>()).add(userId);
    }

    public String getNextReservation(String bookId) {
        Queue<String> queue = reservations.get(bookId);
        return (queue != null && !queue.isEmpty()) ? queue.poll() : null;
    }

    public boolean hasReservations(String bookId) {
        Queue<String> queue = reservations.get(bookId);
        return queue != null && !queue.isEmpty();
    }
}
