#  Test Automation with Selenide

Automated test suite for SauceDemo web application using Selenide, Maven, and JUnit 5.

## Features

- **Login Functionality Testing**
- **Cart Management Operations**
    - Add/Remove products from Home Page
    - Remove products from Cart Page
- **Checkout Process Validation**
- **Navigation Testing**
    - About Page verification
    - Menu interactions

## Technology Stack

- **Test Framework**: Selenide 7.9.0
- **Build Tool**: Maven 3.9.9
- **Test Runner**: JUnit 5
- **Languages**: Java 17

## Project Structure

```text

├── src/
   ├── main/
   │   └── java/
   │       └── com/selenide/
   │           └── pages/                       //represent pages
   │               ├── CartPage.java       
   │               ├── CheckoutPage.java
   │               ├── HomePage.java
   │               └── LoginPage.java
   │
   └── test/
       └── java/
           └── com/selenide/                    //classes related to tests 
              ├── api/                          // api tests 
              │   └── APITest.java
              └── web/                          //UI tests  
                  ├── BaseTest.java             //common setup logic
                  ├── LoginTest.java          
                  ├── NavigationTest.java     
                  └── PurchaseTest.java       
```
## Setup and installation
1. Clone the repository
```` bash
git clone https://github.com/Paula430/SelenideProject.git
````
2. Navigate to project directory
```` bash
cd SelenideProject
````
3. Install dependencies
```` bash
mvn clean install
````

### Run All Tests
```bash
mvn test
```

### Run Tests by Group
1. Tag tests with JUnit 5 `@Tag` annotation:
```java
@Tag("smoke")
@Test
void loginTest() { ... }
```

2. Execute grouped tests:
```bash
# Single group
mvn test -Dgroups="smoke"

```

### Run Specific Test Scenario
```bash
# Run single method
mvn test -Dtest="NavigationTest"
```

### Run Specific Test Case
```bash
# Run single method
mvn test -Dtest="NavigationTest#logoutTest"
```







