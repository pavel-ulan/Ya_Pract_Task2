package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

// Класс первой формы ввода данных для создания заказа
public class OrderPage {

    private WebDriver driver;

    // Поле ввода имени
    private By nameInput = By.xpath(".//input[@*='* Имя']");

    // Поле ввода фамилии
    private By surnameInput = By.xpath(".//input[@*='* Фамилия']");

    // Поле ввода адреса
    private By addressInput = By.xpath(".//input[@*='* Адрес: куда привезти заказ']");

    // Поле выбора станции метро
    private By metroSelectInput = By.xpath(".//input[@*='* Станция метро']");

    // Поле ввода номера телефона
    private By phoneNumberInput = By.xpath(".//input[@*='* Телефон: на него позвонит курьер']");

    // Поле выбора даты доставки
    private By deliveryDateInput = By.xpath(".//input[@*='* Когда привезти самокат']");

    // Поле выбора срока аренды
    private By rentPeriodSelect = By.xpath(".//div[text()='* Срок аренды']");

    // Чекбокс цвета самоката "чёрный жемчуг"
    private By scooterBlackColourCheckbox = By.id("black");

    // Чекбокс цвета самоката "серая безысходность"
    private By scooterGreyColourCheckbox = By.id("grey");

    // Поле комментария для курьера
    private By commentToCourierInput = By.xpath(".//input[@*='Комментарий для курьера']");

    // Кнопка Далее на форме создания заказа
    private By orderFormNextButton = By.xpath(".//button[text()='Далее']");

    // Кнопка Заказать
    private By orderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");

    // Кнопка Да на форме подтверждения создания заказа
    private By confirmButton = By.xpath(".//button[text()='Да']");

    // Кнопка Посмотреть статус на форме подтверждения
    private By checkStatusButton = By.xpath(".//button[text()='Посмотреть статус']");

    // Индикатор подтверждения заказа
    private By orderApprove = By.className("Order_ModalHeader__3FDaJ");

    // Ссылка на страницу самоката
    private By scooterLink = By.className("Header_LogoScooter__3lsAR");

    // Сообщения о неверно заполненных полях
    private By errorMessages = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");

    // Сообщение о не выбранной станции метро
    private By metroFieldError = By.className("Order_MetroError__1BtZb");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName (String name){
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setSurname (String surname){
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAddress (String address){
            driver.findElement(addressInput).sendKeys(address);
    }

    public void selectMetroStationByName(String metroName){
            driver.findElement(metroSelectInput).sendKeys(metroName);
            By locator = By.className("select-search__select");
            driver.findElement(locator).click();
    }

    public void setPhoneNumber (String phoneNumber){
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void selectDeliveryDate (String date){
        driver.findElement(deliveryDateInput).sendKeys(date);
        By locator = By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]");
        driver.findElement(locator).click();
    }

    public void selectRentPeriod (String rentPeriod){
        driver.findElement(rentPeriodSelect).click();
        driver.findElement(By
                .xpath(String.format (".//div[@class='Dropdown-option' and text()='%s']", rentPeriod))).click();
    }

    public void selectScooterColour (String colour){
        if (colour.equals("чёрный жемчуг")) {
            driver.findElement(scooterBlackColourCheckbox).click();
        } else if (colour.equals("серая безысходность")){
            driver.findElement(scooterGreyColourCheckbox).click();
        }
    }

    public void setCommentToCourier (String commentToCourier){
        driver.findElement(commentToCourierInput).sendKeys(commentToCourier);
    }
    public void clickNextButton (){
        driver.findElement(orderFormNextButton).click();
    }

    public void clickOrderButton (){
        driver.findElement(orderButton).click();
    }

    public void clickApproveButton (){
        driver.findElement(confirmButton).click();
    }

    public String getConfirmationText (){
        return driver.findElement(orderApprove).getText();
    }

    public void clickScooterLink (){
        driver.findElement(scooterLink).click();
    }

    public String getErrorMessageTextUnderIndex(int msgIndex){
        List<WebElement> errorElements = driver.findElements(errorMessages);
        errorElements.add(driver.findElement(metroFieldError));
        return errorElements.get(msgIndex).getText();
    }
}
