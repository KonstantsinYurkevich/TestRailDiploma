package pages;

import elements.DropDown;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base.Enum;
import tests.base.PropertyReader;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static tests.base.BaseTest.LOGIN;

@Log4j2
public abstract class BasePage {

    public static final String BASE_URL = System.getenv().getOrDefault("TESTRAIL_URL", PropertyReader.getProperty("testrail.url"));

    public WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract boolean IsPageOpened();

    @Step("Check that element {locator} exists")
    public boolean isExist(By locator) {
        log.info("Check that element exists");
        try {
            driver.findElement(locator);
            return true;
        } catch (NotFoundException exception) {
            log.error(exception.getMessage());
            return false;
        } catch (Exception exceptionFatal) {
            log.fatal(exceptionFatal.getStackTrace());
            return false;
        }
    }

    public boolean isExists(By locator) {
        log.info("Check that element not exists");
        try {
            driver.findElement(locator);
            return false;
        } catch (NoSuchElementException exception) {
            return true;
        }
    }

    @Step("Click on button Blog")
    public BlogPage clickOnBlogLink() {
        log.info("Click on button Blog");
        isExist(By.cssSelector(Enum.BLOG_LOCATOR.getValue()));
        driver.findElement(By.cssSelector(Enum.BLOG_LOCATOR.getValue())).click();
        return new BlogPage(driver);

    }

    @Step("Click on button Twitter")
    public TwitterPage clickOnTwitterLink() {
        log.info("Click on button Twitter");
        isExist(By.cssSelector(Enum.TWITTER_LOCATOR.getValue()));
        driver.findElement(By.cssSelector(Enum.TWITTER_LOCATOR.getValue())).click();
        return new TwitterPage(driver);

    }

    @Step("Click on button User Guide in dropdown Help & Feedback")
    public UserGuidePage clickOnUserGuideLink() {
        log.info("Click on button User Guide in dropdown Help & Feedback");
        new DropDown(driver, Enum.DropDownHelpAndFeedBack.getValue()).select("TestRail User Guide");
        return new UserGuidePage(driver);

    }

    @Step("Click on button News Letter")
    public NewsLetterPage clickOnNewsLetterLink() {
        isExist(By.cssSelector(String.format(Enum.NEWSLETTER_LOCATOR.getValue(), LOGIN)));
        driver.findElement(By.cssSelector(String.format(Enum.NEWSLETTER_LOCATOR.getValue(), LOGIN))).click();
        log.info("Click on button News Letter");
        return new NewsLetterPage(driver);

    }

    @Step("Click on button Log out")
    public LogInPage logout() {
        new DropDown(driver, Enum.DropDownUserMenu.getValue()).select(Enum.DropDownUserMenuOptionLogOut.getValue());
        log.info("Click on button Logout");
        return new LogInPage(driver);

    }

    @Step("Switch window")
    public void SwitchWindow(int windowIndex) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(windowIndex));
    }

    @Step("Open administration tab")
    public AdministrationPage OpenAdministrationTab() {
        log.info("Open administration tab");
        isExist(By.id(Enum.AdministrationTabLocator.getValue()));
        driver.findElement(By.id(Enum.AdministrationTabLocator.getValue())).click();
        return new AdministrationPage(driver);
    }

    @Step("Validating Project name")
    public void validateProjectName(String expected) {
        log.info("Validating Project name");
        driver.findElement(By.id(Enum.DashboardTabLocator.getValue())).click();
        driver.findElement(By.xpath(String.format(Enum.ProjectInListLocator.getValue(), expected))).click();
        isExist(By.cssSelector(Enum.ProjectNameLocator.getValue()));
        assertEquals(
                driver.findElement(By.cssSelector(Enum.ProjectNameLocator.getValue())).getText(),
                expected,
                "Project name is not correct");
    }

    @Step("Validating Project announcement is shown")
    public void validateProjectAnnouncementIsShown(String expected) {
        log.info("Validating Project announcement is shown");
        isExist(By.cssSelector(Enum.ProjectAnnouncementsLocator.getValue()));
        assertEquals(
                driver.findElement(By.cssSelector(Enum.ProjectAnnouncementsLocator.getValue())).getText(),
                expected,
                "Project announcement is not correct");
    }

    @Step("Validating Project announcement is not shown")
    public boolean validateProjectAnnouncementNotShown() {
        log.info("Validating Project announcement not shown");
        return isExists(By.cssSelector(Enum.ProjectAnnouncementsLocator.getValue()));
    }

    @Step("Validating Project status is complete")
    public void validateProjectComplete(String projectName) {
        log.info("Validating Project project complete");
        isExist(By.id(Enum.ButtonReturnToDashboardLocator.getValue()));
        driver.findElement(By.id(Enum.ButtonReturnToDashboardLocator.getValue())).click();
        isExist(By.xpath(String.format(Enum.ListOfCompletedProjectsLocator.getValue(), projectName)));

    }

    @Step("Validating Project status is in progress")
    public void validateProjectInProgress(String projectName) {
        log.info("Validating  Project project in progress");
        isExist(By.id(Enum.ButtonReturnToDashboardLocator.getValue()));
        driver.findElement(By.id(Enum.ButtonReturnToDashboardLocator.getValue())).click();
        isExist(By.xpath(String.format(Enum.ListOfInProgressProjectsLocator.getValue(), projectName)));

    }
   /* @Step("Validating User access to the project")
    public void validateProjectUserAccess(String userName, String expected) {
        assertEquals(driver.findElement(By.cssSelector(Enum.UserNameLocator.getValue())).getText(),
                userName,
                "Wrong user was logged in");
        log.info("Validating  Project user access");

    }*/
    /*@Step("Log in as invited user without email invite")
    public void logInAsUserWithoutEmailInvite(InviteUser user) {
        log.info("Log in as invited user without email invite");
        logout();
        driver.get("https://testrailky.testrail.io/index.php?/auth/login");
        driver.findElement(LOGIN_INPUT).sendKeys(user.getEmailAddress());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        assertEquals(driver.findElement(By.cssSelector(Enum.UserNameLocator.getValue())).getText(),
                user.getFullName(),
                "User name is not correct"
        );

    }*/
    /*@Step("Log in as invited user with email invite")
    public void logInAsUserWithEmailInvite(InviteUser user) {
        log.info("Log in as invited user with email invite");
        logout();
        driver.get("https://testrailky.testrail.io/index.php?/auth/login");
        driver.findElement(LOGIN_INPUT).sendKeys(user.getEmailAddress());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        assertEquals(driver.findElement(By.cssSelector(".navigation-username")).getText(),
                user.getFullName(),
                "User name is not correct"
        );
        driver.findElement(By.id("")).sendKeys(Keys.chord(Keys.CONTROL, "v"));

    }*/
}