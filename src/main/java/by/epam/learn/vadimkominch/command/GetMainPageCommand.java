package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.Category;
import by.epam.learn.vadimkominch.entity.Page;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import by.epam.learn.vadimkominch.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class GetMainPageCommand implements Command {

    private final AdvertisementService adsService;
    private final CategoryService categoryService;

    public static final String CURRENT_PAGE_SESSION_ATTRIBUTE = "currentPageNumber";
    public static final String PAGE_NUMBER_URL_PARAMETER = "pageNumber";
    public static final String ADS_LIST_SESSION_ATTRIBUTE = "advertisementList";
    public static final String CATEGORIES_ATTRIBUTE = "categories";

    public GetMainPageCommand() {
        adsService = AdvertisementService.getInstance();
        categoryService = CategoryService.getInstance();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(true);
        int pageNumber = 1;
        if (session.getAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE) != null) {
            try {
                pageNumber = Integer.parseInt(request.getParameter(PAGE_NUMBER_URL_PARAMETER));
            } catch (NumberFormatException ignored) {}
        }


        List<Advertisement> advertismentList = adsService.getAdvertisementPage(Page.of(pageNumber));
        List<Category> categories = categoryService.getCategories();

        session.setAttribute(CATEGORIES_ATTRIBUTE, categories);
        session.setAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE, pageNumber);
        session.setAttribute(ADS_LIST_SESSION_ATTRIBUTE, advertismentList);

        response.sendRedirect("jsp/mainpage.jsp");
//        return "jsp/mainpage.jsp";
    }
}
