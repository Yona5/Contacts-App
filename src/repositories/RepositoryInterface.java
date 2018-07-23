package repositories;

import model.Contact;

/**
 *
 * repository interface
 */
public interface RepositoryInterface {

    /**
     * inserts a contact at the beginning of the contact list
     *
     * @param contact Contact
     */
    void insertAtStart(Contact contact);

    /**
     * inserts a contact at the end of the contact list
     *
     * @param contact Contact
     */
    void insertAtEnd(Contact contact);

    /**
     * inserts a contact at the specified position of the contact list
     *
     * @param contact Contact
     * @param pos position
     */
    void insertAtPos(int pos, Contact contact);

    /**
     * deletes a contact at the specified position of the contact list
     *
     * @param pos position
     */
    void deleteAtPos(int pos);

    /**
     * searches the contact list by phone number
     *
     * @param num phone number
     * @return
     */
    Contact searchTelNum(int num);

    /**
     * searches the contact list by name
     *
     * @param name first or last name
     * @return
     */
    Contact searchName(String name);

    /**
     * returns a contact list
     *
     * @return
     */
    ContactList getContactList();

    /**
     * sets a contact list
     *
     * @param contactList contactList
     */
    void setContactList(ContactList contactList);

    /**
     * returns string
     *
     * @return
     */
    @Override
    String toString();

}
