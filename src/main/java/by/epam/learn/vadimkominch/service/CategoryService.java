package by.epam.learn.vadimkominch.service;

import by.epam.learn.vadimkominch.repository.CategoryRepository;
import by.epam.learn.vadimkominch.entity.Category;

import java.util.List;

public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService() {
        repository = CategoryRepository.getInstance();
    }

    public List<Category> getCategories() {
        return repository.getAll();
    }


    private static class Holder {
        private static final CategoryService INSTANCE = new CategoryService();
    }

    public static CategoryService getInstance() {
        return CategoryService.Holder.INSTANCE;
    }
}
