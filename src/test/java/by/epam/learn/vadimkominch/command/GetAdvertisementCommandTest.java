package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.command.advertisement.GetAdvertismentCommand;
import by.epam.learn.vadimkominch.data.TestData;
import by.epam.learn.vadimkominch.entity.AdvertisementModel;
import by.epam.learn.vadimkominch.entity.Category;
import by.epam.learn.vadimkominch.service.AdvertisementService;
import by.epam.learn.vadimkominch.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GetAdvertisementCommandTest {
    @Mock
    HttpSession httpSession;

    @Mock
    AdvertisementService advertisementService;

    @Mock
    CategoryService categoryService;

    @InjectMocks
    GetAdvertismentCommand command;

    @Test
    public void successRedirectWhenPassedIdIsValidAndAdvertisementInDb() throws Exception {
        int id = 1;
        AdvertisementModel advertisement = TestData.advertisementWithFullInfo();
        Category category = TestData.category();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(httpSession);
        when(request.getMethod()).thenReturn("GET");
        when(request.getParameter("id")).thenReturn(Integer.toString(id));
        when(advertisementService.getAdvertisementWithFullInfoById(anyInt())).thenReturn(advertisement);
        when(categoryService.getCategories()).thenReturn(List.of(category));
        Mockito.doNothing().when(httpSession).setAttribute(any(),any());
        Mockito.doNothing().when(response).sendRedirect(any());

        command.execute(request,response);

        verify(httpSession,times(1)).setAttribute(GetAdvertismentCommand.ADVERTISEMENT_SESSION_ATTRIBUTE, advertisement);
        verify(advertisementService,times(1)).getAdvertisementWithFullInfoById(id);
        verify(response,times(1)).sendRedirect("jsp/advertisement_info_tab.jsp");
    }
}
