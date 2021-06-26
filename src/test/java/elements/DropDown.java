package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

@Log4j2
public class DropDown {
    WebDriver driver;
    String locator;
    String optionLocator;
    String accessLocator;
    String accessLocatorOption;

    public DropDown(WebDriver driver) {

        locator = "#navigation-menu";
        optionLocator = "//a[contains(text(),'%s')]";

        accessLocator = "#access";
        accessLocatorOption = "//option[contains(text(),'%s')]";


        this.driver = driver;
    }

    public void select(String option) {
        assertTrue(isExist(By.cssSelector(locator)));
        assertTrue(isExist(By.xpath(String.format(optionLocator, option))));
        driver.findElement(By.cssSelector(locator)).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }

    public void selectOption(String option) {
        assertTrue(isExist(By.cssSelector(accessLocator)));
        assertTrue(isExist(By.xpath(String.format(accessLocatorOption, option))));
        driver.findElement(By.cssSelector(accessLocator)).click();
        driver.findElement(By.xpath(String.format(accessLocatorOption, option))).click();
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