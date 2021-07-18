package modals;

import elements.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.NewProjectDetailsPage;
import tests.base.Constants;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Log4j2
public class NewProjectModal extends BasePage {

    public NewProjectModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(By.id(Constants.ButtonAcceptAdd.getValue()));
    }

    @Step("Fill in form of new project according test data ")
    public NewProjectDetailsPage create(Project project, UserVariable userVariable) {

        log.info("Fill in form of new project on new project page");
        new Input(driver, Constants.FieldName.getValue()).writeIn(project.getName());
        new Input(driver, Constants.FieldAnnouncement.getValue()).writeInArea(project.getAnnouncement());
        new CheckBox(driver, Constants.CheckBoxAnnouncement.getValue()).select(project.isShowTheAnnouncement());

        String suiteType = project.getTestSuiteType();
        if (suiteType.equals(Constants.CheckBoxUseASingleRepositoryWithBaselineSupportLocator.getValue())) {
            new CheckBox(driver, Constants.CheckBoxUseASingleRepositoryWithBaselineSupportLocator.getValue()).option();
        } else if (suiteType.equals(Constants.CheckBoxUseMultipleTestSuitesToManageCasesLocator.getValue())) {
            new CheckBox(driver, Constants.CheckBoxUseMultipleTestSuitesToManageCasesLocator.getValue()).option();
        }

        switchTab(Constants.ProjectAddTabAccess.getValue());

        new DropDownSelect(driver, Constants.DropDownProjectGlobalAccess.getValue()).option(project.getDefaultAccess());
        new DropDownUserAccess(driver, "Kanstantsin Yurkevich").select(project.getUserAccess());

        switchTab(Constants.ProjectAddTabDefects.getValue());

        new Input(driver, Constants.InputDefectViewUrl.getValue()).writeIn(project.getDefectViewURL());
        String textDefectViewUrl = driver.findElement(By.xpath(Constants.FieldDefectViewURLLocator.getValue()))
                .getAttribute("value");
        assertEquals(textDefectViewUrl, project.getDefectViewURL());
        driver.findElement(By.xpath(Constants.FieldDefectViewURLLocator.getValue())).clear();


        new Input(driver, Constants.InputDefectAddUrl.getValue()).writeIn(project.getDefectAddURL());
        //assert that field is enabled and values saved
        String textDefectAddUrl = driver.findElement(By.xpath(Constants.FieldDefectAddURLLocator.getValue()))
                .getAttribute("value");
        assertEquals(textDefectAddUrl, project.getDefectAddURL());
        driver.findElement(By.xpath(Constants.FieldDefectAddURLLocator.getValue())).clear();
        new DropDownSearch(driver, Constants.DropDownProjectDefectPlugin.getValue()).select(project.getDefectPlugin());
        String defectPlugin = driver.findElement(By.xpath(Constants.DefectPluginInputLocator.getValue())).getText();
        assertEquals(defectPlugin, project.getDefectPlugin());

        switchTab(Constants.ProjectAddTabReferences.getValue());

        new Input(driver, Constants.InputReferenceViewUrl.getValue()).writeIn(project.getReferenceViewURL());
        //assert that field is enabled and values saved
        String textReferenceViewUrl = driver.findElement(By.xpath(Constants.FieldReferenceViewURLLocator.getValue()))
                .getAttribute("value");
        assertEquals(textReferenceViewUrl, project.getReferenceViewURL());
        driver.findElement(By.xpath(Constants.FieldReferenceViewURLLocator.getValue())).clear();
        new Input(driver, Constants.InputReferenceAddUrl.getValue()).writeIn(project.getReferenceAddURL());
        //assert that field is enabled and values saved
        String textReferenceAddUrl = driver.findElement(By.xpath(Constants.FieldReferenceAddURLLocator.getValue()))
                .getAttribute("value");
        assertEquals(textReferenceAddUrl, project.getReferenceAddURL());
        driver.findElement(By.xpath(Constants.FieldReferenceAddURLLocator.getValue())).clear();

        new DropDownSearch(driver, Constants.DropDownProjectReferencePlugin.getValue()).select(project.getReferencePlugin());
        String referencePlugin = driver.findElement(By.xpath(Constants.ReferencePluginInputLocator.getValue())).getText();
        assertEquals(referencePlugin, project.getReferencePlugin());

        switchTab(Constants.ProjectAddTabUserVariables.getValue());

        driver.findElement(By.xpath(Constants.ButtonAddUserVariableLocator.getValue())).click();
        new Input(driver, Constants.InputVariableLabel.getValue()).writeIn(userVariable.getLabel());
        new Input(driver, Constants.InputVariableDescription.getValue()).writeInArea(userVariable.getDescription());
        new Input(driver, Constants.InputVariableSystemName.getValue()).writeIn(userVariable.getSystemName());
        new DropDownSelect(driver, Constants.DropDownSelectType.getValue()).option(userVariable.getType());
        buttonSubmit();

        buttonAddProject();

        return new NewProjectDetailsPage(driver);

    }

    @Step("Fill in form of new project according test data ")
    public NewProjectDetailsPage createAndAddUserToTheProject(Project project, UserVariable userVariable, User user) {
        log.info("Fill in form of new project on new project page");
        new Input(driver, Constants.FieldName.getValue()).writeIn(project.getName());
        new Input(driver, Constants.FieldAnnouncement.getValue()).writeInArea(project.getAnnouncement());
        new CheckBox(driver, Constants.CheckBoxAnnouncement.getValue()).select(project.isShowTheAnnouncement());

        String suiteType = project.getTestSuiteType();
        if (suiteType.equals(Constants.CheckBoxUseASingleRepositoryWithBaselineSupportLocator.getValue())) {
            new CheckBox(driver, Constants.CheckBoxUseASingleRepositoryWithBaselineSupportLocator.getValue()).option();
        } else if (suiteType.equals(Constants.CheckBoxUseMultipleTestSuitesToManageCasesLocator.getValue())) {
            new CheckBox(driver, Constants.CheckBoxUseMultipleTestSuitesToManageCasesLocator.getValue()).option();
        }

        switchTab(Constants.ProjectAddTabAccess.getValue());

        new DropDownSelect(driver, Constants.DropDownProjectGlobalAccess.getValue()).option(project.getDefaultAccess());
        new DropDownUserAccess(driver, user.getFullName()).select(project.getUserAccess());

        switchTab(Constants.ProjectAddTabDefects.getValue());

        new Input(driver, Constants.InputDefectViewUrl.getValue()).writeIn(project.getDefectViewURL());
        String textDefectViewUrl = driver.findElement(By.xpath(Constants.FieldDefectViewURLLocator.getValue()))
                .getAttribute("value");
        assertEquals(textDefectViewUrl, project.getDefectViewURL());
        driver.findElement(By.xpath(Constants.FieldDefectViewURLLocator.getValue())).clear();
        new Input(driver, Constants.InputDefectAddUrl.getValue()).writeIn(project.getDefectAddURL());
        //assert that field is enabled and values saved
        String textDefectAddUrl = driver.findElement(By.xpath(Constants.FieldDefectAddURLLocator.getValue()))
                .getAttribute("value");
        assertEquals(textDefectAddUrl, project.getDefectAddURL());
        driver.findElement(By.xpath(Constants.FieldDefectAddURLLocator.getValue())).clear();
        new DropDownSearch(driver, Constants.DropDownProjectDefectPlugin.getValue()).select(project.getDefectPlugin());
        String defectPlugin = driver.findElement(By.xpath(Constants.DefectPluginInputLocator.getValue())).getText();
        assertEquals(defectPlugin, project.getDefectPlugin());

        switchTab(Constants.ProjectAddTabReferences.getValue());

        new Input(driver, Constants.InputReferenceViewUrl.getValue()).writeIn(project.getReferenceViewURL());
        //assert that field is enabled and values saved
        String textReferenceViewUrl = driver.findElement(By.xpath(Constants.FieldReferenceViewURLLocator.getValue()))
                .getAttribute("value");
        assertEquals(textReferenceViewUrl, project.getReferenceViewURL());
        driver.findElement(By.xpath(Constants.FieldReferenceViewURLLocator.getValue())).clear();
        new Input(driver, Constants.InputReferenceAddUrl.getValue()).writeIn(project.getReferenceAddURL());
        //assert that field is enabled and values saved
        String textReferenceAddUrl = driver.findElement(By.xpath(Constants.FieldReferenceAddURLLocator.getValue()))
                .getAttribute("value");
        assertEquals(textReferenceAddUrl, project.getReferenceAddURL());
        driver.findElement(By.xpath(Constants.FieldReferenceAddURLLocator.getValue())).clear();

        new DropDownSearch(driver, Constants.DropDownProjectReferencePlugin.getValue()).select(project.getReferencePlugin());
        String referencePlugin = driver.findElement(By.xpath(Constants.ReferencePluginInputLocator.getValue())).getText();
        assertEquals(referencePlugin, project.getReferencePlugin());

        switchTab(Constants.ProjectAddTabUserVariables.getValue());

        driver.findElement(By.xpath(Constants.ButtonAddUserVariableLocator.getValue())).click();
        new Input(driver, Constants.InputVariableLabel.getValue()).writeIn(userVariable.getLabel());
        new Input(driver, Constants.InputVariableDescription.getValue()).writeInArea(userVariable.getDescription());
        new Input(driver, Constants.InputVariableSystemName.getValue()).writeIn(userVariable.getSystemName());
        new DropDownSelect(driver, Constants.DropDownSelectType.getValue()).option(userVariable.getType());

        buttonSubmit();

        buttonAddProject();

        return new NewProjectDetailsPage(driver);
    }

    @Step("Switch on tab {tabName}")
    public void switchTab(String tabName) {
        log.info("Switch on tab " + tabName);
        String locator = "#%s";
        driver.findElement(By.cssSelector(String.format(locator, tabName))).click();
        assertTrue(isExist(By.xpath(String.format(Constants.SwitchTabLocator.getValue(), tabName))));
    }

    @Step("Click on button OK")
    public void buttonSubmit() {
        log.info("Click pn button OK");
        driver.findElement(By.id(Constants.ButtonOkLocator.getValue())).click();
    }

    @Step("Click on button Add Project")
    public void buttonAddProject() {
        log.info("Click on button Add Project");
        WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                presenceOfElementLocated(By.id(Constants.ButtonAcceptAdd.getValue())));
        explicitWait.click();
    }
}
