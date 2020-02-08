package by.epam.learn.vadimkominch.command;

import javax.servlet.http.HttpServletRequest;

public class GetNextPageOfParagraphsCommand implements Command {
    private  int pageNumber;

    public GetNextPageOfParagraphsCommand() {
        this.pageNumber = 0; //save to session
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
