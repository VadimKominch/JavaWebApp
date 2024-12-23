package by.epam.learn.vadimkominch.repository;

import by.epam.learn.vadimkominch.constant.SQLCommand;
import by.epam.learn.vadimkominch.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository extends AbstractRepository<Category, Integer>{
    @Override
    public Category getOne(Integer id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLCommand.GET_ALL_CATEGORIES);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt(category.getId().getColumnName()));
                category.setName(resultSet.getString(category.getName().getColumnName()));
                categories.add(category);
            }
            ps.close();
            resultSet.close();
        } catch (SQLException e) {
        } finally {
            releaseConnection(connection);
        }
        return categories;
    }

    @Override
    public int save(Category category) {

        return 0;
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void update(Integer id, Category replace) {

    }

    private static class Holder {
        private static final CategoryRepository INSTANCE = new CategoryRepository();
    }

    public static CategoryRepository getInstance() {
        return CategoryRepository.Holder.INSTANCE;
    }
}
