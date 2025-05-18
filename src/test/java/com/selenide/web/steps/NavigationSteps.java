package com.selenide.web.steps;

import com.selenide.pages.AboutPage;
import com.selenide.pages.HomePage;
import com.selenide.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationSteps {

    private final HomePage homePage= new HomePage();
    private final LoginPage loginPage= new LoginPage();
    private final AboutPage aboutPage= new AboutPage();

    @And("I click the logout button")
    public void clickLogoutBtn(){
        homePage.logout();
    }

    @Then("I should see the login button")
    public void verifyCorrectLogout(){
        assertTrue(loginPage.isLoginBtnVisible());
    }

    @And("I open the sidebar menu")
    public void clickMenuBtn(){
        homePage.clickMenuBtn();
    }

    @And("I click on the About link")
    public void clickAboutLink(){
        homePage.clickAboutSidebarLink();
    }

    @Then("I should see the About page header \"Build apps users love with AI-driven insights\"")
    public void verifyAboutPageHeader(){
        assertEquals("Build apps users love with AI-driven insights",aboutPage.getHeaderText());
    }
}
