package pages.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import tests.base.Constants;

public class IntegrationTab extends BasePage {

    public IntegrationTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(By.cssSelector(Constants.IntegrationTabLocator.getValue()));
    }
}
