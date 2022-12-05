package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.Const.MAIN_PAGE_URL;

public class MainPage {
    private WebDriver driver;

    // Header
    // Кнопка "Статус заказа"
    private By orderStatusButton = By.className("Header_Link__1TAG7");

    // Header
    // Поле ввода номера заказа
    private By orderNumberInput = By.className("Input_Input__1iN_Z");

    // Header
    // Поле ввода номера заказа
    private By goButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g') and (text() = 'Go!')]");

    // Header
    // Лого "Яндекс"
    private By yandexButton = By.className("Header_LogoYandex__3TSOI");

    // PopUp
    // Кнопка принять cookies
    private By cookieOkButton = By.className("App_CookieButton__3cvqF");

    // Кнопки вопросов о важном
    private By questionButtons = By.className("accordion__item");

    // Кнопки "Заказать" в хедере страницы и middle button
    private By orderButtons = By.xpath(".//button[contains(@class, 'Button_Button__ra12g') and (text() = 'Заказать')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    public boolean isCookieButtonDisplayed() {
        return driver.findElement(cookieOkButton).isDisplayed();
    }

    public void clickAcceptCookieButton() {
        driver.findElement(cookieOkButton).click();
    }

    public void clickOrderButtonByIndex(int index) {
        driver.findElements(orderButtons).get(index).click();
    }

    public void clickQuestionButtonByIndex(int index) {
        driver.findElements(questionButtons).get(index).click();
    }

    public String getFaqQuestionByIndex(int index) {
        return driver.findElements(questionButtons).get(index).findElement(By.className("accordion__button")).getText();
    }

    public String getFaqAnswerByIndex(int index) {
        return driver.findElements(questionButtons).get(index).findElement(By.className("accordion__panel")).getText();
    }

    public void clickYaLinkButton() {
        driver.findElement(yandexButton).click();
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    public void setOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderNumberInput)).sendKeys(orderNumber);
    }

    public boolean isOrderExist() {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//img[@alt = 'Not found']"))).isDisplayed();
    }
}
