package ru.yandex.prakticum.models;

public class OrderModel {
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

    public OrderModel(int orderButtonIndex, String name, String surname, String address, String metro, String phoneNumber, String deliveryDate, String rentPeriod, String scooterColour, String commentToCourier) {
        this.orderButtonIndex = orderButtonIndex;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentPeriod = rentPeriod;
        this.scooterColour = scooterColour;
        this.commentToCourier = commentToCourier;
    }

    public int getOrderButtonIndex() {
        return orderButtonIndex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getMetro() {
        return metro;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getRentPeriod() {
        return rentPeriod;
    }

    public String getScooterColour() {
        return scooterColour;
    }

    public String getCommentToCourier() {
        return commentToCourier;
    }
}
