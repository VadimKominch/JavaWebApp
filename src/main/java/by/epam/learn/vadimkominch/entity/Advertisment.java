package by.epam.learn.vadimkominch.entity;

import java.util.Date;
import java.util.Objects;

public class Advertisment {
    private int advertismentId;
    private int authorId;
    private String author;
    private String name;
    private String text;
    private Date date;
    private String category;

    public Advertisment() {

    }

    public int getAdvertismentId() {
        return advertismentId;
    }

    public void setAdvertismentId(int advertismentId) {
        this.advertismentId = advertismentId;
    }

    public String getAuthor() {
        return author;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisment that = (Advertisment) o;
        return advertismentId == that.advertismentId &&
                authorId == that.authorId &&
                Objects.equals(author, that.author) &&
                Objects.equals(name, that.name) &&
                Objects.equals(text, that.text) &&
                Objects.equals(date, that.date) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertismentId, authorId, author, name, text, date, category);
    }

    @Override
    public String toString() {
        return "Advertisment{" +
                "advertismentId=" + advertismentId +
                ", authorId=" + authorId +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                '}';
    }
}
