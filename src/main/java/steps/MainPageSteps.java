package steps;

import framework.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.MainPage;

import java.time.Duration;
import java.util.ArrayList;

public class MainPageSteps {
    private final WebDriver driver = Browser.getInstance();
    private MainPage mainPage = new MainPage(driver);

    public void open(){
        mainPage.open();
    }

    public void acceptCookie(){
        if (mainPage.isCookieButtonDisplayed()) {
        mainPage.clickAcceptCookieButton();}
    }

    public void clickOrderButtonByIndex (int index){
        mainPage.clickOrderButtonByIndex(index);
    }

    public void expandFaqQuestionWithIndex(int faqIndex){
        mainPage.clickQuestionButtonByIndex(faqIndex);
    }

    public String getQuestionTextFromFaqUnderIndex(int faqIndex){
    return mainPage.getFaqQuestionByIndex(faqIndex);
    }

    public String getAnswerTextFromFaqUnderIndex(int faqIndex){
        return mainPage.getFaqAnswerByIndex(faqIndex);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String goToYaUrl() {
        mainPage.clickYaLinkButton();
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.numberOfWindowsToBe(2));
        var tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }

    public boolean checkIfOrderExistByNumber(int orderNumber) {
        mainPage.clickOrderStatusButton();
        mainPage.setOrderNumber(Integer.toString(orderNumber));
        mainPage.clickGoButton();
        return mainPage.isOrderExist();
    }
}
