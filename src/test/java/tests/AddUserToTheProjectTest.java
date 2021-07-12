package tests;

import modals.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddUserToTheProjectTest extends BaseTest {

    @Test
    public void newUserShouldBeAddedToTheNewProject() throws InterruptedException {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        Project project = ProjectFactory.get();
        UserVariable userVariable = UserVariableFactory.get();
        homePage
                .addProject()
                .create(project, userVariable)
                .validateProject(project);
        isOpened = homePage
                .OpenAdministrationTab()
                .IsPageOpened();
        assertTrue(isOpened, "Administration page dowasn't opened");
        isOpened = administrationPage
                .OpenTabUsersRoles()
                .IsPageOpened();
        assertTrue(isOpened, "Project page from Administration tab wasn't opened");
        InviteUser user = InviteUserFactory.get();
        usersRolesTab
                .clickButtonAddUser()
                .AddNewUserToTheProject(project, user);
    }

    @Test
    public void existingUserShouldBeAddedToTheNewProject() throws InterruptedException {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        isOpened = homePage
                .OpenAdministrationTab()
                .IsPageOpened();
        assertTrue(isOpened, "Administration page wasn't opened");
        isOpened = administrationPage
                .OpenTabUsersRoles()
                .IsPageOpened();
        assertTrue(isOpened, "Project page from Administration tab wasn't opened");
        InviteUser user = InviteUserFactory.get();
        usersRolesTab
                .clickButtonAddUser()
                .AddUser(user);
        Project project = ProjectFactory.get();
        UserVariable userVariable = UserVariableFactory.get();
        homePage
                .OpenDashboard()
                .addProject()
                .createAndAddUserToTheProject(project, userVariable, user);
    }
}
