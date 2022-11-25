package se.lexicon.sequencers;

public class PersonIdSequencer {  // trying to use singleton pattern

    private static int sequencer = 1000;

    public static int nextId() {
        return ++sequencer;

    }}
