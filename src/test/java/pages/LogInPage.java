package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.base.PropertyReader;

import static tests.base.BaseTest.LOGIN;
import static tests.base.BaseTest.PASSWORD;

@Log4j2
public class LogInPage extends BasePage {
    public static final By LOGIN_INPUT = By.id("name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("button_primary");
    String LOGIN_PAGE_URL = "/auth/login/";

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(LOGIN_BUTTON);
    }

    @Step("LogIn using data")
    public HomePage logIn() {
        log.info("Fill in login form and press button login");
        driver.findElement(LOGIN_INPUT).sendKeys(LOGIN);
        driver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

    @Step("Open login page")
    public LogInPage open() {
        log.info("Opening LogIn page");
        driver.get(BASE_URL + LOGIN_PAGE_URL);
        return new LogInPage(driver);
    }
}
