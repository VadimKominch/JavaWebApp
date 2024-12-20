package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.daoimplementation.AdvertismentDaoImplementation;
import by.epam.learn.vadimkominch.daoimplementation.DAOInterface;
import by.epam.learn.vadimkominch.entity.Advertisment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

public class DeleteAdvertismentCommand implements Command {
    Logger log = LogManager.getLogger(DeleteAdvertismentCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        DAOInterface<Advertisment, String> daoInterface = new AdvertismentDaoImplementation();
        Advertisment advertisment = new Advertisment();
        String body;
        try {
            body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            System.out.println("Body:"+ body);
            advertisment.setAdvertismentId(Integer.parseInt(body));
            daoInterface.delete(advertisment);
        } catch (IOException e) {
            log.error(e);
        }
        return "get_page?page=profile";
    }
}
