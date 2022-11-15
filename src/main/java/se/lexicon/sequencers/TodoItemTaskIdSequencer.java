package se.lexicon.sequencers;

public class TodoItemTaskIdSequencer {


    private int currentId;
    private int minLimit;
    private int maxLimit;

    public TodoItemTaskIdSequencer() {
        this.minLimit = 2000;
        this.maxLimit = 3000;
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
