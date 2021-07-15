package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String locator;
    String optionLocator;

    public DropDown(WebDriver driver, String locator) {
        optionLocator = "//a[contains(text(),'%s')]";
        this.locator = locator;
        this.driver = driver;
    }

    public void select(String option) {
        driver.findElement(By.id(locator)).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }


}
