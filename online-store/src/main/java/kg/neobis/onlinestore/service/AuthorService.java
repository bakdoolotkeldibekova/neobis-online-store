package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Author;

import java.util.List;

public interface AuthorService {
    Author getById(Long id);
    List<Author> getAll();
    Author create(Author author);
    Author update(Author author);
    void deleteById(Long id);
}
