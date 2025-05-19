@api
Feature: JSONPlaceholder API testing
  Scenario: Get all posts
    When I send a GET request to "/posts"
    Then the response status code should be 200
    And the response should contain 100 posts

  Scenario: Get post by ID
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response should contain post title "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"

  Scenario: Create new post
    When I send a POST request to "/posts" with body:
      """
      {
        "title": "Test Post",
        "body": "This is a test post",
        "userId": 1
      }
      """
    Then the response status code should be 201
    And the response should contain title "Test Post"

  Scenario: Get user by username
    When I send a GET request to "/users?username=Bret"
    Then the response status code should be 200
    And the response should contain user name "Leanne Graham"

  Scenario: Update user by ID
    When I send a PUT request to "/users/1" with body:
      """
      {
        "name": "Updated Name",
        "email": "updated@email.com"
      }
      """
    Then the response status code should be 200
    And the response should contain email "updated@email.com"