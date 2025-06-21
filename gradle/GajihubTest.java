package com.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GajihubTest {

    private WebDriver driver;

    @BeforeAll
    void setupDriver() {
        WebDriverManager.chromedriver().setup(); // otomatis download driver
    }

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://gajihub.com");
    }

    @Test
    void testLogoIsVisible() {
        WebElement logo = driver.findElement(By.cssSelector("a.navbar-brand img"));
        Assertions.assertTrue(logo.isDisplayed(), "Logo tidak terlihat");
    }

    @Test
    void testMenuFiturAda() {
        WebElement fiturMenu = driver.findElement(By.linkText("Fitur"));
        Assertions.assertTrue(fiturMenu.isDisplayed(), "Menu Fitur tidak ditemukan");
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
