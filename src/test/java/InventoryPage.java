import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class InventoryPage {

    private final Page page;
    private final Locator cartIcon;
    private final Locator cartBadge;
    private final Locator sortDropdown;
    private final Locator inventoryItems;

    public InventoryPage(Page page) {
        this.page = page;
        this.cartIcon = page.locator(".shopping_cart_link");
        this.cartBadge = page.locator(".shopping_cart_badge");
        this.sortDropdown = page.locator("[data-test='product-sort-container']");
        this.inventoryItems = page.locator(".inventory_item");
    }

    public void addProductToCart(String productName) {

        String formattedName = productName.toLowerCase().replace(" ", "-");
        String locatorString = String.format("[data-test='add-to-cart-%s']", formattedName);

        page.locator(locatorString).click();
    }

    public void sortProducts(String sortValue) {
        sortDropdown.selectOption(sortValue);
    }

    public int getCartItemCount() {

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
