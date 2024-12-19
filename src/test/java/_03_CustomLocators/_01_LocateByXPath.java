package _03_CustomLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _01_LocateByXPath extends BaseDriver {

    @Test
    public void locateByXPathTest() {
        page.navigate("https://github.com");

        Locator xpathLocator = page.locator("//a[contains(@href, 'signup')]");
        assertTrue(xpathLocator.isVisible(), "XPath element should be visible");
    }
}
