package com.example.puskar.bridge;

/**
 * Created by puskar on 5/20/2017.
 */

public class Dataprovider {
    private String name;
    private String contact;
    private String address;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Dataprovider(String name, String contact, String address, String message)
    {
        this.name= name;
        this.contact= contact;
        this.address= address;
        this.message= message;

    }
}
