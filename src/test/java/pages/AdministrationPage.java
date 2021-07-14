package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.tabs.*;
import tests.base.Constants;

@Log4j2
public class AdministrationPage extends BasePage {

    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Check that administration tab opened")
    public boolean isPageOpened() {
        log.info("Check that administration tab opened");
        return isExist(By.cssSelector(Constants.AdministrationTabOverViewTabLocator.getValue()));
    }

    @Step("Open Project  tab")
    public ProjectTab openTabProjects() {
        log.info("Open Project settings tab");
        isExist(By.id(Constants.AdministrationTabOpenProjectTabLocator.getValue()));
        driver.findElement(By.id(Constants.AdministrationTabOpenProjectTabLocator.getValue())).click();
        return new ProjectTab(driver);
    }

    @Step("Open Users & Roles  tab")
    public UsersRolesTab openTabUsersRoles() {
        log.info("Open Users & Roles settings tab");
        isExist(By.id(Constants.AdministrationTabOpenUserAndRoleTabLocator.getValue()));
        driver.findElement(By.id(Constants.AdministrationTabOpenUserAndRoleTabLocator.getValue())).click();
        return new UsersRolesTab(driver);
    }

    @Step("Open Overview  tab")
    public OverviewTab openTabOverview() {
        log.info("Open Overview settings tab");
        isExist(By.id(Constants.AdministrationTabOpenOverViewTabLocator.getValue()));
        driver.findElement(By.id(Constants.AdministrationTabOpenOverViewTabLocator.getValue())).click();
        return new OverviewTab(driver);
    }

    @Step("Open Customizations  tab")
    public CustomizationsTab openTabCustomizations() {
        log.info("Open Customizations settings tab");
        isExist(By.id(Constants.AdministrationTabOpenCustomizationsTabLocator.getValue()));
        driver.findElement(By.id(Constants.AdministrationTabOpenCustomizationsTabLocator.getValue())).click();
        return new CustomizationsTab(driver);
    }

    @Step("Open Integration  tab")
    public IntegrationTab openTabPIntegration() {
        log.info("Open Integration settings tab");
        isExist(By.id(Constants.AdministrationTabOpenIntegrationTabLocator.getValue()));
        driver.findElement(By.id(Constants.AdministrationTabOpenIntegrationTabLocator.getValue())).click();
        return new IntegrationTab(driver);
    }

    @Step("Open Data Management  tab")
    public DataManagementTab openTabPDataManagement() {
        log.info("Open Data Management settings tab");
        isExist(By.id(Constants.AdministrationTabOpenDataManagementTabLocator.getValue()));
        driver.findElement(By.id(Constants.AdministrationTabOpenDataManagementTabLocator.getValue())).click();
        return new DataManagementTab(driver);
    }

    @Step("Open Site Settings tab")
    public SiteSettingsTab openTabSiteSettings() {
        log.info("Open Site settings tab");
        isExist(By.id(Constants.AdministrationTabOpenSiteSettingsTabLocator.getValue()));
        driver.findElement(By.id(Constants.AdministrationTabOpenSiteSettingsTabLocator.getValue())).click();
        return new SiteSettingsTab(driver);
    }
}
