import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class CheckoutPage {
    private final Page page;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator postalCodeInput;
    private final Locator continueButton;
    private final Locator finishButton;
    private final Locator completeHeader;
    private final Locator errorMessage;

    public CheckoutPage(Page page) {
        this.page = page;
        this.firstNameInput = page.locator("[data-test='firstName']");
        this.lastNameInput = page.locator("[data-test='lastName']");
        this.postalCodeInput = page.locator("[data-test='postalCode']");
        this.continueButton = page.locator("[data-test='continue']");
        this.errorMessage = page.locator("[data-test='error']");

        this.finishButton = page.locator("[data-test='finish']");
        this.completeHeader = page.locator(".complete-header");
    }

    public void fillShippingInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        postalCodeInput.fill(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public String getCompleteMessage() {
        return completeHeader.textContent();
    }

    public String getErrorMessage() {
        return errorMessage.textContent();
    }
}
