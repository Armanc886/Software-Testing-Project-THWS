import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InventoryTest extends BaseTest {
    @Test
    public void testProductLoadingAndCartAddition() {

        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.loginAs("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(page);

        int productCount = inventoryPage.getLoadedProductCount();
        assertEquals(6, productCount, "The expected number of products (6) did not load on the page");

        inventoryPage.addProductToCart("Sauce Labs Backpack");

        int cartCount = inventoryPage.getCartItemCount();
        assertEquals(1, cartCount, "Cart item count did not update to 1");

        inventoryPage.sortProducts("za");
        inventoryPage.goToCart();
        assertTrue(page.url().contains("cart.html"), "Failed to navigate to the cart page after clicking the cart icon");
    }

}
