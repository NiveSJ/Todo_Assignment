package sequencers;

import org.junit.jupiter.api.Test;
import se.lexicon.sequencers.TodoItemIdSequencer;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TodoItemSequencerTest {


    @Test
    public void todoItemSequencerTest() {

        int currentId = TodoItemIdSequencer.getCurrentId();
        assertEquals(200, currentId);

        int nextId = TodoItemIdSequencer.nextId();
        assertEquals(201, nextId);


    }
}
