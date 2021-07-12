package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.tabs.*;
import tests.base.Enum;

@Log4j2
public class AdministrationPage extends BasePage {

    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Check that administration tab opened")
    public boolean IsPageOpened() {
        log.info("Check that administration tab opened");
        return isExist(By.cssSelector(Enum.AdministrationTabOverViewTabLocator.getValue()));
    }

    @Step("Open Project settings tab")
    public ProjectTab OpenTabProjects() {
        log.info("Open Project settings tab");
        isExist(By.id(Enum.AdministrationTabOpenProjectTabLocator.getValue()));
        driver.findElement(By.id(Enum.AdministrationTabOpenProjectTabLocator.getValue())).click();
        return new ProjectTab(driver);
    }

    //TODO по всему проекту названия методов с маленькой буквы
    //TODO не работает открытие вкладки
    @Step("Open Users & Roles settings tab")
    public UsersRolesTab OpenTabUsersRoles() {
        log.info("Open Users & Roles settings tab");
        isExist(By.id(Enum.AdministrationTabOpenUserAndRoleTabLocator.getValue()));
        driver.findElement(By.id(Enum.AdministrationTabOpenUserAndRoleTabLocator.getValue())).click();
        return new UsersRolesTab(driver);
    }

    @Step("Open Overview settings tab")
    public OverviewTab OpenTabOverview() {
        log.info("Open Overview settings tab");
        isExist(By.id(Enum.AdministrationTabOpenOverViewTabLocator.getValue()));
        driver.findElement(By.id(Enum.AdministrationTabOpenOverViewTabLocator.getValue())).click();
        return new OverviewTab(driver);
    }

    @Step("Open Customizations settings tab")
    public CustomizationsTab OpenTabCustomizations() {
        log.info("Open Customizations settings tab");
        isExist(By.id(Enum.AdministrationTabOpenCustomizationsTabLocator.getValue()));
        driver.findElement(By.id(Enum.AdministrationTabOpenCustomizationsTabLocator.getValue())).click();
        return new CustomizationsTab(driver);
    }

    @Step("Open Integration settings tab")
    public IntegrationTab OpenTabPIntegration() {
        log.info("Open Integration settings tab");
        isExist(By.id(Enum.AdministrationTabOpenIntegrationTabLocator.getValue()));
        driver.findElement(By.id(Enum.AdministrationTabOpenIntegrationTabLocator.getValue())).click();
        return new IntegrationTab(driver);
    }

    @Step("Open Data Management settings tab")
    public DataManagementTab OpenTabPDataManagement() {
        log.info("Open Data Management settings tab");
        isExist(By.id(Enum.AdministrationTabOpenDataManagementTabLocator.getValue()));
        driver.findElement(By.id(Enum.AdministrationTabOpenDataManagementTabLocator.getValue())).click();
        return new DataManagementTab(driver);
    }

    @Step("Open Site settings tab")
    public SiteSettingsTab OpenTabSiteSettings() {
        log.info("Open Site settings tab");
        isExist(By.id(Enum.AdministrationTabOpenSiteSettingsTabLocator.getValue()));
        driver.findElement(By.id(Enum.AdministrationTabOpenSiteSettingsTabLocator.getValue())).click();
        return new SiteSettingsTab(driver);
    }
}
