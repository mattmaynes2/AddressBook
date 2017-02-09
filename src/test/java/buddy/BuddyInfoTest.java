package buddy;

import static org.junit.Assert.*;

/**
 * Created by mattmaynes on 1/12/2017.
 */
public class BuddyInfoTest {

    @org.junit.Test
    public void equals () {
        assertTrue(new BuddyInfo("Tom").equals(new BuddyInfo("Tom")));
        assertFalse(new BuddyInfo("Tom").equals("Matt"));
    }

    @org.junit.Test
    public void testToString () {
        assertEquals(new BuddyInfo("Tom").toString(), "Tom");
    }

}