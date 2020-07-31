package de.t360.example.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void message_has_a_senderName_and_a_text() {

        String text = "Hallo";
        String senderName = "Palyer1";

        Message message = new Message(text, senderName);

        assertEquals(text, message.getText());
        assertEquals(senderName, message.getSenderName());

    }


}
