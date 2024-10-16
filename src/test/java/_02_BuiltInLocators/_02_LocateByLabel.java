package _02_BuiltInLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _02_LocateByLabel extends BaseDriver {

    @Test
    public void findUsernameAndPasswordByLabel() {
        // The Internet login sayfasına git
        page.navigate("https://the-internet.herokuapp.com/login");

        // 'Username' label'ına göre input alanını bul
        Locator usernameInput = page.getByLabel("Username");

        // 'Password' label'ına göre input alanını bul
        Locator passwordInput = page.getByLabel("Password");

        // Username input alanına bir değer gir
        String testUsername = "tomsmith";
        usernameInput.fill(testUsername);

        // Password input alanına bir değer gir
        String testPassword = "SuperSecretPassword!";
        passwordInput.fill(testPassword);

        // Girilen değerlerin doğruluğunu kontrol et
        assertEquals(testUsername, usernameInput.inputValue(), "Username input value should match the entered value.");
        assertEquals(testPassword, passwordInput.inputValue(), "Password input value should match the entered value.");
    }
}
