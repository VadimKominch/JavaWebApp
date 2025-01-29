package by.epam.learn.vadimkominch.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class TimeTag extends TagSupport {
    private String date;


    private final static SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            Date parsedDate = Date.from(Instant.ofEpochMilli(Long.parseLong(date)));
            pageContext.getOut().print(sdf.format(parsedDate));
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
