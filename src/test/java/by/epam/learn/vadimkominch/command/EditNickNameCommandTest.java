package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.entity.NickNameUpdateModel;
import by.epam.learn.vadimkominch.service.UserService;
import by.epam.learn.vadimkominch.utils.JsonReaderUtils;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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

@ExtendWith(MockitoExtension.class)
public class EditNickNameCommandTest {

    @Mock
    UserService service;

    @InjectMocks
    EditNickNameCommand command;

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
    public void testWhenRequestIsCorrectThenRedirectIsCalled() throws Exception {
        var mockObject = new NickNameUpdateModel();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        jsonReaderUtils.when(() -> JsonReaderUtils.readFromHttpRequest(request, NickNameUpdateModel.class))
                        .thenReturn(mockObject);

        Mockito.doNothing().when(service).updateUser(any());
        Mockito.doNothing().when(response).sendRedirect(any());

        command.execute(request,response);

        verify(service,times(1)).updateUser(mockObject);
        verify(response,times(1)).sendRedirect("main");
    }

    @Test
    public void testWhenRequestIsIncorrectThenRedirectIsNotCalledAndExceptionThrowed() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        jsonReaderUtils.when(() -> JsonReaderUtils.readFromHttpRequest(request, NickNameUpdateModel.class))
                .thenThrow(new JsonSyntaxException("test"));

        Assertions.assertThrows(JsonSyntaxException.class, ()-> command.execute(request,response));
        verify(service,times(0)).updateUser(any());
        verify(response,times(0)).sendRedirect(any());
    }
}
