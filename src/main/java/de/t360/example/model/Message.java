package de.t360.example.model;

import java.util.Objects;

/**
 * This the Model  for Message
 */

public class Message {

    private String text;

    private String senderName;

    public Message(String text, String senderName) {
        this.text = text;
        this.senderName = senderName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + text + '\'' +
                ", senderName='" + senderName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return text.equals(message1.text) &&
                senderName.equals(message1.senderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, senderName);
    }
}
