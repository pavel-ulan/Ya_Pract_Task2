import framework.Browser;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.MainPageSteps;
import steps.OrderSteps;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderFieldsTest {

    private final MainPageSteps mainPageSteps = new MainPageSteps();
    private final OrderSteps orderSteps = new OrderSteps();
    private final int orderButtonIndex;
    private final int errorIndex;
    private final String errorMessage;

    public OrderFieldsTest(int orderButtonIndex, int errorIndex, String errorMessage) {
        this.orderButtonIndex=orderButtonIndex;
        this.errorIndex=errorIndex;
        this.errorMessage=errorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderCreationTestData() {
        return new Object[][]{
                {0, 0, "Введите корректное имя"},
                {1, 1, "Введите корректную фамилию"},
                {0, 2, "Введите корректный адрес"},
                {1, 3, "Введите корректный номер"},
                {1, 4, "Выберите станцию"}
        };
    }

    @Test
    public void errorMessageFieldsTest() {
        mainPageSteps.open();
        mainPageSteps.acceptCookie();
        mainPageSteps.clickOrderButtonByIndex(orderButtonIndex);
        orderSteps.clickNextButton();
        orderSteps.fillAddressField(Integer.toString(orderButtonIndex));
        assertEquals("Сообщения об ошибке нет или оно неверное", errorMessage, orderSteps.getErrorMessagesUnderIndex(errorIndex));
    }

    @After
    public void cleanUp() {
        Browser.closeInstance();
    }
}