package com.krungsri.workshop.tdd.login;

import java.util.Map;

public class LoginManagerImpl implements LoginManager {

    private final Map<String, String> userRepository;

    public LoginManagerImpl(Map<String, String> userRepository) {
        this.userRepository = userRepository;
    }

    @Override

    public Boolean login(String username, String password) throws InvalidCredentialException, EmptyPasswordException {
      throw new UnsupportedOperationException();
    }
}
