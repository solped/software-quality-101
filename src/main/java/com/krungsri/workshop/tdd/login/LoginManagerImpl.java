package com.krungsri.workshop.tdd.login;

import java.util.Map;

public class LoginManagerImpl implements LoginManager {

    private final Map<String, String> userRepository;

    public LoginManagerImpl(Map<String, String> userRepository) {
        this.userRepository = userRepository;
    }

    @Override

    public Boolean login(String username, String password) throws InvalidCredentialException, EmptyPasswordException {
        if (password.isEmpty()) {
            throw new EmptyPasswordException();
        }
        if (!isUsernameValid(username) || !this.userRepository.get(username).equals(password)) {
            throw new InvalidCredentialException();
        }
        return true;
    }

    private boolean isUsernameValid(String username) {
        return this.userRepository.containsKey(username);

    }
}
