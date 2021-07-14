package pages.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import tests.base.Constants;

public class UsersRolesTab extends BasePage {

    public UsersRolesTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(By.cssSelector(Constants.AdministrationTabUserAndRolesTabSearchFieldLocator.getValue()));
    }

    public NewUserModal clickButtonAddUser() {
        driver.findElement(By.xpath(Constants.AdministrationTabUserAndRolesTabButtonAddUserLocator.getValue())).click();
        return new NewUserModal(driver);
    }

}
