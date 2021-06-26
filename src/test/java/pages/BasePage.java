package pages;

import elements.DropDown;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.base.PropertyReader;

import java.util.ArrayList;

import static tests.base.BaseTest.LOGIN;

@Log4j2
public abstract class BasePage {

    public static final String BASE_URL = System.getenv().getOrDefault("TESTRAIL_URL", PropertyReader.getProperty("testrail.url"));
    public static final By BLOG_LOCATOR = By.cssSelector("div> a[href^=\"http://blog.gurock.com/\"]");
    public static final By TWITTER_LOCATOR = By.cssSelector("div> a[href^=\"http://twitter.com/testrail\"]");
    public static final String NEWSLETTER_LOCATOR = "div> a[href^=\"https://secure.gurock.com/customers/testrail/newsletter?email=%s\"]";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract boolean IsPageOpened() throws InterruptedException;

    @Step("Check that element {locator} exists")
    public boolean isExist(By locator) {
        log.info("Check that element exists");
        try {
            driver.findElement(locator);
            return true;
        } catch (NotFoundException exception) {
            log.error(exception.getMessage());
            Assert.fail();
            return false;
        } catch (Exception exceptionFatal) {
            log.fatal(exceptionFatal.getStackTrace());
            Assert.fail();
            return false;
        }
    }

    @Step("Click on button Blog")
    public BlogPage clickOnBlogLink() {
        log.info("Click on button Blog");
        isExist(BLOG_LOCATOR);
        driver.findElement(BLOG_LOCATOR).click();
        return new BlogPage(driver);

    }

    @Step("Click on button Twitter")
    public TwitterPage clickOnTwitterLink() {
        log.info("Click on button Twitter");
        isExist(TWITTER_LOCATOR);
        driver.findElement(TWITTER_LOCATOR).click();
        return new TwitterPage(driver);

    }

    @Step("Click on button User Guide in dropdown Help & Feedback")
    public UserGuidePage clickOnUserGuideLink() {
        log.info("Click on button User Guide in dropdown Help & Feedback");
        new DropDown(driver).select("TestRail User Guide");
        return new UserGuidePage(driver);

    }

    @Step("Click on button News Letter")
    public NewsLetterPage clickOnNewsLetterLink() {
        isExist(By.cssSelector(String.format(NEWSLETTER_LOCATOR, LOGIN)));
        driver.findElement(By.cssSelector(String.format(NEWSLETTER_LOCATOR, LOGIN))).click();
        log.info("Click on button News Letter");
        return new NewsLetterPage(driver);

    }

    @Step("Click on button Log out")
    public LogInPage logout() {
        isExist(By.cssSelector("#navigation-user"));
        driver.findElement(By.cssSelector("#navigation-user")).click();
        driver.findElement(By.cssSelector("#navigation-user-logout")).click();
        log.info("Click on button Logout");
        return new LogInPage(driver);

    }

    public void SwitchWindow(int windowIndex) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(windowIndex));
    }
}