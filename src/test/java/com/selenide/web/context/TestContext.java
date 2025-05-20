package com.selenide.web.context;

public class TestContext {
    public double expectedItemTotal=0.0;
    private final double TAX=0.08;
    public double taxValue=expectedItemTotal*TAX;
    public double totalPrice=expectedItemTotal+taxValue;

    public void reset(){
        expectedItemTotal=0.0;
    }
}
