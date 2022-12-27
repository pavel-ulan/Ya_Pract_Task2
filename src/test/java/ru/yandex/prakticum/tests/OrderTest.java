package ru.yandex.prakticum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.prakticum.BaseTest;
import ru.yandex.prakticum.models.OrderModel;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    /**
     * Test data init
     * Может быть передана так же из внешнего файла
     */
    private static final List<OrderModel> ORDERS = List
            .of(new OrderModel(0, "Иван", "Иванов", "Иванович", "Балтийская", "+79991234567", LocalDate.now().plusDays(1).toString(), "сутки", "чёрный жемчуг", "привет"),
                    new OrderModel(1, "Петров", "Петр", "Петрович", "Площадь Ильича", "+79991234567", LocalDate.now().plusDays(1).toString(), "двое суток", "серая безысходность", "привет еще раз"));
    private final OrderModel order;


    public OrderTest(OrderModel order) {
        this.order = order;
    }

    @Parameterized.Parameters
    public static List<OrderModel> getOrderCreationTestData() {
        return ORDERS;
    }

    @Test
    public void createNewOrderTest() {
        mainPageSteps.open();
        mainPageSteps.acceptCookie();
        mainPageSteps.clickOrderButtonByIndex(order.getOrderButtonIndex());
        orderSteps.fillOrderFormOnFirstPage(order.getName(), order.getSurname(), order.getAddress(), order.getMetro(), order.getPhoneNumber());
        orderSteps.clickNextButton();
        orderSteps.fillOrderFormOnSecondPage(order.getDeliveryDate(), order.getRentPeriod(), order.getScooterColour(), order.getCommentToCourier());
        orderSteps.clickOrderButton();
        orderSteps.clickApproveButton();
        assertTrue("Заказ не подтвержден", orderSteps.isOrderConfirmed());
    }
}
