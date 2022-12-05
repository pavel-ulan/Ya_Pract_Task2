package steps;

import framework.Browser;
import org.openqa.selenium.WebDriver;
import page_objects.OrderPage;

public class OrderSteps {
    private final WebDriver driver = Browser.getInstance();
    private OrderPage orderPage = new OrderPage(driver);

    public void fillOrderFormOnFirstPage(String name, String surname, String address, String metroStationName, String phoneNumber){
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.selectMetroStationByName(metroStationName);
        orderPage.setPhoneNumber(phoneNumber);
    }

    public void fillOrderFormOnSecondPage(String deliveryDate, String rentPeriod, String scooterColour, String commentToCourier){
        orderPage.selectDeliveryDate(deliveryDate);
        orderPage.selectRentPeriod(rentPeriod);
        orderPage.selectScooterColour(scooterColour);
        orderPage.setCommentToCourier(commentToCourier);
    }

    public void fillAddressField(String address){
        orderPage.setAddress(address);
    }

    public void clickNextButton(){
        orderPage.clickNextButton();
    }

    public void clickOrderButton(){
        orderPage.clickOrderButton();
    }

    public void clickApproveButton(){
        orderPage.clickApproveButton();
    }

    public void clickScooterLink(){
        orderPage.clickScooterLink();
    }

    public boolean isOrderConfirmed (){
        return orderPage.getConfirmationText().contains("Заказ оформлен");
    }

    public String getErrorMessagesUnderIndex(int msgIndex){
        return orderPage.getErrorMessageTextUnderIndex(msgIndex);
    }

}
