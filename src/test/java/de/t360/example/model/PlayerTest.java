package de.t360.example.model;

import de.t360.example.service.PlayerService;
import de.t360.example.service.PlayerServiceImpl;
import de.t360.example.service.ServerChatService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void player_Has_A_Name() {

        String expected = "player1";

        Player player = new Player(expected);

        assertEquals(expected, player.getName());

    }

    @Test
    public void player_name_can_not_be_null() {

      assertThrows(NullPointerException.class , () -> {new Player(null);});
    }


}
