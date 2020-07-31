package de.t360.example.service;

/**
 * this is the service interface for the player
 */
public interface PlayerService extends Runnable {

    /**
     * this methode send a message to the server
     *
     * @param Message
     */
    void send(String Message);

    /**
     * this method send the last message from the cache to the server
     */
    void send();

    /**
     * this methode receive the message from server and write in the player cache
     */
    void receive();

    /**
     * this method print information in the console
     *
     * @param message
     */
    void printMesage(String message);

    /**
     * this methode read the last messsage in the cache
     *
     * @return the last Text message
     */
    String getLastMessage();

    /**
     * this method check, if the cache is full
     *
     * @return
     */
    boolean is_Player_cache_full();
}
