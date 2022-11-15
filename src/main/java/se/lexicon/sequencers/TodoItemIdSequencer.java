package se.lexicon.sequencers;

public class TodoItemIdSequencer {


    private int currentId;
    private int minLimit;
    private int maxLimit;

    public TodoItemIdSequencer() {
        this.minLimit = 1000;
        this.maxLimit = 2000;
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
            return currentId;
        }

        return -1;

    }

}
