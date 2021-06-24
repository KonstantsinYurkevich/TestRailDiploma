package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base.PropertyReader;

@Log4j2
public abstract class BasePage {

    public static final String BASE_URL = System.getenv().getOrDefault("TESTRAIL_URL", PropertyReader.getProperty("testrail.url"));

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