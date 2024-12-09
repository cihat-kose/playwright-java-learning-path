package _02_BuiltInLocators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _01_LocateByRole extends BaseDriver {

    @Test
    public void findSearchButtonByRole() {
        // Navigate to the Wikipedia homepage
        page.navigate("https://www.wikipedia.org");

        // Locate the "Search" button by role and name
        Locator searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));

        // Wait for the button to become visible
        searchButton.waitFor();

        // Click the button
        searchButton.click();

        // Verification: Check if the button click triggered the expected action
        // For example, checking if the page title or URL has changed
        assertTrue(page.url().contains("search"), "Expected URL to contain 'search' after clicking the button");
    }
}
