package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {
    public static final By BLOG = By.cssSelector("div >[type=\"submit\"]");

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(BLOG);
    }
}
