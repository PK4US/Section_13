package com.MyApp_4;

public class Contacts {

    private String nameContact,numberPhone;

    public Contacts(String nameContact, String numberPhone) {
        this.nameContact = nameContact;
        this.numberPhone = numberPhone;
    }

    public String getNameContact() {
        return nameContact;
    }
    public String getNumberPhone() {
        return numberPhone;
    }
}