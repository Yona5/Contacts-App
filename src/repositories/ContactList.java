/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.Contact;
import model.IDisplayable;

/**
 * Stores contacts and provides methods to manipulate contacts
 *
 * @author thisPC
 *
 */
public class ContactList implements IDisplayable {

    Node head, tail;
    int size;

    /**
     *
     * constructor
     */
    public ContactList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public class Node<T> {

        T data;
        Node next, previous;

        /**
         *
         * constructor
         *
         * @param data a parameter that will be specified during object creation
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        /**
         * returns an object
         *
         * @return
         */
        public T getData() {
            return data;
        }

        /**
         * returns the next object in the contact list
         *
         * @return
         */
        public Node getNext() {
            return next;
        }

        /**
         * returns the previous object in the contact list
         *
         * @return
         */
        public Node getPrevious() {
            return previous;
        }

    }

    /**
     * inserts contact at the start of the contact list
     *
     * @param t contact
     */
    public void insertAtStart(Contact t) {
        Node new_node = new Node(t);
        if (this.head == null) {
            new_node.next = new_node;
            new_node.previous = new_node;
            this.head = new_node;
            this.tail = this.head;
        } else {
            new_node.next = this.head;
            new_node.previous = this.tail;
            this.head.previous = new_node;
            this.tail.next = new_node;
            this.head = new_node;
        }
        this.size++;
    }

    /**
     * inserts contact in the specified position
     *
     * @param pos position
     * @param data contact
     */
    public void insertAtPos(int pos, Contact data) {
        Node new_node = new Node(data);
        if (pos == 1) {
            insertAtStart(data);
            return;
        }
        Node pointer = this.head;
        for (int i = 2; i <= this.size; i++) {
            if (i == pos) {
                Node temp = pointer.next;
                pointer.next = new_node;
                new_node.previous = pointer;
                new_node.next = temp;
                temp.previous = new_node;
            }
            pointer = pointer.next;
        }
        this.size++;
    }

    /**
     * inserts contact at the end of the contact list
     *
     * @param data contact
     */
    public void insertAtEnd(Contact data) {
        Node new_node = new Node(data);
        if (this.head == null) {
            new_node.next = new_node;
            new_node.previous = new_node;
            this.head = new_node;
            this.tail = this.head;
        } else {
            new_node.next = this.head;
            new_node.previous = this.tail;
            this.tail.next = new_node;
            this.head.previous = new_node;
            this.tail = new_node;
        }
        this.size++;
    }

    /**
     * deletes a contact address at the specified position
     *
     * @param pos position
     */
    public void deleteAtPos(int pos) {
        if (pos >= 1 && pos <= this.size) {
            if (pos == 1) {
                if (this.size == 1) {
                    this.head = null;
                    this.tail = null;
                    this.size = 0;
                    return;
                }
                this.head = this.head.next;
                this.head.previous = this.tail;
                this.tail.next = this.head;
                this.size--;
                return;
            }
            if (pos == this.size) {
                this.tail = this.tail.previous;
                this.tail.next = this.head;
                this.head.previous = this.tail;
                this.size--;

            }

            Node pointer = this.head.next;
            for (int i = 2; i <= this.size; i++) {
                if (i == pos) {
                    Node prev = pointer.previous;
                    Node nxt = pointer.next;
                    prev.next = nxt;
                    nxt.previous = prev;
                    this.size--;
                    return;
                }
                pointer = pointer.next;
            }
            System.out.println("Contact deleted");
        } else {
            System.out.println("position out of range.");
        }

    }

    /**
     * searches the contact list by phone number
     *
     * @param telNum phone number
     * @return
     */
    public Contact searchTelNum(int telNum) {
        if (this.size == 0) {
            System.out.println("No contacts in the Contact List");
            return null;
        }
        Node temp = this.head;
        for (int i = 1; i <= this.size; i++) {
            Contact contact = (Contact) temp.data;
            int tel = contact.getTelephoneNumber();
            if (tel == telNum) {
                System.out.println("Name: " + contact.getFirstName() + "\n"
                        + "Phone number: " + contact.getTelephoneNumber() + "\n"
                        + "Email: " + contact.getEmail() + "\n"
                        + "Date Created: " + formatDateTime(contact.getDateCreated()) + "\n"
                        + "Contact type: " + contact.getTypeOfContact());
                return (Contact) temp.data;
            }
            temp = temp.next;
        }
        System.out.println("No match found.");
        return null;
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
     * searches the contact list by name
     *
     * @param name first or last name
     * @return
     */
    public Contact searchName(String name) {
        if (this.size == 0) {
            System.out.println("No contacts in the Contact List");
            return null;
        }
        Node temp = this.head;
        for (int i = 1; i <= this.size; i++) {
            Contact contact = (Contact) temp.data;
            String contactName = contact.getFirstName().toLowerCase();
            if (contactName.equals(name.toLowerCase())) {
                System.out.println("Name: " + contact.getFirstName() + "\n"
                        + "Phone number: " + contact.getTelephoneNumber() + "\n"
                        + "Email: " + contact.getEmail() + "\n"
                        + "Date Created: " + formatDateTime(contact.getDateCreated()) + "\n"
                        + "Contact type: " + contact.getTypeOfContact());
                return (Contact) temp.data;
            }
            temp = temp.next;
        }
        System.out.println("No match found.");
        return null;
    }

    /**
     * returns the size of the contact list
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     *
     * display class info
     */
    @Override
    public void display() {
        System.out.println("Implementing class: ContactList\n" + "Properties: "
                + "head: Node, tail: Node, size: int");
    }

    /**
     * returns the first object in the contact list
     *
     * @return
     */
    public Node getHead() {
        return head;
    }

    /**
     * returns the last object in the contact list
     *
     * @return
     */
    public Node getTail() {
        return tail;
    }

}
