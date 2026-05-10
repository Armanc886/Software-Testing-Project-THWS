import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest extends BaseTest {
    @Test
    public void testProductLoadingAndCartAddition() {
        //we need to log in first
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateTo();
        loginPage.loginAs("standard_user", "secret_sauce");

        // initializing object
        InventoryPage inventoryPage = new InventoryPage(page);

        // check product count
        int productCount = inventoryPage.getLoadedProductCount();
        assertEquals(6, productCount, "The expected number of products (6) did not load on the page");

        //try adding a product to cart
        inventoryPage.addProductToCart("Sauce Labs Backpack");

        // check for cart item count update
        int cartCount = inventoryPage.getCartItemCount();
        assertEquals(1, cartCount, "Cart item count did not update to 1");

        // check sorting and goToCart
        inventoryPage.sortProducts("za");
        inventoryPage.goToCart();
        assertTrue(page.url().contains("cart.html"), "Failed to navigate to the cart page after clicking the cart icon");
    }

}
