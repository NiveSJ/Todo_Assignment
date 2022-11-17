package sequencers;

import org.junit.jupiter.api.Test;
import se.lexicon.sequencers.TodoItemIdSequencer;
import se.lexicon.sequencers.TodoItemTaskIdSequencer;

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
