package de.t360.example.service;

import de.t360.example.utils.InputMethodOptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import  de.t360.example.model.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.*;


public class PlayerServiceTest {

    ServerChatService serverChatService;
    PlayerService service1;
    PlayerService service2;



    @BeforeEach
    public void init(){
        serverChatService = new ServerChatServiceImpl();
        Player player1 =  new Player("Player 1");
        InputMethodService inputMethodService1 = new InputMethodeServiceImpl(InputMethodOptionEnum.DEFAULT,player1);
         service1 = new PlayerServiceImpl(serverChatService, player1,inputMethodService1);


        Player player2 =  new Player("Player 2");
        InputMethodService inputMethodService2 = new InputMethodeServiceImpl(InputMethodOptionEnum.DEFAULT,player2);

        service2 = new PlayerServiceImpl(serverChatService, player2, inputMethodService2);
    }

    @Test
    public void initiator_player_can_send_to_second_player() {


        service1.send("Hallo");
        service2.receive();

        assertEquals("Hallo",service2.getLastMessage() );
        assertTrue(serverChatService.is_server_cache_free() );

    }

    @Test
    public void second_player_can_send_received_message_to_initiator_player() {
        service1.send("Hallo");
        service2.receive();
        service2.send();
        service1.receive();

        assertEquals("1 - Hallo",service1.getLastMessage() );
        assertTrue(serverChatService.is_server_cache_free() );

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/messages.csv", numLinesToSkip = 1)
    public void the_player_change_many_message(String input, String output) {

        service1.send(input);
        service2.receive();
        service2.send();
        service1.receive();

        assertEquals(output,service1.getLastMessage() );
        assertTrue(serverChatService.is_server_cache_free() );

    }

    @Test
    public void check_that_player_cache_is_full() {
        for(int i = 0 ; i < 10; i++){
            String message = "Hallo" + i;
            service1.send(message);
            service2.receive();
            service2.send();
            service1.receive();
        }


        assertTrue(service1.is_Player_cache_full());
        assertTrue(service2.is_Player_cache_full() );

    }

    @Test
    public void check_the_thread() {

        Thread player1Thread = new Thread(service1);
        Thread player2Thread = new Thread(service2);

        player1Thread.start();
        player2Thread.start();


        assertFalse(service1.is_Player_cache_full());
        assertFalse(service2.is_Player_cache_full() );

        while ((player1Thread.isAlive() || player2Thread.isAlive())){;}

        assertTrue(service1.is_Player_cache_full());
        assertTrue(service2.is_Player_cache_full() );



    }



}
