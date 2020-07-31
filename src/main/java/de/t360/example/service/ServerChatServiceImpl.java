package de.t360.example.service;

import de.t360.example.model.Message;

public class ServerChatServiceImpl implements ServerChatService {

    private Message actualMessage;

    @Override
    public synchronized boolean is_server_cache_free() {
        return this.getActualMessage() == null;
    }

    @Override
    public synchronized boolean has_a_message(String name) {

        if(is_server_cache_free())
            return false;

        if( actualMessage.getSenderName().equals(name))
            return false;
        return true;
    }

    @Override
    public synchronized void save(Message message) {
        this.setActualMessage(message);
    }

    @Override
    public synchronized Message read(String playerName) {

        if(this.has_a_message(playerName)){
            Message result = this.getActualMessage();
            this.setActualMessage(null);
            return result;
        }


        return null;
    }

    public synchronized Message getActualMessage() {
        return actualMessage;
    }

    public void setActualMessage(Message actualMessage) {
        this.actualMessage = actualMessage;
    }
}
