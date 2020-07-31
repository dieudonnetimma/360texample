package de.t360.example.service;

import de.t360.example.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ServerChatServiceTest {

    ServerChatService serverChatService;
    Message message;

    @BeforeEach
    public void init (){
         serverChatService = new ServerChatServiceImpl();
         message = new Message("Hallo", "Test");
        serverChatService.save(message);
    }

    @Test
    public void check_that_a_message_can_be_saved(){

       assertFalse(serverChatService.is_server_cache_free());

    }

    @Test
    public void check_if_the_server_has_message_for_a_player(){

        assertFalse(serverChatService.has_a_message("Test"));
        assertTrue(serverChatService.has_a_message("any"));
    }

    @Test
    public  void check_that_message_can_be_read(){
        Message result = serverChatService.read("any");

        assertEquals(message, result);
        assertTrue(serverChatService.is_server_cache_free());

    }
}
