package com.selenide.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Tag("api")
public class APITest {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    // Posts endpoints tests
    @Test
    void getAllPosts_shouldReturn200WithValidData() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", equalTo(100))
                .body("userId", everyItem(notNullValue()))
                .body("title", everyItem(not(emptyString())));
    }

    @Test
    void getPostById_shouldReturnSpecificPost() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", containsString("sunt aut facere"));
    }

    @Test
    void createNewPost_shouldReturnCreatedPost() {
        String requestBody = """
            {
                "title": "Test Post",
                "body": "This is a test post",
                "userId": 1
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("id", equalTo(101))
                .body("title", equalTo("Test Post"))
                .body("userId", equalTo(1));
    }

    // Users endpoints tests
    @Test
    void getUserByUsername_shouldReturnUserData() {
        given()
                .queryParam("username", "Bret")
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("[0].name", equalTo("Leanne Graham"))
                .body("[0].address.street", equalTo("Kulas Light"));
    }

    @Test
    void updateUser_shouldReturnUpdatedData() {
        String requestBody = """
            {
                "name": "Updated Name",
                "email": "updated@email.com"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/users/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Updated Name"))
                .body("email", equalTo("updated@email.com"));
    }

    // Comments endpoints tests
    @Test
    void getCommentsForPost_shouldReturnMultipleComments() {
        given()
                .queryParam("postId", 1)
                .when()
                .get("/comments")
                .then()
                .statusCode(200)
                .body("size()", equalTo(5))
                .body("email", everyItem(endsWith("@example.com")));
    }

    // Error handling tests
    @Test
    void getNonExistentPost_shouldReturn404() {
        given()
                .pathParam("id", 999)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(404);
    }

    @Test
    void createPostWithInvalidBody_shouldReturn400() {
        given()
                .contentType(ContentType.JSON)
                .body("{invalid json}")
                .when()
                .post("/posts")
                .then()
                .statusCode(400);
    }

    // Todos endpoints tests
    @Test
    void getTodosForUser_shouldFilterByCompleted() {
        given()
                .queryParam("userId", 1)
                .queryParam("completed", false)
                .when()
                .get("/todos")
                .then()
                .statusCode(200)
                .body("completed", everyItem(is(false)));
    }

    // Photos endpoints tests
    @Test
    void getPhotosFromAlbum_shouldContainValidURLs() {
        given()
                .pathParam("albumId", 1)
                .when()
                .get("/albums/{albumId}/photos")
                .then()
                .statusCode(200)
                .body("thumbnailUrl", everyItem(startsWith("https://via.placeholder.com/150/")));
    }
}
