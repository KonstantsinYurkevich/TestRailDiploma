package pages;

import elements.Checkbox;
import elements.DropDown;
import elements.DropDownUserAccess;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.InviteUser;
import modals.Project;
import modals.UserVariable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.base.Enum;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Log4j2
public class NewProjectModal extends BasePage {

    public NewProjectModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(By.cssSelector(".tab-header"));
    }

    @Step("Fill in form of new account according test data ")
    public NewProjectDetailsPage create(Project project, UserVariable userVariable) throws InterruptedException {

        log.info("Fill in form of new project on new project page");
        new Input(driver, "name").writeIn(project.getName());
        new Input(driver, "announcement").writeInArea(project.getAnnouncement());
        new Checkbox(driver, "show_announcement").select(project.isShowTheAnnouncement());

        String suiteType = project.getTestSuiteType();
        if (suiteType.equals("Use a single repository with baseline support")) {
            driver.findElement(By.cssSelector("div #suite_mode_single_baseline")).click();
        } else if (suiteType.equals("Use multiple test suites to manage cases")) {
            driver.findElement(By.cssSelector("div #suite_mode_multi")).click();
        }

        switchTab(Enum.ProjectAddTabAccess.getValue());

        new DropDown(driver, Enum.DropDownProjectGlobalAccess.getValue()).select(project.getDefaultAccess());
        new DropDownUserAccess(driver, "Kanstantsin Yurkevich").select(project.getUserAccess());

        switchTab(Enum.ProjectAddTabDefects.getValue());

        new Input(driver, Enum.InputDefectViewUrl.getValue()).writeIn(project.getDefectViewURL());
        //assert that field is enabled and values saved
        String textDefectViewUrl = driver.findElement(By.xpath("//label[contains(text(),'Defect View Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).getAttribute("value");
        assertEquals(textDefectViewUrl, project.getDefectViewURL());
        driver.findElement(By.xpath("//label[contains(text(),'Defect View Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).clear();


        new Input(driver, Enum.InputDefectAddUrl.getValue()).writeIn(project.getDefectAddURL());
        //assert that field is enabled and values saved
        String textDefectAddUrl = driver.findElement(By.xpath("//label[contains(text(),'Defect Add Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).getAttribute("value");
        assertEquals(textDefectAddUrl, project.getDefectAddURL());
        driver.findElement(By.xpath("//label[contains(text(),'Defect Add Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).clear();

        new DropDown(driver, Enum.DropDownProjectDefectPlugin.getValue()).selectIn(project.getDefectPlugin());
        String defectPlugin = driver.findElement(By.xpath("//div[contains(@id,'defect_plugin_chzn')]//span")).getText();
        assertEquals(defectPlugin, project.getDefectPlugin());


        switchTab(Enum.ProjectAddTabReferences.getValue());
        new Input(driver, Enum.InputReferenceViewUrl.getValue()).writeIn(project.getReferenceViewURL());
        //assert that field is enabled and values saved
        String textReferenceViewUrl = driver.findElement(By.xpath("//label[contains(text(),'Reference View Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).getAttribute("value");
        assertEquals(textReferenceViewUrl, project.getReferenceViewURL());
        driver.findElement(By.xpath("//label[contains(text(),'Reference View Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).clear();

        new Input(driver, Enum.InputReferenceAddUrl.getValue()).writeIn(project.getReferenceAddURL());
        //assert that field is enabled and values saved
        String textReferenceAddUrl = driver.findElement(By.xpath("//label[contains(text(),'Reference Add Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).getAttribute("value");
        assertEquals(textReferenceAddUrl, project.getReferenceAddURL());
        driver.findElement(By.xpath("//label[contains(text(),'Reference Add Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).clear();

        new DropDown(driver, Enum.DropDownProjectReferencePlugin.getValue()).selectIn(project.getReferencePlugin());
        String referencePlugin = driver.findElement(By.xpath("//div[contains(@id,'reference_plugin_chzn')]//span")).getText();
        assertEquals(referencePlugin, project.getReferencePlugin());

        switchTab(Enum.ProjectAddTabUserVariables.getValue());

        driver.findElement(By.xpath("//a[ contains(text(),'Add User Variable')]")).click();
        new Input(driver, Enum.InputVariableLabel.getValue()).writeIn(userVariable.getLabel());
        new Input(driver, Enum.InputVariableDescription.getValue()).writeInArea(userVariable.getDescription());
        new Input(driver, Enum.InputVariableSystemName.getValue()).writeIn(userVariable.getSystemName());
        new DropDown(driver, "Type").select(userVariable.getType());
        buttonSubmit();

        buttonAddProject();

        return new NewProjectDetailsPage(driver);

    }

    @Step("Fill in form of new account according test data ")
    public NewProjectDetailsPage createAndAddUserToTheProject(Project project, UserVariable userVariable, InviteUser user) throws InterruptedException {
        log.info("Fill in form of new project on new project page");
        new Input(driver, "name").writeIn(project.getName());
        new Input(driver, "announcement").writeInArea(project.getAnnouncement());
        new Checkbox(driver, "show_announcement").select(project.isShowTheAnnouncement());

        String suiteType = project.getTestSuiteType();
        if (suiteType.equals("Use a single repository with baseline support")) {
            driver.findElement(By.cssSelector("div #suite_mode_single_baseline")).click();
        } else if (suiteType.equals("Use multiple test suites to manage cases")) {
            driver.findElement(By.cssSelector("div #suite_mode_multi")).click();
        }

        switchTab(Enum.ProjectAddTabAccess.getValue());

        new DropDown(driver, Enum.DropDownProjectGlobalAccess.getValue()).select(project.getDefaultAccess());
        new DropDownUserAccess(driver, user.getFullName()).select(project.getUserAccess());

        switchTab(Enum.ProjectAddTabDefects.getValue());

        new Input(driver, Enum.InputDefectViewUrl.getValue()).writeIn(project.getDefectViewURL());
        //assert that field is enabled and values saved
        String textDefectViewUrl = driver.findElement(By.xpath("//label[contains(text(),'Defect View Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).getAttribute("value");
        assertEquals(textDefectViewUrl, project.getDefectViewURL());
        driver.findElement(By.xpath("//label[contains(text(),'Defect View Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).clear();


        new Input(driver, Enum.InputDefectAddUrl.getValue()).writeIn(project.getDefectAddURL());
        //assert that field is enabled and values saved
        String textDefectAddUrl = driver.findElement(By.xpath("//label[contains(text(),'Defect Add Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).getAttribute("value");
        assertEquals(textDefectAddUrl, project.getDefectAddURL());
        driver.findElement(By.xpath("//label[contains(text(),'Defect Add Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).clear();

        new DropDown(driver, Enum.DropDownProjectDefectPlugin.getValue()).selectIn(project.getDefectPlugin());
        String defectPlugin = driver.findElement(By.xpath("//div[contains(@id,'defect_plugin_chzn')]//span")).getText();
        assertEquals(defectPlugin, project.getDefectPlugin());


        switchTab(Enum.ProjectAddTabReferences.getValue());
        new Input(driver, Enum.InputReferenceViewUrl.getValue()).writeIn(project.getReferenceViewURL());
        //assert that field is enabled and values saved
        String textReferenceViewUrl = driver.findElement(By.xpath("//label[contains(text(),'Reference View Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).getAttribute("value");
        assertEquals(textReferenceViewUrl, project.getReferenceViewURL());
        driver.findElement(By.xpath("//label[contains(text(),'Reference View Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).clear();

        new Input(driver, Enum.InputReferenceAddUrl.getValue()).writeIn(project.getReferenceAddURL());
        //assert that field is enabled and values saved
        String textReferenceAddUrl = driver.findElement(By.xpath("//label[contains(text(),'Reference Add Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).getAttribute("value");
        assertEquals(textReferenceAddUrl, project.getReferenceAddURL());
        driver.findElement(By.xpath("//label[contains(text(),'Reference Add Url')]/ancestor::div[contains" +
                "(@class,'form-group')]/input")).clear();

        new DropDown(driver, Enum.DropDownProjectReferencePlugin.getValue()).selectIn(project.getReferencePlugin());
        String referencePlugin = driver.findElement(By.xpath("//div[contains(@id,'reference_plugin_chzn')]//span")).getText();
        assertEquals(referencePlugin, project.getReferencePlugin());

        switchTab(Enum.ProjectAddTabUserVariables.getValue());

        driver.findElement(By.xpath("//a[ contains(text(),'Add User Variable')]")).click();
        new Input(driver, Enum.InputVariableLabel.getValue()).writeIn(userVariable.getLabel());
        new Input(driver, Enum.InputVariableDescription.getValue()).writeInArea(userVariable.getDescription());
        new Input(driver, Enum.InputVariableSystemName.getValue()).writeIn(userVariable.getSystemName());
        new DropDown(driver, "Type").select(userVariable.getType());
        buttonSubmit();

        buttonAddProject();

        return new NewProjectDetailsPage(driver);

    }

    @Step("Switch on tab {tabName}")
    public void switchTab(String tabName) {
        log.info("Switch on tab " + tabName);
        String locator = "#%s";
        driver.findElement(By.cssSelector(String.format(locator, tabName))).click();
        assertTrue(isExist(By.xpath(String.format("//a[@id = '%s' and contains(@class,'current')]", tabName))));
    }

    @Step("Click on button OK")
    public void buttonSubmit() {
        log.info("Click pn button OK");
        driver.findElement(By.cssSelector("#userFieldSubmit")).click();
    }

    @Step("Click on button Add Project")
    public void buttonAddProject() throws InterruptedException {
        log.info("Click on button Add Project");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#accept")).click();
    }
}
