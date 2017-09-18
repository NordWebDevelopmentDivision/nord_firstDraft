package is.nord.repository;

import is.nord.model.News;
import is.nord.model.Registration;

import java.util.List;

/**
 * A storage for news items
 */
public interface RegistrationRepository {
    /**
     * Get all registration items
     * @return a list of registration items
     */
    List<Registration> getAll();

    /**
     * Adds a registration item to the storage
     * @param registration the registration item to be added to the storage
     */
    void add(Registration registration);

    /**
     * removes a registration item to the storage
     * @param username the registration item to be added to the storage
     */
    void remove(String username, String event);
}
