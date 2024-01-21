package com.goltsov.idea.platform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {

    private String origin;
    @JsonProperty("origin_name")
    private String originName;
    private String destination;
    @JsonProperty("destination_name")
    private String destinationName;
    @JsonProperty("departure_date")
    private String departureDate;
    @JsonProperty("departure_time")
    private String departureTime;
    @JsonProperty("arrival_date")
    private String arrivalDate;
    @JsonProperty("arrival_time")
    private String arrivalTime;
    private Carrier carrier;
    private int stops;
    private int price;

    public Ticket() {
    }

    public String getOrigin() {
        return origin;
    }

    public String getOriginName() {
        return originName;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public int getStops() {
        return stops;
    }

    public int getPrice() {
        return price;
    }

    public Ticket setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public Ticket setOriginName(String originName) {
        this.originName = originName;
        return this;
    }

    public Ticket setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public Ticket setDestinationName(String destinationName) {
        this.destinationName = destinationName;
        return this;
    }

    public Ticket setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public Ticket setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public Ticket setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    public Ticket setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public Ticket setCarrier(Carrier carrier) {
        this.carrier = carrier;
        return this;
    }

    public Ticket setStops(int stops) {
        this.stops = stops;
        return this;
    }

    public Ticket setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "\nTicket{"
                + "origin='" + origin + '\''
                + ", origin_name='" + originName + '\''
                + ", destination='" + destination + '\''
                + ", destination_name='" + destinationName + '\''
                + ", departure_date='" + departureDate + '\''
                + ", departure_time='" + departureTime + '\''
                + ", arrival_date='" + arrivalDate + '\''
                + ", arrival_time='" + arrivalTime + '\''
                + ", carrier='" + carrier + '\''
                + ", stops=" + stops
                + ", price=" + price
                + '}';
    }
}
