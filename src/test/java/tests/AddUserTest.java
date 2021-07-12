package tests;

import modals.InviteUser;
import modals.InviteUserFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddUserTest extends BaseTest {
    //TODO добавить названия тестов
    @Test
    public void userShouldBeCreated() {
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

    }
}
