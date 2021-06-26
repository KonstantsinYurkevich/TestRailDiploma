package pages;

import elements.Checkbox;
import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.base.Enum;

import static org.testng.AssertJUnit.assertTrue;

@Log4j2
public class NewProjectModal extends BasePage {

    public NewProjectModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() throws InterruptedException {
        return false;
    }

    @Step("Fill in form of new account according test data ")
    public NewProjectDetailsPage create(Project project) {
        log.info("Fill in form of new project on new project page");
        new Input(driver, "name").writeIn(project.getName());
        new Input(driver, "announcement").writeInArea(project.getAnnouncement());
        new Checkbox(driver, "show_announcement").select(project.isShowTheAnnouncement());
        new Checkbox(driver, project.getTestSuiteType()).click();
        switchTab(Enum.ProjectAddTabAccess.getValue());
        new DropDown(driver).selectOption(project.getDefaultAccess());


        switchTab(Enum.ProjectAddTabDefects.getValue());


        switchTab(Enum.ProjectAddTabReferences.getValue());


        switchTab(Enum.ProjectAddTabUserVariables.getValue());

        return new NewProjectDetailsPage(driver);
    }

    public void switchTab(String tabName) {
        String locator = "#%s";
        driver.findElement(By.cssSelector(String.format(locator, tabName))).click();
        String isOpened = "//a[@id = '%s' and contains(@class,'current')]";
        boolean switched = driver.findElement(By.xpath(isOpened)).isSelected();
        assertTrue(switched);
    }
}
