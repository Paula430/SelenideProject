package com.selenide;

import com.selenide.pages.CartPage;
import com.selenide.pages.CheckoutPage;
import com.selenide.pages.HomePage;
import com.selenide.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class PurchaseTest extends BaseTest{
    @Test
    void addToCartTest() {
        LoginPage loginPage = new LoginPage();

        HomePage homePage= loginPage.login("standard_user", "secret_sauce");
        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.cartBadge.shouldHave(text("1"));

    }

    @Test
    void removeFromCartFromHomePageTest() {
        LoginPage loginPage = new LoginPage();

        // Login and add product
        HomePage homePage= loginPage.login("standard_user", "secret_sauce");
        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.cartBadge.shouldHave(text("1"));

        // Remove from home page
        homePage.removeProductFromHomePage("Sauce Labs Backpack");
        homePage.cartBadge.shouldNot(exist);
    }

    @Test
    void removeFromCartFromCartPageTest() {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();

        HomePage homePage=loginPage.login("standard_user", "secret_sauce");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.cartLink.click();

        cartPage.removeProductFromCart("Sauce Labs Bike Light");
        cartPage.continueShoppingButton.click();
        homePage.cartBadge.shouldNot(exist);
    }

    @Test
    void fullCheckoutTest() {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        HomePage homePage=loginPage.login("standard_user", "secret_sauce");
        homePage.addProductToCart("Test.allTheThings() T-Shirt (Red)");
        homePage.cartLink.click();
        cartPage.proceedToCheckout();

        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
        checkoutPage.completePurchase();
    }


}
