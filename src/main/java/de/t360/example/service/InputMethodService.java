package de.t360.example.service;

import de.t360.example.utils.InputMethodOptionEnum;

/**
 * this is the service interface for the input method
 */
public interface InputMethodService {

    /**
     *  content the input methods for the player
     * @return
     */
    String inputMethod();

    /**
     *  return the choosed input methode
     * @return
     */
    InputMethodOptionEnum getInputMethodOption();
}
