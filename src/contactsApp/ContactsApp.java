/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactsApp;

import controllers.ContactsController;
import model.IDisplayable;

/**
 * This class contains the main method and is where the program starts
 *
 * @author thisPC
 */
public class ContactsApp implements IDisplayable {

    /**
     * Calls a method that displays the menu of the application
     *
     * @author thisPC
     */
    public static void run() {
        System.out.println("Contact App\n" + "==============\n\n");

        ContactsController contactsController = new ContactsController();

        contactsController.run();

        System.out.println("Thank you for using Contacts App. Good bye.\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactsApp contactsApp = new ContactsApp();
        contactsApp.run();
    }

    /**
     * displays information about the class it's inside in
     */
    @Override
    public void display() {
        System.out.println("Implementing class: ContactApp");
    }

}
