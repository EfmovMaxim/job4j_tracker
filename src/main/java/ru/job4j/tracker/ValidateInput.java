package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;
    private final Output output;

    public ValidateInput(Output output, Input input) {
        this.input = input;
        this.output = output;
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;

        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите корректное число");
            }
        } while (invalid);
        return value;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }
}
