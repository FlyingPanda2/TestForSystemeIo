package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SystemeIoIFrame;
import utils.BaseTest;

@DisplayName("Тесты кнопок в iframe")
public class MainTest extends BaseTest {

    private final static String mainPageUrl = "https://systeme.io/blog/cost-of-online-course";

    @Test
    @DisplayName("Проверка отображения кнопки получения копии книги")
    void testReceiveCopyButtonDisplayed(){
        SystemeIoIFrame systemeIoIFrame = new SystemeIoIFrame(mainPageUrl);
        Assertions.assertEquals("I want to receive my copy", systemeIoIFrame.getReceiveCopyButtonText());
    }

    @Test
    @DisplayName("Проверка правильного функционала кнопки закрытия iframe")
    void testExitButton(){
        SystemeIoIFrame systemeIoIFrame = new SystemeIoIFrame(mainPageUrl);
        systemeIoIFrame.closeIFrame();
        Assertions.assertFalse(systemeIoIFrame.isIFrameVisible());
    }
}
