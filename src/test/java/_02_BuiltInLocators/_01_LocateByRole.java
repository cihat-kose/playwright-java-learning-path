package _02_BuiltInLocators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _01_LocateByRole extends BaseDriver {

    @Test
    public void findSearchButtonByRole() {
        // Wikipedia ana sayfasına git
        page.navigate("https://www.wikipedia.org");

        // "Search" butonunu role ve isim ile bul
        Locator searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));

        // Butonun görünür olmasını bekleyin
        searchButton.waitFor();

        // Butona tıklayın
        searchButton.click();
    }
}
