package pages.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import tests.base.Enum;

public class UsersRolesTab extends BasePage {

    public UsersRolesTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(By.cssSelector(Enum.AdministrationTabUserAndRolesTabSearchFieldLocator.getValue()));
    }

    public NewUserModal clickButtonAddUser() {
        driver.findElement(By.xpath(Enum.AdministrationTabUserAndRolesTabButtonAddUserLocator.getValue())).click();
        return new NewUserModal(driver);
    }

}
