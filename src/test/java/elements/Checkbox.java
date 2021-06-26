package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

@Log4j2
public class Checkbox {
    WebDriver driver;
    String locator;
    String label;
    String locatorType;

    public Checkbox(WebDriver driver, String label) {
        locatorType = "//strong[contains(text(),'%s')]//ancestor::div[contains(@class,'project-type')]//input";
        locator = "//input[@name= '%s']";
        this.label = label;
        this.driver = driver;
    }

    public void select(boolean option) {
        assertTrue(isExist(By.xpath(String.format(locator, label))));
        if (option) {
            driver.findElement(By.xpath(String.format(locator, label))).click();
        }

    }

    public void click() {
        assertTrue(isExist(By.xpath(String.format(locatorType, label))));
        driver.findElement(By.xpath(String.format(locatorType, label))).click();
    }

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
}
