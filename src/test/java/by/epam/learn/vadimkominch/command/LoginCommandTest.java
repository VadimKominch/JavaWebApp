package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.check.LoginAndPasswordCheck;
import by.epam.learn.vadimkominch.data.TestData;
import by.epam.learn.vadimkominch.entity.Credentials;
import by.epam.learn.vadimkominch.entity.RegisterUserApiModel;
import by.epam.learn.vadimkominch.entity.User;
import by.epam.learn.vadimkominch.repository.CredentialsRepository;
import by.epam.learn.vadimkominch.service.UserService;
import by.epam.learn.vadimkominch.utils.HashUtils;
import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginCommandTest {
    @Mock
    HttpSession httpSession;

    @Mock
    UserService userService;

    @Mock
    CredentialsRepository credentialsRepository;

    @Mock
    LoginAndPasswordCheck checker;

    @InjectMocks
    LoginCommand command;

    @Test
    public void successWhenPageIsRequested() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getMethod()).thenReturn("GET");
        when(request.getRequestDispatcher(any())).thenReturn(dispatcher);
        Mockito.doNothing().when(dispatcher).forward(request,response);

        command.execute(request,response);

        verify(request,times(1)).getRequestDispatcher("jsp/loginpage.jsp");
        verify(dispatcher,times(1)).forward(request,response);
    }

    @Test
    public void successRegistrationWhenAllPassedDataIsValid() throws Exception {
        Credentials credentials = TestData.credentials();
        User user = TestData.user();
        String login = "login";
        String rawPassword = "password";
        String password = HashUtils.hash(rawPassword);
        credentials.setLogin(login);
        credentials.setPassword(password);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession(true)).thenReturn(httpSession);
        when(request.getMethod()).thenReturn("POST");
        when(request.getParameter("login")).thenReturn(login);
        when(request.getParameter("password")).thenReturn(rawPassword);
        when(checker.checkLoginIsNullable(anyString())).thenReturn(true);
        when(checker.checkPasswordIsNullable(anyString())).thenReturn(true);
        when(credentialsRepository.getByLogin(anyString())).thenReturn(credentials);
        when(userService.getOne(anyInt())).thenReturn(user);
        when(httpSession.getAttribute("user")).thenReturn(null);
        Mockito.doNothing().when(response).sendRedirect(any());
        Mockito.doNothing().when(httpSession).setAttribute(any(),any());

        command.execute(request,response);

        verify(checker,times(1)).checkLoginIsNullable(login);
        verify(checker,times(1)).checkPasswordIsNullable(rawPassword);
        verify(userService,times(1)).getOne(credentials.getUserId().getValue());
        verify(credentialsRepository,times(1)).getByLogin(login);
        verify(httpSession,times(1)).setAttribute("user", user);
        verify(response,times(1)).sendRedirect("main");
    }
}
