package pages.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import tests.base.Constants;

public class DataManagementTab extends BasePage {

    public DataManagementTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(By.cssSelector(Constants.DataManagementTabLocator.getValue()));
    }
}
