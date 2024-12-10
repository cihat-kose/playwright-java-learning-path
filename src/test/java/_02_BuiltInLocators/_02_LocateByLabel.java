package _02_BuiltInLocators;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utility.BaseDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _02_LocateByLabel extends BaseDriver {

    @Test
    public void findUsernameAndPasswordByLabel() {
        // Navigate to The Internet login page
        page.navigate("https://the-internet.herokuapp.com/login");

        // Locate the input field for 'Username' using its label
        Locator usernameInput = page.getByLabel("Username");

        // Locate the input field for 'Password' using its label
        Locator passwordInput = page.getByLabel("Password");

        // Enter a value into the username input field
        String testUsername = "tomsmith";
        usernameInput.fill(testUsername);

        // Enter a value into the password input field
        String testPassword = "SuperSecretPassword!";
        passwordInput.fill(testPassword);

        // Verify that the entered values match the expected inputs
        assertEquals(testUsername, usernameInput.inputValue(), "Username input value should match the entered value.");
        assertEquals(testPassword, passwordInput.inputValue(), "Password input value should match the entered value.");
    }
}
