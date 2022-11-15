package se.lexicon.sequencers;

public class TodoItemTaskIdSequencer {


    private static int currentId = 100;

    public static int getCurrentId() {
        return currentId;
    }

    private static void setCurrentId(int currentId) {
        TodoItemTaskIdSequencer.currentId = currentId;
    }


    public static int nextId() {
        int id = ++currentId;
        setCurrentId(id);
        return id;
    }



}
