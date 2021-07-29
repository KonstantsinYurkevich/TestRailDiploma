package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.NewProjectModal;
import modals.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.base.Constants;

@Log4j2
public class HomePage extends BasePage {

    public static final By TITLE = By.id(Constants.DashboardTabLocator.getValue());

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(TITLE);
    }

    @Step("Click on button new on Projects page")
    public NewProjectModal clickOnButtonAddProject() {
        log.info("Click on button new on Projects page");
        driver.findElement(By.cssSelector(Constants.HomePageButtonNewProjectLocator.getValue())).click();
        return new NewProjectModal(driver);
    }


    @Step("Check that project deleted")
    public boolean isProjectDeleted(Project project) {
        log.info("Check that project was deleted");
        driver.findElement(By.id(Constants.DashboardTabLocator.getValue())).click();
        return isExists(By.xpath(String.format(Constants.ProjectListDashboardLocator.getValue(), project.getName())));
    }

    @Step("Click on tab Dashboard")
    public HomePage openDashboard() {
        log.info("Click on tab Dashboard");
        driver.findElement(By.id(Constants.DashboardTabLocator.getValue())).click();
        return new HomePage(driver);
    }

}
