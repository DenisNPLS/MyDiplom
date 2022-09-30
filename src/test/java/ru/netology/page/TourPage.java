package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TourPage {

    private SelenideElement buttonBuy = $x("//button[@type='button']").find(By.linkText("Купить"));
    private SelenideElement buttonCredit = $x("//*[contains(text(),'Купить в кредит')]");
    private SelenideElement mainPage = $x("//h2[text()='Путешествие дня']");

    public BuyPage toBuy() {
        buttonBuy.click();
        return new BuyPage();
    }

    public TourPage() {
        mainPage.shouldBe(Condition.visible);
    }

    public CreditPage toCredit() {
        buttonCredit.click();
        return new CreditPage();
    }

}
