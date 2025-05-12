package com.selenide.web;

import com.selenide.pages.AboutPage;
import com.selenide.pages.HomePage;
import com.selenide.pages.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("regression")
public class NavigationTest extends BaseTest{

    @Test
    @Tag("smoke")
    void logoutTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage= loginPage.login("standard_user", "secret_sauce");
        homePage.logout();
        assertTrue(loginPage.isLoginBtnVisible());

    }

    @Test
    void navigateToAboutPageTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage=loginPage.login("standard_user", "secret_sauce");
        homePage.clickMenuBtn();
        AboutPage aboutPage=homePage.clickAboutSidebarLink();
        assertEquals("Build apps users love with AI-driven insights",aboutPage.getHeaderText());

    }

}
