package pages;

import elements.DropDown;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base.PropertyReader;

@Log4j2
public abstract class BasePage {

    public static final String BASE_URL = System.getenv().getOrDefault("TESTRAIL_URL", PropertyReader.getProperty("testrail.url"));
    public static final By BLOG_LOCATOR = By.cssSelector("div> a[href^=\"http://blog.gurock.com/\"]");
    public static final By TWITTER_LOCATOR = By.cssSelector("div> a[href^=\"http://twitter.com/testrail\"]");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract boolean IsPageOpened();

    public boolean isExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception exception) {
            log.info(exception.getMessage());
            return false;
        }
    }

    public BlogPage clickOnBlogLink() {
        try {
            driver.findElement(BLOG_LOCATOR).click();
        } catch (Exception exception) {
            log.info(exception.getStackTrace());
        }
        return new BlogPage(driver);

    }

    public TwitterPage clickOnTwitterLink() {
        try {
            driver.findElement(TWITTER_LOCATOR).click();
        } catch (Exception exception) {
            log.info(exception.getStackTrace());
        }
        return new TwitterPage(driver);

    }

    public UserGuidePage clickOnUserGuideLink() {
        new DropDown(driver).select("TestRail User Guide");
        return new UserGuidePage(driver);

    }
}