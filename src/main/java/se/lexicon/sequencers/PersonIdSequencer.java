package se.lexicon.sequencers;

public class PersonIdSequencer {  // trying to use singleton pattern

   /* private static PersonIdSequencer personIdSequencer = new PersonIdSequencer();

    public static PersonIdSequencer getPersonIdSequencer() {

        return personIdSequencer;
    }*/

    private static int currentId;
    private static int minLimit;
    private static int maxLimit;

    public PersonIdSequencer() {
        setCurrentId(currentId);
        this.minLimit = 0;
        this.maxLimit = 1000;
    }


    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        currentId = nextId();
    }


    static int nextId() {
        if (currentId >= minLimit && currentId < 1000) {
            currentId++;
            return currentId;
        }

        return -1;

    }


}
