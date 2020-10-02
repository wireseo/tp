package seedu.address.scraper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seedu.address.commons.exceptions.OsNotSupportedException;
import seedu.address.model.Model;
import seedu.address.model.UserLogin;
import seedu.address.model.mission.Mission;

public class ScraperManager implements Scraper {
    private WebDriver driver;
    private UserLogin loginInfo;
    private Model model;

    /**
     * The scraper constructor to initialize a new scraper instance.
     */
    public ScraperManager(UserLogin loginInfo, Model model) throws OsNotSupportedException {
        this.loginInfo = loginInfo;
        this.model = model;

        // Grab current os name
        final String operatingSystem = System.getProperty("os.name").toUpperCase();
        // Set chrome driver path according to os
        if (operatingSystem.contains("WIN")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/chromedriver.exe");
        } else if (operatingSystem.contains("MAC")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/chromedriver_mac");
        } else if (operatingSystem.contains("NUX")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/chromedriver_linux");
        } else {
            throw new OsNotSupportedException(operatingSystem);
        }

        // Setup headless browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    public void getMissions() {
        // Check if login information is empty
        if (loginInfo.isEmpty()) {
            return;
        }

        // Navigate to address
        driver.get("https://sourceacademy.nus.edu.sg/login");

        try {
            // Authenticate using user-supplied details
            driver.findElement(By.xpath("//button[@class='bp3-button bp3-large']")).click();

            driver.findElement(By.xpath("//input[@id='userNameInput']")).sendKeys(loginInfo.getUsername());
            driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys(
                    loginInfo.getUserPassword());
            driver.findElement(By.xpath("//span[@id='submitButton']")).click();

            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.urlToBe("https://sourceacademy.nus.edu.sg/academy/game"));

            // Grab mission titles
            driver.findElement(By.xpath("//a[@href='/academy/missions']")).click();

            List<WebElement> missionTitles = driver.findElements(By.xpath("//h4[@class='bp3-heading listing-title']"));
            List<WebElement> missionDeadlines = driver.findElements(By.xpath("//div[@class='listing-due-date']"));

            for (int i = 0; i < missionTitles.size(); i++) {
                // Add mission to ModelController here
                model.addMission(new Mission(missionTitles.get(i).getText(), missionDeadlines.get(i).getText()));
            }

            driver.quit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
