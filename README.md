# Assesment

# Web Automation Task

This project contains an automation script to test the user addition functionality on the Way2Automation User List Table.

## Prerequisites

- Java Development Kit (JDK)
- Maven
- ChromeDriver

## Setup

1. Clone the repository.
2. Navigate to the project directory.
3. Update the `chromedriver` path in the `UserAutomationTest.java` file.
4. Run `mvn test` to execute the test.

## Test Description

The test performs the following steps:
1. Navigates to the User List Table.
2. Validates the presence of the User List Table header.
3. Adds a new user with unique username and provided details.
4. Verifies that the new user is added to the list.

## Notes

- Ensure that the ChromeDriver version matches your installed Chrome browser version.
- The username is generated uniquely for each test run using a UUID.
