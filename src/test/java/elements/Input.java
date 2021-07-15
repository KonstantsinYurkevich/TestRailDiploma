package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class Input {
    WebDriver driver;
    String fieldName;
    String input;
    String area;

    public Input(WebDriver driver, String fieldName) {
        input = "//input[@name= '%s']";
        area = "//textarea[@name= '%s']";
        this.driver = driver;
        this.fieldName = fieldName;
    }

    public void writeIn(String text) {
        isExist(By.xpath(String.format(input, fieldName)));
        driver.findElement(By.xpath(String.format(input, fieldName))).sendKeys(text);
    }

    public void writeInArea(String text) {
        isExist(By.xpath(String.format(area, fieldName)));
        driver.findElement(By.xpath(String.format(area, fieldName))).sendKeys(text);
    }

    //TODO если нужен isExist РЕАЛЬНО НУЖЕН?? То тогда создавай BaseElement с этим методом
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
