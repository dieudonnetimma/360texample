package de.t360.example.utils;

public enum InputMethodOptionEnum {
    DEFAULT("none"),
    SHELL("shell"),
    VISUAL("gui");

    private String id;


    InputMethodOptionEnum(String id) {
        this.id = id;
    }

    public static InputMethodOptionEnum valueById(String input) {
        for(InputMethodOptionEnum e : InputMethodOptionEnum.values()){
            if(e.getId().equalsIgnoreCase(input))
                return e;
        }
        return InputMethodOptionEnum.DEFAULT;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "InputMethodOptionEnum{" +
                "id='" + id + '\'' +
                '}';
    }
}
