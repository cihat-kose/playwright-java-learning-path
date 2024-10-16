package _02_BuiltInLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _03_LocateByPlaceholder extends BaseDriver {

    @Test
    public void findInputByPlaceholder() {
        // DemoQA form sayfasına git
        page.navigate("https://demoqa.com/text-box");

        // Placeholder'a göre input alanını bul ('Full Name' placeholder'ına sahip alan)
        Locator nameInput = page.getByPlaceholder("Full Name");

        // Input alanına bir değer gir
        String testName = "Kerem Said";
        nameInput.fill(testName);

        // Girilen değerin doğruluğunu kontrol et
        assertEquals(testName, nameInput.inputValue(), "Input value should match the entered value.");
    }
}
