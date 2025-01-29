package by.epam.learn.vadimkominch.command.advertisement;

import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.constant.UrlMappingConstant;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class GetUserAdvertisementsCommand implements Command {

    private final AdvertisementService advertisementService;

    public GetUserAdvertisementsCommand() {
        advertisementService = AdvertisementService.getInstance();
    }

    public static final String CATEGORY_ATTRIBUTE = "category";
    public static final String CURRENT_PAGE_SESSION_ATTRIBUTE = "currentPageNumber";
    public static final String PAGE_NUMBER_URL_PARAMETER = "pageNumber";
    public static final String ADS_LIST_SESSION_ATTRIBUTE = "advertisementList";
    public static final String CATEGORIES_ATTRIBUTE = "categories";
    public static final String LANG_ATTRIBUTE = "language";
    public static final String AVAILABLE_LANGUAGES_ATTRIBUTE = "langs";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int categoryId = 0;
        try {
            categoryId = Integer.parseInt(request.getParameter(CATEGORY_ATTRIBUTE));
        } catch (NumberFormatException e) {

        }
        List<Advertisement> advertismentList = new ArrayList<>();
        HttpSession session = request.getSession();
        int pageNumber = 1;
        if (session.getAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE) != null) {
            try {
                pageNumber = Integer.parseInt(request.getParameter(PAGE_NUMBER_URL_PARAMETER));
            } catch (NumberFormatException ignored) {}
        } else {

        }


        advertismentList = advertisementService.getCategoryAdvertisements(categoryId);
        session.setAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE, pageNumber);
        session.setAttribute(ADS_LIST_SESSION_ATTRIBUTE, advertismentList);

        response.sendRedirect(UrlMappingConstant.TO_MAIN_PAGE);
    }
}
