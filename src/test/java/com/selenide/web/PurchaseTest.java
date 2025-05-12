package com.selenide.web;

import com.selenide.pages.CartPage;
import com.selenide.pages.CheckoutPage;
import com.selenide.pages.HomePage;
import com.selenide.pages.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Tag("checkout")
@Tag("regression")
public class PurchaseTest extends BaseTest{

    @Test
    void addToCartTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage= loginPage.login("standard_user", "secret_sauce");
        homePage.addProductToCart("Sauce Labs Backpack");
        assertEquals("1",homePage.getCartBadgeNumber());

    }

    @Test
    void removeFromCartFromHomePageTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage= loginPage.login("standard_user", "secret_sauce");
        homePage.addProductToCart("Sauce Labs Backpack");
        assertEquals("1",homePage.getCartBadgeNumber());
        homePage.removeProductFromHomePage("Sauce Labs Backpack");
        assertFalse(homePage.checkCartBadgeNumberExist());
    }

    @Test
    void removeFromCartFromCartPageTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage=loginPage.login("standard_user", "secret_sauce");
        homePage.addProductToCart("Sauce Labs Bike Light");
        CartPage cartPage=homePage.clickCartLink();
        cartPage.removeProductFromCart("Sauce Labs Bike Light");
        cartPage.clickContinueShoppingButton();
        assertFalse(homePage.checkCartBadgeNumberExist());
    }

    @Test
    void checkoutTest() {
        String productName="Sauce Labs Backpack";
        LoginPage loginPage = new LoginPage();
        HomePage homePage=loginPage.login("standard_user", "secret_sauce");
        homePage.addProductToCart(productName);
        CartPage cartPage=homePage.clickCartLink();
        assertEquals("Your Cart", cartPage.getSubpageTitle());
        CheckoutPage checkoutPage=cartPage.clickCheckoutButton();
        assertEquals("Checkout: Your Information", checkoutPage.getSubpageTitle());
        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
        checkoutPage.clickContinueBtn();
        assertEquals("Checkout: Overview",checkoutPage.getSubpageTitle());
        assertTrue(checkoutPage.getProductNames().contains(productName), "Product not found in checkout overview");
        checkoutPage.clickFinishButton();
        assertEquals("Thank you for your order!",checkoutPage.getSuccessMessage());

    }

//    @Test
//    void testTotalPriceCalculationWithMultipleProducts() {
//        String product1 = "Sauce Labs Backpack";
//        String product2 = "Sauce Labs Bike Light";
//
//        LoginPage loginPage = new LoginPage();
//        HomePage homePage = loginPage.login("standard_user", "secret_sauce");
//
//        // Get prices from HomePage
//        double price1 = homePage.getProductPrice(product1);
//        double price2 = homePage.getProductPrice(product2);
//        double expectedItemTotal = price1 + price2;
//
//
//        // Add two products
//        homePage.addProductToCart(product1);
//        homePage.addProductToCart(product2);
//
//        CartPage cartPage = homePage.clickCartLink();
//        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
//
//        // Fill checkout information
//        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
//        checkoutPage.clickContinueBtn();
//
//        // Verify item total (pre-tax)
//        assertEquals(expectedItemTotal, checkoutPage.getItemTotal(), 0.001);
//
//        // Get tax and verify grand total
//        double tax = checkoutPage.getTax(); // e.g., 3.20
//        double expectedTotal = expectedItemTotal + tax; // 43.18
//        assertEquals(expectedTotal, checkoutPage.getTotal(), 0.001);
//
//        assertAll("Price verification",
//                () -> assertEquals(expectedTotal, checkoutPage.getItemTotal(), 0.001,
//                        "Item total mismatch between HomePage and Checkout"),
//                () -> assertEquals(expectedTotal + checkoutPage.getTax(),
//                        checkoutPage.getTotal(), 0.001, "Grand total mismatch")
//        );

//    }




}
