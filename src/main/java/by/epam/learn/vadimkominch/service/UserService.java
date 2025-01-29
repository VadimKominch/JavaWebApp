package by.epam.learn.vadimkominch.service;

import by.epam.learn.vadimkominch.entity.NickNameUpdateModel;
import by.epam.learn.vadimkominch.repository.CredentialsRepository;
import by.epam.learn.vadimkominch.repository.UserRepository;
import by.epam.learn.vadimkominch.entity.Credentials;
import by.epam.learn.vadimkominch.entity.User;

public class UserService {

    private final UserRepository userRepository;
    private final CredentialsRepository credentialsRepository;

    public UserService() {
        userRepository = UserRepository.getInstance();
        credentialsRepository = CredentialsRepository.getInstance();
    }

    /**
     * Returns true if registration was successful, otherwise false
     * */
    public boolean registerUser(User user, Credentials credentials) {
        Credentials selectedUser = credentialsRepository.getByLogin(credentials.getLogin().getValue());
        if(selectedUser == null) {
            int id = userRepository.save(user);
            credentials.setUserId(id);
            credentialsRepository.save(credentials);
            return true;
        }
        return false;
    }

    public void updateUser(NickNameUpdateModel model) {
        var user = userRepository.getOne(model.getId());
        if(user != null) {
            user.setNickName(model.getNickName());
            userRepository.update(model.getId(), user);
        }
    }

    public User getOne(int id) {
        return userRepository.getOne(id);
    }

    private static class Holder {
        private static final UserService INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return UserService.Holder.INSTANCE;
    }
}
