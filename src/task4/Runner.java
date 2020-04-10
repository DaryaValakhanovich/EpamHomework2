package task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class Runner {
    public static void main(String[] args) {
        Author[] authors = new Author[]{
                new Author("Steve", (short) 23),
                new Author("Mary", (short) 29),
                new Author("Bob", (short) 42),
                new Author("Kevin", (short) 21)
        };

        Book[] books = new Book[]{
                new Book("Book1", 201),
                new Book("Book2", 160),
                new Book("Book3", 320),
                new Book("Book4", 70),
        };

        books[0].addAuthor(authors[0]);
        books[0].addAuthor(authors[1]);
        books[1].addAuthor(authors[0]);
        books[1].addAuthor(authors[3]);
        books[2].addAuthor(authors[1]);
        books[2].addAuthor(authors[2]);
        books[2].addAuthor(authors[3]);
        books[3].addAuthor(authors[2]);

        authors[0].addBook(books[0]);
        authors[0].addBook(books[1]);
        authors[1].addBook(books[0]);
        authors[1].addBook(books[2]);
        authors[2].addBook(books[2]);
        authors[2].addBook(books[3]);
        authors[3].addBook(books[1]);
        authors[3].addBook(books[2]);

        BookStream bookStream = new BookStream();
        test(books, bookStream);
        System.out.println("Biggest book of author " + authors[2].getName() + ": "
                + getBook(books, authors[2]));
    }

    public static void printAll(Object[] objects) {
        System.out.println();
        Arrays.stream(objects).forEach(System.out::println);
        System.out.println();
    }

    public static void test(Book[] books, BookStream bookStreamTask) {
        System.out.println("Have books over two hundred pages? "
                + bookStreamTask.isMoreTwoHundredPages(books) + "\n");
        System.out.println("Are all books larger than two hundred pages? "
                + bookStreamTask.isAllMoreTwoHundredPages(books) + "\n");

        System.out.println("Book with max pages: " + bookStreamTask.getBookWithMaxPages(books) + "\n");
        System.out.println("Book with min pages: " + bookStreamTask.getBookWithMinPages(books) + "\n");

        System.out.println("Books with one author:");
        printAll(bookStreamTask.getBooksWithOneAuthor(books));

        System.out.println("Before and after sort by pages:");
        printAll(bookStreamTask.sortByPages(books));

        System.out.println("Before and after sort by titles:");
        printAll(bookStreamTask.sortByTitle(books));

        System.out.println("All titles:\n");
        bookStreamTask.getAllTitles(books).forEach(System.out::println);

        System.out.println("\nAll authors:");
        printAll(bookStreamTask.getAllAuthors(books).toArray());
        System.out.println("All authors by parallel stream:");
        printAll(bookStreamTask.getAllAuthorsByParallelStream(books).toArray());
    }

    public static String getBook(Book[] books, Author author) {
        Comparator<Book> byPagesComparator = Comparator.comparing(Book::getNumberOfPages);
        Predicate<Book> isByAuthor = (Book b) -> b.getAuthors().contains(author);
        Optional<Book> book = Arrays.stream(books).filter(isByAuthor).max(byPagesComparator);
        return book.isPresent() ? book.get().getTitle() : "Book Not Found";
    }
}
