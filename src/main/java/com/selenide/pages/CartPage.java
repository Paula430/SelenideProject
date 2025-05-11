package com.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    public ElementsCollection cartItems = $$("div.cart_item");
    public SelenideElement checkoutButton = $("#checkout");
    public SelenideElement continueShoppingButton = $("#continue-shopping");

    public void removeProductFromCart(String productName) {
        cartItems.findBy(text(productName))
                .$("button.cart_button").click();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}
