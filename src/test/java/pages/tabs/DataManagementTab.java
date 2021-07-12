package pages.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import tests.base.Enum;

public class DataManagementTab extends BasePage {

    public DataManagementTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(By.cssSelector(Enum.DataManagementTabLocator.getValue()));
    }
}
