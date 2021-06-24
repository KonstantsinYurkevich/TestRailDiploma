package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base.PropertyReader;

@Log4j2
public abstract class BasePage {
    public static final String BASE_URL = System.getenv().getOrDefault("testrail.url", PropertyReader.getProperty("testrail.url"));
    public static final String LOGIN = System.getenv().getOrDefault("testrail.user", PropertyReader.getProperty("testrail.user"));
    public static final String PASSWORD = System.getenv().getOrDefault("testrail.password", PropertyReader.getProperty("testrail.password"));
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public abstract boolean IsPageOpened();

    public boolean isExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}