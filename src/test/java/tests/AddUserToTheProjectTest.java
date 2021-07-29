package tests;

import modals.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddUserToTheProjectTest extends BaseTest {

    @Test(description = "User should be added to the project in Add User form", testName = "2021")
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
                .clickOnButtonAddProject()
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
        isDeleted = usersRolesTab
                .clickButtonAddUser()
                .addNewUserToTheProject(project, user)
                .openProjectTab()
                .deleteProject(project)
                .isProjectDeleted(project);
        assertTrue(isDeleted, "Project wasn't deleted");
    }

    @Test(description = "Existing User should be added to the project", testName = "2020")
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
                .clickOnButtonAddProject()
                .createAndAddUserToTheProject(project, userVariable, user)
                .validateProject(project)
                .openProjectTab()
                .deleteProject(project)
                .isProjectDeleted(project);
        assertTrue(isDeleted, "Project wasn't deleted");
    }
}
