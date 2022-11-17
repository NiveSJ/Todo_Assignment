package sequencers;

import org.junit.jupiter.api.Test;
import se.lexicon.sequencers.PersonIdSequencer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonSequencerTest {

   @Test
   public void personSequencerTest(){

       int id =PersonIdSequencer.getCurrentId();
        assertEquals(100, id);
       int id1= PersonIdSequencer.nextId();
        assertEquals(101, id1);






    }



}
