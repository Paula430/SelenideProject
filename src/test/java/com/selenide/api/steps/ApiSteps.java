package com.selenide.api.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiSteps {
    private Response response;

    static {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = given().when().get(endpoint);
    }

    @When("I send a GET request to {string} with query")
    public void sendGetRequestWithQuery(String endpoint) {
        response = given().when().get(endpoint);
    }

    @When("I send a POST request to {string} with body:")
    public void sendPostRequest(String endpoint, String body) {
        response = given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    @When("I send a PUT request to {string} with body:")
    public void sendPutRequest(String endpoint, String body) {
        response = given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain {int} posts")
    public void verifyPostCount(int expectedSize) {
        response.then().body("size()", equalTo(expectedSize));
    }

    @Then("the response should contain post title {string}")
    public void verifyPostTitle(String expectedTitle) {
        response.then().body("title", equalTo(expectedTitle));
    }

    @Then("the response should contain title {string}")
    public void verifyTitle(String expectedTitle) {
        response.then().body("title", equalTo(expectedTitle));
    }

    @Then("the response should contain user name {string}")
    public void verifyUserName(String expectedName) {
        response.then().body("[0].name", equalTo(expectedName));
    }

    @Then("the response should contain email {string}")
    public void verifyUserEmail(String expectedEmail) {
        response.then().body("email", equalTo(expectedEmail));
    }
}
