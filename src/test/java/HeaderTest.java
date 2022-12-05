import framework.Browser;
import org.junit.After;
import org.junit.Test;
import steps.MainPageSteps;
import steps.OrderSteps;

import java.util.Random;

import static framework.Const.MAIN_PAGE_URL;
import static framework.Const.YA_PAGE_URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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