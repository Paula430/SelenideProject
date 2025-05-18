package com.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement logoText=$(".login_logo");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $("h3[data-test='error']");
    private final SelenideElement nameInput=  $("#user-name");
    private final SelenideElement passwordInput=  $("#password");

    public void fillLoginForm(String username, String password) {
        nameInput.setValue(username);
        passwordInput.setValue(password);
    }

    public HomePage clickLoginBtn() {
        loginButton.click();
        return new HomePage();
    }

    public String getErrorMsgText(){
        return errorMessage.text();
    }

    public boolean isLoginBtnVisible(){
        return loginButton.is(visible);
    }

    public String getLogoText(){
        return logoText.text();
    }


}
