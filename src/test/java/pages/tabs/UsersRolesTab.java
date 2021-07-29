package pages.tabs;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import tests.base.Constants;

@Log4j2
public class UsersRolesTab extends BasePage {

    public UsersRolesTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(By.cssSelector(Constants.AdministrationTabUserAndRolesTabSearchFieldLocator.getValue()));
    }

    @Step("Click on button add user")
    public NewUserModal clickButtonAddUser() {
        driver.findElement(By.xpath(Constants.AdministrationTabUserAndRolesTabButtonAddUserLocator.getValue())).click();
        return new NewUserModal(driver);
    }

    @Step("Click on button add user")
    public ProjectTab openProjectTab() {
        log.info("Opening project tab");
        driver.findElement(By.id(Constants.AdministrationTabLocator.getValue())).click();
        driver.findElement(By.id(Constants.AdministrationTabOpenProjectTabLocator.getValue())).click();
        return new ProjectTab(driver);
    }

}
