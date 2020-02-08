package by.epam.learn.vadimkominch.Constant;

import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.command.GetNextPageOfParagraphsCommand;
import by.epam.learn.vadimkominch.command.LoginCommand;
import by.epam.learn.vadimkominch.command.LogoutCommand;

public enum CommandConstant {

    LOGIN{
        {
            this.command = new LoginCommand();
        }
    },LOGOUT{
        {
            this.command = new LogoutCommand();
        }
    },GET_NEXT_PAGE_OF_PARAGRAPHS{
        {
            this.command = new GetNextPageOfParagraphsCommand();
        }
    },DELETE_PARAGRAPH{
        {

        }
    },MODIFY_PARAGRAPH{
        {

        }
    };

    Command command;
    public Command getCurrentCommand() {
        return command;
    }
    //login
    //logout
    //comment
    //like
    //open
    //delete user
    //ban user
    //moderate user
    //delete paragraph
    //modify paragraph
}
