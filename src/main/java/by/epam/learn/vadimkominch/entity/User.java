package by.epam.learn.vadimkominch.entity;


public class User {
    private EntityField<Integer> id;
    private EntityField<String> nickName;
    private EntityField<String> firstName;
    private EntityField<String> lastName;


    public User() {
        setId(-1);
        setFirstName(null);
        setLastName(null);
        setNickName(null);
    }

    public EntityField<Integer> getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new EntityField<>(id, "id");
    }

    public EntityField<String> getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = new EntityField<String>(nickName, "nick_name");
    }

    public EntityField<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = new EntityField<String>(firstName, "first_name");
    }

    public EntityField<String> getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = new EntityField<String>(lastName, "last_name");;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
