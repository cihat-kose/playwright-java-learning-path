package utility;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

// BaseDriver sınıfı, tüm testler için ortak Playwright kurulum ve kapatma işlemlerini yönetir.
public class BaseDriver {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;

    // Her testten önce çalışacak setup metodu. Playwright başlatılır ve yeni bir tarayıcı sayfası açılır.
    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false); // Tarayıcı headless modda başlatılmaz.
        browser = playwright.chromium().launch(options); // Chromium tabanlı tarayıcı başlatılır.
        page = browser.newPage(); // Yeni bir sayfa açılır.
    }

    // Her testten sonra çalışacak tearDown metodu. Açık tarayıcı ve Playwright oturumu kapatılır.
    @AfterEach
    public void tearDown() {
        if (browser != null) {
            browser.close(); // Tarayıcı kapatılır.
        }
        if (playwright != null) {
            playwright.close(); // Playwright oturumu kapatılır.
        }
    }
}
