package ru.job4j.stream;

import com.sun.tools.javac.Main;

import java.util.List;
import java.util.stream.Stream;

public class Cards {
    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public class Card {
        private Suit suit;
        private Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Card{"
                    + "suit=" + suit
                    + ", value=" + value
                    + '}';
        }

    }

    public static void main(String[] args) {
        Cards cards = new Cards();
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> cards.new Card(s, v)))
                .forEach(System.out::println);
    }
}
