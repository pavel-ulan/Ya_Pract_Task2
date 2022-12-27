package ru.yandex.prakticum.tests;

import org.junit.Test;
import ru.yandex.prakticum.BaseTest;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static ru.yandex.prakticum.framework.Const.MAIN_PAGE_URL;
import static ru.yandex.prakticum.framework.Const.YA_PAGE_URL;

public class HeaderTest extends BaseTest {

    private static final int INVALID_ORDER_NUMBER = 0;

    @Test
    public void yaLinkTest() {
        mainPageSteps.open();
        assertEquals("Вы не на главной странице Яндекса", YA_PAGE_URL, mainPageSteps.goToYaUrl());
    }

    @Test
    public void scooterLinkTest() {
        mainPageSteps.open();
        mainPageSteps.clickOrderButtonByIndex(new Random().nextInt(2));
        orderSteps.clickScooterLink();
        assertEquals("Вы не на главной странице самоката", MAIN_PAGE_URL, mainPageSteps.getCurrentUrl());
    }

    @Test
    public void orderCheckTest() {
        mainPageSteps.open();
        assertFalse(mainPageSteps.checkIfOrderExistByNumber(INVALID_ORDER_NUMBER));
    }
}
