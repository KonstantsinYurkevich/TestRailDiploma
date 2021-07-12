package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class DropDown {
    WebDriver driver;
    String locator;
    String optionLocator;
    String inputLocator;

    //TODO сделать одну обертку в которой будет DropDown с div и a
    //TODO сделать вторую обертку в которой будет DropDown с поиском
    //TODO создать третий DtopDown который будет обрабатывать Select
    public DropDown(WebDriver driver, String DropDownName) {
        switch (DropDownName) {
            case "Navigation":
                locator = "#navigation-menu";
                optionLocator = "//div[@id = 'helpDropdown']//a[contains(text(),'%s')]";
                break;
            case "User dropdown":
                locator = "#navigation-user";
                optionLocator = "//div[@id = 'userDropdown']//a[contains(text(),'%s')]";
                break;
            case "Project access":
                locator = "#access";
                optionLocator = "//select[@id = 'access']//option[contains(text(),'%s')]";
                break;
            case "Defect plugin":
                locator = "#defect_plugin_chzn";
                inputLocator = "//div[@id='defect_plugin_chzn']//input[contains(@type,'text')]";
                optionLocator = "//div[@id = 'defect_plugin_chzn']//li[contains(@class,'active-result')]";
                break;
            case "Reference plugin":
                locator = "#reference_plugin_chzn";
                inputLocator = "//div[@id='reference_plugin_chzn']//input[contains(@type,'text')]";
                optionLocator = "//div[@id = 'reference_plugin_chzn']//li[contains(@class,'active-result')]";
                break;
            case "Language":
                locator = "#language";
                optionLocator = "//select[@id = 'language']//option[contains(text(),'%s')]";
                break;
            case "Theme":
                locator = "#theme";
                optionLocator = "//select[@id = 'theme']//option[contains(text(),'%s')]";
                break;
            case "Locate":
                locator = "#locale_chzn";
                inputLocator = "//div[@id='locale_chzn']//input[contains(@type,'text')]";
                optionLocator = "//div[@id = 'locale_chzn']//li[contains(@class,'active-result')]";
                break;
            case "Time Zone":
                locator = "#timezone_chzn";
                inputLocator = "//div[@id='timezone_chzn']//input[contains(@type,'text')]";
                optionLocator = "//div[@id = 'timezone_chzn']//li[contains(@class,'active-result')]";
                break;
            case "Role":
                locator = "#role_id";
                optionLocator = "//select[@id = 'role_id']//option[contains(text(),'%s')]";
                break;
            case "Type":
                locator = "#userFieldType";
                optionLocator = "//select[@id = 'userFieldType']//option[contains(text(),'%s')]";
                break;

        }

        this.driver = driver;
    }

    public void select(String option) {
        isExist(By.cssSelector(locator));
        driver.findElement(By.cssSelector(locator)).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }

    public void selectIn(String option) {
        isExist(By.cssSelector(locator));
        driver.findElement(By.cssSelector(locator)).click();
        isExist(By.xpath(inputLocator));
        driver.findElement(By.xpath(inputLocator)).sendKeys(option);
        isExist(By.xpath(optionLocator));
        driver.findElement(By.xpath(optionLocator)).click();
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