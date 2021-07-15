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
        return isExist(By.cssSelector(Constants.ButtonEdit.getValue()));
    }

    public boolean isProjectExists(Project project) {
        return isExist(By.xpath(String.format(Constants.ProjectListDashboardLocator.getValue(), project.getName())));
    }

    public ProjectTab openProjectTab() {
        driver.findElement(By.id(Constants.AdministrationTabLocator.getValue())).click();
        driver.findElement(By.id(Constants.AdministrationTabOpenProjectTabLocator.getValue())).click();
        return new ProjectTab(driver);
    }

    @Step("Validating account from data and account from site")
    //TODO new user validation using email generator (https://generator.email/)
    public NewProjectDetailsPage validateProject(Project project) {
        log.info("Validating Project");
        validateProjectName(project.getName());

        if (project.isShowTheAnnouncement()) {
            validateProjectAnnouncementIsShown(project.getAnnouncement());
        } else {
            validateProjectAnnouncementNotShown();
        }
        return this;
    }
}
