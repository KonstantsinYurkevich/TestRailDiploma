package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownSearch {
    WebDriver driver;
    String locator;
    String optionLocator;
    String inputLocator;

    public DropDownSearch(WebDriver driver, String DropDownName) {

        switch (DropDownName) {
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
            case "Locale":
                locator = "#locale_chzn";
                inputLocator = "//div[@id='locale_chzn']//input[contains(@type,'text')]";
                optionLocator = "//div[@id = 'locale_chzn']//li[contains(@class,'active-result')]";
                break;
            case "Time Zone":
                locator = "#timezone_chzn";
                inputLocator = "//div[@id='timezone_chzn']//input[contains(@type,'text')]";
                optionLocator = "//div[@id = 'timezone_chzn']//li[contains(@class,'active-result')]";
                break;

        }
        this.driver = driver;
    }

    public void select(String option) {
        driver.findElement(By.cssSelector(locator)).click();
        driver.findElement(By.xpath(inputLocator)).sendKeys(option);
        driver.findElement(By.xpath(optionLocator)).click();
    }
}
