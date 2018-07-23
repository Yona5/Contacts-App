package repositories;

import daos.DAOimpl;
import model.Contact;
import model.IDisplayable;

/**
 * The class where the contact list resides
 *
 */
public class Repository implements RepositoryInterface, IDisplayable {

    private ContactList contactList;

    /**
     * The class where the contact list resides
     *
     */
    public Repository() {
        this.contactList = new ContactList();
    }

    /**
     * Constructor
     *
     * @param contactList contact list object
     */
    public Repository(ContactList contactList) {
        this.contactList = contactList;
    }

    /**
     * Constructor
     *
     * @param filename file name
     */
    public Repository(String filename) {
        this();
        DAOimpl dao = new DAOimpl();
        Repository repo = dao.load(filename);
        this.contactList = repo.getContactList();

    }

    /**
     * returns contact list
     *
     * @return
     */
    @Override
    public ContactList getContactList() {
        return this.contactList;
    }

    /**
     * sets the contact list
     *
     * @param contactList contact list
     */
    @Override
    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }

    /**
     * inserts the contact at the beginning of the contact list
     *
     * @param contact Contact
     */
    @Override
    public void insertAtStart(Contact contact) {
        this.contactList.insertAtStart(contact);
    }

    /**
     * inserts the contact at the end of the contact list
     *
     * @param contact Contact
     */
    @Override
    public void insertAtEnd(Contact contact) {
        this.contactList.insertAtEnd(contact);
    }

    /**
     * inserts the contact at the specified position in the contact list
     *
     * @param contact Contact
     * @param pos position
     */
    @Override
    public void insertAtPos(int pos, Contact contact) {
        this.contactList.insertAtPos(pos, contact);
    }

    /**
     * deletes the contact at the specified position in the contact list
     *
     * @param pos position
     */
    @Override
    public void deleteAtPos(int pos) {
        this.contactList.deleteAtPos(pos);
    }

    /**
     * searches the contact list by phone number
     *
     * @param num phone number
     * @return
     */
    @Override
    public Contact searchTelNum(int num) {
        return this.contactList.searchTelNum(num);
    }

    /**
     * searches the contact list by name
     *
     * @param name first or last name
     * @return
     */
    @Override
    public Contact searchName(String name) {
        return this.contactList.searchName(name);
    }

    /**
     * displays class information
     */
    @Override
    public void display() {
        System.out.println("Implementing class: Repository\n" + "Properties:"
                + " contactList: ContactList");
    }
}
