package utility;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.awt.*;

public class BaseDriver {

    protected static Playwright playwright;  // Static olarak tanımlandı
    protected static Browser browser;  // Static olarak tanımlandı
    protected static Page page;  // Static olarak tanımlandı

    private static final BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
            .setHeadless(false)  // Tarayıcıyı başlık modunda çalıştırır.
            .setSlowMo(50);  // Test adımları arasında 50ms gecikme ekler.

    /**
     * Tüm testler başlamadan önce Playwright ve Browser nesnelerini başlatır.
     */
    @BeforeAll
    public static void globalSetUp() {
        // Playwright sadece bir kere başlatılır.
        playwright = Playwright.create();
    }

    /**
     * Her testten önce çağrılan setup metodu.
     * Tarayıcı başlatılır ve dinamik ekran çözünürlüğüne göre yeni bir sayfa açılır.
     */
    @BeforeEach
    public void setUp() {
        // Tarayıcı başlatılır
        browser = playwright.chromium().launch(launchOptions);

        // Yeni bir sayfa açılır
        page = browser.newPage();

        // Dinamik ekran boyutunu alır ve tarayıcıyı tam ekran başlatır
        setDynamicViewport();
    }

    /**
     * Tarayıcı için dinamik ekran çözünürlüğünü ayarlar.
     */
    private void setDynamicViewport() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        page.setViewportSize(width, height);
    }

    /**
     * Her testten sonra tarayıcı kapatılır.
     */
    @AfterEach
    public void tearDown() {
        if (page != null) {
            page.close();  // Sayfayı kapatır
        }
        if (browser != null) {
            browser.close();  // Tarayıcıyı kapatır
        }
    }

    /**
     * Tüm testler tamamlandıktan sonra Playwright kapatılır.
     */
    @AfterAll
    public static void globalTearDown() {
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
        setDynamicViewport();
    }
}
