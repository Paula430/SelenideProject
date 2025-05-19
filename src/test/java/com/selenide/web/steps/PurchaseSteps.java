package com.selenide.web.steps;

import com.selenide.pages.CartPage;
import com.selenide.pages.CheckoutPage;
import com.selenide.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.jupiter.api.Assertions.*;

public class PurchaseSteps {

    HomePage homePage= new HomePage();
    CartPage cartPage= new CartPage();
    CheckoutPage checkoutPage= new CheckoutPage();

    @And("I add {string} to the cart")
    public void addProductToCart(String productName){
        homePage.addProductToCart(productName);
    }

    @Then("The cart badge should show {string}")
    public void verifyBadgeNumber(String number){
        assertEquals(number, homePage.getCartBadgeNumber());
    }

    @When("I remove {string} from the home page")
    public void removeProductFromHomePage(String productName){
        homePage.removeProductFromHomePage(productName);
    }

    @Then("The cart badge should not be visible")
    public void verifyBadgeInvisible(){
        assertFalse(homePage.checkCartBadgeNumberExist());
    }

    @And("I go to the cart")
    public void clickCartLink(){
        homePage.clickCartLink();
    }

    @And("I remove {string} from the cart")
    public void removeProductFromCartPage(String productName){
        cartPage.removeProductFromCart(productName);
    }

    @And("I continue shopping")
    public void clickContinueShoppingBtn(){
        cartPage.clickContinueShoppingButton();
    }

    @When("I proceed to checkout")
    public void clickCheckoutBtn(){
        cartPage.clickCheckoutButton();
    }

    @Then("I should see the subpage title {string}")
    public void verifySubpageTitleText(String title){
        assertEquals(title, checkoutPage.getSubpageTitle());
    }

    @When("I fill in checkout info with first name {string}, last name {string}, and postal code {string}")
    public void fillCheckoutInfo(String name, String lastName, String postalCode){
        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
    }

    @And("I continue to overview")
    public void clickContinueBtn(){
        checkoutPage.clickContinueBtn();
    }

    @And("I should see the product {string} in checkout")
    public void verifyProductInCheckout(String productName){
        assertTrue(checkoutPage.getProductNames().contains(productName), "Product not found in checkout overview");
    }

    @When("I finish the checkout")
    public void clickFinishBtn(){
        checkoutPage.clickFinishButton();
    }

    @Then("I should see the message {string}")
    public void verifyMessageText(String message){
        assertEquals(message,checkoutPage.getSuccessMessage());
    }

    @Then("I should see product {string} in the cart")
    public void verifyProductInCart(String productName){
        assertTrue(cartPage.getProductNamesInCart().contains(productName));
    }
}
