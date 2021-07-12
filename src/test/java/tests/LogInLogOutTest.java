package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class LogInLogOutTest extends BaseTest {

    @DataProvider(name = "Login data")
    public Object[][] logInaData() {
        return new Object[][]{
                {"", PASSWORD, "Email/Login is required."},
                {LOGIN, "", "Password is required."},
                {LOGIN, "asddsadas", "Email/Login or Password is incorrect. Please try again."},
                {"qweqweqw", PASSWORD, "Email/Login or Password is incorrect. Please try again."},
        };
    }

    @Test(description = "Login tests", dataProvider = "Login data")
    public void logInTest(String user, String password, String errorMessage) {
        logInPage.open();
        logInPage.logIn(user, password);
        String error = logInPage.getError();
        assertEquals(error, errorMessage);
    }

    @Test(description = "LogIn test")
    public void logInShouldBeAcceptedWithCorrectData() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
    }

    @Test(description = "LogOut test")
    public void LogOutShouldGoToLogInPage() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        isOpened = homePage
                .logout()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
    }
}
