package pages;

import org.openqa.selenium.WebDriver;

public class TwitterPage extends BasePage {

    public TwitterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        SwitchWindow(1);
        return driver.getPageSource().contains("twitter");
    }
}
