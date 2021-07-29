package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.tabs.ProjectTab;
import tests.base.Constants;

@Log4j2
public class NewProjectDetailsPage extends BasePage {

    public NewProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        log.info("Check that Project details page opened");
        return isExist(By.cssSelector(Constants.ButtonEdit.getValue()));
    }

    @Step("Check that project exists")
    public boolean isProjectExists(Project project) {
        log.info("Check that Project exists");
        return isExist(By.xpath(String.format(Constants.ProjectListDashboardLocator.getValue(), project.getName())));
    }

    @Step("Opening project tab")
    public ProjectTab openProjectTab() {
        log.info("Opening project tab");
        driver.findElement(By.id(Constants.AdministrationTabLocator.getValue())).click();
        driver.findElement(By.id(Constants.AdministrationTabOpenProjectTabLocator.getValue())).click();
        return new ProjectTab(driver);
    }

    @Step("Validating project from data and account from site")
    //TODO new user validation using email generator (https://generator.email/)
    public NewProjectDetailsPage validateProject(Project project) {
        log.info("Validating Project");
        validateProjectName(project.getName());

        if (project.isShowAnnouncement()) {
            validateProjectAnnouncementIsShown(project.getAnnouncement());
        } else {
            validateProjectAnnouncementNotShown();
        }
        return new NewProjectDetailsPage(driver);
    }
}
