package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LogInLogOutTest extends BaseTest {

    @Test(description = "Log in Should Be Failed With Empty Email", testName = "2014")
    public void LoginShouldBeFailedWithEmptyEmail() {
        logInPage.open();
        logInPage.logIn("", PASSWORD);
        String error = logInPage.getError();
        assertEquals(error, "Email/Login is required.");
    }

    @Test(description = "Log in Should Be Failed With Empty Password", testName = "2015")
    public void LoginShouldBeFailedWithEmptyPassword() {
        logInPage.open();
        logInPage.logIn(LOGIN, "");
        String error = logInPage.getError();
        assertEquals(error, "Password is required.");
    }

    @Test(description = "Log in Should Be Failed With Incorrect Password", testName = "2016")
    public void LoginShouldBeFailedWithIncorrectPassword() {
        logInPage.open();
        logInPage.logIn(LOGIN, "123123qdqw");
        String error = logInPage.getError();
        assertEquals(error, "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(description = "Log in Should Be Failed With Incorrect Email", testName = "2017")
    public void LoginShouldBeFailedWithIncorrectEmail() {
        logInPage.open();
        logInPage.logIn("sdasdasd@gmail.com", PASSWORD);
        String error = logInPage.getError();
        assertEquals(error, "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(description = "Log in should accept correct data ", testName = "2013")
    public void logInShouldBeAcceptedWithCorrectData() {
        boolean isOpened = logInPage
                .open()
                .isPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .isPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
    }

    @Test(description = "Log out should be successful", testName = "2022")
    public void LogOutShouldGoToLogInPage() {
        boolean isOpened = logInPage
                .open()
                .isPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .isPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        isOpened = homePage
                .logout()
                .isPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
    }
}
