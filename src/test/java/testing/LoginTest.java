package testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up ChromeDriver path here
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update with your ChromeDriver path
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window
    }

    @Test
    public void testLoginPageUrl() {
        // Open the login page URL
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Verify if the URL is correct
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        assertTrue(driver.getCurrentUrl().equals(expectedUrl), "URL did not match the expected value.");

        // Check if the login form elements are displayed
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        assertTrue(usernameField.isDisplayed(), "Username field is not displayed.");
        assertTrue(passwordField.isDisplayed(), "Password field is not displayed.");
        assertTrue(loginButton.isDisplayed(), "Login button is not displayed.");
    }

    @Test
    public void testLoginFunctionality() {
        // Open the login page URL
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Locate the username, password, and submit button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        // Enter valid credentials
        usernameField.sendKeys("test");
        passwordField.sendKeys("Password123");

        // Click the login button
        loginButton.click();

        // Verify if the login was successful by checking for a "Logout" button (or another element visible after login)
        WebElement logoutButton = driver.findElement(By.id("logout"));
        assertTrue(logoutButton.isDisplayed(), "Login was not successful. Logout button is not visible.");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
