package by.epam.learn.vadimkominch.entity;

public class AdvertisementApiModel {
    private String title;
    private String body;
    private int categoryId;
    private int userId;

    public AdvertisementApiModel(String title, String body, int categoryId, int userId) {
        this.title = title;
        this.body = body;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public AdvertisementApiModel() {
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
