package service;

/**
 * ApplicationService defines the main application flow interface.
 * It is responsible for starting the application and controlling user interaction.
 */
public interface ApplicationService {

    /**
     * Starts the application.
     * This method should handle the user interface, menu navigation,
     * and coordinate the use of account-related services.
     */
    void start();
}
