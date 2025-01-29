package by.epam.learn.vadimkominch.data;

import by.epam.learn.vadimkominch.entity.*;
import by.epam.learn.vadimkominch.entity.dao.Advertisement;

import java.util.Date;

public class TestData {
    public static Advertisement advertisement() {
        var advertisement = new Advertisement();
        advertisement.setCategoryId(1);
        advertisement.setTitle("Title");
        advertisement.setBody("Body");
        advertisement.setCreatedDate(new Date());
        advertisement.setId(-1);
        advertisement.setAuthorId(-1);
        return advertisement;
    }

    public static AdvertisementModel advertisementWithFullInfo() {
        var advertisement = new AdvertisementModel();
        advertisement.setCategory("category");
        advertisement.setTitle("Title");
        advertisement.setBody("Body");
        advertisement.setCreatedDate(new Date());
        advertisement.setId(-1);
        advertisement.setUser(new User());
        return advertisement;
    }

    public static RegisterUserApiModel registrationModel() {
        var model = new RegisterUserApiModel();
        model.setEmail("email@example.com");
        model.setFirstName("firstName");
        model.setLastName("lastName");
        model.setLogin("login");
        model.setPassword("password");
        model.setNickName("NickName");
        return model;
    }

    public static Credentials credentials() {
        var credentials = new Credentials();
        credentials.setLogin("login");
        credentials.setPassword("password");
        credentials.setEmail("email@example.com");
        return credentials;
    }

    public static User user() {
        var user = new User();
        user.setNickName("nickname");
        user.setFirstName("firstname");
        user.setLastName("lastName");
        return user;
    }

    public static Category category() {
        var category = new Category();
        category.setName("category");
        return category;
    }
}
