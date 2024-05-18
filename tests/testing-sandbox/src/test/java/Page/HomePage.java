package test.java.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By homeMainLocator = By.xpath("//a[@class='sc-f116bf72-4 yKcKi']");
    private By loginLocator = By.xpath("//button[@class='sc-86c38e94-2 sc-86c38e94-5 fUqnZc ifqakP']");
    private By newsLocator = By.xpath("//a[@class='sc-f116bf72-4 eqTiTw']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeDisplayed() {
        waitForVisibility(homeMainLocator);
        return getText(homeMainLocator).contains("Home");
    }

    public void hoverOverNewsElement() {
        super.hoverOverElement(newsLocator);
    }

    public void clickLogin() {
        click(loginLocator);
    }
}

