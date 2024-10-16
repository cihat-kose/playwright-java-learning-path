package _01_PlaywrightIntro;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class _01_OpeningAndClosingBrowser {
    public static void main(String[] args) {
        // Playwright nesnesi oluşturuluyor, tarayıcı başlatılması için gerekli
        Playwright playwright = Playwright.create();

        // Chrome tarayıcısı başlatılıyor, headless mod kapalı (görsel tarayıcı), slowMo ile işlemler 50ms gecikmeli
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        // Yeni bir sayfa oluşturuluyor
        Page page = browser.newPage();

        // Kullanıcının ekran çözünürlüğünü almak için Toolkit sınıfını kullanıyoruz
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Dinamik olarak kullanıcının ekran boyutuna ayarlama
        page.setViewportSize(screenWidth, screenHeight); // Bu, sayfanın boyutunu kullanıcının ekran çözünürlüğüne göre ayarlar.

        // Belirtilen URL'ye gidiliyor
        page.navigate("http://playwright.dev");

        // Sayfa başlığı konsola yazdırılıyor
        System.out.println(page.title());

        // Sayfa kapatılıyor.
        // Bu adım, tarayıcıyı açık tutarken yalnızca bu spesifik sayfayı kapatır.
        // Örneğin, başka sayfalar da açılmış olsaydı, sadece bu sayfa kapanmış olurdu.
        page.close();

        // Tarayıcı kapatılıyor.
        // Tarayıcıya ait tüm sayfalar kapatılır ve tarayıcı örneği sonlandırılır.
        // Tarayıcının kapatılması bellekte kullanılan kaynakları serbest bırakır.
        browser.close();

        // Playwright oturumu kapatılıyor.
        // Playwright'in tüm kaynaklarını temizlemek ve işlem sonlandırmalarını sağlamak için bu adım önemlidir.
        // Bu, Playwright'te kullanılan tüm tarayıcı örnekleri ve ilişkili kaynakları serbest bırakır.
        playwright.close();
    }
}
