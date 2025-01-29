package by.epam.learn.vadimkominch.command.advertisement;

import by.epam.learn.vadimkominch.command.Command;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import by.epam.learn.vadimkominch.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetAdvertismentCommand implements Command {
    private final AdvertisementService adsService;
    private final CategoryService categoryService;

    public GetAdvertismentCommand() {
        this(AdvertisementService.getInstance(), CategoryService.getInstance());
    }

    public GetAdvertismentCommand(AdvertisementService adsService, CategoryService categoryService) {
        this.adsService = adsService;
        this.categoryService = categoryService;
    }

    public static final String ADVERTISEMENT_SESSION_ATTRIBUTE = "advertisement";
    public static final String CATEGORIES_SESSION_ATTRIBUTE = "categories";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if("GET".equals(request.getMethod())) {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));
            var ads = adsService.getAdvertisementWithFullInfoById(id);
            var categories = categoryService.getCategories();
            session.setAttribute(ADVERTISEMENT_SESSION_ATTRIBUTE,ads);
            session.setAttribute(CATEGORIES_SESSION_ATTRIBUTE,categories);
            response.sendRedirect("jsp/advertisement_info_tab.jsp");
        }
    }
}
