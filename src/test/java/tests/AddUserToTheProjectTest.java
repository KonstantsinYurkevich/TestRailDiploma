package tests;

import modals.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddUserToTheProjectTest extends BaseTest {

    @Test(description = "Create project, create user, add created user to the new project")
    public void newUserShouldBeAddedToTheNewProject() {
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
        homePage
                .addProject()
                .create(project, userVariable)
                .validateProject(project);
        isOpened = homePage
                .openAdministrationTab()
                .isPageOpened();
        assertTrue(isOpened, "Administration page dowasn't opened");
        isOpened = administrationPage
                .openTabUsersRoles()
                .isPageOpened();
        assertTrue(isOpened, "Project page from Administration tab wasn't opened");
        User user = UserFactory.get();
        usersRolesTab
                .clickButtonAddUser()
                .addNewUserToTheProject(project, user);
        isDeleted = administrationPage
                .openTabProjects()
                .deleteProject(project)
                .isProjectDeleted(project);
        assertTrue(isDeleted, "Project wasn't deleted");
    }

    @Test(description = "Create project and add existing user to thw new project")
    public void existingUserShouldBeAddedToTheNewProject() {
        boolean isOpened, isDeleted;
        isOpened = logInPage
                .open()
                .isPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .isPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        isOpened = homePage
                .openAdministrationTab()
                .isPageOpened();
        assertTrue(isOpened, "Administration page wasn't opened");
        isOpened = administrationPage
                .openTabUsersRoles()
                .isPageOpened();
        assertTrue(isOpened, "Project page from Administration tab wasn't opened");
        User user = UserFactory.get();
        usersRolesTab
                .clickButtonAddUser()
                .addUser(user);
        Project project = ProjectFactory.get();
        UserVariable userVariable = UserVariableFactory.get();
        isDeleted = homePage
                .openDashboard()
                .addProject()
                .createAndAddUserToTheProject(project, userVariable, user)
                .validateProject(project)
                .openProjectTab()
                .deleteProject(project)
                .isProjectDeleted(project);
        assertTrue(isDeleted, "Project wasn't deleted");
    }
}
