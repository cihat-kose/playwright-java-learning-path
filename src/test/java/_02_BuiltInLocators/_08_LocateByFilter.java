package _02_BuiltInLocators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _08_LocateByFilter extends BaseDriver {

    @Test
    public void locateByFilterExample() {
        // Go to page
        page.navigate("https://github.com");
        page.waitForLoadState();

        // Find the 'div' element that contains the specific text within an element with the role of 'banner'
        Locator searchFilterLocator = page.getByRole(AriaRole.BANNER)
                .locator("div")
                .filter(new Locator.FilterOptions().setHasText("Search or jump to... Search"))
                .nth(3);

        // Verify that the Locator is visible
        assertThat(searchFilterLocator).isVisible();
    }
}
