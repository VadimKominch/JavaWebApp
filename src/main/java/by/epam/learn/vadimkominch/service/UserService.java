package by.epam.learn.vadimkominch.service;

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

    private static class Holder {
        private static final UserService INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return UserService.Holder.INSTANCE;
    }
}
