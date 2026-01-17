package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SystemeIoIFrame {

    public SystemeIoIFrame(String URL) {
        Selenide.open(URL);
        switchToIFrame();
    }
    // Получение основных элементов страницы
    private SelenideElement getIFrame(){
        return $x("//iframe[starts-with(@id, 'systemeio-iframe-')]");
    }

    private SelenideElement getReceiveCopyButton(){
        return $x("//button[.//div[contains(text(), 'I want to receive my copy')]]");
    }

    private SelenideElement getExitButton(){
        return $x("//button[@data-testid='popup-close-icon']");
    }

    // Основные методы для взаимодействия с фреймом
    public void switchToIFrame() {
        getIFrame().shouldBe(visible);
        Selenide.switchTo().frame(getIFrame());
    }

    public boolean isIFrameVisible() {
        return getIFrame().is(visible);
    }

    public String getReceiveCopyButtonText() {
        return getReceiveCopyButton().shouldBe(visible).getText();
    }

    public void closeIFrame() {
        getExitButton().shouldBe(visible).click();
    }
}
