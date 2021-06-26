package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LogInLogOutTest extends BaseTest {

    @Test(description = "LogIn test")
    public void logInShouldBeAcceptedWithCorrectData() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page doesn't open");
        isOpened = logInPage
                .logIn()
                .IsPageOpened();
        assertTrue(isOpened, "Home page doesn't open");
    }

    @Test(description = "LogOut test")
    public void LogOutShouldGoToLogInPage() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page doesn't open");
        isOpened = logInPage
                .logIn()
                .IsPageOpened();
        assertTrue(isOpened, "Home page doesn't open");
        isOpened = homePage
                .logout()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page doesn't open");
    }
}
