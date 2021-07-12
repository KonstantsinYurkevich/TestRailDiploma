package tests;

import modals.Project;
import modals.ProjectFactory;
import modals.UserVariable;
import modals.UserVariableFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreatedAndDeleted() throws InterruptedException {
        boolean isOpened, IsCreated, IsDeleted;
        isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        Project project = ProjectFactory.get();
        UserVariable userVariable = UserVariableFactory.get();
        IsCreated = homePage
                .OpenDashboard()
                .addProject()
                .create(project, userVariable)
                .IsProjectExists(project);
        assertTrue(IsCreated, "Project wasn't created");
        IsDeleted = newProjectDetailsPage
                .validateProject(project)
                .OpenProjectTab()
                .deleteProject(project)
                .IsProjectDeleted(project);
        assertTrue(IsDeleted, "Project wasn't deleted");


    }

}
