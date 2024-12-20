package by.epam.learn.vadimkominch.entity;

public class EntityField<T> {
    private T value;
    private final String columnName;

    public EntityField(T value, String columnName) {
        this.value = value;
        this.columnName = columnName;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getColumnName() {
        return columnName;
    }
}
