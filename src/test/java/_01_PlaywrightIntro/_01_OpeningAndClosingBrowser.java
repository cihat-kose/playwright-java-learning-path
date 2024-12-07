package _01_PlaywrightIntro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _01_OpeningAndClosingBrowser {
    public static void main(String[] args) {
        // Step 1: Initialize Playwright
        // Playwright is the main library used to interact with web browsers.
        // It must be initialized before any browser actions can be performed.
        Playwright playwright = Playwright.create();

        // Step 2: Launch the Chromium browser
        // The browser is launched in visible mode (non-headless) with a delay of 50ms between actions.
        // Slow motion allows us to observe the test in action.
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false) // Enables visible mode
                        .setSlowMo(50) // Adds a 50ms delay for observation
        );

        // Step 3: Create a new browser page (tab)
        // A browser tab is created to perform actions like navigation and testing.
        Page page = browser.newPage();

        // Step 4: Dynamically set the viewport size based on the user's screen resolution
        // This ensures the browser adjusts to the user's screen dimensions dynamically.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Fetch user's screen dimensions
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        page.setViewportSize(screenWidth, screenHeight); // Adjust viewport size

        // Step 5: Navigate to the Playwright website
        // The page navigates to the specified URL and waits for the page to load completely.
        page.navigate("http://playwright.dev");

        // Step 6: Validate page content
        // Validations are performed to ensure the correct page has loaded
        // and the necessary elements are visible and working as expected.
        validatePageContent(page);

        // Step 7: Close the browser page
        // The current browser tab is closed, freeing resources for other operations.
        page.close();

        // Step 8: Close the browser
        // The entire browser instance is closed, terminating all associated pages.
        browser.close();

        // Step 9: Close the Playwright session
        // Playwright resources and background processes are cleaned up.
        playwright.close();
    }

    // Validation method to verify the content of the page
    public static void validatePageContent(Page page) {
        // Step 1: Validate the page title using Playwright Assertions
        // This ensures the page has loaded the expected content.
        System.out.println("Validating page title...");
        assertThat(page).hasTitle("Fast and reliable end-to-end testing for modern web apps | Playwright");

        // Step 2: Validate the visibility of the "Get started" button
        // This ensures that the button is present and visible on the page.
        System.out.println("Validating 'Get started' button visibility...");
        assertThat(page.locator("text=Get started")).isVisible();

        // Step 3: Validate that the page title contains a specific phrase using JUnit Assertions
        // This ensures the title contains the expected text, which is useful for dynamic titles.
        System.out.println("Validating that the page title contains the expected substring...");
        String pageTitle = page.title();
        assertTrue(pageTitle.contains("Fast and reliable"),
                "Page title does not contain the expected phrase: 'Fast and reliable'");
    }
}
