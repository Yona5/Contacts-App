/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import static com.sun.javafx.util.Utils.stripQuotes;
import repositories.Repository;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import model.Contact;
import model.IDisplayable;

/**
 * This class is an implementation of DAOInterface. It accepts file name and
 * changes it to contact object
 *
 * @author thisPC
 */
public class DAOimpl implements DAOInterface, IDisplayable {

    Repository repository = new Repository();

    /**
     * Accepts a file name
     *
     * @param filename a file name a user provides 
     * @return
     */
    @Override
    public Repository load(String filename) {
        String[] tempContact = null;
        int telephoneNumber;
        String firstName, lastName, email, typeOfContact;

        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(filename);
            reader = new BufferedReader(fileReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                Calendar calendar = Calendar.getInstance();
                tempContact = line.split(",");

                if (tempContact.length == 6) {

                    firstName = stripQuotes(tempContact[0]);
                    lastName = stripQuotes(tempContact[1]);
                    telephoneNumber = Integer.parseInt(stripQuotes(tempContact[2]));
                    email = stripQuotes(tempContact[3]);
                    try {
                        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(stripQuotes(tempContact[4]));
                        calendar.setTime(date);
                    } catch (ParseException ex) {
                        System.out.print(ex);
                    }

                    typeOfContact = stripQuotes(tempContact[5]);
                    repository.insertAtEnd(new Contact(firstName, lastName, telephoneNumber, email, calendar, typeOfContact));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return repository;
    }

    /**
     * displays class information
     */
    @Override
    public void display() {
        System.out.println("Implementing class: DAOimpl\n"
                + "Number of contacts: " + this.repository.getContactList().getSize());
    }
}
