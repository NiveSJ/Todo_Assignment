package se.lexicon.sequencers;

public class TodoItemIdSequencer {


    private static int currentId = 200;

    public static int getCurrentId() {
        return currentId;
    }

    private static void setCurrentId(int currentId) {
        TodoItemIdSequencer.currentId = currentId;
    }


    public static int nextId() {
        int id = ++currentId;
        setCurrentId(id);
        return id;
    }




}
