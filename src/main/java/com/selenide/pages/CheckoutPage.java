package com.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage {
    private final SelenideElement firstNameInput = $("#first-name");
    private final SelenideElement lastNameInput = $("#last-name");
    private final SelenideElement postalCodeInput = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement finishButton = $("#finish");
    private final SelenideElement subpageTitle=$(".title");
    private final ElementsCollection productList = $$(".cart_item");
    private final SelenideElement completeHeader = $(".complete-header");
    private final SelenideElement itemSubtotalText=$(".summary_subtotal_label");
    private final SelenideElement summaryTotalText=$(".summary_total_label");
    private final SelenideElement taxText=$(".summary_tax_label");

    public void fillCheckoutInfo(String first, String last, String zip) {
        firstNameInput.setValue(first);
        lastNameInput.setValue(last);
        postalCodeInput.setValue(zip);
    }

    public void clickContinueBtn(){
        continueButton.click();
    }

    public String getSubpageTitle(){
        return subpageTitle.text();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public List<String> getProductNames() {
        return productList.stream()
                .map(item -> item.$(".inventory_item_name").text())
                .collect(Collectors.toList());
    }

    public String getSuccessMessage() {
        return completeHeader.text();

    }

    private double getPriceFromString(String text){
        String[] splitArray=text.split("[$]");
        return Double.parseDouble(splitArray[splitArray.length-1]);

    }

    public double getSubTotalPrice(){
        return getPriceFromString(itemSubtotalText.text());
    }

    public double getTaxPrice(){
        return getPriceFromString(taxText.text());
    }

    public double getSummaryTotalPrice(){
        return getPriceFromString(summaryTotalText.text());
    }




}
