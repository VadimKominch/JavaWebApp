package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.service.AdvertisementService;
import by.epam.learn.vadimkominch.service.CategoryService;
import by.epam.learn.vadimkominch.service.LanguageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static by.epam.learn.vadimkominch.command.GetProfileCommand.CURRENT_PAGE_SESSION_ATTRIBUTE;
import static java.util.Collections.emptyList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetMainpageCommandTest {
    @Mock
    HttpSession httpSession;

    @Mock
    AdvertisementService advertisementService;
    @Mock
    CategoryService categoryService;
    @Mock
    LanguageService languageService;

    @InjectMocks
    GetMainPageCommand command;
//InOrder
    @Test
    public void testWhenPageWasIncorrectThenReturnEmptyList() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession(true)).thenReturn(httpSession);
        when(httpSession.getAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE)).thenReturn(0);
        when(advertisementService.getTopN(anyInt())).thenReturn(emptyList());
        when(categoryService.getCategories()).thenReturn(emptyList());
        when(languageService.getChoosen()).thenReturn("ru");
        when(languageService.getAvailableLangs()).thenReturn(emptyList());
        Mockito.doNothing().when(httpSession).setAttribute(any(),any());
        Mockito.doNothing().when(response).sendRedirect(any());

        command.execute(request,response);
    }
}
