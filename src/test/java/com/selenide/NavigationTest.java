package com.selenide;

import com.selenide.pages.HomePage;
import com.selenide.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NavigationTest extends BaseTest{
    @Test
    void logoutTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        loginPage.login("standard_user", "secret_sauce");
        homePage.logout();
        loginPage.loginButton.shouldBe(visible);
    }

    @Test
    void shouldNavigateToAboutPage() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage=loginPage.login("standard_user", "secret_sauce");
        homePage.menuButton.click();
        $("#about_sidebar_link").click();
        $("h1").shouldHave(text("The world relies on your code. Test on thousands of devices."));
    }

}
