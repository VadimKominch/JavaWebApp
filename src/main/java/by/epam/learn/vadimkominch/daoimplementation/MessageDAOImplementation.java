package by.epam.learn.vadimkominch.daoimplementation;

import by.epam.learn.vadimkominch.entity.Message;

import java.util.List;

public class MessageDAOImplementation implements DAOInterface<Message,String> {

    @Override
    public Message getOne(String id) {
        return null;
    }

    @Override
    public List<Message> getAmountOfDAOInBorders(Integer fromId, Integer toId) {
        return null;
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public void addOneDAO(Message message) {

    }

    @Override
    public void deleteOneDAO(Message message) {

    }

    @Override
    public void updateOneDAO(String id, Message replace) {

    }
}
