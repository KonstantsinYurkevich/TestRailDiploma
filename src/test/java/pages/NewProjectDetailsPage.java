package pages;

import org.openqa.selenium.WebDriver;

public class NewProjectDetailsPage extends BasePage {

    public NewProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() throws InterruptedException {
        return false;
    }
}
