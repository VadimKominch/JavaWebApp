package by.epam.learn.vadimkominch.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            Calendar c = new GregorianCalendar();
            pageContext.getOut().print(c.getTime());
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
