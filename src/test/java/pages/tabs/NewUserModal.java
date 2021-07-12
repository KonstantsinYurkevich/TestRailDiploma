package pages.tabs;

import elements.Checkbox;
import elements.DropDown;
import elements.Input;
import modals.InviteUser;
import modals.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import tests.base.Enum;

public class NewUserModal extends BasePage {

    public NewUserModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return true;
    }

    public UsersRolesTab AddUser(InviteUser user) {

        new Input(driver, Enum.NewUserInputName.getValue()).writeIn(user.getFullName());
        new Input(driver, Enum.NewUserInputEmail.getValue()).writeIn(user.getEmailAddress());
        boolean enableEmailNotification = user.isEnableEmailNotifications();
        if (!enableEmailNotification) {
            driver.findElement(By.xpath(Enum.NewUserEmailNotificationLocator.getValue())).click();
        }
        new DropDown(driver, Enum.DropDownLanguage.getValue()).select(user.getLanguage());
        new DropDown(driver, Enum.DropDownTheme.getValue()).select(user.getTheme());
       /* new DropDown(driver,"Locate").selectIn(user.getLocate());
        new DropDown(driver,"Time Zone").selectIn(user.getTimeZone());*/

        String invite = user.getTypeOfInvite();
        switch (invite) {
            case "Invite user via email":
                break;
            case "Manually specify password (no invitation is sent)":
                driver.findElement(By.id(Enum.NewUserNoInvitationIsSentLocator.getValue())).click();
                driver.findElement(By.cssSelector(Enum.NewUserSetPasswordLocator.getValue())).sendKeys(user.getPassword());
                driver.findElement(By.cssSelector(Enum.NewUserConfirmPasswordLocator.getValue())).sendKeys(user.getPassword());
                break;
        }

        switchTab(Enum.NewUserTabAccess.getValue());

        new DropDown(driver, Enum.NewUserDropDownRole.getValue()).select(user.getRole());

        boolean isUserActive = user.isThisUserIsActive();
        if (!isUserActive) {
            new Checkbox(driver, Enum.NewUserCheckboxIsActive.getValue()).click();
        }
        boolean IsUserAdministrator = user.isThisUserIaAnAdministrator();
        if (IsUserAdministrator) {
            new Checkbox(driver, Enum.NewUserCheckboxIsAdministrator.getValue()).click();
        }

        driver.findElement(By.id(Enum.NewUserButtonAddLocator.getValue())).click();


        return new UsersRolesTab(driver);
    }

    public UsersRolesTab AddNewUserToTheProject(Project project, InviteUser user) {

        new Input(driver, Enum.NewUserInputName.getValue()).writeIn(user.getFullName());
        new Input(driver, Enum.NewUserInputEmail.getValue()).writeIn(user.getEmailAddress());
        boolean enableEmailNotification = user.isEnableEmailNotifications();
        if (!enableEmailNotification) {
            driver.findElement(By.xpath(Enum.NewUserEmailNotificationLocator.getValue())).click();
        }
        new DropDown(driver, Enum.DropDownLanguage.getValue()).select(user.getLanguage());
        new DropDown(driver, Enum.DropDownTheme.getValue()).select(user.getTheme());
       /* new DropDown(driver,"Locate").selectIn(user.getLocate());
        new DropDown(driver,"Time Zone").selectIn(user.getTimeZone());*/

        String invite = user.getTypeOfInvite();
        switch (invite) {
            case "Invite user via email":
                break;
            case "Manually specify password (no invitation is sent)":
                driver.findElement(By.id(Enum.NewUserNoInvitationIsSentLocator.getValue())).click();
                driver.findElement(By.cssSelector(Enum.NewUserSetPasswordLocator.getValue())).sendKeys(user.getPassword());
                driver.findElement(By.cssSelector(Enum.NewUserConfirmPasswordLocator.getValue())).sendKeys(user.getPassword());
                break;
        }

        switchTab(Enum.NewUserTabAccess.getValue());

        new DropDown(driver, Enum.NewUserDropDownRole.getValue()).select(user.getRole());

        boolean isUserActive = user.isThisUserIsActive();
        if (!isUserActive) {
            new Checkbox(driver, Enum.NewUserCheckboxIsActive.getValue()).click();
        }
        boolean IsUserAdministrator = user.isThisUserIaAnAdministrator();
        if (IsUserAdministrator) {
            new Checkbox(driver, Enum.NewUserCheckboxIsAdministrator.getValue()).click();
        }

        switchTab(Enum.NewUserTabProjects.getValue());
        driver.findElement(By.xpath(String.format(Enum.NewUserTabProjectProjectNameLocator.getValue(), project.getName()))).click();
        driver.findElement(By.xpath(String.format(Enum.NewUserTabProjectProjectAccessLocator.getValue(), user.getRole()))).click();


        driver.findElement(By.id(Enum.NewUserButtonAddLocator.getValue())).click();

        return new UsersRolesTab(driver);
    }

    public void switchTab(String tabName) {
        driver.findElement(By.xpath(String.format(Enum.NewUserSwitchTabLocator.getValue(), tabName))).click();
    }
}
