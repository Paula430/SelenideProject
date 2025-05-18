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
        loginPage.fillLoginForm("standard_user", "secret_sauce");
        HomePage homePage=loginPage.clickLoginBtn();
        assertEquals("Products",homePage.getTitleText());
    }

    @Test
    void lockedOutUserLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillLoginForm("locked_out_user", "secret_sauce");
        loginPage.clickLoginBtn();
        assertEquals("Epic sadface: Sorry, this user has been locked out.",loginPage.getErrorMsgText());
    }

    @Test
    void invalidCredentialsTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillLoginForm("incorrect_user", "wrong_password");
        loginPage.clickLoginBtn();
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMsgText());
    }

}
