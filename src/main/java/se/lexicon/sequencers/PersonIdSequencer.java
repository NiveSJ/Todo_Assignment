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


    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId(int currentId) {
        this.currentId = nextId();
    }


    int nextId() {
        if (this.currentId >= this.minLimit && this.currentId < 1000) {
            currentId++;
            return currentId;
        }

        return -1;

    }


}
