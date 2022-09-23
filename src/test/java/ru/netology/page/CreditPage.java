package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CreditPage {

    public CreditPage() {
        SelenideElement creditPage = $x("//h3[contains(text(),'Кредит по данным карты')]");
        creditPage.shouldBe(Condition.visible);
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

    public void fillFormCredit(DataGenerator.OwnerInfo ownerInfo) {
        numberCard.setValue(ownerInfo.getCardNumber());
        month.setValue(ownerInfo.getMonth());
        year.setValue(ownerInfo.getYear());
        owner.setValue(ownerInfo.getName());
        cvc.setValue(ownerInfo.getCvc());
    }

    public void sendForm() {
        button.click();
    }

    public void declinedMessage() {
        messageFailure.shouldBe(Condition.visible, Duration.ofSeconds(10));
        messageDeclined.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void approvedMessage() {
        messageSuccess.shouldBe(Condition.visible, Duration.ofSeconds(10));
        messageApproved.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

}
