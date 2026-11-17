# DummyJSON API Testing

## Project Overview

This project focuses on functional API testing of the Products module provided by [DummyJSON](https://dummyjson.com/).

The purpose of this project is to verify API behavior through different HTTP methods, request parameters, and response validations. Testing activities include retrieving product data, adding new products, updating existing product information, and simulating product deletion.

The tests were designed and executed using Postman, with JavaScript test scripts to validate selected response data and HTTP status codes.

## Project Information

| Item | Description |
|---|---|
| Project Name | DummyJSON API Testing Portfolio |
| API Platform | DummyJSON |
| API Module | Products |
| Testing Type | Functional API Testing |
| Testing Tool | Postman 12.36.4 |
| API Format | JSON |
| Execution Tool | Postman Collection Runner |
| Operating System | macOS |
| Base URL | `https://dummyjson.com` |

## Scope of Testing

The testing covers the following API functionalities:

### 1. GET Requests

- Retrieve all product data.
- Retrieve product details using a specific Product ID.
- Retrieve products using query parameters.
- Verify the response when requesting a non-existing Product ID.

### 2. POST Request

- Simulate adding a new product.
- Validate the returned product information and generated Product ID.

### 3. PUT Request

- Simulate updating the entire product information.
- Validate the updated product data in the response.

### 4. PATCH Request

- Simulate updating selected product fields.
- Validate the updated field and other returned product information.

### 5. DELETE Request

- Simulate deleting a product.
- Validate the deletion status and deletion timestamp in the response.

## Test Scenarios

A total of 11 test cases were documented and executed.

| No. | Test Scenario | HTTP Method |
|---:|---|---|
| 1 | Get All Products | GET |
| 2 | Get Product by ID | GET |
| 3 | Get Products with Limit | GET |
| 4 | Get Non-Existing Product | GET |
| 5 | Boundary Limit 1 | GET |
| 6 | Boundary Limit 0 | GET |
| 7 | Boundary Limit 200 | GET |
| 8 | Add New Product | POST |
| 9 | Update Product | PUT |
| 10 | Partially Update Product | PATCH |
| 11 | Delete Product | DELETE |

## Testing Approach

The following testing approaches were applied:

- **Positive Testing:** Verifying API behavior using valid requests and input data.
- **Negative Testing:** Testing requests involving a Product ID that does not exist.
- **Boundary Value Analysis:** Testing boundary values for the `limit` query parameter, including 0, 1, and 200.
- **Response Validation:** Checking HTTP status codes, JSON response format, response body properties, and returned data.
- **Automated Assertions:** Using JavaScript test scripts in Postman to validate selected API responses automatically.

## Test Execution Results

The test cases were executed using Postman Collection Runner.

| Test Result | Count |
|---|---:|
| Total Test Cases | 11 |
| Passed | 11 |
| Failed | 0 |
| Not Executed | 0 |

**Overall Test Case Result: 11/11 passed.**

The execution summary records all 11 test cases as passed. The documentation also notes that the negative-testing request was once marked as failed by Collection Runner even though its four assertions passed. Therefore, the test case result and the Collection Runner request status are documented separately.

## Key Features

### Multiple HTTP Methods

Implements five HTTP methods: GET, POST, PUT, PATCH, and DELETE to test different product-related API operations.

### JavaScript Test Scripts

Uses Postman test scripts to validate HTTP status codes, JSON response formats, response properties, and selected product values.

### Boundary Value Analysis

Tests different values of the `limit` query parameter to observe API behavior at selected boundary values.

### Negative Testing

Tests the API response when requesting a product using a non-existing Product ID and verifies the expected HTTP 404 response.

### Collection Runner

Uses Postman Collection Runner to execute the documented API requests and record execution results.

## Test Documentation and Evidence

The project includes the following documentation and testing assets:

### 1. API Test Plan

Documents the testing objectives, scope, testing strategy, entry criteria, exit criteria, and test deliverables.

### 2. API Test Cases

Contains 11 test cases with test scenarios, endpoints, HTTP methods, test steps, test data, expected results, actual results, and execution status.

### 3. Postman Collection

Contains the API requests and JavaScript test scripts used for selected response validations.

### 4. Execution Summary

Provides the overall test execution results, including the number of passed, failed, and unexecuted test cases.

### 5. Evidence

Contains screenshots documenting the API testing activities and execution results.

## Important Notes

DummyJSON simulates data modification operations. Requests using POST, PUT, PATCH, and DELETE return simulated responses and do not permanently modify the original server-side data.

This project focuses on functional API testing of the Products module. Load testing, stress testing, security testing, authentication, and authorization testing are outside the project scope.

## Project Files

```text
02-API-Testing/
├── README.md
├── DummyJSON API Testing Portfolio.postman_collection.json
├── DummyJSON_API_Testing_Documentation.xlsx
└── evidence/
    ├── screenshot-1.png
    ├── screenshot-2.png
    └── screenshot-3.png
```

The screenshot filenames above are illustrative. Keep the original filenames of your evidence files.

## Author

**Gregorius Bryan Tetuko Jati**

Computer Science – Software Engineering  
BINUS University

- GitHub: [bryantetuko](https://github.com/bryantetuko)
- LinkedIn: [bryan-tetuko](https://www.linkedin.com/in/bryan-tetuko/)