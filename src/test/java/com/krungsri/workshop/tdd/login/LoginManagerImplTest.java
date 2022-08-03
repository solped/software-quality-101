package com.krungsri.workshop.tdd.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class LoginManagerImplTest {

    @Test
    void givenCredentialsAreValid_whenCallLogin_thenReturnTrue() throws EmptyPasswordException, InvalidCredentialException {
        // given
        String username = "username";
        String password = "password";
        HashMap<String, String> userRepository = new HashMap<>();
        userRepository.put(username, password);
        LoginManagerImpl loginManager = new LoginManagerImpl(userRepository);

        // when
        Boolean isLoginSuccess = loginManager.login(username, password);

        // then
        Assertions.assertEquals(true, isLoginSuccess);
    }

    @Test
    void givenUsernameIsInValid_whenCallLogin_thenThrowInvalidCredential() {
        // given
        String username = "username";
        String password = "password";
        HashMap<String, String> userRepository = new HashMap<>();
        userRepository.put(username, password);
        LoginManagerImpl loginManager = new LoginManagerImpl(userRepository);

        // when & then
        Assertions.assertThrows(InvalidCredentialException.class, () -> loginManager.login("fake-user", password));
    }

    @Test
    void givenPasswordIsInValid_whenCallLogin_thenThrowInvalidCredential() {
        // given
        String username = "username";
        String password = "password";
        HashMap<String, String> userRepository = new HashMap<>();
        userRepository.put(username, password);
        LoginManagerImpl loginManager = new LoginManagerImpl(userRepository);

        // when & then
        Assertions.assertThrows(InvalidCredentialException.class, () -> loginManager.login(username, "fake-password"));
    }

    @Test
    void givenPasswordIsEmpty_whenCallLogin_thenThrowEmptyPasswordException() {
        // given
        String username = "username";
        String password = "password";
        HashMap<String, String> userRepository = new HashMap<>();
        userRepository.put(username, password);
        LoginManagerImpl loginManager = new LoginManagerImpl(userRepository);

        // when & then
        Assertions.assertThrows(EmptyPasswordException.class, () -> loginManager.login(username, ""));
    }
}