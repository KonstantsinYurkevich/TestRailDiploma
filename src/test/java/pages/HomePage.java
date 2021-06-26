package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public static final By TITLE = By.id("navigation-dashboard");
    public static final By BUTTON_NEW_PROJECT = By.id("navigation-dashboard");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(TITLE);
    }

    @Step("Click on button new on Accounts page")
    public NewProjectModal addProject() {
        driver.findElement(BUTTON_NEW_PROJECT).click();
        return new NewProjectModal(driver);
    }

}
