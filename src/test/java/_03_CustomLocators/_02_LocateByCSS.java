package _03_CustomLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _02_LocateByCSS extends BaseDriver {

    @Test
    public void locateByCSSTest() {
        page.navigate("https://github.com");

        Locator cssLocator = page.locator("a[href*='signup']");
        assertTrue(cssLocator.isVisible(), "CSS element should be visible");
    }
}
