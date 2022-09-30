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
import ru.netology.page.BuyPage;
import ru.netology.page.CreditPage;
import ru.netology.page.TourPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    private TourPage tourPage = new TourPage();

    @BeforeAll
    static void setUpAll() {
        open(System.getProperty("sut.url"));
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

    @Test
    void shouldTest() {
        BuyPage buyPage = new BuyPage();
        buyPage.fillFormBuy(DataGenerator.getApprovedCard());
        buyPage.sendForm();
        buyPage.approvedMessage();
        var id = DataGenerator.getIdOperationBuyToCard();
        var status = DataGenerator.getStatusOperationBuyToCard();
        assertEquals(id, status.getTransaction_id());
        assertEquals("APPROVED", status.getStatus());
    }

}