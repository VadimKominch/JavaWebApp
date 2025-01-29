package by.epam.learn.vadimkominch.entity.dao;

import by.epam.learn.vadimkominch.entity.EntityField;

public class Conversation {
    private EntityField<Integer> id;
    private EntityField<String> hash;
    private EntityField<Integer> first;
    private EntityField<Integer> second;

    public Conversation() {
        setId(-1);
        setHash("");
        setFirst(-1);
        setSecond(-1);
    }

    public EntityField<Integer> getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new EntityField<>(id, "id");
    }

    public EntityField<String> getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = new EntityField<>(hash, "hash");
    }

    public EntityField<Integer> getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = new EntityField<>(first, "first_id");
    }

    public EntityField<Integer> getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = new EntityField<>(second, "second_id");;
    }
}
