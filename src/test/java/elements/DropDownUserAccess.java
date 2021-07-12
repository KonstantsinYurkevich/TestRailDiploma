package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class DropDownUserAccess {
    WebDriver driver;
    String locator;
    String optionLocator;
    String userName;

    public DropDownUserAccess(WebDriver driver, String userName) {

        locator = "//span[contains(text(),'%s')]//ancestor::tr/td/a[contains(@class,'nolink')]";
        optionLocator = "//div[contains(@id,'userAccessDropdown')]//a[contains(text(),'%s')]";

        this.userName = userName;
        this.driver = driver;
    }

    public void select(String option) {
        isExist(By.xpath(String.format(locator, userName)));
        isExist(By.xpath(String.format(optionLocator, option)));
        driver.findElement(By.xpath(String.format(locator, userName))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
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
