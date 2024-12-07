package _01_PlaywrightIntro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _01_OpeningAndClosingBrowser {
    public static void main(String[] args) {
        // Creating a Playwright object
        Playwright playwright = Playwright.create();

        // Launching the browser in headless=false mode with slowMo
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        // Creating a new page
        Page page = browser.newPage();

        // Navigating to the specified URL
        page.navigate("http://playwright.dev");

        // Using Playwright Assertions to verify the page title
        assertThat(page).hasTitle("Fast and reliable end-to-end testing for modern web apps | Playwright");

        // Printing the page title to confirm
        System.out.println("Page title: " + page.title());

        // Closing the page
        page.close();

        // Closing the browser
        browser.close();

        // Closing the Playwright session
        playwright.close();
    }
}
