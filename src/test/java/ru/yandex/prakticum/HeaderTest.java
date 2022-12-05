package ru.yandex.prakticum;

import org.junit.After;
import org.junit.Test;
import ru.yandex.prakticum.framework.Browser;
import ru.yandex.prakticum.steps.MainPageSteps;
import ru.yandex.prakticum.steps.OrderSteps;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static ru.yandex.prakticum.framework.Const.MAIN_PAGE_URL;
import static ru.yandex.prakticum.framework.Const.YA_PAGE_URL;

public class HeaderTest {
    private final MainPageSteps mainPageStep = new MainPageSteps();
    private final OrderSteps orderSteps = new OrderSteps();


    public HeaderTest() {

    }

    @Test
    public void yaLinkTest() {
        mainPageStep.open();
        assertEquals("Вы не на главной странице Яндекса", YA_PAGE_URL, mainPageStep.goToYaUrl());
    }

    @Test
    public void scooterLinkTest() {
        mainPageStep.open();
        mainPageStep.clickOrderButtonByIndex(new Random().nextInt(1));
        orderSteps.clickScooterLink();
        assertEquals("Вы не на главной странице самоката", MAIN_PAGE_URL, mainPageStep.getCurrentUrl());
    }

    @Test
    public void orderCheckTest() {
        mainPageStep.open();
        assertFalse(mainPageStep.checkIfOrderExistByNumber(0));
    }

    @After
    public void cleanUp() {
        Browser.closeInstance();
    }
}