package by.epam.learn.vadimkominch.utils;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonReaderUtils {

    public static <T> T readFromHttpRequest(HttpServletRequest request, Class<T> clazz) throws IOException {
        T element = null;
        try(BufferedReader reader = request.getReader()) {
            StringBuilder buffer = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append(System.lineSeparator());
            }
            String data = buffer.toString();
            var gson = new Gson();
            element = gson.fromJson(data, clazz);
        }
        return element;
    }

    public static <T> String writeToJsonString(T t) {
        var gson = new Gson();
        return gson.toJson(t);
    }
}
