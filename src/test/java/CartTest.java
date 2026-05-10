import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CartTest extends BaseTest {

    @Test
    public void testCartItemRemoval() {

        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.loginAs("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(page);

        assertEquals(1, cartPage.getCartItemCount(), "There should be exactly 1 item in the cart.");

        cartPage.removeProduct("Sauce Labs Bike Light");
        assertEquals(0, cartPage.getCartItemCount(), "The cart should be empty after the item is removed.");
    }
}
