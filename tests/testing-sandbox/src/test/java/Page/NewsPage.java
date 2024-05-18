package test.java.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsPage extends BasePage{
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public void goToNewsPage() {
        driver.get("https://www.bbc.com/news");
    }

    public void navigateBack() {
        driver.navigate().back();
    }
}
