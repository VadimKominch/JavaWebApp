package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.data.TestData;
import by.epam.learn.vadimkominch.entity.Credentials;
import by.epam.learn.vadimkominch.entity.RegisterUserApiModel;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.service.UserService;
import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class RegistrationCommandTest {

    @Mock
    UserService userService;

    @InjectMocks
    RegistrationCommand command;
    private MockedStatic<JsonReaderUtils> jsonReaderUtils;

    @BeforeEach
    public void setUp() {
        jsonReaderUtils = mockStatic(JsonReaderUtils.class);
    }

    @AfterEach
    public void tearDown() {
        jsonReaderUtils.close();
    }

    @Test
    public void successWhenPageIsRequested() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getMethod()).thenReturn("GET");
        when(request.getRequestDispatcher(any())).thenReturn(dispatcher);
        Mockito.doNothing().when(dispatcher).forward(request,response);

        command.execute(request,response);

        verify(request,times(1)).getRequestDispatcher("jsp/register.jsp");
        verify(dispatcher,times(1)).forward(request,response);
    }

    @Test
    public void successRegistrationWhenAllPassedDataIsValid() throws Exception {
        RegisterUserApiModel mockObject = TestData.registrationModel();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getMethod()).thenReturn("POST");
        jsonReaderUtils.when(() -> JsonReaderUtils.readFromHttpRequest(request, RegisterUserApiModel.class))
                .thenReturn(mockObject);
        when(userService.registerUser(any(), any())).thenReturn(true);
        Mockito.doNothing().when(response).sendRedirect(any());

        command.execute(request,response);

        verify(userService,times(1)).registerUser(any(User.class),any(Credentials.class));
        verify(response,times(1)).sendRedirect("main");
    }
}
