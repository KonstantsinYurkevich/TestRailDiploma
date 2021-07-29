package tests.base;

import adapters.ProjectTestRun;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import modals.NewProjectModal;
import modals.ResponseStatus;
import modals.TestRun;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.AdministrationPage;
import pages.HomePage;
import pages.LogInPage;
import pages.NewProjectDetailsPage;
import pages.tabs.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import com.google.common.collect.ImmutableMap;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {

    public static final String LOGIN = System.getenv().getOrDefault("TESTRAIL_USER", PropertyReader.getProperty("testrail.user"));
    public static final String PASSWORD = System.getenv().getOrDefault("TESTRAIL_PASSWORD", PropertyReader.getProperty("testrail.password"));

    protected static int runId;
    protected LogInPage logInPage;
    protected HomePage homePage;
    protected NewProjectModal addProjectPage;
    protected NewProjectDetailsPage newProjectDetailsPage;
    protected AdministrationPage administrationPage;
    protected ProjectTab projectTab;
    protected UsersRolesTab usersRolesTab;
    protected OverviewTab overviewTab;
    protected CustomizationsTab customizationsTab;
    protected IntegrationTab integrationTab;
    protected DataManagementTab dataManagementTab;
    protected SiteSettingsTab siteSettingsTab;
    WebDriver driver;



    @BeforeSuite
    public void testRunCreate(ITestContext context) {
        ProjectTestRun testRunAdapter = new ProjectTestRun();
        String suiteName = context.getCurrentXmlTest().getSuite().getName();
        if (suiteName.equals("Regression Test suite")) {
            TestRun testRun = TestRun.builder()
                    .name("Test run " + context.getSuite().getName() + " - " + context.getStartDate())
                    .includeAll(true)
                    .build();
            ResponseStatus actual = testRunAdapter.create(testRun, 200, 36);
            runId = Integer.parseInt(actual.getId());
        } else if (suiteName.equals("Smoke Test suite")) {
            ListOfCaseIdSmokeSuite listCaseId = new ListOfCaseIdSmokeSuite();
            TestRun testRun = TestRun.builder()
                    .name("Test run " + context.getSuite().getName() + " - " + context.getStartDate())
                    .includeAll(false)
                    .caseIds(listCaseId.getList())
                    .build();
            ResponseStatus actual = testRunAdapter.create(testRun, 200, 36);
            runId = Integer.parseInt(actual.getId());
        }
    }
    @BeforeSuite
    public void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("OS", "Linux")
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "86.0.4240.22")
                        .build(),System.getProperty("allure.results.directory")
                );
    }


    @Parameters({"browser"})
    @BeforeMethod

    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            Map<String, Object> prefs = new HashMap<>();
            ChromeOptions options = new ChromeOptions();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-dev-shm-usage");
            WebDriverManager.chromedriver().setup();
            options.addArguments("--no-sandbox");
            options.addArguments("--start-maximized");
            /* options.addArguments("--headless");*/
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            /* options.addArguments("--headless");*/
            options.addPreference("disable_beforeunload", false);
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage = new LogInPage(driver);
        homePage = new HomePage(driver);
        administrationPage = new AdministrationPage(driver);
        projectTab = new ProjectTab(driver);
        usersRolesTab = new UsersRolesTab(driver);
        overviewTab = new OverviewTab(driver);
        customizationsTab = new CustomizationsTab(driver);
        integrationTab = new IntegrationTab(driver);
        dataManagementTab = new DataManagementTab(driver);
        siteSettingsTab = new SiteSettingsTab(driver);
        addProjectPage = new NewProjectModal(driver);
        newProjectDetailsPage = new NewProjectDetailsPage(driver);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.quit();

    }
    public static int getRunId() {
        return runId;
    }
}
