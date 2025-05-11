package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public SelenideElement
            usernameField = $("#user-name"),
            passwordField = $("#password"),
            loginButton = $("#login-button"),
            errorMessage = $("h3[data-test='error']");

    public HomePage login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
        return new HomePage();
    }
}
