package pages.tabs;

import elements.Checkbox;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import tests.base.Enum;

import static org.testng.Assert.assertEquals;

@Log4j2
public class ProjectTab extends BasePage {

    public ProjectTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(By.cssSelector(Enum.AdministrationTabProjectTabButtonAddLocator.getValue()));
    }

    public boolean IsProjectExists(Project project) {
        return isExist(By.xpath(String.format("//a[contains(text(),'%s')]", project.getName())));
    }

    @Step("Delete project")
    public HomePage deleteProject(Project project) {
        log.info("Deleting project");
        driver.findElement(By.xpath(String.format(Enum.AdministrationTabProjectTabDeleteProjectLocator.getValue(), project.getName()))).click();
        new Checkbox(driver, "Yes, delete this project (cannot be undone)").click();
        driver.findElement(By.cssSelector(Enum.AdministrationTabProjectTabDeleteProjectConfirmWindowButtonOkLocator.getValue())).click();
        String message = driver.findElement(By.cssSelector(Enum.AdministrationTabProjectTabDeleteProjectMessageSuccessLocator.getValue())).getText();
        assertEquals(message, "Successfully deleted the project.");
        return new HomePage(driver);
    }
}
