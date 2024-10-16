package utility;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

public class BaseDriver {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;

    private final BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
            .setHeadless(false)  // Tarayıcıyı başlık modunda çalıştırır.
            .setSlowMo(50);  // Test adımları arasında 50ms gecikme ekler.

    /**
     * Testlerden önce çağrılan setup metodu.
     * Playwright nesnesi oluşturulur, tarayıcı başlatılır ve dinamik ekran çözünürlüğüne göre yeni bir sayfa açılır.
     */
    @BeforeEach
    public void setUp() {
        // Playwright başlatılır
        playwright = Playwright.create();

        // Tarayıcı başlatılır
        browser = playwright.chromium().launch(launchOptions);

        // Yeni bir sayfa açılır
        page = browser.newPage();

        // Dinamik ekran boyutunu alır
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Tarayıcıyı dinamik ekran çözünürlüğünde tam ekran boyutunda başlat
        page.setViewportSize(width, height);
    }

    /**
     * Testlerden sonra çağrılan tearDown metodu.
     * Tarayıcı ve Playwright nesneleri düzgün bir şekilde kapatılır.
     */
    @AfterEach
    public void tearDown() {
        if (page != null) {
            page.close();  // Sayfayı kapatır
        }
        if (browser != null) {
            browser.close();  // Tarayıcıyı kapatır
        }
        if (playwright != null) {
            playwright.close();  // Playwright'i kapatır
        }
    }

    /**
     * Özel bir tarayıcı başlatmak için tarayıcı türünü alır.
     * @param browserType Tarayıcı türü (chromium, firefox, webkit)
     */
    public void launchBrowser(BrowserType browserType) {
        browser = browserType.launch(launchOptions);
        page = browser.newPage();

        // Dinamik ekran boyutunu alır
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Tarayıcıyı dinamik ekran çözünürlüğünde başlat
        page.setViewportSize(width, height);
    }
}
