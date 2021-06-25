package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown {
    WebDriver driver;
    String locator;
    String optionLocator;

    public DropDown(WebDriver driver) {

        locator = "#navigation-menu";
        optionLocator = "//a[contains(text(),'%s')]";

        this.driver = driver;
    }

    public void select(String option) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
            driver.findElement(By.xpath(String.format(optionLocator, option))).click();
        } catch (Exception exception) {
            log.fatal(exception.getStackTrace());
        }

    }
}