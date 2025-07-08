public class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + " | Author: " + author + " | Issued: " + (isIssued ? "Yes" : "No"));
    }
}
