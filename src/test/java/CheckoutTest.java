import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CheckoutTest extends BaseTest {

    @Test
    public void testSuccessfulCheckoutHappyPath() {

        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.loginAs("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.addProductToCart("Sauce Labs Fleece Jacket");
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.fillShippingInformation("John", "Doe", "90210");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        String expectedCompleteMessage = "Thank you for your order!";
        assertEquals(expectedCompleteMessage, checkoutPage.getCompleteMessage(),
            "The order completion message did not match the expected text.");
    }

    @Test
    public void testCheckoutFormValidation() {

        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.loginAs("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.addProductToCart("Sauce Labs Onesie");
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.clickContinue();

        String expectedErrorMessage = "Error: First Name is required";
        assertEquals(expectedErrorMessage, checkoutPage.getErrorMessage(),
            "The form validation error message is missing or incorrect.");
    }
}
