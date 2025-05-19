package com.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private final ElementsCollection cartItems = $$("div.cart_item");
    private final SelenideElement checkoutButton = $("#checkout");
    private final SelenideElement continueShoppingButton = $("#continue-shopping");
    private final SelenideElement subpageTitle = $(".title");
    private final ElementsCollection productNames=$$(".inventory_item_name");


    public void removeProductFromCart(String productName) {
        cartItems.findBy(text(productName)).$("button.cart_button").click();

    }

    public CheckoutPage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutPage();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public String getSubpageTitle() {
        return subpageTitle.text();
    }

    public List<String> getProductNamesInCart(){
       return productNames.texts();
    }
}
