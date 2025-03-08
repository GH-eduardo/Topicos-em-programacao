package org.example.entities.book;

import org.example.entities.book.Book;
import org.example.entities.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Create
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Read (todos)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Read (por ID)
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Update
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        return bookRepository.save(book);
    }

    // Delete
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}