package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

@Log4j2
public class DropDownSelect {
    WebDriver driver;
    String locator;

    public DropDownSelect(WebDriver driver, String DropDownName) {
        locator = DropDownName;
        this.driver = driver;
    }


    public void option(String option) {
        Select select = new Select(driver.findElement(By.id(locator)));
        select.selectByVisibleText(option);
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