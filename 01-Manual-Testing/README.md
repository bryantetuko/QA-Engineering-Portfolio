# SauceDemo Manual Testing

## Project Overview

This project documents manual black-box functional testing performed on the [SauceDemo](https://www.saucedemo.com/) web application.

The testing was conducted to evaluate the behavior of the application's main features by executing manually designed test cases, comparing actual results against expected results, and documenting identified observations and potential defects.

The project includes three main testing documents: a Test Plan, Test Cases, and a Bug Report.

## Project Information

| Item | Description |
|---|---|
| Project | SauceDemo Website |
| Testing Type | Manual Functional Testing |
| Testing Approach | Black-box Testing |
| Role | Quality Assurance |
| Prepared By | Gregorius Bryan Tetuko Jati |
| Environment | macOS, Google Chrome |
| Application | [SauceDemo](https://www.saucedemo.com/) |
| Execution Status | Complete |

## Scope of Testing

The testing covers nine main application modules:

| No. | Module | Test Cases |
|---:|---|---:|
| 1 | Login | 4 |
| 2 | Inventory | 7 |
| 3 | Sorting | 4 |
| 4 | Product Details | 4 |
| 5 | Cart | 7 |
| 6 | Checkout Information | 6 |
| 7 | Checkout Overview | 4 |
| 8 | Checkout Complete | 3 |
| 9 | Logout | 5 |
| | **Total** | **44** |

## Testing Approach

The following testing techniques and approaches were applied:

- **Black-box Testing:** Evaluating application functionality through user interactions without examining the internal source code.
- **Equivalence Partitioning:** Grouping input data into valid and invalid categories to reduce redundant test scenarios.
- **Boundary Value Analysis:** Testing boundary conditions, including Zip/Postal Code lengths and shopping cart quantities.
- **Positive Testing:** Verifying expected application behavior with valid inputs and workflows.
- **Negative Testing:** Evaluating application behavior with invalid inputs, empty fields, and unexpected navigation scenarios.
- **Retesting:** Rechecking scenarios that produced unexpected results before documenting findings.

## Test Documentation

The project consists of the following deliverables:

### 1. Test Plan

Defines the testing objectives, scope, testing strategy, environment, entry criteria, exit criteria, and test deliverables.

### 2. Test Cases

Contains 44 unique test case IDs covering nine application modules. Each test case documents relevant preconditions, scenarios, test steps, test data, expected results, actual results, and execution status.

### 3. Bug Report

Documents three findings identified during test execution, including their descriptions, reproduction steps, expected results, actual results, severity, and priority.

## Bug Report Summary

| Bug ID | Module | Finding | Severity | Priority |
|---|---|---|---|---|
| BUG-001 | Checkout Information | Zip/Postal Code input validation | Low | Medium |
| BUG-002 | Checkout Complete | Confirmation page accessible through direct URL | Low | Medium |
| BUG-003 | Cart | Checkout can be completed with an empty cart | Medium | High |

**Testing note:** The five-digit numeric Zip/Postal Code requirement and the expectation that checkout must be rejected when the cart is empty were defined as testing assumptions. They should not be interpreted as confirmed official SauceDemo requirements.

## Testing Environment

- **Operating System:** macOS
- **Browser:** Google Chrome
- **Application Under Test:** SauceDemo
- **Test Account:** standard_user

## Project Files

```text
01-Manual-Testing/
├── README.md
└── Portofolio QA - Test Plan, Test Case, and Bug Report SauceDemo.xlsx
```

The Excel workbook contains three worksheets:

- `TEST PLAN`
- `TEST CASE`
- `BUG REPORT`

## Author

**Gregorius Bryan Tetuko Jati**

Computer Science – Software Engineering  
BINUS University

- GitHub: [bryantetuko](https://github.com/bryantetuko)
- LinkedIn: [bryan-tetuko](https://www.linkedin.com/in/bryan-tetuko/)