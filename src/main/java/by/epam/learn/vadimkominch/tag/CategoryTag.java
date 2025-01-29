package by.epam.learn.vadimkominch.tag;

import by.epam.learn.vadimkominch.entity.Category;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.service.CategoryService;
import by.epam.learn.vadimkominch.service.UserService;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;
import java.util.stream.Collectors;

public class CategoryTag extends TagSupport {
    private String categoryId;


    private final CategoryService service = CategoryService.getInstance();

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            int parsedId = Integer.parseInt(categoryId);
            Category category = service.getCategories().stream().filter(cat -> cat.getId().getValue() == parsedId).collect(Collectors.toList()).get(0);
            pageContext.getOut().print(category.getName().getValue());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
