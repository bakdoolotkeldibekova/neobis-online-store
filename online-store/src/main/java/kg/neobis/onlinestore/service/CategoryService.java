package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category create(Category category);
}
