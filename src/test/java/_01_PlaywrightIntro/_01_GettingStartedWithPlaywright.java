package _01_PlaywrightIntro;

import com.microsoft.playwright.*;
import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _01_GettingStartedWithPlaywright {
    public static void main(String[] args) {
        // Step 1: Initialize Playwright
        System.out.println("Initializing Playwright...");
        Playwright playwright = Playwright.create();

        // Step 2: Launch the browser
        System.out.println("Launching browser...");
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false) // Run browser in visible mode
                        .setSlowMo(50)      // Add a delay between actions for better observation
        );

        // Step 3: Open a new browser page (tab)
        System.out.println("Creating a new browser page...");
        Page page = browser.newPage();

        // Step 4: Set viewport size dynamically based on the screen resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        page.setViewportSize(screenWidth, screenHeight);

        // Step 5: Navigate to the Playwright website
        System.out.println("Navigating to Playwright.dev...");
        page.navigate("http://playwright.dev");

        // Step 6: Validate the page title
        System.out.println("Validating the page title...");
        assertThat(page).hasTitle("Fast and reliable end-to-end testing for modern web apps | Playwright");

        // Step 7: Validate the "Get started" button is visible
        System.out.println("Validating 'Get started' button visibility...");
        assertThat(page.locator("text=Get started")).isVisible();

        // Step 8: Close the browser
        System.out.println("Closing the browser...");
        browser.close();

        // Step 9: Close Playwright
        System.out.println("Closing Playwright...");
        playwright.close();
    }
}
