package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getById(Long id);
    Book create(Book book);
    Book update(Book book);
    void deleteById(Long id);
}
