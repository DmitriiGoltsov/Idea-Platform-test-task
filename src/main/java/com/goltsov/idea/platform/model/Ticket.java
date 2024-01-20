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

    public Ticket(String origin, String originName, String destination, String destinationName, String departureDate,
                  String departureTime, String arrivalDate, String arrivalTime, Carrier carrier, int stops, int price) {
        this.origin = origin;
        this.originName = originName;
        this.destination = destination;
        this.destinationName = destinationName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
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

    public String getCarrier() {
        return carrier.toString();
    }

    public int getStops() {
        return stops;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\nTicket{" +
                "origin='" + origin + '\'' +
                ", origin_name='" + originName + '\'' +
                ", destination='" + destination + '\'' +
                ", destination_name='" + destinationName + '\'' +
                ", departure_date='" + departureDate + '\'' +
                ", departure_time='" + departureTime + '\'' +
                ", arrival_date='" + arrivalDate + '\'' +
                ", arrival_time='" + arrivalTime + '\'' +
                ", carrier='" + carrier + '\'' +
                ", stops=" + stops +
                ", price=" + price +
                '}';
    }
}
