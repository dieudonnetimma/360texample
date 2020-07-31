package de.t360.example.model;

/**
 * This is the Model for a Player
 */
public class Player {

    private String name;


    public Player(String name) throws NullPointerException {
        if (name != null)
            this.name = name;
        else
            throw new NullPointerException();
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException {
        if (name != null)
            this.name = name;
        else
            throw new NullPointerException();
    }
}
