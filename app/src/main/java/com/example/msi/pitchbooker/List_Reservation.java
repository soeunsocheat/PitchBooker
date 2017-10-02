package com.example.msi.pitchbooker;

import java.util.ArrayList;

/**
 * Created by MSI on 9/26/2017.
 */

public class List_Reservation {
    private boolean status;
    private String message;
    private String date;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    private ArrayList<Location> locations;
}


class Location{
    private long location_id;
    private String location_name;
    private ArrayList <Field> fields;

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }
}

class Field{
    private long field_id;
    private String field_name;
    private ArrayList <Reservation> reservations;

    public long getField_id() {
        return field_id;
    }

    public void setField_id(long field_id) {
        this.field_id = field_id;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}

class Reservation{
    private long reserve_id;
    private long field_id;
    private long customer_id;
    private String reserve_date;
    private String reserve_start_time;

    public long getReserve_id() {
        return reserve_id;
    }

    public void setReserve_id(long reserve_id) {
        this.reserve_id = reserve_id;
    }

    public long getField_id() {
        return field_id;
    }

    public void setField_id(long field_id) {
        this.field_id = field_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getReserve_date() {
        return reserve_date;
    }

    public void setReserve_date(String reserve_date) {
        this.reserve_date = reserve_date;
    }

    public String getReserve_start_time() {
        return reserve_start_time;
    }

    public void setReserve_start_time(String reserve_start_time) {
        this.reserve_start_time = reserve_start_time;
    }

    public String getReserve_end_time() {
        return reserve_end_time;
    }

    public void setReserve_end_time(String reserve_end_time) {
        this.reserve_end_time = reserve_end_time;
    }

    private String reserve_end_time;
}

class Item {
    private String time;

    public Item(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}