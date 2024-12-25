package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.Category;
import by.epam.learn.vadimkominch.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;

public class GetCategoriesCommand implements Command {
    private final CategoryService categoryService;

    public GetCategoriesCommand() {
        categoryService = CategoryService.getInstance();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Category> categories = categoryService.getCategories();
        String categoriesString = categories.stream().map(Category::toJsonString).collect(Collectors.joining(",\n"));
        String responseString = "[ "+ categoriesString + "]";
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseString);
    }
}
