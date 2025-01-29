package by.epam.learn.vadimkominch.tag;

import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.service.UserService;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
// <p><a href="#">${param.author}</a></p>
public class AuthorTag extends TagSupport {
    private String authorId;


    private final UserService service = UserService.getInstance();

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            int parsedId = Integer.parseInt(authorId);
            User user = service.getOne(parsedId);
            pageContext.getOut().print(user.getNickName().getValue());
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
