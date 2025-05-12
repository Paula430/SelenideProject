package com.selenide.web;

import com.selenide.pages.HomePage;
import com.selenide.pages.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("regression")
@Tag("smoke")
public class LoginTest extends BaseTest {

    @Test
    void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage=loginPage.login("standard_user", "secret_sauce");
        assertEquals("Products",homePage.getTitleText());
    }

    @Test
    void lockedOutUserLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals("Epic sadface: Sorry, this user has been locked out.",loginPage.getErrorMsgText());
    }

    @Test
    void invalidCredentialsTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("incorrect_user", "wrong_password");
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMsgText());
    }

}
