package sequencers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemTaskSequencerTest {

    @Test
    public void todoItemTaskSequencerTest() {

        int currentId = TodoItemTaskIdSequencer.getCurrentId();
        assertEquals(300, currentId);

        int nextId = TodoItemTaskIdSequencer.nextId();
        assertEquals(301, nextId);


    }
}
