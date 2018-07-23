/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import java.util.Calendar;
import model.Contact;
import model.IDisplayable;
import repositories.ContactList;
import repositories.Repository;

/**
 * This class provides multiple functions that interact with the user as menu
 *
 * @author thisPC
 */
public class ContactsController implements IDisplayable {

    private final Repository repository;

    /**
     * Constructor
     *
     */
    public ContactsController() {
        InputHelper inputHelper = new InputHelper();
        char ans = inputHelper.readCharacter("Load contacts from file? Y/N ");
        if (Character.toUpperCase(ans) == 'Y') {
            String filename = inputHelper.readString("Type file name");
            this.repository = new Repository(filename);

        } else {
            this.repository = new Repository();
        }
    }

    /**
     * calls functions that interact with users
     */
    public void run() {
        boolean finished = false;

        do {
            char choice = displayAttendanceMenu();
            switch (choice) {
                case 'A':
                    info();
                    break;
                case 'B':
                    createContact();
                    break;
                case 'C':
                    searchByPhonenum();
                    break;
                case 'D':
                    searchByName();
                    break;
                case 'E':
                    showContacts();
                    break;
                case 'F':
                    deleteContact();
                    break;
                case 'H':
                    help();
                    break;
                case 'Q':
                    finished = true;
                    break;

            }
        } while (!finished);
    }

    /**
     * displays the options users can choose from
     * 
     */
    private char displayAttendanceMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.println("===============");
        System.out.print("\nA. Class Info");
        System.out.print("\tB. Create Contact");
        System.out.print("\tC. Search by Telephone Number");
        System.out.println("\tD. Search by Name");
        System.out.print("\tE. Show Contact");
        System.out.print(" ");
        System.out.print("\tF. Delete Contact");
        System.out.print("\tH. Help");
        System.out.print(" ");
        System.out.print("\tQ. Quit\n");
        return inputHelper.readCharacter("Enter choice", "ABCDEFHQ");
    }

    /**
     * shows class information
     */
    private void info() {
        System.out.format("\033[31m%s\033[0m%n", "Class Info");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        this.repository.getContactList().display();
        System.out.println("Number of contacts: " + this.repository.getContactList().getSize());

    }

    /**
     * creates new contact and inserts it into contact list
     */
    private void createContact() {
        System.out.format("\033[31m%s\033[0m%n", "Create Contact");
        System.out.format("\033[31m%s\033[0m%n", "======");
        InputHelper inputHelper = new InputHelper();
        String fName = inputHelper.readString("type first name");
        String lName = inputHelper.readString("type last name");
        int num = inputHelper.readInt("type phone number");
        String email = inputHelper.readString("type email");
        String contactType = inputHelper.readString("personal or business?");
        this.repository.insertAtEnd(new Contact(fName, lName, num, email, Calendar.getInstance(), contactType));
        System.out.println("Contact added.");
    }

    /**
     * searches the contact list by phone number and shows the matching result
     */
    private Contact searchByPhonenum() {
        System.out.format("\033[31m%s\033[0m%n", "Search By Phone Number");
        System.out.format("\033[31m%s\033[0m%n", "=================");
        InputHelper inputHelper = new InputHelper();
        int ans = inputHelper.readInt("Type phone number");
        return this.repository.searchTelNum(ans);

    }

    /**
     * searches the contact list by name and shows matching results
     */
    private Contact searchByName() {
        System.out.format("\033[31m%s\033[0m%n", "Search By Name");
        System.out.format("\033[31m%s\033[0m%n", "=========================");

        InputHelper inputHelper = new InputHelper();
        String ans = inputHelper.readString("Type Name ");
        return this.repository.searchName(ans);
    }

    /**
     * deletes a contact from the contact list base on the position
     */
    private void deleteContact() {
        System.out.format("\033[31m%s\033[0m%n", "Delete Contact");
        System.out.format("\033[31m%s\033[0m%n", "=========================");

        InputHelper inputHelper = new InputHelper();
        int ans = inputHelper.readInt("Type the position");
        this.repository.deleteAtPos(ans);
    }

    /**
     * shows help
     */
    private void help() {

        System.out.println("Type myContacts.txt to load contacts file\n" 
            + "Choose E to see the list of all contacts");
    }

    /**
     * displays class information
     */
    @Override
    public void display() {
        System.out.println("Implementing class: ContactController\n "
                + "Properties: repository");
    }

    /**
     * lists all contacts in the contact list
     */
    private void showContacts() {
        int size = this.repository.getContactList().getSize();
        if (size == 0) {
            System.out.println("No contacts in the Contact List");
        } else {
            ContactList.Node temp = this.repository.getContactList().getHead();
            for (int i = 1; i <= size; i++) {
                Contact contact = (Contact) temp.getData();
                contact.display();
                //int tel = contact.getTelephoneNumber();

                temp = temp.getNext();
            }
        }
    }
}
