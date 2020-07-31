package de.t360.example.service;

import de.t360.example.model.Message;

/**
 * this is the service interface for the ServerChat
 */
public interface ServerChatService {
    /**
     * this method check, if the cache in server is free
     * @return
     */
    boolean is_server_cache_free();

    /**
     * this methode check, if a player has a message im server
     * @param name
     * @return
     */
    boolean has_a_message(String name);

    /**
     * this methode save a message object in server
     * @param message
     */
    void save(Message message);

    /**
     * this method read the message for a given playner name
     * @param playerName
     * @return
     */
    Message read(String playerName);
}
