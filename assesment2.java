package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class UserAutomationTest {
    private WebDriver driver;
    private String baseUrl = "http://www.way2automation.com/angularjsprotractor/webtables/";

    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddUser() {
        // Navigate to the URL
        driver.get(baseUrl);

        // Validate that you are on the User List Table
        WebElement userListTableHeader = driver.findElement(By.xpath("//h3[text()='Smart Table example']"));
        Assert.assertTrue(userListTableHeader.isDisplayed(), "User List Table header is not displayed");

        // Click Add User
        WebElement addUserButton = driver.findElement(By.xpath("//button[@ng-click='pop()']"));
        addUserButton.click();

        // Add user details
        WebElement firstNameField = driver.findElement(By.name("FirstName"));
        WebElement lastNameField = driver.findElement(By.name("LastName"));
        WebElement userNameField = driver.findElement(By.name("UserName"));
        WebElement passwordField = driver.findElement(By.name("Password"));
        WebElement customerRoleRadio = driver.findElement(By.xpath("//input[@value='15']"));
        WebElement emailField = driver.findElement(By.name("Email"));
        WebElement phoneField = driver.findElement(By.name("Mobilephone"));

        // Unique username for each run
        String uniqueUsername = "user_" + UUID.randomUUID().toString().substring(0, 8);

        // Fill in the user details
        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        userNameField.sendKeys(uniqueUsername);
        passwordField.sendKeys("Password123");
        customerRoleRadio.click();
        emailField.sendKeys("john.doe@example.com");
        phoneField.sendKeys("1234567890");

        // Click Save button
        WebElement saveButton = driver.findElement(By.xpath("//button[@ng-click='save(user)']"));
        saveButton.click();

        // Verify that the user is added to the list
        WebElement addedUser = driver.findElement(By.xpath("//td[text()='" + uniqueUsername + "']"));
        Assert.assertTrue(addedUser.isDisplayed(), "Newly added user is not displayed in the list");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
