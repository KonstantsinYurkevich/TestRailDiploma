package tests;

import modals.User;
import modals.UserFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddUserTest extends BaseTest {

    @Test(description = "User should be added in to account", testName = "2019")
    public void userShouldBeCreated() {
        boolean isOpened = logInPage
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

    }
}
