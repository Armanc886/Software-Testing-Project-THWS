import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        // initialize objects
        LoginPage loginPage = new LoginPage(page);

        // perform test
        loginPage.navigateTo();
        loginPage.loginAs("standard_user", "secret_sauce");

        // assertion
        assertTrue(page.url().contains("inventory.html"), "Failed to navigate to the inventory page after successful login");
    }

    @Test
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateTo();
        loginPage.loginAs("locked_out_user", "secret_sauce");

        // assertion
        String expectedMessage = "Sorry, this user has been locked out.";
        assertTrue(loginPage.getErrorMessage().contains(expectedMessage), "Locked out user error message is missing or incorrect");
    }
}
