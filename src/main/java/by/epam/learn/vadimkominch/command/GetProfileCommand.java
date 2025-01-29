package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Collections;
import java.util.List;

public class GetProfileCommand implements Command{

    private final AdvertisementService adsService;

    public GetProfileCommand() {
        this(AdvertisementService.getInstance());
    }

    protected GetProfileCommand(AdvertisementService adsService) {
        this.adsService = adsService;
    }

    public static final String CURRENT_PAGE_SESSION_ATTRIBUTE = "currentPageNumber";
    public static final String PAGE_NUMBER_URL_PARAMETER = "pageNumber";
    public static final String ADS_LIST_SESSION_ATTRIBUTE = "advertisementList";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Advertisement> userAds;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null) {
            userAds  = adsService.getUserAdvertisements(user.getId().getValue());
        } else {
            userAds = Collections.emptyList();
        }

        int pageNumber = 1;
        if (session.getAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE) != null) {
            try {
                pageNumber = Integer.parseInt(request.getParameter(PAGE_NUMBER_URL_PARAMETER));
            } catch (NumberFormatException ignored) {}
        } else {
            // pagination
        }
        session.setAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE, pageNumber);
        session.setAttribute(ADS_LIST_SESSION_ATTRIBUTE, userAds);
        response.sendRedirect("jsp/profile.jsp");
    }
}
