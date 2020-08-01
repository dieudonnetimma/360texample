package de.t360.example.service;

import de.t360.example.utils.InputMethodOptionEnum;
import de.t360.example.model.*;

import javax.swing.*;
import java.util.Scanner;

public class InputMethodeServiceImpl implements InputMethodService {

    private InputMethodOptionEnum inputMethodOption;
    private Player player;
    private Scanner scanner;

    //this is the Default text to begin the chat
    private final String DEFAULT_TEXT = "Hallo_Test";


    public InputMethodeServiceImpl(InputMethodOptionEnum inputMethodOption, Player player) {
        this.inputMethodOption = inputMethodOption;
        this.player = player;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String inputMethod() {
        switch (this.inputMethodOption) {
            case SHELL: {
                return this.shellInputMethod();

            }
            case VISUAL: {
                return this.visualInputMethod();

            }

            default: {
                return this.DEFAULT_TEXT;
            }
        }
    }

    @Override
    public InputMethodOptionEnum getInputMethodOption() {
        return this.inputMethodOption;
    }

    private String visualInputMethod() {
        String text = JOptionPane.showInputDialog("Player " + this.player.getName() + " :");
        return text;
    }

    private String shellInputMethod() {
        System.out.println("Player " + this.player.getName() + " :");
        String text = this.scanner.nextLine();
        return text;
    }
}
