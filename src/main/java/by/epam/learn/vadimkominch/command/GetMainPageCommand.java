package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.Category;
import by.epam.learn.vadimkominch.entity.Page;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import by.epam.learn.vadimkominch.service.CategoryService;
import by.epam.learn.vadimkominch.service.LanguageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class GetMainPageCommand implements Command {

    private final AdvertisementService adsService;
    private final CategoryService categoryService;
    private final LanguageService languageService;

    public static final String CURRENT_PAGE_SESSION_ATTRIBUTE = "currentPageNumber";
    public static final String PAGE_NUMBER_URL_PARAMETER = "pageNumber";
    public static final String ADS_LIST_SESSION_ATTRIBUTE = "advertisementList";
    public static final String CATEGORIES_ATTRIBUTE = "categories";
    public static final String LANG_ATTRIBUTE = "language";
    public static final String AVAILABLE_LANGUAGES_ATTRIBUTE = "langs";

    public GetMainPageCommand() {
        this(AdvertisementService.getInstance(), CategoryService.getInstance(), LanguageService.getInstance());
    }

    public GetMainPageCommand(AdvertisementService adsService, CategoryService categoryService, LanguageService languageService) {
        this.adsService = adsService;
        this.categoryService = categoryService;
        this.languageService = languageService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Advertisement> advertismentList = new ArrayList<>();
        HttpSession session = request.getSession(true);
        int pageNumber = 1;
        if (session.getAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE) != null) {
            try {
                pageNumber = Integer.parseInt(request.getParameter(PAGE_NUMBER_URL_PARAMETER));
            } catch (NumberFormatException ignored) {}
        } else {

        }


        advertismentList = adsService.getTopN(Page.DEFAULT_PAGE_SIZE);
        List<Category> categories = categoryService.getCategories();

        session.setAttribute(CATEGORIES_ATTRIBUTE, categories);
        session.setAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE, pageNumber);
        session.setAttribute(ADS_LIST_SESSION_ATTRIBUTE, advertismentList);
        session.setAttribute(LANG_ATTRIBUTE, languageService.getChoosen());
        session.setAttribute(AVAILABLE_LANGUAGES_ATTRIBUTE, languageService.getAvailableLangs());

        response.sendRedirect("jsp/mainpage.jsp");
    }
}
