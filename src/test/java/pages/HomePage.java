package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public static final By TITLE = By.id("navigation-dashboard");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(TITLE);
    }

}
