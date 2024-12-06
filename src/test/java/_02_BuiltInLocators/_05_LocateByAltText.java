package _02_BuiltInLocators;

import utility.BaseDriver;
import org.junit.jupiter.api.Test;

public class _05_LocateByAltText extends BaseDriver {

    @Test
    public void locateByAltTextTest() {
        // Google Görseller sayfasına git
        page.navigate("https://www.google.com/imghp");

        // Çerez izni penceresi kontrolü ve "Tümünü reddet" butonuna tıklama
        if (page.locator("//button[@id='W0wltc']/div").count() > 0) {
            page.locator("//button[@id='W0wltc']/div").first().click();
            System.out.println("Cookies rejected successfully.");
        } else {
            System.out.println("No cookie dialog detected.");
        }

        // Alt metne göre bir görseli bul ve tıkla
        page.getByAltText("Google").first().click();

        System.out.println("Image with alt text located and clicked successfully!");
    }
}
