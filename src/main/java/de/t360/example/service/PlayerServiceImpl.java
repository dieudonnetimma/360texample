package de.t360.example.service;


import de.t360.example.model.*;

import java.util.LinkedList;
import java.util.List;


public class PlayerServiceImpl implements PlayerService {

    //this is the Default text to begin the chat
    private final String DEFAULT_TEXT = "Hallo_Test";
    private final int MAX_MESSAGE_SIZE = 10;
    private ServerChatService server;
    private Player player;
    private List<String> messageList = new LinkedList<String>();

    public PlayerServiceImpl(ServerChatService server, Player player) {
        this.server = server;
        this.player = player;
    }

    public PlayerServiceImpl() {
    }

    @Override
    public void send(String message) {
        if (this.server.is_server_cache_free()) {
            printMesage("Player " + player.getName() + " send :" + message);
            server.save(new Message(message, player.getName()));
        } else {
            printMesage("Player " + player.getName() + " cannot send the server is not free");
        }

    }

    @Override
    public void send() {
        String message = getLastMessage();

        if (message != null) {
            int counter = messageList.size();
            send(counter + " - " + message);
        } else {
            printMesage(" Player " + player.getName() + " has no message to send");
        }


    }


    @Override
    public void receive() {
        Message message = server.read(player.getName());

        if (this.is_Player_cache_full()) {
            printMesage("Cache of Player" + this.player.getName() + " is full, no message can be added");
            return;
        }


        if (message != null) {
            this.getMessageList().add(message.getText());
            printMesage("Player " + player.getName() + " receive: " + message.getText());
        } else {
            printMesage(" Player " + player.getName() + " receive no message");
        }


    }

    @Override
    public void printMesage(String message) {
        System.out.println(message);
    }

    @Override
    public String getLastMessage() {
        if (messageList.isEmpty())
            return null;
        int counter = messageList.size();
        return messageList.get(counter - 1);
    }

    @Override
    public boolean is_Player_cache_full() {

        return this.messageList.size() >= MAX_MESSAGE_SIZE;
    }


    public ServerChatService getServer() {
        return server;
    }

    public void setServer(ServerChatService server) {
        this.server = server;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    @Override
    public void run() {

        while (!is_Player_cache_full()) {
            if (this.getMessageList().isEmpty()) {

                if (this.getServer().has_a_message(this.getPlayer().getName())) {
                    this.receive();
                    send();
                } else {
                    send(DEFAULT_TEXT);
                }
            } else {
                this.send();
            }

            while (!this.getServer().has_a_message(this.getPlayer().getName())) {
                ;
            }
            this.receive();
        }
        this.send();


    }


}
