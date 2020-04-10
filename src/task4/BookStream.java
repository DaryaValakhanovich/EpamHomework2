package task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStream {
    public Predicate<Book> isMoreTwoHundredPagesPredicate = (Book b) -> b.getNumberOfPages() > 200;
    public Comparator<Book> byPagesComparator = Comparator.comparing(Book::getNumberOfPages);
    public Predicate<Book> isOneAuthor = (Book b) -> b.getAuthors().size() == 1;
    public Comparator<Book> byTitleComparator = Comparator.comparing(Book::getTitle);

    public boolean isMoreTwoHundredPages(Book[] books) {
        return Arrays.stream(books).anyMatch(isMoreTwoHundredPagesPredicate);
    }

    public boolean isAllMoreTwoHundredPages(Book[] books) {
        return Arrays.stream(books).allMatch(isMoreTwoHundredPagesPredicate);
    }

    public Book getBookWithMaxPages(Book[] books) {
        return Arrays.stream(books).max(byPagesComparator).get();
    }

    public Book getBookWithMinPages(Book[] books) {
        return Arrays.stream(books).min(byPagesComparator).get();
    }

    public Book[] getBooksWithOneAuthor(Book[] books) {
        return Arrays.stream(books).filter(isOneAuthor).toArray(Book[]::new);
    }

    public Book[] sortByPages(Book[] books) {
        return Arrays.stream(books).peek(System.out::println).sorted(byPagesComparator).toArray(Book[]::new);
    }

    public Book[] sortByTitle(Book[] books) {
        return Arrays.stream(books).peek(System.out::println).sorted(byTitleComparator).toArray(Book[]::new);
    }

    public List<String> getAllTitles(Book[] books) {
        return Arrays.stream(books).map(Book::getTitle).collect(Collectors.toList());
    }

    public List<Author> getAllAuthors(Book[] books) {
        List<Author> authorList = new ArrayList<>();
        Arrays.stream(books).map(Book::getAuthors).forEach(authorList::addAll);
        return authorList.stream().distinct().collect(Collectors.toList());
    }

    public List<Author> getAllAuthorsByParallelStream(Book[] books) {
        List<Author> authorList = new ArrayList<>();
        Arrays.stream(books).parallel().map(Book::getAuthors).forEach(authorList::addAll);
        return authorList.stream().parallel().distinct().collect(Collectors.toList());
    }
}
