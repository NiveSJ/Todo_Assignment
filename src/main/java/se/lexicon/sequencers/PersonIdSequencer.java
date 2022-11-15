package se.lexicon.sequencers;

public class PersonIdSequencer {  // trying to use singleton pattern

    private static int currentId = 100;

    public static int getCurrentId() {
        return currentId;
    }

    private static void setCurrentId(int currentId) {
        PersonIdSequencer.currentId = currentId;
    }


    public static int nextId() {
        int id = ++currentId;
        setCurrentId(id);
        return id;
    }


}
