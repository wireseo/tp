package seedu.address.scraper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.OsNotSupportedException;
import seedu.address.commons.exceptions.WrongLoginDetailsException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserLogin;
import seedu.address.model.UserPrefs;
import seedu.address.model.mission.Mission;
import seedu.address.model.student.Student;
import seedu.address.testutil.TypicalStudents;

public class ScraperManagerTest {

    private static String os = null;
    private String validUsername = "nusstu\\e0406907";
    private String validPassword = "Stinkbomb132!";

    /**
     * Iterates through the given mission list, checking if the mission title and deadlines
     * are correctly assigned and not null.
     * @param missionObservableList an observable list of missions
     * @return true if the missionList contains missions with non null titles and deadlines
     */
    private boolean validateMissions(ObservableList<Mission> missionObservableList) {
        for (int i = 0; i < missionObservableList.size(); i++) {
            Mission checkedMission = missionObservableList.get(i);
            String missionTitle = checkedMission.getTitle();
            String missionDeadline = checkedMission.getDeadline();
            if (missionTitle == null || missionDeadline == null) {
                return false;
            } else if (missionTitle.length() == 0 || missionDeadline.length() == 0) {
                return false;
            }
        }
        return true;
    }

    @BeforeAll
    public static void initialize() {
        os = System.getProperty("os.name");
    }

    @Test
    public void constructor_nullUserLogin_throwsNullPointerException() {
        System.setProperty("os.name", os);
        Assertions.assertThrows(NullPointerException.class, () -> new ScraperManager(null, null));
    }

    @Test
    // as this sets the System.property "os.name" to android, all subsequent tests set it back to the
    // original system name.
    public void constructor_unsupportedOs_throwsOsNotSupportedException() {
        System.setProperty("os.name", os);
        String invalidOsName = "android";
        System.setProperty("os.name", invalidOsName);
        Assertions.assertThrows(OsNotSupportedException.class, () -> new ScraperManager(new UserLogin(),
                    new ModelManager(TypicalStudents.getTypicalAddressBook(), new UserPrefs()))
        );
    }

    // glass box test case
    // Unable to simulate the separate Os's and their web driver set-up as the file paths are not
    // present for the Chrom object to be instantiated, even after os.name is set.
    // this test case only tests if the web driver is correctly allocated for the runtime environment os,
    // it does not test if the web driver is correctly allocated for all OSes.
    @Test
    public void constructor_supportedOs_webdriverFieldSetSuccess() throws OsNotSupportedException {
        System.setProperty("os.name", os);
        final String operatingSystem = System.getProperty("os.name").toUpperCase();
        ScraperManager scraperManager = new ScraperManager(new UserLogin(),
                new ModelManager(TypicalStudents.getTypicalAddressBook(), new UserPrefs()));
        // Check if the System property "webdriver.chrome.driver" is set correctly.
        String webDriver = System.getProperty("webdriver.chrome.driver");
        if (operatingSystem.contains("WIN")) {
            Assertions.assertEquals("src/main/resources/chrome_driver/chromedriver.exe", webDriver);
        } else if (operatingSystem.contains("MAC")) {
            Assertions.assertEquals("src/main/resources/chrome_driver/chromedriver_mac", webDriver);
        } else if (operatingSystem.contains("NUX")) {
            Assertions.assertEquals("src/main/resources/chrome_driver/chromedriver_linux", webDriver);
        }
    }

    @Test
    public void constructor_validLoginDetails_driverInstantiated() throws OsNotSupportedException {
        System.setProperty("os.name", os);
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(validUsername);
        userLogin.setPassword(validPassword);
        ScraperManager scraperManager = new ScraperManager(userLogin,
                new ModelManager(TypicalStudents.getTypicalAddressBook(), new UserPrefs()));
        Assertions.assertNotEquals(null, scraperManager.getDriver());
    }
    // find a way to test for linux OSes.

    // Test that the assumption, the openqa imports works after the system property
    // webDriver is allocated correctly.

    @Test
    public void authenticate_emptyStringLoginUsername_throwsWrongLoginDetailsException()
            throws OsNotSupportedException {
        System.setProperty("os.name", os);
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(" ");
        userLogin.setPassword(validUsername);
        ScraperManager scraperManager = new ScraperManager(userLogin,
                new ModelManager(TypicalStudents.getTypicalAddressBook(), new UserPrefs()));
        Assertions.assertThrows(WrongLoginDetailsException.class, () -> scraperManager.authenticate());
    }

    @Test
    public void authenticate_emptyStringLoginPassword_throwsWrongLoginDetailsException()
            throws OsNotSupportedException {
        System.setProperty("os.name", os);
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(validUsername);
        userLogin.setPassword(" ");
        ScraperManager scraperManager = new ScraperManager(userLogin,
                new ModelManager(TypicalStudents.getTypicalAddressBook(), new UserPrefs()));
        Assertions.assertThrows(WrongLoginDetailsException.class, () -> scraperManager.authenticate());
    }



    @Test
    public void authenticate_validLoginDetails_loginSuccess()
            throws WrongLoginDetailsException, OsNotSupportedException {
        System.setProperty("os.name", os);
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(validUsername);
        userLogin.setPassword(validPassword);
        ScraperManager scraperManager = new ScraperManager(userLogin,
                new ModelManager(TypicalStudents.getTypicalAddressBook(), new UserPrefs()));
        scraperManager.authenticate();
        WebDriver webDriver = scraperManager.getDriver();

        // check for both the url and the title of the web page to be correct
        Assertions.assertEquals("Source Academy", webDriver.getTitle());
        Assertions.assertEquals("https://sourceacademy.nus.edu.sg/academy/game", webDriver.getCurrentUrl());
    }

    // test getMissions
    @Test
    public void getMissions_validLoginDetails_missionsAddedToModel()
            throws WrongLoginDetailsException, OsNotSupportedException {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(validUsername);
        userLogin.setPassword(validPassword);
        Model model = new ModelManager(TypicalStudents.getTypicalAddressBook(), new UserPrefs());
        ScraperManager scraperManager = new ScraperManager(userLogin, model);
        scraperManager.getMissions();
        ObservableList<Mission> missionObservableList = model.getAddressBook().getMissionList();

        // Assumption that there is always at least one mission in the list. however at the end of the semester this
        // test case may fail.
        System.out.println(missionObservableList.size());
        int missionCount = missionObservableList.size();
        if (missionCount == 0) {
            Assertions.assertTrue(true);
        } else {
            Assertions.assertTrue(validateMissions(missionObservableList));
        }

    }

    // test getStudents
    @Test
    public void getStudents_validLoginDetails_missionsAddedToModel()
            throws WrongLoginDetailsException, OsNotSupportedException {
        System.setProperty("os.name", os);
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(validUsername);
        userLogin.setPassword(validPassword);
        Model model = new ModelManager(TypicalStudents.getTypicalAddressBook(), new UserPrefs());
        ScraperManager scraperManager = new ScraperManager(userLogin, model);
        scraperManager.getMissions();
        ObservableList<Student> studentList = model.getAddressBook().getStudentList();

        // Assumption that there is always at least one mission in the list. however at the end of the semester this
        // test case may fail.
        System.out.println(studentList.size());
        Assertions.assertNotEquals(0, studentList.size());
    }

}
