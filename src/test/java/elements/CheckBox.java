package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class CheckBox {
    WebDriver driver;
    String locator;
    String label;
    String locatorTypeSelect;
    String locatorTypeClick;

    public CheckBox(WebDriver driver, String label) {
        locatorTypeSelect = "//strong[contains(text(),'%s')]//ancestor::div[contains(@class,'project-type')]//input";
        locatorTypeClick = "//strong[contains(text(),'%s')]//ancestor::div[contains(@class,'checkbox')]//input";
        locator = "//input[@name= '%s']";
        this.label = label;
        this.driver = driver;
    }

    public void select(boolean option) {
        isExist(By.xpath(String.format(locator, label)));
        if (option) {
            driver.findElement(By.xpath(String.format(locator, label))).click();
        }

    }

    public void click() {
        isExist(By.xpath(String.format(locatorTypeClick, label)));
        driver.findElement(By.xpath(String.format(locatorTypeClick, label))).click();
    }

    public void option() {
        isExist(By.xpath(String.format(locatorTypeSelect, label)));
        driver.findElement(By.xpath(String.format(locatorTypeSelect, label))).click();
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
