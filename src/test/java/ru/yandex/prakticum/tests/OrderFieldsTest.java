package ru.yandex.prakticum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.prakticum.BaseTest;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderFieldsTest extends BaseTest {

    private final int orderButtonIndex;
    private final int errorIndex;
    private final String errorMessage;

    public OrderFieldsTest(int orderButtonIndex, int errorIndex, String errorMessage) {
        this.orderButtonIndex = orderButtonIndex;
        this.errorIndex = errorIndex;
        this.errorMessage = errorMessage;
    }

    /**
     * Оставил тестовые данные внутри параметров.
     * К 4 спринту мы уже учим ООП подходу, но думаю, что студентам будет проще работать с захардкоженными тестовыми данными внутри параметров.
     * Считаю, что на данном этапе это так же приемлемо.
     *
     * @return кнопка Заказать (0 - header/1 - middle), номер проверяемого input поля, errorMessage;
     */
    @Parameterized.Parameters
    public static Object[][] getOrderCreationTestData() {
        return new Object[][]{
                {new Random().nextInt(2), 0, "Введите корректное имя"},
                {new Random().nextInt(2), 1, "Введите корректную фамилию"},
                {new Random().nextInt(2), 2, "Введите корректный адрес"},
                {new Random().nextInt(2), 3, "Введите корректный номер"},
                {new Random().nextInt(2), 4, "Выберите станцию"}
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
}
