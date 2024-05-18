package test.java.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private UsernamePage username;
    private PasswordPage password;
    private By errorMessageLocator = By.xpath("//p[@class='sb-form-message__content__text']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.username = new UsernamePage(driver);
        this.password = new PasswordPage(driver);
    }

    public void enterUsername(String usernameText) {
        username.enterUsername(usernameText);
        username.clickContinue();
    }

    public void enterPassword(String passwordText) {
        password.enterPassword(passwordText);
        password.clickSignin();
    }

    public boolean isWrongUsername() {
        waitForVisibility(errorMessageLocator);
        System.out.println("Error message text: " + getText(errorMessageLocator));
        return getText(errorMessageLocator).contains("You can try again");
    }
}
