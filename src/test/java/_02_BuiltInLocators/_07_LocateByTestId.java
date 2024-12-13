package _02_BuiltInLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _07_LocateByTestId extends BaseDriver {

    @Test
    public void locateByTestIdTest() {
        // Navigate to Github (or any testable page with data-testid attributes)
        page.navigate("https://www.github.com");

        // Locate an element by its Test ID and Alt Text
        Locator testIdLocator = page.getByTestId("Grid-:Rib:").getByAltText("Duolingo");

        // Validate that the Test ID element has a specific attribute
        assertEquals("true", testIdLocator.getAttribute("aria-hidden"), "The aria-hidden attribute should be 'true'");
    }
}
