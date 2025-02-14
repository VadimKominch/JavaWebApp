package by.epam.learn.vadimkominch.entity.dao;

import by.epam.learn.vadimkominch.entity.EntityField;

import java.util.Date;
import java.util.Objects;

public class Advertisement {

    private EntityField<Integer> id;
    private EntityField<String> title;
    private EntityField<String> body;
    private EntityField<Integer> authorId;
    private EntityField<Integer> categoryId;
    private EntityField<Date> createdDate;

    public Advertisement() {
        setId(-1);
        setBody(null);
        setTitle(null);
        setAuthorId(-1);
        setCategoryId(-1);
        setCreatedDate(new Date());
    }

    public EntityField<Integer> getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new EntityField<>(id,"id");
    }

    public EntityField<String> getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = new EntityField<>(title, "title");
    }

    public EntityField<String> getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = new EntityField<>(body, "body");
    }

    public EntityField<Integer> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = new EntityField<>(authorId,"author_id");
    }

    public EntityField<Integer> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = new EntityField<>(categoryId, "category_id");
    }

    public EntityField<Date> getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = new EntityField<>(createdDate, "created_date");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getBody(), that.getBody()) && Objects.equals(getAuthorId(), that.getAuthorId()) && Objects.equals(getCategoryId(), that.getCategoryId()) && Objects.equals(getCreatedDate(), that.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getBody(), getAuthorId(), getCategoryId(), getCreatedDate());
    }
}
