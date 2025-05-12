package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AboutPage{

    private final SelenideElement headerText=$("h1");

    public String getHeaderText(){
        return headerText.text();
    }
}
