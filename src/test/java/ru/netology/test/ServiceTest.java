package ru.netology.test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class ServiceTest {

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @BeforeEach
    void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    /*@Test
    void testTest() {
        var validOwner = DataGenerator.Owner.generateOwner("ru");
        $x("//*[@class='button button_size_m button_theme_alfa-on-white']").click();
        $x("//h3[contains(text(), 'Оплата по карте')]").shouldBe(Condition.visible);
        $x("//input[@maxlength='19']").setValue("4444444444444444");
        $x("//input[@placeholder='08']").setValue(DataGenerator.dateMonth(validOwner.getMonth()));
        $x("//input[@placeholder='22']").setValue(DataGenerator.dateYear(validOwner.getYear())).pressTab();
        $$("input[class='input__control']").get(3).setValue(DataGenerator.generateUser(validOwner.getName()));
        $$("input[class='input__control']").get(4).setValue(validOwner.getCvc());
        $$x("//button[@type='button']").get(2).click();
        $$x("//div[@class='notification__title']").get(1).shouldBe(Condition.visible, Duration.ofSeconds(10));
    }*/
}