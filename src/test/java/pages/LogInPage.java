package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

@Log4j2
public class LogInPage extends BasePage {

    public static final By LOGIN_INPUT = By.id("name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("button_primary");
    public static final String LOGIN_PAGE_URL = "/auth/login/";
    public static final By ERROR_MASSAGE = By.cssSelector(".error-text");
    public static final By ERROR_MASSAGE_LOGIN = By.cssSelector(".loginpage-message-image");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }

    @Step("LogIn using data")
    public HomePage logIn(String name, String password) {
        log.info("Fill in login form and press button login");
        driver.findElement(LOGIN_INPUT).sendKeys(name);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    @Step("Open login page")
    public LogInPage open() {
        log.info("Opening LogIn page");
        driver.get(BASE_URL + LOGIN_PAGE_URL);
        return new LogInPage(driver);
    }

    @Step("Get error message on login page")
    public String getError() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        log.info("Get error message on login page");
        By locator = null;
        if (isExist(ERROR_MASSAGE)) {
            locator = ERROR_MASSAGE;
        } else if (isExist(ERROR_MASSAGE_LOGIN)) {
            locator = ERROR_MASSAGE_LOGIN;
        } else if (!isExist(ERROR_MASSAGE_LOGIN)) {
            log.error("No such error");
            Assert.fail();
        }
        return driver.findElement(locator).getText();
    }
}
