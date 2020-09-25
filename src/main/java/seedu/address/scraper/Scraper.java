package seedu.address.scraper;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Scraper {
    private WebDriver driver;

    /**
     * The scraper constructor to initialize a new scraper instance.
     */
    public Scraper() {
        // Setup headless browser
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    public void get() {
        // Navigate to address
        driver.get("https://sourceacademy.nus.edu.sg/login");

        try {
            // Authenticate using user-supplied details
            driver.findElement(By.xpath("//button[@class='bp3-button bp3-large']")).click();

            driver.findElement(By.xpath("//input[@id='userNameInput']")).sendKeys("nusstu\\e0406907");
            driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("Stinkbomb132!");
            driver.findElement(By.xpath("//span[@id='submitButton']")).click();

            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.urlToBe("https://sourceacademy.nus.edu.sg/academy/game"));

            // Grab mission titles
            driver.findElement(By.xpath("//a[@href='/academy/missions']")).click();

            List<WebElement> missionTitles = driver.findElements(By.xpath("//h4[@class='bp3-heading listing-title']"));
            // Grab deadlines
            for (WebElement title : missionTitles) {
                System.out.println(title.getText());
            }

            driver.quit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
