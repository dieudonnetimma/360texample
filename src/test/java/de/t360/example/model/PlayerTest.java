package de.t360.example.model;


import org.junit.Test;

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
