package com.krungsri.workshop.tdd.login;

public interface LoginManager {
    Boolean login(String username, String password) throws InvalidCredentialException, EmptyPasswordException;
}
