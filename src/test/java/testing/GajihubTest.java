package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GajihubTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://gajihub.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testTombolJadwalkanDemo() {
        WebElement demoButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Jadwalkan Demo Sekarang')]"))
        );
        demoButton.click();

        // Tunggu URL berubah atau redirect
        wait.until(ExpectedConditions.urlContains("demo"));
        Assertions.assertTrue(driver.getCurrentUrl().toLowerCase().contains("demo"),
                "Tidak diarahkan ke halaman demo");
    }

    @Test
    void testTombolCobaGratis() {
        WebElement cobaGratisButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Coba Gratis')]"))
        );
        cobaGratisButton.click();

        // Tunggu URL mengandung kata "signup" atau "daftar"
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("signup"),
                ExpectedConditions.urlContains("daftar")
        ));
        String url = driver.getCurrentUrl().toLowerCase();
        Assertions.assertTrue(url.contains("signup") || url.contains("daftar"),
                "Tidak diarahkan ke halaman signup atau daftar");
    }

    @AfterEach
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
