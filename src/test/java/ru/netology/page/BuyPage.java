package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class BuyPage {

    public BuyPage() {
        SelenideElement buyPage = $x("//h3[contains(text(),'Оплата по карте')]");
        buyPage.shouldBe(Condition.visible);
    }

    private SelenideElement numberCard = $x("//span[contains(text(),'Номер карты')]");
    private SelenideElement month = $x("//span[contains(text(),'Месяц')]");
    private SelenideElement year = $x("//span[contains(text(),'Год')]");
    private SelenideElement owner = $x("//span[contains(text(),'Владелец')]");
    private SelenideElement cvc = $x("//span[contains(text(),'CVC/CVV')]");
    private SelenideElement button = $x("//button[@type='button']").find(By.linkText("Продолжить"));

    private SelenideElement messageSuccess = $x("//div[contains(text(),'Успешно')]");
    private SelenideElement messageApproved = $x("//div[contains(text(),'Операция одобрена Банком')]");
    private SelenideElement messageFailure = $x("//*[text()='Ошибка']");
    private SelenideElement messageDeclined = $x("//div[contains(text(),'Ошибка! Банк отказал в проведении операции')]");

    private SelenideElement numberCardError = $x("//span[contains(text(),'Номер карты')]").parent().$(".input__sub");
    private SelenideElement monthError = $x("//span[contains(text(),'Месяц')]").parent().$(".input__sub");
    private SelenideElement yearError = $x("//span[contains(text(),'Год')]").parent().$(".input__sub");
    private SelenideElement ownerError = $x("//span[contains(text(),'Владелец')]").parent().$(".input__sub");
    private SelenideElement cvcError = $x("//span[contains(text(),'CVC/CVV')]").parent().$(".input__sub");

    public void declinedMessage() {
        messageFailure.shouldBe(Condition.visible, Duration.ofSeconds(10));
        messageDeclined.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void approvedMessage() {
        messageSuccess.shouldBe(Condition.visible, Duration.ofSeconds(10));
        messageApproved.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void sendForm() {
        button.click();
    }

    public void emptyFieldNumberCard() {
        numberCardError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldNumberCard() {
        numberCardError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void emptyFieldMonth() {
        monthError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldNumberMonth() {
        monthError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void wrongPeriodMonthField() {
        monthError.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void cardExpiredFieldMonth() {
        monthError.shouldHave(Condition.exactText("Истек срок действия карты"));
    }

    public void emptyFieldYear() {
        yearError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldNumberYear() {
        yearError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void wrongPeriodYearField() {
        yearError.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void cardExpiredFieldYear() {
        yearError.shouldHave(Condition.exactText("Истек срок действия карты"));
    }

    public void emptyFieldOwner() {
        ownerError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldNumberOwner() {
        ownerError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void emptyFieldCvc() {
        cvcError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldNumberCvc() {
       cvcError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillFormBuy(DataGenerator.OwnerInfo ownerInfo) {
        numberCard.setValue(ownerInfo.getCardNumber());
        month.setValue(ownerInfo.getMonth());
        year.setValue(ownerInfo.getYear());
        owner.setValue(ownerInfo.getName());
        cvc.setValue(ownerInfo.getCvc());
    }

}
