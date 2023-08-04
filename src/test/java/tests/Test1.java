package tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.*;

@Owner("o.kos")
@Epic("VOA")
public class Test1 extends TestBase {

    @Test
    @DisplayName("Search info in VOA")
    void currencyChangeTest() {

         $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/searchMenuItem")).click();
         $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/search_src_text")).sendKeys("James Dean");
         $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/search_src_text")).pressEnter();
         $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/title_text"))
                    .shouldHave(text("Dead for 64 Years, James Dean to Star in New Film"));
         $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/published_date_text"))
                    .shouldHave(text("November 13, 2019"));
    }

        @Test
    void successfulSearchTest2() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("vn.innoloop.VOALearningEnglish:id/searchMenuItem")).click();
            $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/search_src_text")).sendKeys("James Dean");
            $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/search_src_text")).pressEnter();
        });
        
        step("Verify content found", () ->              
         $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/title_text"))
                    .shouldHave(text("Dead for 64 Years, James Dean to Star in New Film"));
         $(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/published_date_text"))
                    .shouldHave(text("November 13, 2019"));        
            $$(AppiumBy.id("vn.innoloop.VOALearningEnglish:id/title_text"))
                    .shouldHave(sizeGreaterThan(0)));
    }
    
    @Test
    void successfulSearchTest0() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
                    .shouldHave(sizeGreaterThan(0)));
    }

            //$x("//android.widget.EditText").sendKeys("anti");
            //$$(className("android.widget.TextView")).findBy(text("antis")).shouldBe(visible);
}
