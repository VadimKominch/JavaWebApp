package by.epam.learn.vadimkominch.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnknownCommand implements Command {
    Logger log = LogManager.getLogger(UnknownCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.warn("Access to url {}", request.getServletPath());
    }
}
