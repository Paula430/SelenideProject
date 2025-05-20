# Test Automation with Selenide, Cucumber & RestAssured

Automated test suite for the [SauceDemo](https://www.saucedemo.com) web application,
covering both UI and API layers using **Selenide**, **Cucumber**, **RestAssured**, and **JUnit 5**.

---

## 🚀 Features

### UI Tests (Web)
- **Login Functionality**
- **Cart Management**
  - Add & Remove products from Home Page
  - Remove products from Cart Page
- **Checkout Process Validation**
- **Navigation Tests (e.g. About page, logout)**

### API Tests
- Verify endpoints from [JSONPlaceholder](https://jsonplaceholder.typicode.com/)
  - `GET /posts`, `GET /users`, `POST /posts`, etc.
- Valid & Invalid Scenarios

---

## 🛠 Technology Stack

| Layer     | Tool                     |
|-----------|--------------------------|
| UI Tests  | Selenide `7.9.0`         |
| API Tests | RestAssured `5.5.1`      |
| BDD       | Cucumber `7.16.1`        |
| Language  | Java `17`                |
| Build     | Maven `3.9.9`            |
| Runner    | JUnit Platform           |

---

## 📁 Project Structure

## Project Structure

```text
src
├── main
│  └── java
│  └── com/selenide/pages/         # Page Object classes
│     ├── CartPage.java
│     ├── CheckoutPage.java
│     ├── HomePage.java
│     ├── LoginPage.java
│     └── AboutPage.java
│
└── test
    ├── java
    │   └── com/selenide
    │     ├── api/
    │     │   ├── runners/ApiRunnerTest.java
    │     │   └── steps/ApiSteps.java
    │     └── web/
    │         ├── hooks/WebHooks.java
    │         ├── runners/WebRunnerTest.java
    │         └── steps/
    │             ├── LoginSteps.java
    │             ├── NavigationSteps.java
    │             └── PurchaseSteps.java
    └── resources
        └── features/
            ├── api/jsonplaceholder.feature
            └── web/
                ├── login.feature
                ├── navigation.feature
                └── purchase.feature      
```

### Run All Tests (UI and API)
```bash
mvn test
```

### Run All UI Tests
```bash
mvn test -Dtest=WebRunnerTest
```

### Run All API Tests
```bash
mvn test -Dtest=APIRunnerTest
```

### Run Tests by Group
1. Tag tests with `@Tag` annotation:
```java
@smoke
Scenario: Valid user login
```

2. Execute grouped tests:
```bash
# execute web test with tag "smoke"
mvn test "-Dcucumber.filter.tags=@smoke" -Dtest=WebRunnerTest

```

### Run Specific Test Scenario
```bash
mvn test "-Dcucumber.filter.name=Valid user login" -Dtest=WebRunnerTest

```








