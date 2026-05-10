import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class CartPage {
    private final Page page;
    private final Locator checkoutButton;
    private final Locator continueShoppingButton;
    private final Locator cartItems;

    public CartPage(Page page) {
        this.page = page;
        this.checkoutButton = page.locator("[data-test='checkout']");
        this.continueShoppingButton = page.locator("[data-test='continue-shopping']");
        this.cartItems = page.locator(".cart_item");
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }

    public void removeProduct(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        String locatorString = String.format("[data-test='remove-%s']", formattedName);
        page.locator(locatorString).click();
    }

    public int getCartItemCount() {
        return cartItems.count();
    }
}
