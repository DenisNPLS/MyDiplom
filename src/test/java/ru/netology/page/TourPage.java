package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TourPage {

    private SelenideElement buttonBuy = $x("//*[@class='button button_size_m button_theme_alfa-on-white']");
    private SelenideElement buttonCredit = $x("//*[contains(text(),'Купить в кредит')]");
    private SelenideElement pageCredit = $x("//*[contains(text(), 'Кредит по данным карты')]");

    public BuyPage toBuy() {
        buttonBuy.click();
        return new BuyPage();
    }

    public CreditPage toCredit() {
        buttonCredit.click();
        return new CreditPage();
    }

    public void pageCreditVisible() {
        pageCredit.shouldBe(Condition.visible);
    }
}
