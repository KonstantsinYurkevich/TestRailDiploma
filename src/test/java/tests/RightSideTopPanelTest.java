package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;


public class RightSideTopPanelTest extends BaseTest {

    @Test (description = "Test lint on TestRail blog")
    public void buttonNewsLetterLinkShouldGoOnTestRailBlog() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page doesn't open");
        isOpened = logInPage
                .logIn()
                .IsPageOpened();
        assertTrue(isOpened, "Home page doesn't open");
        isOpened = homePage
                .clickOnBlogLink()
                .IsPageOpened();
        assertTrue(isOpened, "Blog page doesn't open");

    }
    @Test (description = "Test lint on TestRail twitter")
    public void buttonTwitterLinkShouldGoOnTestRailTwitterPage() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page doesn't open");
        isOpened = logInPage
                .logIn()
                .IsPageOpened();
        assertTrue(isOpened, "Home page doesn't open");
        isOpened = homePage
                .clickOnTwitterLink()
                .IsPageOpened();
        assertTrue(isOpened, "Twitter page doesn't open");

    }
    @Test (description = "Test lint on TestRail twitter")
    public void buttonTestRailUserGuideShouldOpenGuide() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page doesn't open");
        isOpened = logInPage
                .logIn()
                .IsPageOpened();
        assertTrue(isOpened, "Home page doesn't open");
        isOpened = homePage
                .clickOnUserGuideLink()
                .IsPageOpened();
        assertTrue(isOpened, "User guide page doesn't open");

    }
}
