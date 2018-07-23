package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IDisplayable;

/**
 * This class handles inputs from users and is taken from Attendance
 * Application, coursework
 *
 * @author mga
 */
public class InputHelper implements IDisplayable {

    private final Scanner reader;

    /**
     * Constructor
     */
    public InputHelper() {
        reader = new Scanner(System.in);
    }

    /**
     * Reads character
     *
     * @param prompt a prompt to the user
     * @return
     */
    public char readCharacter(String prompt) {

        System.out.println(prompt + ": ");
        char inputText = reader.nextLine().charAt(0);
        return inputText;
    }

    /**
     * Reads character - set of valid values
     *
     * @param prompt a prompt to the user
     * @param validCharacters it's used to check if the character entered is
     * valid
     * @return
     */
    public char readCharacter(String prompt, String validCharacters) {
        char inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");
            inputText = reader.nextLine().toUpperCase().charAt(0);
            if (validCharacters.indexOf(inputText) == -1) {
                inputError = true;
                System.out.println("Character out of range: please re-enter: ");
            }
        } while (inputError);
        return inputText;
    }

    /**
     * reads string
     *
     * @param prompt a prompt to the user
     * @return
     */
    public String readString(String prompt) {

        System.out.println(prompt + ": ");
        String inputText = reader.nextLine();
        return inputText;
    }

    /**
     * reads integer
     *
     * @param prompt a prompt
     * @param max maximum
     * @param min minimum
     * @return
     */
    public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");
                }
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    /**
     * reads integer
     *
     * @param prompt a prompt
     * @return
     */
    public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    /**
     * reads date
     *
     * @param prompt a prompt
     * @param format data format
     * @return
     */
    public Calendar readDate(String prompt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateInString = readString(prompt);
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(InputHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * displays class information
     */
    @Override
    public void display() {
        System.out.println("Implementing class: InputHelper\n"
                + "Properties: reader: Scanner");
    }
}
