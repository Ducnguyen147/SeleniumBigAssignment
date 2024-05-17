package test.java.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By usernameLoginLocator = By.xpath("//input[@id='user-identifier-input']");
    private By continueButtonLocator = By.xpath("//button[@id='submit-button']");
    private By pwLoginLocator = By.xpath("//input[@id='password-input']");
    private By buttonSigninLocator = By.xpath("//button[@id='submit-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        type(usernameLoginLocator, username);
        click(continueButtonLocator);
    }

    public void enterPassword(String password) {
        type(pwLoginLocator, password);
        click(buttonSigninLocator);
    }
}

