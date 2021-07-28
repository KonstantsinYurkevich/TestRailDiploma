package pages.tabs;

import elements.CheckBox;
import elements.DropDownSelect;
import elements.Input;
import io.qameta.allure.Step;
import modals.Project;
import modals.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import tests.base.Constants;

public class NewUserModal extends BasePage {

    public NewUserModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(By.id(Constants.ButtonAcceptAdd.getValue()));
    }

    @Step("Fill in new user form")
    public UsersRolesTab addUser(User user) {

        new Input(driver, Constants.NewUserInputName.getValue()).writeIn(user.getFullName());
        new Input(driver, Constants.NewUserInputEmail.getValue()).writeIn(user.getEmailAddress());
        boolean enableEmailNotification = user.isEnableEmailNotifications();
        if (!enableEmailNotification) {
            driver.findElement(By.xpath(Constants.NewUserEmailNotificationLocator.getValue())).click();
        }
        new DropDownSelect(driver, Constants.DropDownSelectLanguage.getValue()).option(user.getLanguage());
        new DropDownSelect(driver, Constants.DropDownSelectTheme.getValue()).option(user.getTheme());
       /* new DropDown(driver,"Locate").selectIn(user.getLocate());
        new DropDown(driver,"Time Zone").selectIn(user.getTimeZone());*/

        String invite = user.getTypeOfInvite();
        switch (invite) {
            case "Invite user via email":
                break;
            case "Manually specify password (no invitation is sent)":
                driver.findElement(By.id(Constants.NewUserNoInvitationIsSentLocator.getValue())).click();
                driver.findElement(By.cssSelector(Constants.NewUserSetPasswordLocator.getValue())).sendKeys(user.getPassword());
                driver.findElement(By.cssSelector(Constants.NewUserConfirmPasswordLocator.getValue())).sendKeys(user.getPassword());
                break;
        }

        switchTab(Constants.NewUserTabAccess.getValue());

        new DropDownSelect(driver, Constants.DropDownSelectRole.getValue()).option(user.getRole());

        boolean isUserActive = user.isThisUserIsActive();
        if (!isUserActive) {
            new CheckBox(driver, Constants.NewUserCheckboxIsActive.getValue()).click();
        }
        boolean IsUserAdministrator = user.isThisUserIaAnAdministrator();
        if (IsUserAdministrator) {
            new CheckBox(driver, Constants.NewUserCheckboxIsAdministrator.getValue()).click();
        }

        driver.findElement(By.id(Constants.ButtonAcceptAdd.getValue())).click();


        return new UsersRolesTab(driver);
    }

    @Step("Fill in new user form")
    public UsersRolesTab addNewUserToTheProject(Project project, User user) {

        new Input(driver, Constants.NewUserInputName.getValue()).writeIn(user.getFullName());
        new Input(driver, Constants.NewUserInputEmail.getValue()).writeIn(user.getEmailAddress());
        boolean enableEmailNotification = user.isEnableEmailNotifications();
        if (!enableEmailNotification) {
            driver.findElement(By.xpath(Constants.NewUserEmailNotificationLocator.getValue())).click();
        }
        new DropDownSelect(driver, Constants.DropDownSelectLanguage.getValue()).option(user.getLanguage());
        new DropDownSelect(driver, Constants.DropDownSelectTheme.getValue()).option(user.getTheme());
       /* new DropDown(driver,"Locate").selectIn(user.getLocate());
        new DropDown(driver,"Time Zone").selectIn(user.getTimeZone());*/

        String invite = user.getTypeOfInvite();
        switch (invite) {
            case "Invite user via email":
                break;
            case "Manually specify password (no invitation is sent)":
                driver.findElement(By.id(Constants.NewUserNoInvitationIsSentLocator.getValue())).click();
                driver.findElement(By.cssSelector(Constants.NewUserSetPasswordLocator.getValue())).sendKeys(user.getPassword());
                driver.findElement(By.cssSelector(Constants.NewUserConfirmPasswordLocator.getValue())).sendKeys(user.getPassword());
                break;
        }

        switchTab(Constants.NewUserTabAccess.getValue());

        new DropDownSelect(driver, Constants.DropDownSelectRole.getValue()).option(user.getRole());

        boolean isUserActive = user.isThisUserIsActive();
        if (!isUserActive) {
            new CheckBox(driver, Constants.NewUserCheckboxIsActive.getValue()).click();
        }
        boolean IsUserAdministrator = user.isThisUserIaAnAdministrator();
        if (IsUserAdministrator) {
            new CheckBox(driver, Constants.NewUserCheckboxIsAdministrator.getValue()).click();
        }

        switchTab(Constants.NewUserTabProjects.getValue());
        driver.findElement(By.xpath(String.format(Constants.NewUserTabProjectProjectNameLocator.getValue(), project.getName()))).click();
        driver.findElement(By.xpath(String.format(Constants.NewUserTabProjectProjectAccessLocator.getValue(), user.getRole()))).click();


        driver.findElement(By.id(Constants.ButtonAcceptAdd.getValue())).click();

        return new UsersRolesTab(driver);
    }

    public void switchTab(String tabName) {
        driver.findElement(By.xpath(String.format(Constants.NewUserSwitchTabLocator.getValue(), tabName))).click();
    }
}
