package com.selenide.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SoftAssertsExtension.class)
public class BaseTest {

    @BeforeAll
    static void setupAll() {
        Configuration.timeout = 10000;
        Configuration.headless = false; // Set to true for CI/CD
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    void openBrowser() {
        open("https://www.saucedemo.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

}
