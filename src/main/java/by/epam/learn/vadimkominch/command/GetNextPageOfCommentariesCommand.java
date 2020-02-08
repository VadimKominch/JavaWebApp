package by.epam.learn.vadimkominch.command;

import javax.servlet.http.HttpServletRequest;

public class GetNextPageOfCommentariesCommand implements Command {
    private int pageNumber;

    public GetNextPageOfCommentariesCommand() {
    pageNumber = 0;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //get next page if it exists
        return null;
    }
}
