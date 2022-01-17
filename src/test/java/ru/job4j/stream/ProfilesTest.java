package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void when3profilesAnd2Adresses() {
        Profile p1 = new Profile(new Address("Spb", "Toreza", 8, 12));
        Profile p2 = new Profile(new Address("Spb", "Toreza", 8, 12));
        Profile p3 = new Profile(new Address("Moscow", "Engelsa", 77, 88));

        List<Profile> profiles = List.of(p1, p2, p3);

        Profiles pr = new Profiles();
        List<Address> expected = List.of(new Address("Moscow", "Engelsa", 77, 88),
                new Address("Spb", "Toreza", 8, 12));
        Assert.assertThat(pr.collect(profiles), is(expected));
    }

}