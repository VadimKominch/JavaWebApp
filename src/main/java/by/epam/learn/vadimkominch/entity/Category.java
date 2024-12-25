package by.epam.learn.vadimkominch.entity;


public class Category {
    private EntityField<Integer> id;
    private EntityField<String> name;

    public Category() {
        setId(-1);
        setName("");
    }

    public EntityField<Integer> getId() {
        return id;
    }

    public EntityField<String> getName() {
        return name;
    }

    public void setId(int id) {
        this.id = new EntityField<>(id, "id");
    }

    public void setName(String name) {
        this.name = new EntityField<>(name, "name");
    }

    public String toJsonString() {
        return String.format("{ \"id\" : %d , \"name\": \" %s\"}", this.id.getValue(), this.name.getValue());
    }
}
