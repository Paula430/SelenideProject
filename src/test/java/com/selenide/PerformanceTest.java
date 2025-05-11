package com.selenide;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.selenide.pages.LoginPage;
import com.selenide.pages.HomePage;

public class PerformanceTest extends BaseTest{

    @Test
    void pageShouldLoadWithinAcceptableTime() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginButton
                .shouldBe(visible)
                .shouldBe(enabled);

        long startTime = System.currentTimeMillis();
        loginPage.login("performance_glitch_user", "secret_sauce");
        long loadTime = System.currentTimeMillis() - startTime;

        new HomePage().title.shouldBe(visible);
        assertTrue(loadTime < 5000, "Page load took too long: " + loadTime + "ms");
    }
}
