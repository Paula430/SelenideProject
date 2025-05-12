package com.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement title = $("span.title");
    private final SelenideElement menuButton = $("#react-burger-menu-btn");
    private final SelenideElement cartBadge = $(".shopping_cart_badge");
    private final SelenideElement cartLink = $(".shopping_cart_link");
    private final ElementsCollection productList= $$("div.inventory_item");
    private final SelenideElement logoutLink = $("#logout_sidebar_link");
    private final SelenideElement  aboutSidebarLink=$("#about_sidebar_link");

    public void logout() {
        clickMenuBtn();
        logoutLink.click();
    }

    public void addProductToCart(String productName) {
        productList.findBy(text(productName)).$("button.btn_inventory").click();
    }

    public void removeProductFromHomePage(String productName) {
        productList.findBy(text(productName)).$("button.btn_inventory").click();
    }

    public String getTitleText(){
        return title.text();
    }

    public void clickMenuBtn(){
        menuButton.click();
    }

    public AboutPage clickAboutSidebarLink(){
        aboutSidebarLink.click();
        return new AboutPage();
    }

    public String getCartBadgeNumber(){
        return cartBadge.text();
    }

    public boolean checkCartBadgeNumberExist(){
        return cartBadge.is(visible);
    }

    public CartPage clickCartLink(){
        cartLink.click();
        return new CartPage();
    }




}