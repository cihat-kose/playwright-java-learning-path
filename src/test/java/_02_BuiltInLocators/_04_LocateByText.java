package _02_BuiltInLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _04_LocateByText extends BaseDriver {

    @Test
    public void findElementByText() {
        // The Internet Herokuapp sayfasına git
        page.navigate("https://the-internet.herokuapp.com/");

        // 'A/B Testing' bağlantısını LocateByText ile bul
        Locator abTestingLink = page.getByText("A/B Testing");

        // Bağlantıya tıkla
        abTestingLink.click();

        // Yeni sayfanın başlığını kontrol et
        String expectedHeader = "A/B Test Variation 1";
        Locator header = page.locator("h3");
        assertEquals(expectedHeader, header.textContent(), "Page header should match the expected header.");
    }
}
