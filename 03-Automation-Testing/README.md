# SauceDemo Automation Testing

## Project Overview

This project focuses on automating functional tests for the [SauceDemo](https://www.saucedemo.com/) web application.

The objective is to verify key application functionalities through automated test execution, covering the login process, product inventory, shopping cart, and checkout workflow.

This project is developed using Java, Selenium WebDriver, and TestNG, with the Page Object Model (POM) design pattern to organize page interactions and test scripts.

## Tools and Technologies

| Tool / Technology | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution and test management |
| Maven | Dependency management and build automation |
| WebDriverManager | WebDriver setup and management |
| Google Chrome | Browser under test |
| Eclipse IDE | Development environment |

## Project Structure

```text
03-Automation-Testing/
├── pom.xml
├── .gitignore
├── README.md
├── screenshots/
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── saucedemo/
    │               └── pages/
    │                   ├── LoginPage.java
    │                   ├── InventoryPage.java
    │                   ├── CartPage.java
    │                   └── CheckoutPage.java
    └── test/
        └── java/
            └── com/
                └── saucedemo/
                    ├── tests/
                    │   ├── BaseTest.java
                    │   ├── LoginTest.java
                    │   ├── ProductTest.java
                    │   ├── CartTest.java
                    │   └── CheckoutTest.java
                    └── utils/
                        ├── ScreenshotUtil.java
                        └── TestListener.java
```

## Test Scenarios

The automation suite covers four main application functionalities.

### 1. Login Testing

- Verify login with valid credentials.
- Verify login with an incorrect password.
- Verify login with an empty username.
- Verify login with an empty password.
- Verify login with an unregistered username.

### 2. Product Testing

- Verify that the inventory page is displayed.
- Verify that six products are displayed.
- Verify that product names are not empty.
- Verify that product prices are displayed.

### 3. Shopping Cart Testing

- Verify adding a single product to the cart.
- Verify adding multiple products to the cart.
- Verify removing a product from the inventory page.
- Verify removing a product from the cart page.
- Verify that the cart page is displayed.
- Verify product details in the cart.

### 4. Checkout Testing

- Verify checkout with valid customer information.
- Verify validation when the first name is empty.
- Verify validation when the last name is empty.
- Verify validation when the postal code is empty.
- Verify product details on the checkout overview page.
- Verify successful order completion.

## Test Execution Results

The automation test suite was executed successfully.

| Test Result | Count |
|---|---:|
| Total Test Executions | 21 |
| Passed | 21 |
| Failed | 0 |
| Skipped | 0 |

**Overall Result: 21/21 test executions passed.**

## Key Features

### Page Object Model (POM)

Implements the Page Object Model design pattern to separate page elements and interactions from test classes, improving code organization and maintainability.

### Explicit Waits

Uses Selenium WebDriverWait to wait for web elements to become available before performing interactions.

### Data-Driven Testing

Uses TestNG DataProvider to execute multiple login test scenarios with different input conditions.

### Automated Screenshot Capture

Implements a TestNG listener to capture screenshots automatically when a test fails. The screenshots are stored in the `screenshots/` directory.

### Maven Integration

Uses Maven to manage project dependencies and execute the automated test suite.

## How to Run the Tests

### Prerequisites

Make sure the following tools are installed:

- Java Development Kit (JDK)
- Apache Maven
- Google Chrome
- Git

### 1. Clone the Repository

```bash
git clone https://github.com/bryantetuko/QA-Engineering-Portfolio.git
```

### 2. Navigate to the Automation Testing Directory

```bash
cd QA-Engineering-Portfolio/03-Automation-Testing
```

### 3. Execute the Automated Tests

```bash
mvn clean test
```

Maven will compile the project, execute the test suite, and display the test execution results in the terminal.

## Test Reports and Evidence

Test execution results can be reviewed through the generated TestNG and Maven Surefire reports.

Screenshots captured during failed test executions are stored in the `screenshots/` directory.

## Author

**Gregorius Bryan Tetuko Jati**

Computer Science – Software Engineering  
BINUS University

- GitHub: [bryantetuko](https://github.com/bryantetuko)
- LinkedIn: [bryan-tetuko](https://www.linkedin.com/in/bryan-tetuko/)