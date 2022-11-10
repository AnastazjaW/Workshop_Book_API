package pl.coderslab.services;

import org.springframework.stereotype.Component;
import pl.coderslab.models.Book;

import java.util.ArrayList;
import java.util.List;
@Component
public class MockBookService {
    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public List<Book> allBooks() {
        return this.getList();
    }

    public Book findBook(long id) {
        Book bookToFind = list.stream().filter(book -> book.getId() == id).findAny().orElse(null);
        return bookToFind;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        list.add(book);
    }

    public void editBook(Book book) {
        Book bookToEdit = findBook(book.getId());
        int indexOfBookToEdit = list.indexOf(bookToEdit);
        list.set(indexOfBookToEdit, book);
    }

    public void deleteBook(long id) {
        list.remove(findBook(id));
    }
}

