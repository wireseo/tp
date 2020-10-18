package seedu.address.scraper;

import static java.util.Objects.requireNonNull;

import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.OsNotSupportedException;
import seedu.address.commons.exceptions.WrongLoginDetailsException;
import seedu.address.model.Model;
import seedu.address.model.UserLogin;
import seedu.address.model.mission.Mission;
import seedu.address.model.quest.Quest;
import seedu.address.model.student.Address;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Phone;
import seedu.address.model.student.Student;
import seedu.address.model.student.exceptions.DuplicateStudentException;



public class ScraperManager implements Scraper {

    private static final String FILTER_KEY = "STUDIO JOURNAL";
    private final Logger logger = LogsCenter.getLogger(ScraperManager.class);
    private WebDriver driver;
    private UserLogin loginInfo;
    private Model model;
    private boolean isAuthenticated;

    /**
     * The scraper constructor to initialize a new scraper instance.
     */
    public ScraperManager(UserLogin loginInfo, Model model) throws OsNotSupportedException {
        requireNonNull(loginInfo);
        requireNonNull(model);
        this.loginInfo = loginInfo;
        this.model = model;
        this.isAuthenticated = false;

        // Grab current os name
        final String operatingSystem = System.getProperty("os.name").toUpperCase();
        // Set chrome driver path according to os
        if (operatingSystem.contains("WIN")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/chromedriver.exe");
        } else if (operatingSystem.contains("MAC")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/chromedriver_mac");
        } else if (operatingSystem.contains("NUX")) {
            //what about ubuntu??
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/chromedriver_linux");
        } else {
            throw new OsNotSupportedException(operatingSystem);
        }

        // Setup headless browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    /**
     * Authenticates the user with their supplied emails and password.
     * @throws WrongLoginDetailsException
     */
    public void authenticate() throws WrongLoginDetailsException {
        // Check if authenticated or login information is empty
        if (isAuthenticated || loginInfo.isEmpty()) {
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

            // The time out of 5 may need to be adjusted, depending on how we implement the login system
            // for Jarvis.
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.urlToBe("https://sourceacademy.nus.edu.sg/academy/game"));
        } catch (Exception e) {
            throw new WrongLoginDetailsException();
        }
        this.isAuthenticated = true;
    }

    public void getMissions() throws WrongLoginDetailsException {
        if (!isAuthenticated) {
            authenticate();
        }

        // Grab mission titles
        driver.findElement(By.xpath("//a[@href='/academy/missions']")).click();

        List<WebElement> missionTitles = driver.findElements(By.xpath("//h4[@class='bp3-heading listing-title']"));
        List<WebElement> missionDeadlines = driver.findElements(By.xpath("//div[@class='listing-due-date']"));

        for (int i = 0; i < missionTitles.size(); i++) {
            // Add mission to ModelController here
            String mTitle = missionTitles.get(i).getText();
            String mDeadline = missionDeadlines.get(i).getText();
            logger.info((i + 1) + "th mission added: " + mTitle);
            model.addMission(new Mission(mTitle, mDeadline));
        }
        logger.info("Missions addition complete");
    }

    public void getStudents() throws WrongLoginDetailsException {
        if (!isAuthenticated) {
            authenticate();
        }
        // Navigate to grading page
        driver.findElement(By.xpath("//a[@href='/academy/grading']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='filterBar']")));

        // Filter by Studio Journal
        driver.findElement(By.xpath("//input[@id='filterBar']")).sendKeys(FILTER_KEY + Keys.ENTER);

        // Get all student names
        List<WebElement> studentNames = driver.findElements(By.xpath("//div[@col-id='studentName']"));
        studentNames.remove(0);

        // Add student names to ModelController here
        for (WebElement name : studentNames) {
            try {
                model.addPerson(new Student(new Name(name.getText()), new Phone("999"), new Email("student@gmail.com"),
                        new Address("Test drive"), new HashSet<>()));
            } catch (DuplicateStudentException dse) {
                // a DuplicateStudentException is thrown when addressbook.json contains a student and ScraperManager
                // tries to fetch the same students on startup to add them to the addressbook.
                logger.info("ScraperManager tried adding a student which existed in addressbook.json");
            }

        }
    }

    public void getQuests() throws WrongLoginDetailsException {
        if (!isAuthenticated) {
            authenticate();
        }

        // Grab quest titles
        driver.findElement(By.xpath("//a[@href='/academy/quests']")).click();

        List<WebElement> questTitles = driver.findElements(By.xpath("//h4[@class='bp3-heading listing-title']"));
        List<WebElement> questDeadlines = driver.findElements(By.xpath("//div[@class='listing-due-date']"));

        for (int i = 0; i < questTitles.size(); i++) {
            // Add quest to ModelController here
            String qTitle = questTitles.get(i).getText();
            String qDeadline = questDeadlines.get(i).getText();
            logger.info((i + 1) + "th quest added: " + qTitle);
            model.addQuest(new Quest(qTitle, qDeadline));
        }
        logger.info("Quests addition complete");
    }

    public void getUngradedMissionsAndQuests() throws WrongLoginDetailsException {
        if (!isAuthenticated) {
            authenticate();
        }
        // Navigate to grading page
        driver.findElement(By.xpath("//a[@href='/academy/grading']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='filterBar']")));

        List<Mission> missions = model.getFilteredMissionList();
        List<Quest> quests = model.getFilteredQuestList();

        for (Mission mission : missions) {
            System.out.println("mission: " + mission.getTitle());
            WebElement filterBar = driver.findElement(By.xpath("//input[@id='filterBar']"));
            filterBar.clear();
            filterBar.sendKeys(mission.getTitle() + Keys.ENTER);

            // Get ungraded missions
            List<WebElement> allStudents = driver.findElement(By.xpath("//div[@class='ag-center-cols-container']"))
                    .findElements(By.xpath(".//div[@role='row']"));

            for (WebElement student : allStudents) {
                // Get the graded icon
                WebElement gradedIcon = student.findElement(By.xpath(".//div[@aria-colindex='7']"))
                        .findElement(By.xpath(".//span[@icon]"));

                // Add student to mission if mission is not yet graded
                if (gradedIcon.getAttribute("icon").equals("cross")) {
                    String studentName = student.findElement(By.xpath(".//div[@aria-colindex='4']")).getText();

                    model.addStudentToMission(studentName, mission);
                }
            }

        }
    }

    /**
     * Returns the WebDriver object created by ScraperManager
     * The returned object is used for testing.
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    public void shutDown() {
        driver.quit();
    }
}
