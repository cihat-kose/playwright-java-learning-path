package _02_BuiltInLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _04_LocateByText extends BaseDriver {

    @Test
    public void findElementByText() {
        // Navigate to The Internet Herokuapp page
        page.navigate("https://the-internet.herokuapp.com/");

        // Locate the 'A/B Testing' link using LocateByText
        Locator abTestingLink = page.getByText("A/B Testing");

        // Click the link
        abTestingLink.click();

        // Verify the header text of the new page
        String expectedHeader = "A/B Test Variation 1";
        Locator header = page.locator("h3");
        assertEquals(expectedHeader, header.textContent(), "Page header should match the expected header.");
    }
}
