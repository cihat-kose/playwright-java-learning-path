package _02_BuiltInLocators;

import utility.BaseDriver;
import org.junit.jupiter.api.Test;

public class _05_LocateByAltText extends BaseDriver {

    @Test
    public void locateByAltTextTest() {
        // Navigate to Google Images page
        page.navigate("https://www.google.com/imghp");

        // Check for the cookie consent dialog and click "Reject all" button if present
        if (page.locator("//button[@id='W0wltc']/div").count() > 0) {
            page.locator("//button[@id='W0wltc']/div").first().click();
            System.out.println("Cookies rejected successfully.");
        } else {
            System.out.println("No cookie dialog detected.");
        }

        // Locate an image using its alt text and click on it
        page.getByAltText("Google").first().click();

        System.out.println("Image with alt text located and clicked successfully!");
    }
}
