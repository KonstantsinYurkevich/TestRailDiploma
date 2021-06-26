package tests;

import modals.Project;
import modals.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddProjectTest extends BaseTest {
    @Test
    public void createProjectTest() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page doesn't open");
        isOpened = logInPage
                .logIn()
                .IsPageOpened();
        assertTrue(isOpened, "Home page doesn't open");
        Project project = ProjectFactory.get();
        homePage
                .addProject()
                .create(project);
        /*.validateProject(project)*/

    }
}
