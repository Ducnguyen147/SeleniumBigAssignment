package test.java.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    private By yourAccountMainLocator = By.xpath("//button[@class='sc-75742244-7 QGgNL']");
    private By signoutMainLocator = By.xpath("//button[@class='sc-75742244-7 eRaTVX' and text()='Sign Out']");
    private By continueSignoutLocator = By.xpath("//a[@class='button']");
    private By searchLocator = By.xpath("//button[@class='sc-75742244-3 sc-75742244-4 eupXpe hKHSDc']");
    private By searchTextLocator = By.xpath("//input[@class='sc-e1a87ea7-1 iARAvt']");
    private By searchSendFormLocator = By.xpath("//button[@data-testid='search-input-search-button' and contains(@class, 'sc-248b48c6-2')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDisplayed() {
        waitForVisibility(yourAccountMainLocator);
        return getText(yourAccountMainLocator).contains("Your Account");
    }

    public void sendFormAfterLogin() {
        WebElement searchIconButton = wait.until(ExpectedConditions.elementToBeClickable(searchLocator));
        searchIconButton.click();
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextLocator));
        searchInput.sendKeys("news");
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchSendFormLocator));
        searchButton.click();
    }

    public void signOut() {
        click(yourAccountMainLocator);
        click(signoutMainLocator);
        click(continueSignoutLocator);
    }
}

