package ru.yandex.prakticum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.prakticum.BaseTest;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final int orderButtonIndex;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentPeriod;
    private final String scooterColour;
    private final String commentToCourier;


    public OrderTest(int orderButtonIndex, String name, String surname, String address, String metro, String phoneNumber, String deliveryDate, String rentPeriod, String scooterColour, String commentToCourier) {
        this.orderButtonIndex=orderButtonIndex;
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.metro=metro;
        this.phoneNumber=phoneNumber;
        this.deliveryDate=deliveryDate;
        this.rentPeriod=rentPeriod;
        this.scooterColour=scooterColour;
        this.commentToCourier=commentToCourier;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderCreationTestData() {
        return new Object[][]{
                {0, "Иван", "Иванов", "Иванович", "Балтийская", "+79991234567", LocalDate.now().plusDays(1).toString(), "сутки", "чёрный жемчуг", "привет"},
                {1, "Петров", "Петр", "Петрович", "Площадь Ильича", "+79991234567", LocalDate.now().plusDays(1).toString(), "двое суток", "серая безысходность", "привет еще раз"}
        };
    }

    @Test
    public void createNewOrderTest() {
        mainPageSteps.open();
        mainPageSteps.acceptCookie();
        mainPageSteps.clickOrderButtonByIndex(orderButtonIndex);
        orderSteps.fillOrderFormOnFirstPage(name, surname, address, metro, phoneNumber);
        orderSteps.clickNextButton();
        orderSteps.fillOrderFormOnSecondPage(deliveryDate, rentPeriod, scooterColour, commentToCourier);
        orderSteps.clickOrderButton();
        orderSteps.clickApproveButton();
        assertTrue("Заказ не подтвержден", orderSteps.isOrderConfirmed());
    }
}
