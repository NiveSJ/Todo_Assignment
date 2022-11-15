package se.lexicon.sequencers;

public class TodoItemTaskIdSequencer {


    private static int currentId;


    public TodoItemTaskIdSequencer() {

        setCurrentId(currentId);

    }


    public int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        currentId = nextId();
    }


    static int nextId() {
        if (currentId >= 0 && currentId < 2000){
            currentId++;
            return currentId;
        }

        return -1;

    }
}
