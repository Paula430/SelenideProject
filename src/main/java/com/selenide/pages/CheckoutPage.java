package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage {
    SelenideElement firstName = $("#first-name");
    SelenideElement lastName = $("#last-name");
    SelenideElement postalCode = $("#postal-code");
    SelenideElement continueButton = $("#continue");
    SelenideElement finishButton = $("#finish");
    SelenideElement completeHeader = $(".complete-header");

    public void fillCheckoutInfo(String first, String last, String zip) {
        firstName.setValue(first);
        lastName.setValue(last);
        postalCode.setValue(zip);
        continueButton.click();
    }

    public void completePurchase() {
        finishButton.click();

    }

}
