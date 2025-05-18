package com.selenide.web.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.open;

public class WebHooks {

    static {
        Configuration.timeout = 10000;
        Configuration.headless = false; // Set to true for CI/CD
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true).savePageSource(true));
    }

    @Before("@web")
    public void openBrowser() {
        open("https://www.saucedemo.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
