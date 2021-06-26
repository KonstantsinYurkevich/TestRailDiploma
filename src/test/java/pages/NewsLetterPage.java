package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewsLetterPage extends BasePage {
    public static final By SUBSCRIBE_TITLE = By.xpath("//h1[contains(text(),'Subscribe to TestRail News')]");

    public NewsLetterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        SwitchWindow(1);
        return isExist(SUBSCRIBE_TITLE);
    }
}
