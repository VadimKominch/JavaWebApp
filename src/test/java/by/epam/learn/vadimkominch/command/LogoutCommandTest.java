package by.epam.learn.vadimkominch.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class LogoutCommandTest {
    @Mock
    HttpSession httpSession;

    @InjectMocks
    LogoutCommand command;

    @Test
    public void successLogout() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(httpSession);
        Mockito.doNothing().when(response).sendRedirect(anyString());
        Mockito.doNothing().when(httpSession).invalidate();

        command.execute(request,response);

        verify(response,times(1)).sendRedirect("/main");
    }
}
