package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LogInTest extends BaseTest {
    @Test(description = "LogIn test")
    public void logIn() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page doesn't open");
        isOpened = logInPage
                .logIn()
                .IsPageOpened();
        assertTrue(isOpened, "Home page doesn't open");
    }
}
