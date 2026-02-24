package task1.entity;

public class Book {
    private final String id;
    private final String title;
    private boolean isLoaned;
    private String currentUserId;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isLoaned = false;
        this.currentUserId = null;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isLoaned() { return isLoaned; }
    public String getCurrentUserId() { return currentUserId; }

    public void loanTo(String userId) {
        this.isLoaned = true;
        this.currentUserId = userId;
    }

    public void returnBook() {
        this.isLoaned = false;
        this.currentUserId = null;
    }
}
