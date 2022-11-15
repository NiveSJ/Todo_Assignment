package se.lexicon.sequencers;

public class PersonIdSequencer {


    private int currentId;
    private int minLimit;
    private int maxLimit;

    public PersonIdSequencer() {
        this.minLimit = 0;
        this.maxLimit = 1000;
    }


    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }


    int nextId() {
        if (this.currentId >= this.minLimit && this.currentId < 1000){
            currentId++;
        return currentId;}

        return -1;

    }


}
