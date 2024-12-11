package _02_BuiltInLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class _06_LocateByTitle extends BaseDriver {

    @Test
    public void locateByTitleTest() {
        // Navigate to GitHub
        page.navigate("https://github.com");

        // Locate the title element
        Locator titleLocator = page.getByTitle("GitHub").nth(1);

        // Validate that the title element is not null
        assertNotNull(titleLocator, "The title element should not be null");
    }
}
