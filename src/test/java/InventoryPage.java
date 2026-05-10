import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InventoryPage {
    //defining objects
    private final Page page;
    private final Locator cartIcon;
    private final Locator cartBadge;
    private final Locator sortDropdown;
    private final Locator inventoryItems;

    //const.
    public InventoryPage(Page page) {
        this.page = page;
        this.cartIcon = page.locator(".shopping_cart_link");
        this.cartBadge = page.locator(".shopping_cart_badge");
        this.sortDropdown = page.locator("[data-test='product-sort-container']");
        this.inventoryItems = page.locator(".inventory_item");
    }

    public void addProductToCart(String productName) {
        //changing the products name to lowercase and adding "-" in spaces
        //this way we can address them directly from html
        String formattedName = productName.toLowerCase().replace(" ", "-");
        String locatorString = String.format("[data-test='add-to-cart-%s']", formattedName);

        page.locator(locatorString).click();
    }

    //method to check sorting
    public void sortProducts(String sortValue) {
        sortDropdown.selectOption(sortValue);
    }

    public int getCartItemCount() {
        //checking if cart has any items (in some sites the cart is invisible when its empty)
        if (cartBadge.isVisible()) {
            return Integer.parseInt(cartBadge.textContent());
        }
        return 0;
    }

    public void goToCart() {
        cartIcon.click();
    }

    public int getLoadedProductCount() {
        return inventoryItems.count();
    }
}
