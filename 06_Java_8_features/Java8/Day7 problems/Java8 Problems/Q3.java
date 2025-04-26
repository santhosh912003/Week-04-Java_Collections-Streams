package org.rajesh;

// Problem3_BookRecommendations.java
import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
}

public class Q3 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book A", "Author A", "Science Fiction", 4.5),
                new Book("Book B", "Author B", "Science Fiction", 4.2),
                new Book("Book C", "Author C", "Drama", 4.8)
        );

        List<BookRecommendation> recommendations = books.stream()
                .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
                .map(b -> new BookRecommendation(b.title, b.rating))
                .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
                .limit(10)
                .collect(Collectors.toList());

        recommendations.forEach(r -> System.out.println(r.title + ": " + r.rating));
    }
}
