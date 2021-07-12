package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.base.Enum;

@Log4j2
public class HomePage extends BasePage {

    public static final By TITLE = By.id("navigation-dashboard");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(TITLE);
    }

    @Step("Click on button new on Accounts page")
    public NewProjectModal addProject() {
        log.info("Click on button new on Accounts page");
        driver.findElement(By.cssSelector(Enum.HomePageButtonNewProjectLocator.getValue())).click();
        return new NewProjectModal(driver);
    }


    @Step("Check that project deleted")
    public boolean IsProjectDeleted(Project project) {
        log.info("Check that project was deleted");
        driver.findElement(By.cssSelector("#navigation-dashboard")).click();
        return isExists(By.xpath(String.format("//a[contains(text(),'%s')]", project.getName())));
    }

    @Step("Click on tab Dashboard")
    public HomePage OpenDashboard() {
        log.info("Click on tab Dashboard");
        driver.findElement(By.cssSelector("#navigation-dashboard")).click();
        return this;
    }

}
