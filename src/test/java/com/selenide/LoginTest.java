package com.selenide;

import com.selenide.pages.HomePage;
import com.selenide.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();

        HomePage homePage=loginPage.login("standard_user", "secret_sauce");
        homePage.title.shouldHave(text("Products"));
        assertEquals("Swag Labs", homePage.checkLogoText());
    }

    @Test
    void lockedOutUserLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.errorMessage.shouldBe(visible).shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    void invalidCredentialsTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("incorrect_user", "wrong_password");
        loginPage.errorMessage.shouldBe(visible)
                .shouldHave(text("Username and password do not match any user in this service"));
    }

}
