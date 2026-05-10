import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    // defining objects
    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator errorMessage;

    // constructor
    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("[data-test='username']");
        this.passwordInput = page.locator("[data-test='password']");
        this.loginButton = page.locator("[data-test='login-button']");
        this.errorMessage = page.locator("[data-test='error']");
    }

    // method for navigation
    public void navigateTo() {
        page.navigate("https://www.saucedemo.com/");
    }

    // login method
    public void loginAs(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    //return error message
    public String getErrorMessage() {
        return errorMessage.textContent();
    }
}
