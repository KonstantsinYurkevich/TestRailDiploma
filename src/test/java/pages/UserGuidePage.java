package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserGuidePage extends BasePage {
    public static final By TITLE = By.xpath("//a[contains(text(),'TestRail User Guide')]");

    public UserGuidePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        SwitchWindow(1);
        return isExist(TITLE);
    }
}
