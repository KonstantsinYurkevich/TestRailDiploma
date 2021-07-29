package tests;

import lombok.extern.log4j.Log4j2;
import modals.Project;
import modals.ProjectFactory;
import modals.UserVariable;
import modals.UserVariableFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

@Log4j2
public class AddProjectTest extends BaseTest {

    @Test(description = "Project should be created", testName = "2018")
    public void projectShouldBeCreatedAndDeleted() {
        boolean isOpened, isDeleted;
        isOpened = logInPage
                .open()
                .isPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .isPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        Project project = ProjectFactory.get();
        UserVariable userVariable = UserVariableFactory.get();
        isDeleted = homePage
                .openDashboard()
                .clickOnButtonAddProject()
                .create(project, userVariable)
                .validateProject(project)
                .openProjectTab()
                .deleteProject(project)
                .isProjectDeleted(project);
        assertTrue(isDeleted, "Project wasn't deleted");
    }
}
