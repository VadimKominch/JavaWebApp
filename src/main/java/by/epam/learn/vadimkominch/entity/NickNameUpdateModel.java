package by.epam.learn.vadimkominch.entity;

public class NickNameUpdateModel {
    private int id;
    private String nickName;

    public NickNameUpdateModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
