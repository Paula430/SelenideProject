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
    void getAllPostsTest() {
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
    void getPostByIdTest() {
        String titleText="sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        String bodyText="quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae " +
                "ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";
        given()
                .pathParam("id", 1)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", equalTo(titleText))
                .body("body",equalTo(bodyText));
    }

    @Test
    void createNewPostTest() {
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
                .body("userId", equalTo(1))
                .body("body", equalTo("This is a test post"));

    }

    // Users endpoints tests
    @Test
    void getUserByUsernameTest() {
        given()
                .queryParam("username", "Bret")
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("[0].name", equalTo("Leanne Graham"))
                .body("[0].address.street", equalTo("Kulas Light"))
                .body("[0].email",notNullValue());
    }

    @Test
    void updateUserTest() {
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
    void getCommentsForPostTest() {
        given()
                .queryParam("postId", 1)
                .when()
                .get("/comments")
                .then()
                .statusCode(200)
                .body("size()", equalTo(5))
                .body("email", everyItem(notNullValue()))
                .body("id",everyItem(notNullValue()))
                .body("postId",everyItem(equalTo(1)))
                .body("body", everyItem(notNullValue()));
    }

    // Negative test cases
    @Test
    void getNonExistentPostTest() {
        given()
                .pathParam("id", 999)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(404);
    }

    @Test
    void postWithInvalidBodyTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{invalid json}")
                .when()
                .post("/posts")
                .then()
                .statusCode(500);
    }

    // Todos endpoints tests
    @Test
    void getTodosForUserTest() {
        given()
                .queryParam("userId", 1)
                .queryParam("completed", false)
                .when()
                .get("/todos")
                .then()
                .statusCode(200)
                .body("completed", everyItem(is(false)))
                .body("userId", everyItem(equalTo(1)))
                .body("title", everyItem(notNullValue()));
    }

    // Photos endpoints tests
    @Test
    void getPhotosFromAlbumTest() {
        given()
                .pathParam("albumId", 1)
                .when()
                .get("/albums/{albumId}/photos")
                .then()
                .statusCode(200)
                .body("thumbnailUrl", everyItem(startsWith("https://via.placeholder.com/150/")))
                .body("albumId", everyItem(equalTo(1)))
                .body("id", everyItem(notNullValue()))
                .body("title", everyItem(notNullValue()))
                .body("url",everyItem(notNullValue()));
    }
}
