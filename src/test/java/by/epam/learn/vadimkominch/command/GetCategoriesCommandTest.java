package by.epam.learn.vadimkominch.command;

import by.epam.learn.vadimkominch.data.TestData;
import by.epam.learn.vadimkominch.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetCategoriesCommandTest {

    @Mock
    CategoryService service;

    @Mock
    PrintWriter writer;

    @InjectMocks
    GetCategoriesCommand command;

    @Test
    public void successGettingCategories() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(service.getCategories()).thenReturn(List.of(TestData.category()));
        when(response.getWriter()).thenReturn(writer);
        Mockito.doNothing().when(writer).write(anyString());
        Mockito.doNothing().when(response).setContentType(anyString());
        Mockito.doNothing().when(response).setCharacterEncoding(anyString());
        command.execute(request, response);
        verify(writer,times(1)).write("[{ \"id\" : -1 , \"name\": \" category\"}]");
        verify(response,times(1)).setContentType("application/json");
        verify(response,times(1)).setCharacterEncoding("UTF-8");
    }

    @Test
    public void successWithEmptyJsonIfCategoriesListIsEmpty() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(service.getCategories()).thenReturn(Collections.emptyList());
        when(response.getWriter()).thenReturn(writer);
        Mockito.doNothing().when(writer).write(anyString());
        command.execute(request, response);
        verify(writer,times(1)).write("[]");
        verify(response,times(1)).setContentType("application/json");
        verify(response,times(1)).setCharacterEncoding("UTF-8");
    }

}
