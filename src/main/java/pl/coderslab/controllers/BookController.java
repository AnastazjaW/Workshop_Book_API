package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.models.Book;
import pl.coderslab.services.MockBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
private final MockBookService mockBookService;

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
    @GetMapping("")
    public List<Book> allBooks() {
        return mockBookService.allBooks();
    }
    @GetMapping("/{id}")
    public Book findBook(@PathVariable long id) {
        return mockBookService.findBook(id);

    }
    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mockBookService.addBook(book);
    }
    @PutMapping("")
    public void editBook(@RequestBody Book book) {
        mockBookService.editBook(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        mockBookService.deleteBook(id);
    }



}
