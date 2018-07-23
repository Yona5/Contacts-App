/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * creates a contact object and provides methods to access class fields
 *
 * @author thisPC
 */
public class Contact implements IDisplayable {

    private String firstName;
    private String lastName;
    private int telephoneNumber;
    private String email;
    private Calendar dateCreated;
    private String typeOfContact;

    /**
     * Constructor
     *
     * @param firstName first name
     * @param lastName last name
     * @param telephoneNumber telephone number
     * @param email email address
     * @param dateCreated date created
     * @param typeOfContact type of contact, stored in string format
     *
     *
     */
    public Contact(String firstName, String lastName, int telephoneNumber, String email, Calendar dateCreated, String typeOfContact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.dateCreated = dateCreated;
        this.typeOfContact = typeOfContact;
    }

    /**
     * returns first name
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets first name
     *
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * returns last name
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets last name
     *
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * returns telephone number
     *
     * @return
     */
    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * sets telephone number
     *
     * @param telephoneNumber telephone number
     *
     */
    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * returns email address
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets email address
     *
     * @param email email address
     *
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * returns contact created date
     *
     * @return
     */
    public Calendar getDateCreated() {
        return dateCreated;
    }

    /**
     * sets contact created date
     *
     * @param dateCreated date created
     */
    public void setDateCreated(Calendar dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * returns type of contact
     *
     * @return
     */
    public String getTypeOfContact() {
        return typeOfContact;
    }

    /**
     * sets type of contact
     *
     * @param typeOfContact type of contact
     */
    public void setTypeOfContact(String typeOfContact) {
        this.typeOfContact = typeOfContact;
    }

    /**
     * formats the calendar to string
     *
     * @param calendar calendar
     * @return
     */
    public static String formatDateTime(Calendar calendar) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(calendar.getTime());
    }

    /**
     *
     * display info about a class
     */
    @Override
    public void display() {
        System.out.println("First Name: " + this.firstName + "\n"
                + "Last Name: " + this.lastName + "\n" + "Phone Number" + this.telephoneNumber + "\n"
                + "Email: " + this.email + "\n" + "Date Created: " + formatDateTime(this.dateCreated) + "\n"
                + "Type of Contact: " + this.typeOfContact + "\n");
    }
}
