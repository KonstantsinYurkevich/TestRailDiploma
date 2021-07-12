package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.base.Enum;

public class BlogPage extends BasePage {


    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return isExist(By.cssSelector(Enum.BlogPageIsOpenedLocator.getValue()));
    }
}
