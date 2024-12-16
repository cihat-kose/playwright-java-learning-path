package _02_BuiltInLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _03_LocateByPlaceholder extends BaseDriver {

    @Test
    public void findInputByPlaceholder() {
        // Navigate to the DemoQA form page
        page.navigate("https://demoqa.com/text-box");

        // Locate the input field using its placeholder ('Full Name' placeholder)
        Locator nameInput = page.getByPlaceholder("Full Name");

        // Enter a value into the input field
        String testName = "Kerem Said";
        nameInput.fill(testName);

        // Verify that the entered value matches the expected value
        assertEquals(testName, nameInput.inputValue(), "Input value should match the entered value.");
    }
}
