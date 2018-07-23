package daos;

import repositories.Repository;

/**
 * This interface provides a method for implementing classes to read file
 *
 * @author mga
 */
public interface DAOInterface {

    /**
     * accepts a file name as a parameter and creates a contact
     *
     * @param filename a file name that a user provides
     * @return
     */
    public Repository load(String filename);
}
