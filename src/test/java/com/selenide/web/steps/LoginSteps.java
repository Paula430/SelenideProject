package com.selenide.web.steps;

import com.selenide.pages.HomePage;
import com.selenide.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private final LoginPage loginPage=new LoginPage();
    private final HomePage homePage= new HomePage();

    @Given("I am on the login page")
    public void verifyLoginPage() {
        assertEquals("Swag Labs",loginPage.getLogoText());
    }

    @When("I enter username {string} and password {string}")
    public void fillLoginForm(String username, String password) {
        loginPage.fillLoginForm(username, password);
    }


    @And("I click the login button")
    public void clickLoginBtn(){
        loginPage.clickLoginBtn();
    }

    @Then("I should be redirected to the home page")
    public void verifyHomePage() {
        assertEquals("Products",homePage.getTitleText());
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String message) {
        assertEquals(message,loginPage.getErrorMsgText());
    }


}
