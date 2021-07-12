package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;


public class RightSideTopPanelTest extends BaseTest {

    @Test(description = "Test link on TestRail blog")
    public void buttonNewsLetterLinkShouldGoOnTestRailBlog() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        isOpened = homePage
                .clickOnBlogLink()
                .IsPageOpened();
        assertTrue(isOpened, "Blog page wasn't opened");

    }

    @Test(description = "Test link on TestRail twitter")
    public void buttonTwitterLinkShouldGoOnTestRailTwitterPage() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        isOpened = homePage
                .clickOnTwitterLink()
                .IsPageOpened();
        assertTrue(isOpened, "Twitter page wasn't opened");

    }

    @Test(description = "Test link on TestRail newsletter")
    public void buttonNewsLetterLinkShouldGoOnTestRailNewsLetterPage() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        isOpened = homePage
                .clickOnNewsLetterLink()
                .IsPageOpened();
        assertTrue(isOpened, "News letter page wasn't opened");

    }

    @Test(description = "Test lint on TestRail user guide")
    public void buttonTestRailUserGuideShouldOpenGuide() {
        boolean isOpened = logInPage
                .open()
                .IsPageOpened();
        assertTrue(isOpened, "LogIn page wasn't opened");
        isOpened = logInPage
                .logIn(LOGIN, PASSWORD)
                .IsPageOpened();
        assertTrue(isOpened, "Home page wasn't opened");
        isOpened = homePage
                .clickOnUserGuideLink()
                .IsPageOpened();
        assertTrue(isOpened, "User guide page wasn't opened");
    }
}
