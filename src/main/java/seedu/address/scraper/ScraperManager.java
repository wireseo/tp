package seedu.address.scraper;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.util.ArrayList;
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
import seedu.address.model.student.Student;
import seedu.address.model.student.Telegram;
import seedu.address.model.student.exceptions.DuplicateStudentException;
import seedu.address.storage.Storage;


public class ScraperManager implements Scraper {

    private static final String FILTER_KEY = "STUDIO JOURNAL";
    private final Logger logger = LogsCenter.getLogger(ScraperManager.class);
    private WebDriver driver;
    private UserLogin loginInfo;
    private Model model;
    private Storage storage;
    private boolean isAuthenticated;

    /**
     * The scraper constructor to initialize a new scraper instance.
     */
    public ScraperManager(UserLogin loginInfo, Model model, Storage storage) throws OsNotSupportedException {
        requireNonNull(loginInfo);
        requireNonNull(model);
        this.loginInfo = loginInfo;
        this.model = model;
        this.storage = storage;
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
     * Initializes the scraping sequence to parse for information.
     * @throws WrongLoginDetailsException
     * @throws IOException
     */
    public void startScraping() throws WrongLoginDetailsException, IOException {
        authenticate();
        List<Mission> missions = getMissions();
        List<Quest> quests = getQuests();
        List<Student> students = new ArrayList<>();

        getUngradedMissionsAndQuests();

        // Only fetch students if students in addressbook is empty
        if (!model.hasStudents()) {
            students = getStudents();
        }

        saveToStorage(missions, quests, students);
        shutDown();
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

        logger.info("Authenticating");

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

    /**
     * Fetches missions from Sourceacademy and saves them to storage.
     * @return a list of missions
     * @throws WrongLoginDetailsException
     */
    public List<Mission> getMissions() throws WrongLoginDetailsException {
        List<Mission> missions = new ArrayList<>();

        if (loginInfo.isEmpty()) {
            return missions;
        }

        if (!isAuthenticated) {
            authenticate();
        }

        logger.info("Getting missions");

        if (!driver.getCurrentUrl().equals("https://sourceacademy.nus.edu.sg/academy/missions")) {
            // Navigate to missions page
            driver.findElement(By.xpath("//a[@href='/academy/missions']")).click();
        }

        assert driver.getCurrentUrl().equals("https://sourceacademy.nus.edu.sg/academy/missions")
                : "Driver is on wrong page (Missions)";

        // Grab mission titles
        List<WebElement> missionTitles = driver.findElements(By.xpath("//h4[@class='bp3-heading listing-title']"));
        List<WebElement> missionDeadlines = driver.findElements(By.xpath("//div[@class='listing-due-date']"));

        for (int i = 0; i < missionTitles.size(); i++) {
            // Add mission to ModelController here
            String mTitle = missionTitles.get(i).getText();
            String mDeadline = missionDeadlines.get(i).getText();

            // Do not add missions that are not yet opened
            if (mDeadline.contains("Opens at")) {
                continue;
            }
            logger.info((i + 1) + "th mission added: " + mTitle);
            missions.add(new Mission(mTitle, mDeadline));
        }
        logger.info("Missions addition complete");

        return missions;
    }

    /**
     * Fetches quests from Sourceacademy and saves them to storage.
     * @return returns a list of quests
     * @throws WrongLoginDetailsException
     */
    public List<Quest> getQuests() throws WrongLoginDetailsException {
        List<Quest> quests = new ArrayList<>();

        if (loginInfo.isEmpty()) {
            return quests;
        }

        if (!isAuthenticated) {
            authenticate();
        }

        if (!driver.getCurrentUrl().equals("https://sourceacademy.nus.edu.sg/academy/quests")) {
            // Navigate to quests page
            driver.findElement(By.xpath("//a[@href='/academy/quests']")).click();
        }

        assert driver.getCurrentUrl().equals("https://sourceacademy.nus.edu.sg/academy/quests")
                : "Driver is on wrong page (Quests)";

        // Grab quest titles
        List<WebElement> questTitles = driver.findElements(By.xpath("//h4[@class='bp3-heading listing-title']"));
        List<WebElement> questDeadlines = driver.findElements(By.xpath("//div[@class='listing-due-date']"));

        for (int i = 0; i < questTitles.size(); i++) {
            // Add quest to ModelController here
            String qTitle = questTitles.get(i).getText();
            String qDeadline = questDeadlines.get(i).getText();

            // Do not add quests that are not yet opened
            if (qDeadline.contains("Opens at")) {
                continue;
            }

            logger.info((i + 1) + "th quest added: " + qTitle);
            quests.add(new Quest(qTitle, qDeadline));
        }
        logger.info("Quests addition complete");

        return quests;
    }

    /**
     * Fetches students from Sourceacademy and saves them to the model.
     * @return A list of students
     * @throws WrongLoginDetailsException
     */
    public List<Student> getStudents() throws WrongLoginDetailsException {
        List<Student> students = new ArrayList<>();

        if (loginInfo.isEmpty()) {
            return students;
        }

        if (!isAuthenticated) {
            authenticate();
        }

        logger.info("Getting students");

        if (!driver.getCurrentUrl().equals("https://sourceacademy.nus.edu.sg/academy/grading")) {
            // Navigate to grading page
            driver.findElement(By.xpath("//a[@href='/academy/grading']")).click();
        }

        assert driver.getCurrentUrl().equals("https://sourceacademy.nus.edu.sg/academy/grading")
                : "Driver is on wrong page (Grading)";

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='filterBar']")));

        // Filter by Studio Journal
        driver.findElement(By.xpath("//input[@id='filterBar']")).sendKeys(FILTER_KEY + Keys.ENTER);

        // Get all student names
        List<WebElement> studentNames = driver.findElements(By.xpath("//div[@col-id='studentName']"));
        studentNames.remove(0);

        // Add student names to ModelController here
        for (WebElement name : studentNames) {
            try {
                students.add(new Student(new Name(name.getText()), new Telegram("helloworld"),
                        new Email("student@gmail.com"), new Address("Test drive"), new HashSet<>()));
            } catch (DuplicateStudentException dse) {
                // a DuplicateStudentException is thrown when addressbook.json contains a student and ScraperManager
                // tries to fetch the same students on startup to add them to the addressbook.
                logger.info("ScraperManager tried adding a student which existed in addressbook.json");
            }
        }

        return students;
    }

    /**
     * Fetches the ungraded missions and quests that have just recently passed.
     * @throws WrongLoginDetailsException
     */
    public void getUngradedMissionsAndQuests() throws WrongLoginDetailsException {
        if (loginInfo.isEmpty()) {
            return;
        }

        if (!isAuthenticated) {
            authenticate();
        }

        logger.info("Getting ungraded missions and quests");

        // Navigate to grading page
        driver.findElement(By.xpath("//a[@href='/academy/grading']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='filterBar']")));

        // WIP

        logger.info("Completed getting ungraded missions and quests");
    }

    /**
     * Saves the model information to storage.
     * @param missions list of missions to be saved
     * @param quests list of quests to be saved
     * @param students list of students to be saved
     * @throws IOException
     */
    private void saveToStorage(List<Mission> missions, List<Quest> quests, List<Student> students) throws IOException {
        try {
            model.setMissions(missions);
            model.setQuests(quests);
            model.setStudents(students);
            storage.saveAddressBook(model.getAddressBook());
        } catch (IOException e) {
            throw new IOException("Error saving to addressbook");
        }

    }

    /**
     * Returns the WebDriver object created by ScraperManager
     * The returned object is used for testing.
     * @return a webdriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    public void shutDown() {
        driver.quit();
    }
}
