package by.epam.learn.vadimkominch.entity;

import java.util.Objects;

/**
 * Basic entity for security information holding
 * */
public class Credentials {
    private EntityField<Integer> id;
    private EntityField<String> login;
    private EntityField<String> password;
    private EntityField<String> email;
    private EntityField<Integer> userId;

    public Credentials() {
        setId(-1);
        setUserId(-1);
        setLogin("");
        setPassword("");
        setEmail("");
    }

    public EntityField<Integer> getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new EntityField<>(id,"id");
    }

    public EntityField<String> getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = new EntityField<>(login, "login");
    }

    public EntityField<String> getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new EntityField<>(password, "password");
    }

    public EntityField<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = new EntityField<>(email, "email");
    }

    public EntityField<Integer> getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = new EntityField<>(userId, "user_id");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(getLogin(), that.getLogin()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getEmail());
    }
}
