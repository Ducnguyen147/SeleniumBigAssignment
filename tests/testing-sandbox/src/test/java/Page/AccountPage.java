package test.java.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    private By yourAccountMainLocator = By.xpath("//button[@class='sc-75742244-7 QGgNL']");
    private By signoutMainLocator = By.xpath("//button[@class='sc-75742244-7 eRaTVX' and text()='Sign Out']");
    private By continueSignoutLocator = By.xpath("//a[@class='button']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDisplayed() {
        waitForVisibility(yourAccountMainLocator);
        return getText(yourAccountMainLocator).contains("Your Account");
    }

    public void signOut() {
        click(yourAccountMainLocator);
        click(signoutMainLocator);
        click(continueSignoutLocator);
    }
}

