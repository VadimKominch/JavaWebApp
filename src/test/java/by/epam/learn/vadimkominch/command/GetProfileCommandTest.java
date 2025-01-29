package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static by.epam.learn.vadimkominch.command.GetProfileCommand.CURRENT_PAGE_SESSION_ATTRIBUTE;
import static by.epam.learn.vadimkominch.command.GetProfileCommand.PAGE_NUMBER_URL_PARAMETER;
import static java.util.Collections.emptyList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetProfileCommandTest {
    @Mock
    HttpSession httpSession;

    @Mock
    AdvertisementService advertisementService;

    @InjectMocks
    GetProfileCommand command;

    @ParameterizedTest
    @ValueSource(strings = {"abracadabra", ""})
    @NullSource
    public void testWhenPageWasIncorrectThenReturnEmptyList(String attrValue) throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(httpSession);
        when(httpSession.getAttribute("user")).thenReturn(new User());
        when(httpSession.getAttribute(CURRENT_PAGE_SESSION_ATTRIBUTE)).thenReturn(0);
        when(request.getParameter(PAGE_NUMBER_URL_PARAMETER)).thenReturn(attrValue);
        when(advertisementService.getUserAdvertisements(anyInt())).thenReturn(emptyList());
        Mockito.doNothing().when(httpSession).setAttribute(any(),any());
        Mockito.doNothing().when(response).sendRedirect(any());

        command.execute(request,response);
    }
}
