#  Test Automation with Selenide

Automated test suite for SauceDemo web application using Selenide, Maven, and JUnit 5.

## Features

- **Login Functionality Testing**
- **Cart Management Operations**
    - Add/Remove products from Home Page
    - Add/Remove products from Cart Page
    - Multi-product scenarios
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
   │           └── pages/                 //represent pages
   │               ├── CartPage.java       
   │               ├── CheckoutPage.java
   │               ├── HomePage.java
   │               └── LoginPage.java
   │
   └── test/
       └── java/
           └── com/selenide/              //classes related to tests 
              ├── BaseTest.java           //common setup and teardown logic
              ├── LoginTest.java          
              ├── NavigationTest.java     
              └── PurchaseTest.java       
```
## Setup and installation
1. Clone the repository
```` bash
git clone https://github.com/Paula430/SelenideProject.git
````
3. Navigate to project directory
```` bash
cd SelenideProject
````
3. Install dependencies
```` bash
mvn clean install
````

## Running tests
### Run all tests
```` bash
mvn test
````





