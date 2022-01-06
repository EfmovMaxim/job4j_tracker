package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Input in = new StubInput(new String[]{"one", "1"});
        Output out = new StubOutput();

        ValidateInput vInput = new ValidateInput(out, in);
        int selected = vInput.askInt("Enter menu:");

        Assert.assertThat(selected, is(1));
    }

    @Test
    public void whenValidInputManyTimes() {
        Input in = new StubInput(new String[]{"1", "2"});
        Output out = new StubOutput();

        ValidateInput vInput = new ValidateInput(out, in);
        int selected = vInput.askInt("Enter menu:");
        Assert.assertThat(selected, is(1));

        selected = vInput.askInt("Enter menu:");
        Assert.assertThat(selected, is(2));
    }

    @Test
    public void whenNegativeInput() {
        Input in = new StubInput(new String[]{"-1"});
        Output out = new StubOutput();

        ValidateInput vInput = new ValidateInput(out, in);
        int selected = vInput.askInt("Enter menu:");
        Assert.assertThat(selected, is(-1));
    }
}
