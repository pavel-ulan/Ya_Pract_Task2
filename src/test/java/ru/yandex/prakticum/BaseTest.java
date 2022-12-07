package ru.yandex.prakticum;

import org.junit.After;
import ru.yandex.prakticum.framework.Browser;
import ru.yandex.prakticum.steps.MainPageSteps;
import ru.yandex.prakticum.steps.OrderSteps;

public class BaseTest {
    protected final MainPageSteps mainPageSteps = new MainPageSteps();
    protected final OrderSteps orderSteps = new OrderSteps();

    @After
    public void cleanUp() {
        Browser.closeInstance();
    }
}
