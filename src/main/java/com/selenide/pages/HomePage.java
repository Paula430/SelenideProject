package com.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public SelenideElement
            title = $("span.title"),
            menuButton = $("#react-burger-menu-btn"),
            logoText=$(".app_logo");

    public SelenideElement cartBadge = $(".shopping_cart_badge");
    public SelenideElement cartLink = $(".shopping_cart_link");

    public ElementsCollection productList= $$("div.inventory_item");

    public SelenideElement
            logoutLink = $("#logout_sidebar_link");

    public void logout() {
        menuButton.click();
        logoutLink.click();
    }

    public String checkLogoText(){
        return logoText.text();
    }

    public void addProductToCart(String productName) {
        productList.findBy(text(productName))
                .$("button.btn_inventory").click();
    }
    public void removeProductFromHomePage(String productName) {
        productList.findBy(text(productName))
                .$("button.btn_inventory").click();
    }

}